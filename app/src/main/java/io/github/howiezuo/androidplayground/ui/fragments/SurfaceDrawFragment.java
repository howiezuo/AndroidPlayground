package io.github.howiezuo.androidplayground.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.ui.widgets.DrawView;


public class SurfaceDrawFragment extends BaseFragment {

    private static final String TAG = SurfaceDrawFragment.class.getName();

    @Bind(R.id.draw)
    DrawView drawView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MainFragment.
     */
    public static SurfaceDrawFragment newInstance() {
        SurfaceDrawFragment fragment = new SurfaceDrawFragment();
        return fragment;
    }

    public SurfaceDrawFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_draw, container, false);
    }

}
