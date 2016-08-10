package cn.mrxus.mscan.activity;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import cn.mrxus.mscan.fragment.MainFragment;
import cn.mrxus.mscan.utils.SnackBarUtil;

public class MainActivity extends BaseActivity implements MainView, View.OnClickListener {


    private static final int REQUEST_CODE = 0X01;
    @BindView(R.id.iv_mian_menu)
    ImageView ivMianMenu;
    @BindView(R.id.tv_main_title)
    TextView tvMainTitle;
    @BindView(R.id.fl_main_content)
    FrameLayout flMainContent;

    @BindView(R.id.dl_main_cont)
    DrawerLayout dlMainCont;
    @BindView(R.id.pb_main)
    ProgressBar pbMain;
    @BindView(R.id.tv_menu_head_name)
    TextView tvMenuHeadName;
    @BindView(R.id.tv_menu_head_id)
    TextView tvMenuHeadId;
    @BindView(R.id.left)
    LinearLayout left;
    private PopupWindow popupWindow;
    private MainPresenter presenter;
    private FragmentTransaction ft;
    private MainFragment mainFragment;

    @Override
    protected void init() {
        presenter = new MainPresenter(this);
        initView();
        isHaveNetwork();
        initFramgnet();
        addFragment(mainFragment);

    }

    /**
     * 初始化Fragment
     */
    private void initFramgnet() {
        if (mainFragment == null) {
            mainFragment = new MainFragment();
        }
    }


    /**
     * 添加fragment
     */
    private void addFragment(Fragment fragment) {
        pbMain.setVisibility(View.GONE);
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fl_main_content, fragment);
        ft.commit();
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
        //设置字体
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @OnClick({R.id.iv_mian_menu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_mian_menu:
                presenter.shouMenu();

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
        dlMainCont.openDrawer(left);
    }

    @Override
    public void hideMenu() {
        dlMainCont.closeDrawer(left);
    }


    @Override
    public void showNotNetwork() {
        SnackBarUtil.showSnackBar(dlMainCont, getString(R.string.notHaveNetwork), R.color.hyaline_gray);
    }

    @Override
    public void showProgressBar() {
        pbMain.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        pbMain.setVisibility(View.GONE);
    }

    @Override
    public void showNotHaveData() {

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
