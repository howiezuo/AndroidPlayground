package io.github.howiezuo.androidplayground.retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.models.CurrentWeather;
import io.github.howiezuo.androidplayground.ui.fragments.BaseFragment;
import io.github.howiezuo.androidplayground.utils.LogUtils;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.OkClient;

public class RetrofitFragment extends BaseFragment {

    private static final String TAG = RetrofitFragment.class.getName();

    public static RetrofitFragment newInstance() {
        RetrofitFragment fragment = new RetrofitFragment();
        return fragment;
    }

    public RetrofitFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_retrofit, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://api.openweathermap.org/data/2.5/")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setClient(new OkClient())
                .build();
        OpenWeatherApi api = adapter.create(OpenWeatherApi.class);
        api.getCurrentWeatherByName("London", new RequestCallback<CurrentWeather>(new RequestListener<CurrentWeather>() {
            @Override
            public void onSuccess(CurrentWeather response) {
                LogUtils.LOGD(TAG, response.toString());
            }

            @Override
            public void onFailure(RetrofitError error) {
                LogUtils.LOGE(TAG, error.getLocalizedMessage());
            }
        }));
    }
}
