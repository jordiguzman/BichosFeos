package appkite.jordiguzman.com.bichosfeos.touchImageView.ui.escarabajos;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Locale;
import java.util.Objects;

import appkite.jordiguzman.com.bichosfeos.Idioma;
import appkite.jordiguzman.com.bichosfeos.MenuImagenes;
import appkite.jordiguzman.com.bichosfeos.R;
import appkite.jordiguzman.com.bichosfeos.VisorWeb;
import appkite.jordiguzman.com.bichosfeos.dialogos.DialogoAyudaImagenes;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ExtendedViewPager;
import appkite.jordiguzman.com.bichosfeos.touchImageView.TouchImageView;
import appkite.jordiguzman.com.bichosfeos.touchImageView.provider.Avispas_url;
import appkite.jordiguzman.com.bichosfeos.touchImageView.provider.Escarabajos_url;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.avispas.AvispasPager;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.avispas.EditarImagenAvispas;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.mantis.MantisPager;


public class EscarabajosPager extends Activity {
    private static Context context;
    static TextView tv_modelo;
    public static TouchImageView img;
    public static int posImagen=-1;
    static Button btn_wiki, btn_bajar, btn_help;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_modelo);

        btn_wiki=(Button) findViewById(R.id.btn_wiki);
        btn_bajar=(Button)findViewById(R.id.btn_bajar);
        btn_help=(Button)findViewById(R.id.btn_help);
        tv_modelo = (TextView) findViewById(R.id.tv_mantis);

        final DialogoAyudaImagenes dialogoAyudaImagenes= new DialogoAyudaImagenes();

        btn_wiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(posImagen==-1){
                    Toast.makeText(getAppContext(), getResources().getText(R.string.mensajePager), Toast.LENGTH_LONG).show();
                }else {
                    switch (posImagen) {

                        case 0:
                            irWiki();
                            break;
                        case 1:
                            irWiki();
                            break;
                        case 2:
                            irWiki();
                            break;
                        case 3:
                            irWiki();
                            break;
                        case 4:
                            irWiki();
                            break;
                        case 5:
                            irWiki();
                            break;
                        case 6:
                            irWiki();
                            break;
                        case 7:
                            irWiki();
                            break;
                        case 8:
                            irWiki();
                            break;
                        case 9:
                            irWiki();
                            break;

                    }
                }
            }
        });

        btn_bajar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(posImagen==-1){
                    Toast.makeText(getAppContext(), getResources().getText(R.string.mensajePager), Toast.LENGTH_LONG).show();
                }else{
                    bajar();
                }

            }
        });

        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogoAyudaImagenes.show(getFragmentManager(), null);
            }
        });
        ExtendedViewPager mViewPager = (ExtendedViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(new TouchImageAdapter());


        EscarabajosPager.context = getApplicationContext();

    }
    public void bajar()  {

        Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
        try {
            myWebLink.setData(Uri.parse("http://jordiguzman.com/bf/Escarabajos.zip"));
        }catch (Exception e){
            Toast.makeText(this,  R.string.servidor, Toast.LENGTH_SHORT).show();
        }
        startActivity(myWebLink);

    }

    public void irWiki() {
        Intent in = new Intent(EscarabajosPager.this, VisorWeb.class);

        String idioma= String.valueOf(Locale.getDefault());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Objects.equals(idioma, "en") || Objects.equals(idioma, "en_GB") || Objects.equals(idioma, "en_US")){
                in.putExtra("urlWiki", Escarabajos_url.escarabajosUrlWikiEn[posImagen]);
            }if (Objects.equals(idioma, "es") || Objects.equals(idioma, "es_ES")){
                in.putExtra("urlWiki", Escarabajos_url.escarabajosUrlWiki[posImagen]);
            }
        }

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
        posImagen=-1;
        MantisPager.posImagen=-1;
        cambiarIdioma();
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        posImagen=-1;
        MantisPager.posImagen=-1;
        cambiarIdioma();

    }


    public static Context getAppContext() {
        return EscarabajosPager.context;
    }


    class TouchImageAdapter extends PagerAdapter {
        public TouchImageAdapter() {

        }

        @Override
        public int getCount() {
            return Escarabajos_url.escarabajosUrl.length;
        }

        @Override
        public View instantiateItem(ViewGroup container, final int position) {
            tv_modelo.setText("");
            posImagen=-1;


            img = new TouchImageView(container.getContext());


            Glide.with(getAppContext())
                    .load(Escarabajos_url.escarabajosUrl[position])
                    .asBitmap()
                    .placeholder(R.drawable.foto_vacia)
                    .into(img);
            container.addView(img, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {
                        switch (position){

                            case 0:
                                tv_modelo.setText(R.string.escarabajo);
                                posImagen=0;

                                break;
                            case 1:
                                tv_modelo.setText(R.string.escarabajo2);
                                posImagen=1;
                                break;
                            case 2:
                                tv_modelo.setText(R.string.escarabajo3);
                                posImagen=2;
                                break;
                            case 3:
                                tv_modelo.setText(R.string.escarabajo4);
                                posImagen=3;
                                break;
                            case 4:
                                tv_modelo.setText(R.string.escarabajo5);
                                posImagen=4;
                                break;
                            case 5:
                                tv_modelo.setText(R.string.escarabajo6);
                                posImagen=5;
                                break;
                            case 6:
                                tv_modelo.setText(R.string.escarabajo7);
                                posImagen=6;
                                break;
                            case 7:
                                tv_modelo.setText(R.string.escarabajo8);
                                posImagen=7;
                                break;
                            case 8:
                                tv_modelo.setText(R.string.escarabajo9);
                                posImagen=8;
                                break;
                            case 9:
                                tv_modelo.setText(R.string.escarabajo10);
                                posImagen=9;
                                break;

                        }
                    }catch (Exception e){
                        e.printStackTrace();
                        Toast.makeText(getAppContext(), "Error", Toast.LENGTH_LONG).show();
                    }

                }
            });

            return img;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
            tv_modelo.setText("");
            posImagen=-1;

        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }



    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        posImagen=-1;
        Intent in= new Intent(EscarabajosPager.this, MenuImagenes.class);
        startActivity(in);
    }
}
