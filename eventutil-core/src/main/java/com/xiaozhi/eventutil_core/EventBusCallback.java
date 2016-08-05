package com.xiaozhi.eventutil_core;

/**
 * Created by liudezhi on 16/8/4.
 */
public interface EventBusCallback<T> {
    abstract void operate(CareEvent<T> careEvent);
}
