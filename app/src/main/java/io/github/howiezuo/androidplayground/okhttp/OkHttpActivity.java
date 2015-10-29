package io.github.howiezuo.androidplayground.okhttp;

import android.os.Bundle;

import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.ui.MainActivity;

public class OkHttpActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.title_ok_http);

        if (savedInstanceState != null) {
            return;
        }

        addFragment(OkHttpFragment.newInstance());
    }
}
