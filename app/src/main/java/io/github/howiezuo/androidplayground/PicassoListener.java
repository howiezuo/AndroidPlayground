package io.github.howiezuo.androidplayground;

import android.net.Uri;

import com.squareup.picasso.Picasso;

import io.github.howiezuo.androidplayground.utils.LogUtils;

public class PicassoListener implements Picasso.Listener {

    private static final String TAG = PicassoListener.class.getName();

    @Override
    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
        LogUtils.LOGD(TAG, "onImageLoadFailed url:" + uri.getHost() + uri.getPath() + " exception(" + exception.getLocalizedMessage() + ")");
    }
}
