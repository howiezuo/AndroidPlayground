package io.github.howiezuo.androidplayground.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.OnItemClick;
import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.androidasynchttp.AndroidAsyncHttpActivity;
import io.github.howiezuo.androidplayground.glide.GlideActivity;
import io.github.howiezuo.androidplayground.okhttp.OkHttpActivity;
import io.github.howiezuo.androidplayground.otto.OttoActivity;
import io.github.howiezuo.androidplayground.ui.CameraActivity;
import io.github.howiezuo.androidplayground.ui.DrawActivity;
import io.github.howiezuo.androidplayground.eventbus.EventBusActivity;
import io.github.howiezuo.androidplayground.ui.FontAwesomeActivity;
import io.github.howiezuo.androidplayground.fresco.FrescoActivity;
import io.github.howiezuo.androidplayground.picasso.PicassoActivity;
import io.github.howiezuo.androidplayground.ui.SurfaceDrawActivity;
import io.github.howiezuo.androidplayground.ui.TestActivity;
import io.github.howiezuo.androidplayground.ui.TransitionActivity;
import io.github.howiezuo.androidplayground.retrofit.RetrofitActivity;
import io.github.howiezuo.androidplayground.ui.adapters.MenuAdapter;

public class MenuFragment extends BaseFragment {

    @Bind(R.id.list_menu)
    ListView menuList;

    MenuAdapter mAdapter;

    private static final Integer[] NAVDRAWER_TITLE_RES_ID = {
            R.string.navdrawer_item_android_async_http,
            R.string.navdrawer_item_picasso,
            R.string.navdrawer_item_retrofit,
            R.string.navdrawer_item_event_bus,
            R.string.navdrawer_item_fresco,
            R.string.navdrawer_item_ok_http,
            R.string.navdrawer_item_glide,
            R.string.navdrawer_item_otto,
            R.string.navdrawer_item_font,
            R.string.navdrawer_item_surface_draw,
            R.string.navdrawer_item_draw,
            R.string.navdrawer_item_camera,
            R.string.navdrawer_item_transition,
            R.string.navdrawer_item_test
    };

    enum NavdrawerItem {
        ANDROID_ASYNC_HTTP,
        PICASSO,
        RETROFIT,
        EVENT_BUS,
        FRESCO,
        OK_HTTP,
        GLIDE,
        OTTO,
        FONT,
        SURFACE_DRAW,
        DRAW,
        CAMERA,
        TRANSITION,
        TEST,
    }

    public static MenuFragment newInstance() {
        return new MenuFragment();
    }

    public MenuFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter = new MenuAdapter(getActivity());
        mAdapter.addAll(NAVDRAWER_TITLE_RES_ID);
        menuList.setAdapter(mAdapter);
    }

    @OnItemClick(R.id.list_menu)
    void onItemClick(int position) {
        if (position == NavdrawerItem.ANDROID_ASYNC_HTTP.ordinal()) {
            startActivity(new Intent(getActivity(), AndroidAsyncHttpActivity.class));
        } else if (position == NavdrawerItem.RETROFIT.ordinal()) {
            startActivity(new Intent(getActivity(), RetrofitActivity.class));
        } else if (position == NavdrawerItem.OK_HTTP.ordinal()) {
            startActivity(new Intent(getActivity(), OkHttpActivity.class));
        } else if (position == NavdrawerItem.FONT.ordinal()) {
            startActivity(new Intent(getActivity(), FontAwesomeActivity.class));
        } else if (position == NavdrawerItem.SURFACE_DRAW.ordinal()) {
            startActivity(new Intent(getActivity(), SurfaceDrawActivity.class));
        } else if (position == NavdrawerItem.DRAW.ordinal()) {
            startActivity(new Intent(getActivity(), DrawActivity.class));
        } else if (position == NavdrawerItem.CAMERA.ordinal()) {
            startActivity(new Intent(getActivity(), CameraActivity.class));
        } else if (position == NavdrawerItem.PICASSO.ordinal()) {
            startActivity(new Intent(getActivity(), PicassoActivity.class));
        } else if (position == NavdrawerItem.EVENT_BUS.ordinal()) {
            startActivity(new Intent(getActivity(), EventBusActivity.class));
        } else if (position == NavdrawerItem.FRESCO.ordinal()) {
            startActivity(new Intent(getActivity(), FrescoActivity.class));
        } else if (position == NavdrawerItem.TRANSITION.ordinal()) {
            startActivity(new Intent(getActivity(), TransitionActivity.class));
        } else if (position == NavdrawerItem.TEST.ordinal()) {
            startActivity(new Intent(getActivity(), TestActivity.class));
        } else if (position == NavdrawerItem.GLIDE.ordinal()) {
            startActivity(new Intent(getActivity(), GlideActivity.class));
        } else if (position == NavdrawerItem.OTTO.ordinal()) {
            startActivity(new Intent(getActivity(), OttoActivity.class));
        }
    }
}
