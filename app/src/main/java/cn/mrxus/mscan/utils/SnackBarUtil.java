package cn.mrxus.mscan.utils;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import cn.mrxus.mscan.R;
import cn.mrxus.mscan.common.Mapplication;

/**
 * Created by mrxus on 16/7/23.
 */
public class SnackBarUtil {
    public static void showSnackBar(View contain, String msg) {
        Snackbar.make(contain, msg, Snackbar.LENGTH_SHORT).show();
    }

    public static void showSnackBar(View contain, int msg) {
        Snackbar.make(contain, msg, Snackbar.LENGTH_SHORT).show();
    }

    public static void showSnackBar(View view, String msg, @ColorRes int colorRes) {

        Snackbar snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_SHORT);
        View v = snackbar.getView();
        v.setBackgroundColor(ContextCompat.getColor(view.getContext(), colorRes));
        snackbar.show();

    }

}
