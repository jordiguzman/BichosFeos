package appkite.jordiguzman.com.bichosfeos.informacion;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.robohorse.pagerbullet.PagerBullet;

import java.util.Locale;

import appkite.jordiguzman.com.bichosfeos.Idioma;
import appkite.jordiguzman.com.bichosfeos.R;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.mantis.MantisPager;

public class Imagenes extends AppCompatActivity {


    CustomSwipeAdapter adapter;
    PagerBullet pagerBullet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagenes);
        cambiarIdioma();

        pagerBullet = (PagerBullet) findViewById(R.id.view_pager);
        assert pagerBullet != null;
        pagerBullet.invalidateBullets();
        adapter = new CustomSwipeAdapter(this);
        adapter.notifyDataSetChanged();
        pagerBullet.setAdapter(adapter);

        pagerBullet.setIndicatorTintColorScheme(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.colorPrimary));


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
