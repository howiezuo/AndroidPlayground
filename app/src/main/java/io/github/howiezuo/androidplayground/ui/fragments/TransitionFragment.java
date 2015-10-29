package io.github.howiezuo.androidplayground.ui.fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.OnClick;
import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.ui.TransitionDetailActivity;


public class TransitionFragment extends BaseFragment {

    private static final String TAG = TransitionFragment.class.getName();

    @Bind(R.id.root_layout)
    ViewGroup mRootLayout;

    @Bind(R.id.mask_view)
    View mMaskView;
    @Bind(R.id.android_image)
    ImageView mAndroidImage;

    @Bind(R.id.red_view)
    View mRedView;
    @Bind(R.id.blue_view)
    View mBlueView;
    @Bind(R.id.green_view)
    View mGreenView;
    @Bind(R.id.yellow_view)
    View mYellowView;

    public static TransitionFragment newInstance() {
        TransitionFragment fragment = new TransitionFragment();
        return fragment;
    }

    public TransitionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_transition, container, false);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int cx = (mMaskView.getLeft() + mMaskView.getRight()) / 2;
            int cy = (mMaskView.getTop() + mMaskView.getBottom()) / 2;
            int finalRadius = Math.max(mMaskView.getWidth(), mMaskView.getHeight());
            Animator anim =
                    ViewAnimationUtils.createCircularReveal(mMaskView, cx, cy, finalRadius, 0);
            anim.setDuration(1000);
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    mMaskView.setVisibility(View.INVISIBLE);
                }
            });
            anim.start();
        }
    }

    @OnClick(R.id.red_view)
    public void onClickRedView() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityCompat.startActivity(
                    getActivity(),
                    new Intent(getActivity(), TransitionDetailActivity.class),
                    ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), mRedView, "transition").toBundle()
            );
//        }
    }

    @OnClick(R.id.blue_view)
    public void onClickBlueView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int maskX = (mMaskView.getLeft() + mMaskView.getRight()) / 2;
            int maskY = (mMaskView.getTop() + mMaskView.getBottom()) / 2;
            int maskR = Math.max(mMaskView.getWidth(), mMaskView.getHeight());
            Animator maskAnim =
                    ViewAnimationUtils.createCircularReveal(mMaskView, maskX, maskY, 0, maskR);
            mMaskView.setVisibility(View.VISIBLE);
            maskAnim.setDuration(2000);
            maskAnim.start();

            int imgX = (mAndroidImage.getLeft() + mAndroidImage.getRight()) / 2;
            int imgY = (mAndroidImage.getTop() + mAndroidImage.getBottom()) / 2;
            int imgR = Math.max(mAndroidImage.getWidth(), mAndroidImage.getHeight());
            Animator imgAnim =
                    ViewAnimationUtils.createCircularReveal(mAndroidImage, imgX, imgY, 0, imgR);
            mAndroidImage.setVisibility(View.VISIBLE);
            imgAnim.setDuration(1000);
//            imgAnim.setStartDelay(10);
            imgAnim.start();
            imgAnim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    startActivityForResult(
                            new Intent(getActivity(), TransitionDetailActivity.class),
                            100
                    );
//                    ActivityCompat.startActivityForResult(
//                            getActivity(),
//                            new Intent(getActivity(), TransitionDetailActivity.class),
//                            100,
//                            null);
                }
            });
        }
    }
}
