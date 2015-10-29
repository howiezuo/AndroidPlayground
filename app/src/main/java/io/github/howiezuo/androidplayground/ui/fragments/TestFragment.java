package io.github.howiezuo.androidplayground.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.Bind;
import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.utils.LogUtils;


public class TestFragment extends BaseFragment {

    private static final String TAG = TestFragment.class.getName();

    @Bind(R.id.test_result)
    TextView testResult;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment MainFragment.
     */
    public static TestFragment newInstance() {
        TestFragment fragment = new TestFragment();
        return fragment;
    }

    public TestFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String str = "あいうえお、かきくけこ、#TAG さしすせそ #tag#ABC";
        testResult.setText(formatString(str));
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private SpannableString formatString(String str) {
        SpannableString ss = new SpannableString(str);

        Pattern pattern = Pattern.compile("#(.+?)( |$)");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            LogUtils.LOGD(TAG, matcher.group());

            int start = matcher.start();
            int end = matcher.end();

            ss.setSpan(new ClickableSpan() {
                @Override
                public void onClick(View widget) {

                }
            }, start, end, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        }

        return ss;
    }
}
