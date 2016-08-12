package cn.mrxus.mscan.activity;

import android.content.Intent;
import android.graphics.Bitmap;
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
import android.widget.Toast;


import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.mrxus.mscan.MVP.presenter.MainPresenter;
import cn.mrxus.mscan.MVP.view.MainView;
import cn.mrxus.mscan.R;
import cn.mrxus.mscan.common.BaseActivity;
import cn.mrxus.mscan.fragment.MainFragment;
import cn.mrxus.mscan.ui.RoundImageView;
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
    @BindView(R.id.menu_scanner)
    LinearLayout menuScanner;
    @BindView(R.id.menu_user)
    RoundImageView menuUser;
    @BindView(R.id.menu_main_page)
    LinearLayout menuMainPage;
    @BindView(R.id.make_code)
    LinearLayout makeCode;
    @BindView(R.id.menu_history)
    LinearLayout menuHistory;
    @BindView(R.id.menu_setting)
    LinearLayout menuSetting;
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
        presenter.isHaveNetWork(this);
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

    @OnClick({R.id.menu_user, R.id.menu_main_page, R.id.make_code, R.id.menu_history, R.id.menu_setting, R.id.menu_scanner})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menu_scanner:
                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            case R.id.menu_user:

                break;
            case R.id.menu_main_page:
                break;
            case R.id.make_code:
                break;
            case R.id.menu_history:
                break;
            case R.id.menu_setting:
                startActivityForResult(new Intent(this, SettingActivity.class), 100);

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(MainActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
