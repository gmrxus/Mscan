package cn.mrxus.mscan.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;


import butterknife.BindView;
import butterknife.OnClick;
import cn.mrxus.mscan.R;
import cn.mrxus.mscan.common.BaseFragment;
import cn.mrxus.mscan.utils.HttpUtil;
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
        LoadImageUtil.loadImgUrl(this, imgs[1], ivMainBanner);

    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }


    @OnClick(R.id.bt_main_scan)
    public void onClick() {
        HttpUtil.RequestBody requestBody = new HttpUtil.RequestBody();
        requestBody
                .add("method","taobao.products.search")
                .add()


                .add("fields","product_id,name,pic_url,cid,props,price,tsc")
                .add("q","优衣库 1234")
                .add("cid","50011999")
                .add("props","pid:vid;pid:vid")
                .add("status","3")
                .add("page_no","1")
                .add("page_size","40")
                .add("vertical_market","4")
                .add("customer_props","20000:优衣库:型号:001:632501:1234")
                .add("market_id","2")
                .add("suite_items_str","1000000062318020:1;1000000062318020:2;")
                .add("barcode_str","6924343550791,6901028180559");
        HttpUtil.post("https://eco.taobao.com/router/rest", requestBody, new HttpUtil.OnNetRequestListener() {
            @Override
            public void onSuccess(String returnValue) {

                Message msg=new Message();
                msg.what=100;
                msg.obj=returnValue;
                handler.sendMessage(msg);
            }

            @Override
            public void onFail() {

            }
        });
    }

}
