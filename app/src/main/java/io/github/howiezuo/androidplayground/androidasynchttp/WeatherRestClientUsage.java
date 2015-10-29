package io.github.howiezuo.androidplayground.androidasynchttp;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.apache.http.Header;
import org.json.JSONObject;

public class WeatherRestClientUsage {

    public void getCurrentWeatherBy(String name, AsyncHttpResponseHandler handler) {
        WeatherRestClient.get("weather", new RequestParams("q", name), handler);
    }
}
