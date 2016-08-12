package cn.mrxus.mscan.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


/**
 * Created by mrxus on 16/7/23.
 */
public class NetworkUtil {
    /**
     * 判断当前是否有网络
     *
     * @return
     */
    public static boolean isHaveNetwork(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();

        return (info != null && info.isConnected());
    }


}
