package appkite.jordiguzman.com.bichosfeos;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.balysv.materialripple.MaterialRippleLayout;

import java.util.Locale;

import appkite.jordiguzman.com.bichosfeos.dialogos.DialogoInicio;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.mantis.MantisPager;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static appkite.jordiguzman.com.bichosfeos.Portada.numDialogo;

public class MenuInicio extends AppCompatActivity {

    public int ir;
    private static Context context;
    public DialogoInicio dialogoInicio;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.floating_menu_inicio);
        cambiarIdioma();
        MenuInicio.context = getApplicationContext();

        iniciaDialogo();




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    numDialogo=0;
                    dialogoInicio = new DialogoInicio();
                    dialogoInicio.show(getFragmentManager(), null);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

        View view = findViewById(R.id.iv_imag_touch);
        assert view != null;
        MaterialRippleLayout.on(view)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irMenuImagenes(v);
            }
        });

        View view1 = findViewById(R.id.iv_info_touch);
        assert view1 != null;
        MaterialRippleLayout.on(view1)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irMenuInfo(v);
            }
        });

        View view2 = findViewById(R.id.iv_enlaces_touch);
        assert view2 != null;
        MaterialRippleLayout.on(view2)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irEnlaces(v);
            }
        });
        View view3 = findViewById(R.id.iv_video_touch);
        assert view3 != null;
        MaterialRippleLayout.on(view3)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irVideo(v);
            }
        });

        View view4 = findViewById(R.id.iv_idioma_touch);
        assert view4 != null;
        MaterialRippleLayout.on(view4)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irIdioma(v);
            }
        });

        View view5 = findViewById(R.id.iv_acerca_touch);
        assert view5 != null;
        MaterialRippleLayout.on(view5)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irAcerca(v);
            }
        });



    }
    public void iniciaDialogo(){


        if (numDialogo==0){
            dialogoInicio = new DialogoInicio();
            dialogoInicio.show(getFragmentManager(), null);
            numDialogo+=+1;

        }else{
            try {
                dialogoInicio.dismiss();
            }catch (Exception e){
                e.printStackTrace();

            }

        }

    }

    public void cambiarIdioma(){
        int ori=getResources().getConfiguration().orientation;

        if (ori==1 && Idioma.currentIdioma ==1 || ori==2 && Idioma.currentIdioma==1){
            String languageToLoad  = "es"; // your language
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());
            numDialogo=1;

        }

        if (ori==2 && Idioma.currentIdioma ==2 || ori==1 && Idioma.currentIdioma==2){
            String languageToLoad  = "en"; // your language
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());
            numDialogo=1;
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        MantisPager.posImagen=-1;
        cambiarIdioma();
        numDialogo=1;
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        MantisPager.posImagen=-1;
        cambiarIdioma();
        numDialogo=1;

    }



    public static Context getAppContext() {
        return MenuInicio.context;
    }
    public void irMenuImagenes(View view) {

        Intent in = new Intent(MenuInicio.this, MenuImagenes.class);
        startActivity(in);

        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

    public void irMenuInfo(View view) {
        Intent in1 = new Intent(MenuInicio.this, MenuInfo.class);
        startActivity(in1);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

    public void irEnlaces(View view) {
        Intent in1 = new Intent(MenuInicio.this, Enlaces.class);
        startActivity(in1);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

    public void irVideo(View view) {
        Intent in = new Intent(MenuInicio.this, MenuVideo.class);
        startActivity(in);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

    public void irIdioma(View view) {
        Intent in = new Intent(MenuInicio.this, Idioma.class);
        startActivity(in);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

    public void irAcerca(View view) {
        Intent in = new Intent(MenuInicio.this, Acerca.class);
        startActivity(in);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

    /**
     * LAYOUTS INFLADOS
     *
     */






    /**
     * *********************************************
     */



    @Override
    public void onBackPressed() {
        if (ir == 1) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        } else {
            ir = 1;
            Toast.makeText(this, getText(R.string.salir), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
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






}
