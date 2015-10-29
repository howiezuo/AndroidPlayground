package io.github.howiezuo.androidplayground.ui;

import android.os.Bundle;

import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.ui.fragments.CameraFragment;
import io.github.howiezuo.androidplayground.ui.fragments.DrawFragment;

public class CameraActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.title_camera);

        if (savedInstanceState != null) {
            return;
        }

        if (findViewById(R.id.fragment_container) != null) {
            getFragmentManager().beginTransaction().add(R.id.fragment_container, CameraFragment.newInstance()).commit();
        }
    }
}
