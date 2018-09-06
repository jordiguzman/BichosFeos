package appkite.jordiguzman.com.bichosfeos;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.balysv.materialripple.MaterialRippleLayout;
import java.util.Locale;

import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.mantis.MantisPager;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static appkite.jordiguzman.com.bichosfeos.Portada.numDialogo;

public class Idioma extends AppCompatActivity {

    public static Context context;
    public static int currentIdioma;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idioma);
        cambiarIdioma();


        Idioma.context = getApplicationContext();


        View view = findViewById(R.id.iv_idioma_esp_touch);
        assert view != null;
        MaterialRippleLayout.on(view)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIdioma =1;
                Locale locale = new Locale("es");
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getAppContext().getApplicationContext().getResources().updateConfiguration(config, null);
                Intent go = new Intent(getApplicationContext(), MenuInicio.class);
                startActivity(go);

            }
        });

        View view1 = findViewById(R.id.iv_idioma_ingl_touch);
        assert view1 != null;
        MaterialRippleLayout.on(view1)
                .rippleColor(Color.parseColor("#20ffffff"))
                .rippleAlpha(0.2f)
                .rippleHover(true)
                .create();
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIdioma =2;
                Locale locale1 = new Locale("en");
                Locale.setDefault(locale1);
                Configuration config1 = new Configuration();
                config1.locale = locale1;
                getAppContext().getApplicationContext().getResources().updateConfiguration(config1, null);
                Intent go1 = new Intent(getApplicationContext(), MenuInicio.class);
                startActivity(go1);

            }
        });


    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        numDialogo=1;
        Intent ba= new Intent(this, MenuInicio.class);
        startActivity(ba);
        overridePendingTransition(R.anim.right_in, R.anim.right_out);
    }
    public static Context getAppContext() {
        return Idioma.context;
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
}
