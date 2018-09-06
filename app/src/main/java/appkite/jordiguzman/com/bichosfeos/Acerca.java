package appkite.jordiguzman.com.bichosfeos;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Locale;

import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.mantis.MantisPager;

import static appkite.jordiguzman.com.bichosfeos.Portada.numDialogo;

public class Acerca extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acerca);
        cambiarIdioma();


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
