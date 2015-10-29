package io.github.howiezuo.androidplayground.picasso;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.ui.fragments.BaseFragment;

public class PicassoFragment extends BaseFragment {

    private static final String TAG = PicassoFragment.class.getName();

    @Bind(R.id.img)
    ImageView mImage;

    public static PicassoFragment newInstance() {
        PicassoFragment fragment = new PicassoFragment();
        return fragment;
    }

    public PicassoFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_picasso, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Picasso.with(getActivity()).load("http://i.imgur.com/DvpvklR.png").into(mImage);
    }
}
