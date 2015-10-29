package io.github.howiezuo.androidplayground.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import io.github.howiezuo.androidplayground.FontAwesome;
import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.ui.adapters.FontAwesomeAdapter;

public class FontAwesomeFragment extends BaseFragment {

    private static final String ARG_CATEGORY = "category";

    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private FontAwesomeAdapter mAdapter;
    private List<FontAwesome.Font> mFonts = new ArrayList<>();

    public static FontAwesomeFragment newInstance(String category) {
        FontAwesomeFragment fragment = new FontAwesomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CATEGORY, category);
        fragment.setArguments(args);
        return fragment;
    }

    public FontAwesomeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        String category = args.getString(ARG_CATEGORY);
        if (category == null) return;

        try {
            FontAwesome fa = new FontAwesome(getActivity());
            mFonts = fa.getIcons(category);
            mAdapter = new FontAwesomeAdapter(mFonts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_font_awesome, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mRecyclerView.setAdapter(mAdapter);
//        try {
//            FontAwesome fa = new FontAwesome(getActivity());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
