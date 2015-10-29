package io.github.howiezuo.androidplayground.eventbus;

import android.os.Bundle;

import de.greenrobot.event.EventBus;
import io.github.howiezuo.androidplayground.R;
import io.github.howiezuo.androidplayground.ui.MainActivity;

public class EventBusActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setTitle(R.string.title_event_bus);

        if (savedInstanceState != null) {
            return;
        }

        addFragment(EventBusFragment.newInstance());
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    public void onEvent(MessageEvent event) {
        getSupportActionBar().setTitle(event.getMessage());
    }
}
