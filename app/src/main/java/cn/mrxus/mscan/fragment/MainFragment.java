package cn.mrxus.mscan.fragment;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;



import butterknife.BindView;
import butterknife.OnClick;
import cn.mrxus.mscan.R;
import cn.mrxus.mscan.activity.MainActivity;
import cn.mrxus.mscan.common.BaseFragment;
import cn.mrxus.mscan.utils.HttpUtil;
import cn.mrxus.mscan.utils.LoadImageUtil;


/**
 * Created by mrxus on 16/7/25.
 */
public class MainFragment extends BaseFragment {


    private static final int REQUEST_CODE = 100;
    @BindView(R.id.iv_main_banner)
    ImageView ivMainBanner;
    @BindView(R.id.bt_main_scan)
    FloatingActionButton btMainScan;


    String[] imgs = {"http://img05.tooopen.com/images/20140731/sy_67889293117.jpg", "http://www.umu.com.tw/wp-content/uploads/13-700x933.jpg"};


    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 100:
                    String returnValue = (String) msg.obj;
                    Log.e("MainFragment", returnValue);
                    break;
            }
        }
    };

    @Override
    protected void init() {
        LoadImageUtil.loadImgUrl(this, imgs[0], ivMainBanner);

    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }


    @OnClick(R.id.bt_main_scan)
    public void onClick() {

        Toast.makeText(getActivity(), "11", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
}

