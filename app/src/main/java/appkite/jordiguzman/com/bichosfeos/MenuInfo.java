package appkite.jordiguzman.com.bichosfeos;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.balysv.materialripple.MaterialRippleLayout;

import java.util.Locale;

import appkite.jordiguzman.com.bichosfeos.dialogos.DialogoImagenes;
import appkite.jordiguzman.com.bichosfeos.dialogos.DialogoInformacion;
import appkite.jordiguzman.com.bichosfeos.informacion.Imagenes;
import appkite.jordiguzman.com.bichosfeos.informacion.Informacion;
import appkite.jordiguzman.com.bichosfeos.informacion.Tecnica;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.mantis.MantisPager;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static appkite.jordiguzman.com.bichosfeos.Portada.numDialogo;

public class MenuInfo extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.floating_menu_info);
        cambiarIdioma();



        final DialogoInformacion dialogoInformacion= new DialogoInformacion();

        FloatingActionButton fab=(FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogoInformacion.show(getFragmentManager(), null);

            }
        });




        View view = findViewById(R.id.iv_teoria_touch);
        assert view != null;
        MaterialRippleLayout.on(view)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irTeoria();
            }
        });

        View view1 = findViewById(R.id.iv_tecnica_touch);
        assert view1 != null;
        MaterialRippleLayout.on(view1)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               irTecnica();
            }
        });

        View view2 = findViewById(R.id.iv_info_img_touch);
        assert view2 != null;
        MaterialRippleLayout.on(view2)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irImagenes();
            }
        });

    }
    public void irTeoria(){
        Intent in= new Intent(MenuInfo.this, Informacion.class);
        startActivity(in);
    }
    public void irTecnica(){
        Intent in= new Intent(MenuInfo.this, Tecnica.class);
        startActivity(in);
    }

    public void irImagenes(){
        Intent in= new Intent(MenuInfo.this, Imagenes.class);
        startActivity(in);
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

        }

        if (ori==2 && Idioma.currentIdioma ==2 || ori==1 && Idioma.currentIdioma==2){
            String languageToLoad  = "en"; // your language
            Locale locale = new Locale(languageToLoad);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config,
                    getBaseContext().getResources().getDisplayMetrics());
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        MantisPager.posImagen=-1;
        cambiarIdioma();
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        MantisPager.posImagen=-1;
        cambiarIdioma();

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        numDialogo=1;
        Intent ba= new Intent(this, MenuInicio.class);
        startActivity(ba);
        overridePendingTransition(R.anim.right_in, R.anim.right_out);
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
