package cn.mrxus.mscan.activity;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.mrxus.mscan.R;
import cn.mrxus.mscan.common.BaseActivity;

/**
 * Created by mrxus on 16/7/22.
 */
public class SplashActivity extends BaseActivity {


    @BindView(R.id.iv_splash_img)
    ImageView ivSplashImg;
    @BindView(R.id.tv_splash_pass)
    TextView tvSplashPass;
    private int timeOut;
    private Handler mHandler = new Handler();
    private Runnable r;

    @Override
    protected void init() {
        timeOut = 5;
        tvSplashPass.setText("跳过(" + timeOut + ")");
        countDown();
    }

    /**
     * 倒计时跳转
     */
    private void countDown() {
        if (timeOut == 0) {
            go2Activity(MainActivity.class);
            finish();
        } else {
            timeOut--;
            r = new Runnable() {
                @Override
                public void run() {
                    tvSplashPass.setText("跳过(" + timeOut + ")");
                    countDown();
                    return;
                }
            };
            mHandler.postDelayed(r, 1000);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }


    @OnClick(R.id.tv_splash_pass)
    public void onClick() {
        mHandler.removeCallbacks(r);
        go2Activity(MainActivity.class);
        finish();
    }


}
