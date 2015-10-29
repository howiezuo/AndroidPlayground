package io.github.howiezuo.androidplayground.retrofit;

import retrofit.RetrofitError;

public abstract interface RequestListener<T> {
    void onSuccess(T response);
    void onFailure(RetrofitError error);
}
