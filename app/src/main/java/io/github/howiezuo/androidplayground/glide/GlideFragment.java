package io.github.howiezuo.androidplayground.glide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.ui.fragments.BaseFragment;

public class GlideFragment extends BaseFragment {

    @Bind(R.id.img_glide)
    public ImageView glideImage;

    public static GlideFragment newInstance() {
        GlideFragment fragment = new GlideFragment();
        return fragment;
    }

    public GlideFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_glide, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Glide
                .with(this)
                .load("https://raw.githubusercontent.com/bumptech/glide/master/static/glide_logo.png")
                .into(glideImage);
    }
}
