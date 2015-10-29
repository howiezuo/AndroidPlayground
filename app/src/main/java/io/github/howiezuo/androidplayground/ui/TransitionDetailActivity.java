package io.github.howiezuo.androidplayground.ui;

import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.view.Window;

import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.ui.fragments.TransitionDetailFragment;

public class TransitionDetailActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(new Fade());
            getWindow().setExitTransition(new Fade());
            getWindow().setAllowEnterTransitionOverlap(true);
            getWindow().setAllowReturnTransitionOverlap(true);
        }

        getSupportActionBar().setTitle(R.string.title_transition);

        if (savedInstanceState != null) {
            return;
        }

        if (findViewById(R.id.fragment_container) != null) {
            getFragmentManager().beginTransaction().add(R.id.fragment_container, TransitionDetailFragment.newInstance()).commit();
        }
    }

}
