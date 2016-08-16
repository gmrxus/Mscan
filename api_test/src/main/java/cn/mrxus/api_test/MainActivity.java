package cn.mrxus.api_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.mrxus.api_test.View.Activity.GuishudiActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        findView();
    }

    private void findView() {
        findViewById(R.id.bt_tb1).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_tb1:
                // TODO: 16/8/16 号码归属地
                startActivity(new Intent(MainActivity.this, GuishudiActivity.class));
                break;
            default:
                break;
        }
    }
}
