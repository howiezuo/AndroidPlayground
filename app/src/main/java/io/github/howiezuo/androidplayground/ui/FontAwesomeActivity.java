package io.github.howiezuo.androidplayground.ui;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import io.github.howiezuo.androidplayground.FontAwesome;
import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.ui.adapters.FontAwesomeCategoryAdapter;
import io.github.howiezuo.androidplayground.ui.fragments.FontAwesomeFragment;

public class FontAwesomeActivity extends BaseActivity {

    @Bind(R.id.tool_bar)
    Toolbar mToolBar;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Bind(R.id.spinner)
    Spinner mSpinner;

    private FontAwesomeCategoryAdapter mAdapter;
    private List<String> mFontCategories;

//    @Bind(R.id.tab_layout)
//    TabLayout mTabLayout;
//
//    @Bind(R.id.view_pager)
//    ViewPager mViewPager;

    @Override
    protected int onGetLayoutResID() {
        return R.layout.activity_font_awesome;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setSupportActionBar(mToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mDrawerLayout.setDrawerListener(new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, R.string.menu_open, R.string.menu_close));

        try {
            FontAwesome fa = new FontAwesome(this);
            mFontCategories = new ArrayList<>(fa.getIcons().keySet());

            if (mFontCategories == null) return;

            replaceFragment(mFontCategories.get(0));

//            mViewPager.setAdapter(new FontAwesomeAdapter(getFragmentManager()));
//            mTabLayout.setupWithViewPager(mViewPager);
            mAdapter = new FontAwesomeCategoryAdapter(this);
            mAdapter.addAll(mFontCategories);
            mSpinner.setAdapter(mAdapter);
            mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    replaceFragment(mFontCategories.get(position));
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (savedInstanceState != null) {
            return;
        }
    }

    private void replaceFragment(String category) {
        if (findViewById(R.id.fragment_container) != null) {
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, FontAwesomeFragment.newInstance(category)).commit();
//            getFragmentManager().beginTransaction().add(R.id.fragment_container, MainFragment.newInstance()).commit();
        }
    }

//    public class FontAwesomeAdapter extends FragmentPagerAdapter {
//
//        public FontAwesomeAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return FontAwesomeFragment.newInstance(mTabs.get(position));
//        }
//
//        @Override
//        public int getCount() {
//            return mTabs.size();
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return mTabs.get(position);
//        }
//    }

}
