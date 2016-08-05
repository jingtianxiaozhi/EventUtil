package com.xiaozhi.eventutil_core;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by liudezhi on 16/5/2.
 */
public class EventBusUtil {

    private EventBusUtil(){}
    private HashMap<Object,ArrayList<Integer>> eventConstantMap = new HashMap<>();
    private HashMap<Object,ArrayList<EventBusCallback>> eventCallbackMap = new HashMap<>();
    public static final EventBusUtil eventBusUtil = new EventBusUtil();

    public static EventBusUtil get() {
        return eventBusUtil;
    }

    public void register(Object context){
        EventBus.getDefault().register(context);
        if(eventConstantMap.get(context) == null){
            ArrayList<Integer> eventConstants = new ArrayList<>();
            eventConstantMap.put(context,eventConstants);
        }
        if(eventCallbackMap.get(context) == null){
            ArrayList<EventBusCallback> EventListeners = new ArrayList<>();
            eventCallbackMap.put(context,EventListeners);
        }
    }

    public void unregister(Object context){
        EventBus.getDefault().unregister(context);
        if(eventConstantMap != null){
            eventConstantMap.remove(context);
        }
        if(eventCallbackMap != null){
            eventCallbackMap.remove(context);
        }
    }

    public static <T> void post(int what, T paramObj){
        EventBus.getDefault().post(new CareEvent(what, paramObj));
    }

    public void addConstantCallback(Context context, int eventConstant, EventBusCallback eventBusCallback){
        ArrayList<Integer> getConstants = eventConstantMap.get(context);
        if(getConstants != null){
            getConstants.add(eventConstant);
        }
        ArrayList<EventBusCallback> getEventListeners = eventCallbackMap.get(context);
        if(getEventListeners != null){
            getEventListeners.add(eventBusCallback);
        }
    }

    public int getEventSize(Object context){
        if(eventConstantMap.get(context) != null){
            return eventConstantMap.get(context).size();
        }
        return 0;
    }

    public ArrayList<Integer> getEventConstans(Object context){
        return eventConstantMap.get(context);
    }

    public ArrayList<EventBusCallback> getEventBusCallbacks(Object context){
        return eventCallbackMap.get(context);
    }

}
