package appkite.jordiguzman.com.bichosfeos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Locale;

import appkite.jordiguzman.com.bichosfeos.adaptador.AdaptadorEnlaces;
import appkite.jordiguzman.com.bichosfeos.titulador.TitulosEnlaces;
import appkite.jordiguzman.com.bichosfeos.touchImageView.provider.Enlaces_url;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.mantis.MantisPager;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static appkite.jordiguzman.com.bichosfeos.Portada.numDialogo;

public class Enlaces extends Activity {


    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enlaces);
        cambiarIdioma();

         listView=(ListView)findViewById(R.id.lista_enlaces);

        TitulosEnlaces[] args= new TitulosEnlaces[]{
                new TitulosEnlaces(getResources().getString(R.string.enlace_ugly)),
                new TitulosEnlaces(getResources().getString(R.string.enlace_telegraph)),
                new TitulosEnlaces(getResources().getString(R.string.enlace_micronaut)),
                new TitulosEnlaces(getResources().getString(R.string.enlace_dartmouth)),
                new TitulosEnlaces(getResources().getString(R.string.enlace_mundoMicroscopio)),
                new TitulosEnlaces(getResources().getString(R.string.enlace_macromite)),
                new TitulosEnlaces(getResources().getString(R.string.enlace_cosmos)),
                new TitulosEnlaces(getResources().getString(R.string.enlace_sem_BLOG)),
                new TitulosEnlaces(getResources().getString(R.string.enlace_nikon)),

        };
        AdaptadorEnlaces adap = new AdaptadorEnlaces(this, args);
        listView.setAdapter(adap);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){

                    case 0:
                        Intent in= new Intent(Intent.ACTION_VIEW, Uri.parse(Enlaces_url.enlacesUrl[position]));
                        startActivity(in);
                        break;
                    case 1:
                        Intent in1= new Intent(Intent.ACTION_VIEW, Uri.parse(Enlaces_url.enlacesUrl[position]));
                        startActivity(in1);
                        break;
                    case 2:
                        Intent in2= new Intent(Intent.ACTION_VIEW, Uri.parse(Enlaces_url.enlacesUrl[position]));
                        startActivity(in2);
                        break;
                    case 3:
                        Intent in3= new Intent(Intent.ACTION_VIEW, Uri.parse(Enlaces_url.enlacesUrl[position]));
                        startActivity(in3);
                        break;
                    case 4:
                        Intent in4= new Intent(Intent.ACTION_VIEW, Uri.parse(Enlaces_url.enlacesUrl[position]));
                        startActivity(in4);
                        break;
                    case 5:
                        Intent in5= new Intent(Intent.ACTION_VIEW, Uri.parse(Enlaces_url.enlacesUrl[position]));
                        startActivity(in5);
                        break;
                    case 6:
                        Intent in6= new Intent(Intent.ACTION_VIEW, Uri.parse(Enlaces_url.enlacesUrl[position]));
                        startActivity(in6);
                        break;
                    case 7:
                        Intent in7= new Intent(Intent.ACTION_VIEW, Uri.parse(Enlaces_url.enlacesUrl[position]));
                        startActivity(in7);
                        break;
                    case 8:
                        Intent in8= new Intent(Intent.ACTION_VIEW, Uri.parse(Enlaces_url.enlacesUrl[position]));
                        startActivity(in8);
                        break;

                }
            }
        });


    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
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
