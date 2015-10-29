package io.github.howiezuo.androidplayground.eventbus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;
import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.ui.fragments.BaseFragment;

public class EventBusFragment extends BaseFragment {

    @Bind(R.id.et_message)
    EditText mMessageEt;

    public static EventBusFragment newInstance() {
        EventBusFragment fragment = new EventBusFragment();
        return fragment;
    }

    public EventBusFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event_bus, container, false);
    }

    @OnClick(R.id.btn_event)
    public void onEventButtonClicked() {
        EventBus.getDefault().post(new MessageEvent(mMessageEt.getText().toString()));
    }
}
