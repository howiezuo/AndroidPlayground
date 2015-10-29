package io.github.howiezuo.androidplayground.androidasynchttp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONObject;

import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.ui.fragments.BaseFragment;
import io.github.howiezuo.androidplayground.utils.LogUtils;

public class AndroidAsyncHttpFragment extends BaseFragment {

    private static final String TAG = AndroidAsyncHttpFragment.class.getName();

    public static AndroidAsyncHttpFragment newInstance() {
        AndroidAsyncHttpFragment fragment = new AndroidAsyncHttpFragment();
        return fragment;
    }

    public AndroidAsyncHttpFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_android_async_http, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        WeatherRestClientUsage usage = new WeatherRestClientUsage();
        usage.getCurrentWeatherBy("London", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                LogUtils.LOGD(TAG, response.toString());
            }
        });
    }
}
