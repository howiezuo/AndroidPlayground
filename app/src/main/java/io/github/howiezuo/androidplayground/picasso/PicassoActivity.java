package io.github.howiezuo.androidplayground.picasso;

import android.os.Bundle;

import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.picasso.PicassoFragment;
import io.github.howiezuo.androidplayground.ui.MainActivity;

public class PicassoActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.title_picasso);

        if (savedInstanceState != null) {
            return;
        }

        addFragment(R.id.fragment_container, PicassoFragment.newInstance());
    }
}
