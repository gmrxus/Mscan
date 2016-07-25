package cn.mrxus.mscan.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import cn.mrxus.mscan.common.Mapplication;

/**
 * Created by mrxus on 16/7/23.
 */
public class NetworkUtil {
    /**
     * 判断当前是否有网络
     *
     * @return
     */
    public static boolean isHaveNetwork() {
        ConnectivityManager cm = (ConnectivityManager) Mapplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();

        return (info != null && info.isConnected());
    }


}
