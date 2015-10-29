package io.github.howiezuo.androidplayground.glide;

import android.os.Bundle;

import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.ui.MainActivity;

public class GlideActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.title_glide);

        if (savedInstanceState != null) {
            return;
        }

        addFragment(GlideFragment.newInstance());
    }
}
