package io.github.howiezuo.androidplayground.ui;

import android.os.Bundle;

import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.ui.fragments.DrawFragment;

public class DrawActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.title_draw);

        if (savedInstanceState != null) {
            return;
        }

        addFragment(DrawFragment.newInstance());
    }
}
