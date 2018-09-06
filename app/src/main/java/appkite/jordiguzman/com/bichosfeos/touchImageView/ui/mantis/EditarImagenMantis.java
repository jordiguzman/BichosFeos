package appkite.jordiguzman.com.bichosfeos.touchImageView.ui.mantis;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.io.FileOutputStream;

import appkite.jordiguzman.com.bichosfeos.R;
import appkite.jordiguzman.com.bichosfeos.VisorWeb;

public class EditarImagenMantis extends AppCompatActivity {

    ImageView iv_editar_imagen;

    TextView tv_editar;
    Toolbar toolbar;
    ImageButton ib_wiki;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_imagen);
        toolbar = (Toolbar) findViewById(R.id.toolbar);


        try {
            getSupportActionBar().hide();
        }catch (Exception e){
            e.printStackTrace();
        }

        iv_editar_imagen = (ImageView) findViewById(R.id.iv_editar_imagen);
        tv_editar = (TextView) findViewById(R.id.tv_editar_imagen);
        ib_wiki = (ImageButton) findViewById(R.id.ib_wiki);
        FloatingActionButton fab_compartir = (FloatingActionButton) findViewById(R.id.fab_home);
        assert fab_compartir != null;
        fab_compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compartir(v);
            }
        });


        Bundle bun = getIntent().getExtras();
        String url = bun.getString("url");
        int numero = bun.getInt("numero");
        final String urlWiki = bun.getString("urlWiki");
        switch (numero) {
            case 0:
                tv_editar.setText(R.string.mantis);
                break;
            case 1:
                tv_editar.setText(R.string.mantis2);
                break;
            case 2:
                tv_editar.setText(R.string.mantis3);
                break;
            case 3:
                tv_editar.setText(R.string.mantis4);
                break;
            case 4:
                tv_editar.setText(R.string.mantis5);
                break;
            case 5:
                tv_editar.setText(R.string.mantis6);
                break;
            case 6:
                tv_editar.setText(R.string.mantis7);
                break;
        }


        ib_wiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ib_wiki.setImageResource(R.drawable.animacion_pulsar_wiki);
                irWiki(urlWiki);
            }
        });


        Glide.with(this)
                .load(url)
                .asBitmap()
                .into(iv_editar_imagen);

    }

    public void compartir(View view) {
        iv_editar_imagen.buildDrawingCache();
        Bitmap bitmap = iv_editar_imagen.getDrawingCache();

        try {
            File file = new File(iv_editar_imagen.getContext().getCacheDir(), bitmap + ".png");
            FileOutputStream fOut = null;
            fOut = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
            file.setReadable(true, false);
            final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
            intent.setType("image/png");
            startActivity(intent);
            ocultarNavigation();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ocultarNavigation() {
        View decorView = getWindow().getDecorView();

        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ocultarNavigation();
    }

    public void irWiki(String string) {
        Intent in = new Intent(EditarImagenMantis.this, VisorWeb.class);
        in.putExtra("url", string);
        startActivity(in);

    }
}
