package appkite.jordiguzman.com.bichosfeos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.avispas.AvispasPager;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.escarabajos.EscarabajosPager;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.gorgojos.GorgojosPager;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.grillos.GrillosPager;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.hormigas.HormigasPager;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.mantis.MantisPager;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.moscas.MoscasPager;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.polillas.PolillasPager;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.saltamontes.SaltamontesPager;
import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.tabanos.TabanosPager;

import static appkite.jordiguzman.com.bichosfeos.touchImageView.ui.avispas.AvispasPager.idioma;

public class VisorWeb extends Activity {

    WebView webView;
    ImageView iv_cerrar;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visor_web);

        webView=(WebView)findViewById(R.id.web_view);
        iv_cerrar=(ImageView) findViewById(R.id.iv_cerrar);
        progressBar= (ProgressBar) findViewById(R.id.pb_web);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(true);

        Bundle bun=getIntent().getExtras();
        try {
            webView.loadUrl(bun.getString("urlWiki"));
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, R.string.problema_idioma, Toast.LENGTH_SHORT).show();
        }

        progressBar.setVisibility(View.VISIBLE);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                view.loadUrl(url);
                progressBar.setVisibility(View.GONE);
                return true;
            }
        });


    }
    public void cerrarWeb(View view){
        AvispasPager.posImagen=-1;
        HormigasPager.posImagen=-1;
        EscarabajosPager.posImagen=-1;
        GorgojosPager.posImagen=-1;
        GrillosPager.posImagen=-1;
        MantisPager.posImagen=-1;
        TabanosPager.posImagen=-1;
        MoscasPager.posImagen=-1;
        PolillasPager.posImagen=-1;
        SaltamontesPager.posImagen=-1;
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MantisPager.posImagen=-1;
    }
}
