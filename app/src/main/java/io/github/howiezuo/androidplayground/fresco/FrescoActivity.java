package io.github.howiezuo.androidplayground.fresco;

import android.os.Bundle;

import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.fresco.FrescoFragment;
import io.github.howiezuo.androidplayground.ui.MainActivity;

public class FrescoActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.title_draw);

        if (savedInstanceState != null) {
            return;
        }

        addFragment(FrescoFragment.newInstance());
    }
}
