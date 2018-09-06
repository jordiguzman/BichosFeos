package appkite.jordiguzman.com.bichosfeos;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.balysv.materialripple.MaterialRippleLayout;

import java.util.Locale;

import appkite.jordiguzman.com.bichosfeos.dialogos.DialogoImagenes;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.avispas.AvispasPager;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.coloreadas.ColoreadasPager;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.escarabajos.EscarabajosPager;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.gorgojos.GorgojosPager;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.grillos.GrillosPager;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.hormigas.HormigasPager;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.mantis.MantisPager;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.moscas.MoscasPager;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.polillas.PolillasPager;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.saltamontes.SaltamontesPager;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.tabanos.TabanosPager;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static appkite.jordiguzman.com.bichosfeos.Portada.numDialogo;

public class MenuImagenes extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.floating_menu_imagenes);
        cambiarIdioma();

        MantisPager.dialogo = false;



        final DialogoImagenes dialogoImagenes = new DialogoImagenes();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_imagenes);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogoImagenes.show(getFragmentManager(), null);
            }
        });

        View view = findViewById(R.id.iv_img_mantis_touch);
        assert view != null;
        MaterialRippleLayout.on(view)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irMantis(v);
            }
        });

        View view1 = findViewById(R.id.iv_img_avispas_touch);
        assert view1 != null;
        MaterialRippleLayout.on(view1)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irAvispas(v);
            }
        });

        View view2 = findViewById(R.id.iv_img_escarabajo_touch);
        assert view2 != null;
        MaterialRippleLayout.on(view2)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irEscarabajos(v);
            }
        });

        View view3 = findViewById(R.id.iv_img_tabano_touch);
        assert view3 != null;
        MaterialRippleLayout.on(view3)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irTabanos(v);
            }
        });

        View view4 = findViewById(R.id.iv_img_gorgojo_touch);
        assert view4 != null;
        MaterialRippleLayout.on(view4)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irGorgojos(v);
            }
        });

        View view5 = findViewById(R.id.iv_img_grillos_touch);
        assert view5 != null;
        MaterialRippleLayout.on(view5)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irGrillos(v);
            }
        });

        View view6 = findViewById(R.id.iv_img_hormigas_touch);
        assert view6 != null;
        MaterialRippleLayout.on(view6)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irHormigas(v);
            }
        });

        View view7 = findViewById(R.id.iv_img_mosca_touch);
        assert view7 != null;
        MaterialRippleLayout.on(view7)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irMoscas(v);
            }
        });

        View view8 = findViewById(R.id.iv_img_polillas_touch);
        assert view8 != null;
        MaterialRippleLayout.on(view8)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irPolillas(v);
            }
        });

        View view9 = findViewById(R.id.iv_img_saltamontes_touch);
        assert view9 != null;
        MaterialRippleLayout.on(view9)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irSaltamontes(v);
            }
        });



        /**
         * AQUI LOS INSECTOS QUE FALTAN
         */

        View view10= findViewById(R.id.iv_img_coloreadas_touch);
        assert view10 != null;
        MaterialRippleLayout.on(view10)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irColoreadas(v);
            }
        });

    }

    public void irMantis(View view) {
        Intent in = new Intent(MenuImagenes.this, MantisPager.class);
        startActivity(in);
    }

    public void irAvispas(View view) {
        Intent in = new Intent(MenuImagenes.this, AvispasPager.class);
        startActivity(in);
    }

    public void irEscarabajos(View view) {
        Intent in = new Intent(MenuImagenes.this, EscarabajosPager.class);
        startActivity(in);
    }

    public void irTabanos(View view) {
        Intent in = new Intent(MenuImagenes.this, TabanosPager.class);
        startActivity(in);
    }

    public void irGorgojos(View view) {
        Intent in = new Intent(MenuImagenes.this, GorgojosPager.class);
        startActivity(in);
    }
    public void irGrillos(View view) {
        Intent in = new Intent(MenuImagenes.this, GrillosPager.class);
        startActivity(in);
    }

    public void irHormigas(View view) {
        Intent in = new Intent(MenuImagenes.this, HormigasPager.class);
        startActivity(in);
    }

    public void irMoscas(View view) {
        Intent in = new Intent(MenuImagenes.this, MoscasPager.class);
        startActivity(in);
    }

    public void irPolillas(View view) {
        Intent in = new Intent(MenuImagenes.this, PolillasPager.class);
        startActivity(in);
    }

    public void irSaltamontes(View view) {
        Intent in = new Intent(MenuImagenes.this, SaltamontesPager.class);
        startActivity(in);
    }



    public void irColoreadas(View view){
        Intent in= new Intent(MenuImagenes.this, ColoreadasPager.class);
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
        Intent ba = new Intent(this, MenuInicio.class);
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
