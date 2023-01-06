package com.example.mycloudmusicandroidjava.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.example.common.SuperDateUtil;
import com.example.mycloudmusicandroidjava.MainActivity;
import com.example.mycloudmusicandroidjava.R;
import com.example.mycloudmusicandroidjava.config.Config;
import com.example.mycloudmusicandroidjava.databinding.ActivitySplashBinding;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;


@SuppressWarnings({"all"})
//声明当前界面有动态获取权限逻辑
@RuntimePermissions
public class SplashActivity extends BaseLogicActivity {
    private static final String TAG = "SplashActivity";
    private ActivitySplashBinding binding;
//    private TextView copyright;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splash);

        //视图绑定 用来代替findViewById
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void initViews() {
        super.initViews();
        //设置沉浸式状态栏
        QMUIStatusBarHelper.translucent(this);

        //状态栏文字颜色 对于系统而言只有黑色和白色两种颜色
        QMUIStatusBarHelper.setStatusBarLightMode(this);

//        copyright = findViewById(R.id.copyright);
    }

    @Override
    protected void initDatum() {
        super.initDatum();
        binding.copyright.setText(getString(R.string.logo_name) + SuperDateUtil.currentYear() + "年");

        checkPermission();
    }

    @Override
    protected void initListeners() {
        super.initListeners();
//        binding.logo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                testGet();
//                testRetrofitGet();
//            }
//        });
    }

    private void testRetrofitGet() {


//        service.songDetail("header", "1234234234234345")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new HttpObserver<DetailResponse<Song>>() {
//
//                    @Override
//                    public void onSucceeded(DetailResponse<Song> data) {
//                        Log.d(TAG, "onSucceeded: " + data.getData().getTitle());
//                    }
//                });

//        Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
//        SuperToast.show(R.string.app_name);
    }

    private void testGet() {
//        OkHttpClient client = new OkHttpClient();
//
//        String url = Config.ENDPOINT + "v1/songs";
//
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//
//        client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {
//                Log.d(TAG, "onFailure: " + e.getLocalizedMessage());
//            }
//
//            @Override
//            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//                Log.d(TAG, "onResponse: " + response.body().string());
//            }
//        });
    }

    private void checkPermission() {
        //让动态框架检查是否授权了
        //如果不使用框架就使用系统提供的API检查
        //它内部也是使用系统API检查
        //只是使用框架就更简单了
        SplashActivityPermissionsDispatcher.onPermissionGrantedWithPermissionCheck(this);//注意这行权限需要先编译后才能使用

    }

    //权限授权了就会调用该方法
    //请求相机权限的目的是扫描二维码 拍照
    @NeedsPermission({
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    })
    void onPermissionGranted() {
        //如果有权限就进入下一步
        prepareNext();
    }

    //显示权限授权对话框
    //目的是提示用户
    @OnShowRationale({
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    })
    void showRequestPermission(PermissionRequest request) {
        new AlertDialog.Builder(this)
                .setMessage(R.string.permission_hint)
                .setPositiveButton(R.string.allow, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        request.proceed();
                    }
                }).setNegativeButton(R.string.deny, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                request.cancel();
            }
        }).show();

    }

    @OnPermissionDenied({
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    })
    void showDenied() {
        //退出应用
        finish();
    }

    //再次获取权限的提示
    @OnNeverAskAgain({
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    })
    void showNeverAsk() {
        //继续请求权限
        checkPermission();
    }

    //跳转页面
    private void prepareNext() {
        //跳转延迟
        binding.copyright.postDelayed(new Runnable() {
            @Override
            public void run() {
                next();
            }
        }, Config.SPLASH_DEFAULT_DELAY_TIME);
    }

    private void next() {
        startActivityAfterFinishThis(MainActivity.class);
    }


    //授权后回调
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //将授权结果传递到框架
        SplashActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }
}