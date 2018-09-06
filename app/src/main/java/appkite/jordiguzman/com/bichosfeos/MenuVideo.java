package appkite.jordiguzman.com.bichosfeos;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;

import java.util.Locale;

import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.mantis.MantisPager;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static appkite.jordiguzman.com.bichosfeos.Portada.numDialogo;

public class MenuVideo extends AppCompatActivity {

    Toolbar toolbar;

    public static int video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_video);
        cambiarIdioma();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        try {
            getSupportActionBar().hide();
        }catch (Exception e){
            e.printStackTrace();
        }






        View view = findViewById(R.id.iv_pulga_touch);
        assert view != null;
        MaterialRippleLayout.on(view)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irPulga();
            }
        });

        View view1 = findViewById(R.id.iv_piojo_touch);
        assert view1 != null;
        MaterialRippleLayout.on(view1)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irPiojo();
            }
        });

        View view2 = findViewById(R.id.iv_mosca_touch);
        assert view2 != null;
        MaterialRippleLayout.on(view2)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irPulga();irMosca();
            }
        });

        View view3 = findViewById(R.id.iv_mosquito_touch);
        assert view3 != null;
        MaterialRippleLayout.on(view3)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irMosquito();
            }
        });

        View view4 = findViewById(R.id.iv_imagenes_vari_touch);
        assert view4 != null;
        MaterialRippleLayout.on(view4)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irVari();
            }
        });

        View view5 = findViewById(R.id.iv_imagenes_vari2_touch);
        assert view5 != null;
        MaterialRippleLayout.on(view5)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irVari2();
            }
        });

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void irPulga() {
        video = 0;
        Intent in = new Intent(this, Video.class);
        startActivity(in);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

    public void irPiojo() {
        video = 1;
        Intent in = new Intent(this, Video.class);
        startActivity(in);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);

    }

    public void irMosca() {
        video = 2;
        Intent in = new Intent(this, Video.class);
        startActivity(in);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);

    }

    public void irMosquito() {
        video = 3;
        Intent in = new Intent(this, Video.class);
        startActivity(in);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);

    }

    public void irVari() {
        video = 4;
        Intent in = new Intent(this, Video.class);
        startActivity(in);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);

    }

    public void irVari2() {
        video = 5;
        Intent in = new Intent(this, Video.class);
        startActivity(in);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);

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
}
