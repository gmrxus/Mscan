package cn.mrxus.mscan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.mrxus.mscan.R;
import cn.mrxus.mscan.common.BaseActivity;

/**
 * Created by mrxus on 16/7/23.
 */
public class SettingActivity extends BaseActivity {
    @BindView(R.id.iv_setting_back)
    ImageView ivSettingBack;
    @BindView(R.id.cb_setting_shengyin)
    CheckBox cbSettingShengyin;
    @BindView(R.id.rl_setting_shengyin)
    RelativeLayout rlSettingShengyin;
    @BindView(R.id.cb_setting_zhendong)
    CheckBox cbSettingZhendong;
    @BindView(R.id.rl_setting_zhendong)
    RelativeLayout rlSettingZhendong;
    @BindView(R.id.cb_setting_saomiaolishi)
    CheckBox cbSettingSaomiaolishi;
    @BindView(R.id.rl_setting_saomiaolishi)
    RelativeLayout rlSettingSaomiaolishi;
    @BindView(R.id.cb_setting_shengchenglishi)
    CheckBox cbSettingShengchenglishi;
    @BindView(R.id.rl_setting_shengchenglishi)
    RelativeLayout rlSettingShengchenglishi;
    @BindView(R.id.rl_setting_clear_cg)
    RelativeLayout rlSettingClearCg;
    @BindView(R.id.rl_setting_serch)
    RelativeLayout rlSettingSerch;

    @Override
    protected void init() {


    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }


    @OnClick({R.id.iv_setting_back, R.id.rl_setting_shengyin, R.id.rl_setting_zhendong, R.id.rl_setting_saomiaolishi, R.id.rl_setting_shengchenglishi, R.id.rl_setting_clear_cg, R.id.rl_setting_serch})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_setting_back:
                go2Activity(MainActivity.class);
                break;
            case R.id.rl_setting_shengyin:
                break;
            case R.id.rl_setting_zhendong:
                break;
            case R.id.rl_setting_saomiaolishi:
                break;
            case R.id.rl_setting_shengchenglishi:
                break;
            case R.id.rl_setting_clear_cg:
                break;
            case R.id.rl_setting_serch:
                break;
        }
    }
}
