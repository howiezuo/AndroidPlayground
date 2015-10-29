package io.github.howiezuo.androidplayground.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.ui.widgets.DrawView;


public class DrawFragment extends BaseFragment {

    private static final String TAG = DrawFragment.class.getName();

    @Bind(R.id.draw)
    DrawView drawView;

    public static DrawFragment newInstance() {
        DrawFragment fragment = new DrawFragment();
        return fragment;
    }

    public DrawFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_draw, container, false);
    }

}
