package io.github.howiezuo.androidplayground.androidasynchttp;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class WeatherRestClient {

    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler handler) {
        client.get(getAbsoluteUrl(url), params, handler);
    }

    private static String getAbsoluteUrl(String url) {
        return BASE_URL + url;
    }
}
