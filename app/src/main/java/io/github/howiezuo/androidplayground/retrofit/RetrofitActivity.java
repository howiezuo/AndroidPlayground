package io.github.howiezuo.androidplayground.retrofit;

import android.os.Bundle;

import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.retrofit.RetrofitFragment;
import io.github.howiezuo.androidplayground.ui.MainActivity;

public class RetrofitActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.title_retrofit);

        if (savedInstanceState != null) {
            return;
        }

        addFragment(RetrofitFragment.newInstance());
    }
}
