package com.xiaozhi.eventutil_core.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.xiaozhi.eventutil_core.CareEvent;
import com.xiaozhi.eventutil_core.EventBusUtil;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBusUtil.get().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(CareEvent careEvent) {
        for (int i = 0; i < EventBusUtil.get().getEventSize(EventFragment.this); i++) {
            if (careEvent.what == EventBusUtil.get().getEventConstans(EventFragment.this).get(i)) {
                EventBusUtil.get().getEventBusCallbacks(EventFragment.this).get(i).operate(careEvent);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBusUtil.get().unregister(this);
    }
}
