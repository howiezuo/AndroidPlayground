package io.github.howiezuo.androidplayground.okhttp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.ui.fragments.BaseFragment;
import io.github.howiezuo.androidplayground.utils.LogUtils;

public class OkHttpFragment extends BaseFragment {

    private static final String TAG = OkHttpFragment.class.getName();

    public static OkHttpFragment newInstance() {
        OkHttpFragment fragment = new OkHttpFragment();
        return fragment;
    }

    public OkHttpFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ok_http, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://api.openweathermap.org/data/2.5/weather/?q=London")
                .get()
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                LogUtils.LOGE(TAG, e.getLocalizedMessage());
            }

            @Override
            public void onResponse(Response response) throws IOException {
                LogUtils.LOGD(TAG, response.toString());
            }
        });
    }
}
