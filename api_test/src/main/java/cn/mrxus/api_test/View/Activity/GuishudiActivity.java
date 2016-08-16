package cn.mrxus.api_test.View.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.mrxus.api_test.R;
import cn.mrxus.api_test.View.BaseActivity;
import cn.mrxus.api_test.utils.HttpUtil;
import cn.mrxus.api_test.utils.LogUtil;


/**
 * Created by mrxus on 16/8/16.
 */
public class GuishudiActivity extends BaseActivity implements View.OnClickListener {

    public static final String url = "http://op.juhe.cn/onebox/phone/query";//号码鬼实地访问接口

    private EditText etTelephone;
    private TextView tvGuishidi;
    private String telephone;

    @Override
    protected void findView() {
        etTelephone = (EditText) findViewById(R.id.et_telephone);
        tvGuishidi = (TextView) findViewById(R.id.tv_guishudi);
        findViewById(R.id.bt).setOnClickListener(this);
    }
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 100:
                    String guishudi = (String) msg.obj;
                    tvGuishidi.setText(guishudi);
                    break;
            }
        }
    };



    @Override
    protected void init() {
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_guishudi;
    }

    @Override
    public void onClick(View view) {
        telephone = etTelephone.getText().toString();
        if (telephone != null) {
            HttpUtil.RequestBody requestBody = new HttpUtil.RequestBody();
            requestBody
                    .add("tel", telephone)
                    .add("key", "0a35edc648400b4dd0c12dcf5a7f84f1")
                    .add("dtype", "");
            HttpUtil.post(url, requestBody, new HttpUtil.OnNetRequestListener() {
                @Override
                public void onSuccess(String returnValue) {
                    LogUtil.e(returnValue);
                    Message msg=new Message();
                    msg.what=100;
                    msg.obj=returnValue;
                    mHandler.sendMessage(msg);

                }

                @Override
                public void onFail() {

                }
            });
        }
    }
}
