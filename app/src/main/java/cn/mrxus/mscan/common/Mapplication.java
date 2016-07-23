package cn.mrxus.mscan.common;

import android.app.Application;

/**
 * Created by mrxus on 16/7/22.
 */
public class Mapplication extends Application {
    private static Mapplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Mapplication getInstance() {
        if (null == instance) {
            instance = new Mapplication();
        }
        return instance;
    }
}
