package io.github.howiezuo.androidplayground.ui.fragments;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.OnClick;
import io.github.howiezuo.androidplayground.R;


public class TransitionDetailFragment extends BaseFragment {

    private static final String TAG = TransitionDetailFragment.class.getName();

    @Bind(R.id.root_layout)
    ViewGroup mRootLayout;

    @Bind(R.id.detail_view)
    View mDetailView;
    View mYellowView;

    public static TransitionDetailFragment newInstance() {
        TransitionDetailFragment fragment = new TransitionDetailFragment();
        return fragment;
    }

    public TransitionDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_transition_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @OnClick(R.id.detail_view)
    public void onDetailViewClicked() {
        ActivityCompat.finishAfterTransition(getActivity());
    }
}
