package io.github.howiezuo.androidplayground.otto;

import android.os.Bundle;

import com.squareup.otto.Subscribe;

import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.ui.MainActivity;

public class OttoActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.title_otto);

        if (savedInstanceState != null) {
            return;
        }

        addFragment(OttoFragment.newInstance());
    }

    @Subscribe
    public void eventMessage(StringEvent event) {
        getSupportActionBar().setTitle(event.getString());
    }
}
