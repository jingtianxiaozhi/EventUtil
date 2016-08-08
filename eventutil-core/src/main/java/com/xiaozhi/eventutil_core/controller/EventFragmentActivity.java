package com.xiaozhi.eventutil_core.controller;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.xiaozhi.eventutil_core.CareEvent;
import com.xiaozhi.eventutil_core.EventBusUtil;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventFragmentActivity extends FragmentActivity {
    protected boolean isRegiste = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(isRegiste){
            EventBusUtil.get().register(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(CareEvent careEvent) {
        for (int i = 0; i < EventBusUtil.get().getEventSize(EventFragmentActivity.this); i++) {
            if (careEvent.what == EventBusUtil.get().getEventConstans(EventFragmentActivity.this).get(i)) {
                EventBusUtil.get().getEventBusCallbacks(EventFragmentActivity.this).get(i).operate(careEvent);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isRegiste){
            EventBusUtil.get().unregister(this);
        }
    }
}
