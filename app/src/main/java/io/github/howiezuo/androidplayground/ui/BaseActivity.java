package io.github.howiezuo.androidplayground.ui;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.ui.fragments.DrawFragment;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(onGetLayoutResID());
        ButterKnife.bind(this);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    protected void addFragment(@NonNull @IdRes int viewId, @NonNull Fragment fragment) {
        if (fragment == null) return;
        if (findViewById(viewId) == null) return;

        getFragmentManager().beginTransaction().add(viewId, fragment).commit();
    }

    protected abstract int onGetLayoutResID();
}
