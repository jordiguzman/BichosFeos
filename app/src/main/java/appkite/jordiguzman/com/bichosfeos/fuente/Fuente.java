package appkite.jordiguzman.com.bichosfeos.fuente;

import android.app.Application;

import appkite.jordiguzman.com.bichosfeos.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Jordi Guzman on 02/04/2016.
 */
public class Fuente extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/msyi.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
    }
}
