package cn.mrxus.mscan.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.mrxus.mscan.MVP.presenter.MainPresenter;
import cn.mrxus.mscan.MVP.view.MainView;
import cn.mrxus.mscan.R;
import cn.mrxus.mscan.common.BaseActivity;
import cn.mrxus.mscan.utils.SnackBarUtil;

public class MainActivity extends BaseActivity implements MainView, View.OnClickListener {


    @BindView(R.id.iv_mian_menu)
    ImageView ivMianMenu;
    @BindView(R.id.tv_main_title)
    TextView tvMainTitle;
    @BindView(R.id.iv_main_setting)
    ImageView ivMainSetting;
    @BindView(R.id.fl_main_content)
    FrameLayout flMainContent;
    @BindView(R.id.nv_main)
    NavigationView nvMain;
    @BindView(R.id.dl_main_cont)
    DrawerLayout dlMainCont;
    @BindView(R.id.pb_main)
    ProgressBar pbMain;
    private PopupWindow popupWindow;
    private MainPresenter presenter;

    @Override
    protected void init() {
        presenter = new MainPresenter(this);
        isHaveNetwork();
        initView();

    }

    /**
     * 判断是否有网络
     */
    private void isHaveNetwork() {
        presenter.isHaveNetWork();
    }

    private void initView() {
        View popupView = getLayoutInflater().inflate(R.layout.popup_main_setting, null);
        popupWindow = new PopupWindow(popupView, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));
        popupView.findViewById(R.id.tv_popup_setting).setOnClickListener(this);
        popupView.findViewById(R.id.tv_popup_cancel).setOnClickListener(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @OnClick({R.id.iv_mian_menu, R.id.iv_main_setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_mian_menu:
                presenter.shouMenu();
                break;
            case R.id.iv_main_setting:
                presenter.shouSettingPopup();
                break;
            case R.id.tv_popup_setting:
                go2Activity(SettingActivity.class);
                break;
            case R.id.tv_popup_cancel:
                break;
        }
    }


    @Override
    public void showMenu() {
        dlMainCont.openDrawer(nvMain);
    }

    @Override
    public void hideMenu() {
        dlMainCont.closeDrawer(nvMain);
    }

    @Override
    public void shouSetting() {
        popupWindow.showAsDropDown(ivMainSetting);
    }

    @Override
    public void hideSetting() {
        popupWindow.dismiss();
    }

    @Override
    public void showNotNetwork() {
        SnackBarUtil.showSnackBar(dlMainCont, getString(R.string.notHaveNetwork), R.color.hyaline_gray);
    }

    @Override
    public void shouProgressBar() {
        pbMain.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        pbMain.setVisibility(View.GONE);

    }

    @Override
    public void shouNotHaveData() {

    }

    @Override
    public void hideNotHaveData() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }


}
