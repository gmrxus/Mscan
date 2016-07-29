package cn.mrxus.mscan.fragment;

import android.content.Intent;
import android.media.MediaCodecInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;



import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.mrxus.mscan.R;
import cn.mrxus.mscan.activity.MainActivity;
import cn.mrxus.mscan.common.BaseFragment;
import cn.mrxus.mscan.common.Mapplication;
import cn.mrxus.mscan.utils.LoadImageUtil;

/**
 * Created by mrxus on 16/7/25.
 */
public class MainFragment extends BaseFragment {


    @BindView(R.id.iv_main_banner)
    ImageView ivMainBanner;
    @BindView(R.id.bt_main_scan)
    FloatingActionButton btMainScan;


    String[] imgs = {"http://img05.tooopen.com/images/20140731/sy_67889293117.jpg", "http://www.umu.com.tw/wp-content/uploads/13-700x933.jpg"};


    @Override
    protected void init() {

        LoadImageUtil.loadImgUrl(this, imgs[1], ivMainBanner);


    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }


    @OnClick(R.id.bt_main_scan)
    public void onClick() {
    }

}
