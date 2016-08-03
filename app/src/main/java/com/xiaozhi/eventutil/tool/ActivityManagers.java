package com.xiaozhi.eventutil.tool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


public class ActivityManagers {

    /**
     * 没有绑定的Bundler的时候使用此方法
     */
    public static void startActivity(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        context.startActivity(intent);
    }

    /**
     * 绑定的Bundler的时候使用此方法
     */
    public static void startActivity(Context context, Class<?> cls, Bundle bundle) {
        Intent intent = new Intent(context, cls);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /**
     * 没有绑定的Bundler的时候使用此方法
     */
    public static void startActivityForResult(Activity activity, Class<?> cls, int requestCode) {
        Intent intent = new Intent(activity, cls);
        activity.startActivityForResult(intent, requestCode);
    }

    /**
     * 绑定的Bundler的时候使用此方法
     */
    public static void startActivityForResult(Activity activity, Class<?> cls, Bundle bundle, int requestCode) {
        Intent intent = new Intent(activity, cls);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, requestCode);
    }
}
