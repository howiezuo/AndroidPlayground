package io.github.howiezuo.androidplayground.retrofit;

import io.github.howiezuo.androidplayground.models.CurrentWeather;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface OpenWeatherApi {

    static final String API_VERSION = "2.5";

    @GET("/weather")
    void getCurrentWeatherByName(@Query("q") String name, Callback<CurrentWeather> callback);

    @GET("/weather")
    void getCurrentWeatherById(@Query("id") String id);

    @GET("/weather")
    void getCurrentWeatherByCoord(@Query("lat") String lat,
                                  @Query("lon") String lon);

    @GET("/weather")
    void getCurrentWeatherByZipcode(@Query("zip") String zip);
}
