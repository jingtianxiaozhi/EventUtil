package com.xiaozhi.eventutil_core;


import org.greenrobot.eventbus.EventBus;

/**
 * Created by liudezhi on 16/5/2.
 */
public class EventBusUtil {

    public static void register(Object context){
        EventBus.getDefault().register(context);
    }

    public static void unregister(Object context){
        EventBus.getDefault().unregister(context);
    }

    public static <T> void post(int what, T paramObj){
        EventBus.getDefault().post(new CareEvent(what, paramObj));
    }
}
