package cn.mrxus.mscan.scan;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;
import cn.mrxus.mscan.R;

/**
 * Created by mrxus on 16/8/13.
 */
public class ScannerActivity extends AppCompatActivity implements QRCodeView.Delegate {
    private ZXingView zxingView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        zxingView = (ZXingView)findViewById(R.id.zxingview);
        zxingView.setDelegate(this);
    }
    @Override
    protected void onStart() {
        super.onStart();
        zxingView.startCamera();
//        zxingView.startCamera(Camera.CameraInfo.CAMERA_FACING_FRONT);
        zxingView.startSpot();
    }

    @Override
    protected void onStop() {
        zxingView.stopCamera();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        zxingView.onDestroy();
        super.onDestroy();
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        // TODO: 16/8/13 这里执行扫码结果回馈 
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        vibrate();
        zxingView.startSpot();
    }
    @Override
    public void onScanQRCodeOpenCameraError() {
        Log.e("pengqian", "打开相机出错");
    }

}
