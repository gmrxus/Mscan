package cn.mrxus.mscan.MVP.presenter;

import android.content.Context;

import cn.mrxus.mscan.MVP.model.MainModel;
import cn.mrxus.mscan.MVP.model.MainModelImpl;
import cn.mrxus.mscan.MVP.view.MainView;
import cn.mrxus.mscan.utils.NetworkUtil;

/**
 * Created by mrxus on 16/7/23.
 */
public class MainPresenter {
    private MainView view;
    private MainModel model;

    public MainPresenter(MainView view) {
        this.view = view;
        this.model = new MainModelImpl();
    }

    /**
     * 解绑view
     */
    public void onDestroy() {
        view = null;
    }


    public void shouMenu() {
        if (view != null) {
            view.showMenu();
        }
    }



    public void isHaveNetWork(Context context){
        if (NetworkUtil.isHaveNetwork(context)) {
            return;
        }else {
            view.showNotNetwork();
        }
    }
}
