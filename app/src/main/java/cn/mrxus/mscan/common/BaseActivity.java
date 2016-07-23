package cn.mrxus.mscan.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by mrxus on 16/7/22.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        init();
    }

    /**
     * 初始化
     */
    protected abstract void init();

    /**
     * 布局的layout文件ID
     *
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * activity跳转
     * @param activityClass activity的class
     */
    protected void go2Activity(Class activityClass) {
        startActivity(new Intent(this, activityClass));
    }

}
