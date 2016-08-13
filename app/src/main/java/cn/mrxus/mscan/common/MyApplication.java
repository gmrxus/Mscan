package cn.mrxus.mscan.common;

import android.app.Application;
import android.content.Context;

/**
 * Created by mrxus on 16/7/22.
 */
public class MyApplication extends Application {
    private static MyApplication instance;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static MyApplication getInstance() {
        if (null == instance) {
            instance = new MyApplication();
        }
        return instance;
    }

    public static Context getContext() {
        if (context == null) {
            context = instance.getApplicationContext();
        }
        return context;
    }
}
