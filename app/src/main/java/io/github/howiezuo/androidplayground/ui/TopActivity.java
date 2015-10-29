package io.github.howiezuo.androidplayground.ui;

import android.os.Bundle;

import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.ui.fragments.MainFragment;

public class TopActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            return;
        }

        if (findViewById(R.id.fragment_container) != null) {
            getFragmentManager().beginTransaction().add(R.id.fragment_container, MainFragment.newInstance()).commit();
        }
    }
}
