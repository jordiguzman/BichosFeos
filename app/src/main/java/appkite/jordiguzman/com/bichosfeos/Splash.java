package appkite.jordiguzman.com.bichosfeos;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    //La duración del Splash
    private static final long SPLASH_SCREEN_DELAY = 1500;
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    protected void onCreate(Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);
       Splash.context = getApplicationContext();

        CheckInternet();
        //Orientación
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //Ocultar barra titulo ¡IMPORTANTE!
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        ocultarNavigation();

        setContentView(R.layout.activity_splash);

        TimerTask task = new TimerTask() {

            public void run() {

                //Empieza la nueva activity
                Intent mainIntent = new Intent(Splash.this, Portada.class);
                startActivity(mainIntent);


                //Cierra la activity. El usuario no podra volver pulsando el botón "Volver"
                finish();
            }
        };
        //Simulando una carga lenta de la aplicación
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);


        /**
         * IDIOMA
         */

        String idioma = Locale.getDefault().getLanguage();


        if (idioma.equals("ca") || idioma.equals("gl") || idioma.equals("eu") || idioma.equals("es")) {
            Locale locale = new Locale("es");
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            this.getApplicationContext().getResources().updateConfiguration(config, null);
        } else {
            Locale locale = new Locale("en");
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            this.getApplicationContext().getResources().updateConfiguration(config, null);
        }
    }

    public boolean CheckInternet()
    {
        ConnectivityManager connec = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        android.net.NetworkInfo wifi = connec.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        android.net.NetworkInfo mobile = connec.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        // Here if condition check for wifi and mobile network is available or not.
        // If anyone of them is available or connected then it will return true, otherwise false;

        if (wifi.isConnected()) {
            return true;
        } else if (mobile.isConnected()) {
            return true;
        }else{
            Toast.makeText(this, getResources().getText(R.string.CheckInternet), Toast.LENGTH_LONG).show();
            Toast.makeText(this, getResources().getText(R.string.CheckInternet1), Toast.LENGTH_LONG).show();
        }
        return false;
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
