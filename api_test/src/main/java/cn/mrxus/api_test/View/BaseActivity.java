package cn.mrxus.api_test.View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mrxus on 16/8/16.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        findView();
        init();
    }

    protected abstract void findView();

    protected abstract void init();

    public abstract int getLayoutID();
}
