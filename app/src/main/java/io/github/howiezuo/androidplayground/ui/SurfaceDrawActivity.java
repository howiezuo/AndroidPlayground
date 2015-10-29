package io.github.howiezuo.androidplayground.ui;

import android.os.Bundle;

import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.ui.fragments.SurfaceDrawFragment;

public class SurfaceDrawActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.title_surface_draw);

        if (savedInstanceState != null) {
            return;
        }

        if (findViewById(R.id.fragment_container) != null) {
            getFragmentManager().beginTransaction().add(R.id.fragment_container, SurfaceDrawFragment.newInstance()).commit();
        }

    }
}
