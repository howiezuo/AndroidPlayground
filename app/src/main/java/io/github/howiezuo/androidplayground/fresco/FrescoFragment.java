package io.github.howiezuo.androidplayground.fresco;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.ui.fragments.BaseFragment;

public class FrescoFragment extends BaseFragment {

    @Bind(R.id.img_fresco)
    SimpleDraweeView mFrescoImg;

    public static FrescoFragment newInstance() {
        FrescoFragment fragment = new FrescoFragment();
        return fragment;
    }

    public FrescoFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fresco, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Uri uri = Uri.parse("https://raw.githubusercontent.com/facebook/fresco/gh-pages/static/fresco-logo.png");
        mFrescoImg.setImageURI(uri);
    }
}
