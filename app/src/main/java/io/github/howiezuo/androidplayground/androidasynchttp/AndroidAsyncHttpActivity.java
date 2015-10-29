package io.github.howiezuo.androidplayground.androidasynchttp;

import android.os.Bundle;

import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.ui.MainActivity;

public class AndroidAsyncHttpActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.title_android_async_http);

        if (savedInstanceState != null) {
            return;
        }

        addFragment(AndroidAsyncHttpFragment.newInstance());
    }
}
