package appkite.jordiguzman.com.bichosfeos;


import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import appkite.jordiguzman.com.bichosfeos.touchImageView.ui.mantis.MantisPager;


public class Portada extends AppCompatActivity implements AnimationListener {

    public static int numDialogo=0;

    ImageView iv_portada, iv_bicho;
    TextView tv_portada;
    Animation fadein;


    AnimationDrawable animacion;

    String url_land = "https://kickintheeyeblog.files.wordpress.com/2016/07/c0290304-aedes_aegypti_mosquito_sem-1200x800.jpg";
    String url_ver = "https://kickintheeyeblog.files.wordpress.com/2016/06/pulga.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portada);

        ocultarNavigation();
        iv_portada = (ImageView) findViewById(R.id.iv_portada);
        tv_portada = (TextView) findViewById(R.id.tv_portada1);


        final int screenOrientation = ((WindowManager) this.getSystemService(WINDOW_SERVICE)).getDefaultDisplay().getOrientation();
        if (isTablet(this)) {
            switch (screenOrientation) {
                case Surface.ROTATION_90:
                    Glide.with(this)
                            .load(url_ver)
                            .asBitmap()
                            .into(iv_portada);
                    break;
                case Surface.ROTATION_0:
                    Glide.with(this)
                            .load(url_land)
                            .asBitmap()
                            .into(iv_portada);
                    break;
                case Surface.ROTATION_180:
                    Glide.with(this)
                            .load(url_ver)
                            .asBitmap()
                            .into(iv_portada);
                    break;
                    case Surface.ROTATION_270:
                        Glide.with(this)
                                .load(url_ver)
                                .asBitmap()
                                .into(iv_portada);
                        break;
            }
        } else {
            switch (screenOrientation) {
                case Surface.ROTATION_90:
                    Glide.with(this)
                            .load(url_land)
                            .asBitmap()
                            .into(iv_portada);
                    break;
                case Surface.ROTATION_0:
                    Glide.with(this)
                            .load(url_ver)
                            .asBitmap()
                            .into(iv_portada);
                    break;
                case Surface.ROTATION_180:
                    Glide.with(this)
                            .load(url_ver)
                            .asBitmap()
                            .into(iv_portada);
                    break;

            }
        }


        iv_bicho = (ImageView) findViewById(R.id.iv_bicho);
        if (iv_bicho != null) {
            iv_bicho.setBackgroundResource(R.drawable.animacion_antenas);
        }
        assert iv_bicho != null;
        animacion = (AnimationDrawable) iv_bicho.getBackground();
        animacion.start();
        animacion.setOneShot(false);

        fadein = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fadein_portada);
        fadein.setAnimationListener(this);
        iv_portada.startAnimation(fadein);

        tv_portada.startAnimation(fadein);
        iv_bicho.startAnimation(fadein);


    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }


    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

        Intent in = new Intent(getApplication(), MenuInicio.class);
        MantisPager.posImagen = -1;
        startActivity(in);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    public void ocultarNavigation() {
        View decorView = getWindow().getDecorView();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                            | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                            | View.SYSTEM_UI_FLAG_IMMERSIVE);
        }
    }

}
