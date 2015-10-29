package io.github.howiezuo.androidplayground.otto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import butterknife.Bind;
import butterknife.OnClick;
import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.ui.fragments.BaseFragment;

public class OttoFragment extends BaseFragment {

    @Bind(R.id.et_message)
    EditText message;

    public static OttoFragment newInstance() {
        OttoFragment fragment = new OttoFragment();
        return fragment;
    }

    public OttoFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_otto, container, false);
    }

    @OnClick(R.id.btn_otto)
    public void onOttoButtonClicked() {
        Bus bus = new Bus(ThreadEnforcer.MAIN);
        bus.post(new StringEvent(message.getText().toString()));
    }
}
