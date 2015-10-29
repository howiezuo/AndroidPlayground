package io.github.howiezuo.androidplayground;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.picasso.Picasso;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Picasso
        new Picasso.Builder(this)
                .loggingEnabled(true)
                .listener(new PicassoListener())
                .build();

        // Fresco
        Fresco.initialize(this);

        // LeakCanary
        LeakCanary.install(this);

        // Font
        CalligraphyConfig.initDefault(
                new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/NotoSans-Regular.ttf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
        );
    }
}
