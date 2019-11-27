package com.config.pad.content.ui;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.config.pad.content.R;
import com.config.pad.content.libding.rerxmvp.base.BaseActivity;
import com.config.pad.content.libding.rerxmvp.view.activity.GetMvpRspActivity;
import com.config.pad.content.libding.rerxmvp.view.activity.PostListRspActivity;
import com.config.pad.content.libding.utils.SpfsUtils;
import com.config.pad.content.libding.utils.XPermission;

import java.util.concurrent.TimeUnit;

import butterknife.OnClick;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class SplashActivity extends BaseActivity {

    private String TAG = SplashActivity.class.getSimpleName();
    protected BaseActivity mBaseActivity;

    String[] permissions = new String[]{Manifest.permission.CALL_PHONE,//打电话
            Manifest.permission.WRITE_EXTERNAL_STORAGE,//写内存卡的权限
            Manifest.permission.READ_EXTERNAL_STORAGE,//读内存卡的权限
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.CAMERA,
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        mBaseActivity = SplashActivity.this;
        //用于存储是否第一次进入
        boolean isFirst = SpfsUtils.readBoolean(SplashActivity.this,"isFirst", true);
        if (!isFirst){
//            goHome();
        }

        //1、请求单个权限
        requestPermissionsOne();
        //2、请求多个权限
        requestPermissionsMore();
    }

    private void requestPermissionsOne() {
//        doCallPhone();
//        doCamera();;
    }

    private void requestPermissionsMore() {
        sendPermission();
    }


    /**
     * 延迟进入页面，为了增加用户体检效果
     * 一般在欢迎界面停留几秒
     * 使用RxJava的标识符来实现延迟效果
     */
    @SuppressLint("CheckResult")
    private void delayEntryPage() {
        Flowable.timer(1200, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {
                    mBaseActivity.startActivity(new Intent(getActivity(), PostListRspActivity.class));
//                    mBaseActivity.startActivity(new Intent(getActivity(), GetMvpRspActivity.class));
//                    readyGo(GetMvpRspActivity.class);
                    finish();
                }, Throwable::printStackTrace);
    }


    @Override
    protected View getRootView() {
        return null;
    }

    @OnClick(R.id.enter_button)
    public void goHome(){
        SpfsUtils.write(SplashActivity.this,"isFirst", false);
//        startActivity(new Intent(this,GetListRspActivity.class));
//        mBaseActivity.startActivity(new Intent(getActivity(), PostListRspActivity.class));
//        mBaseActivity.startActivity(new Intent(getActivity(), GetMvpRspActivity.class));
        readyGo(GetMvpRspActivity.class);
        finish();
    }



    /**
     * 拨打电话
     */
    private void doCallPhone() {
        XPermission.requestPermissions(this, 100,new String[]{Manifest.permission.CALL_PHONE}, new XPermission.OnPermissionListener() {
            //权限申请成功时调用
            @Override
            public void onPermissionGranted() {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:18682555854"));
                startActivity(intent);
            }
            //权限被用户禁止时调用
            @Override
            public void onPermissionDenied() {
                //给出友好提示，并且提示启动当前应用设置页面打开权限
                XPermission.showTipsDialog(SplashActivity.this);
            }
        });
    }

    /**
     * 照相
     */
    private void doCamera() {
        XPermission.requestPermissions(this, 101, new String[]{Manifest.permission
                .CAMERA}, new XPermission.OnPermissionListener() {
            @Override
            public void onPermissionGranted() {
                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }

            @Override
            public void onPermissionDenied() {
                XPermission.showTipsDialog(SplashActivity.this);
            }
        });
    }
    /**
     * 多个权限
     */
    private void sendPermission() {
        XPermission.requestPermissions(this, 102, permissions, new XPermission.OnPermissionListener() {
            @Override
            public void onPermissionGranted() {
                Toast.makeText(getApplication(),"申请成功！",Toast.LENGTH_SHORT).show();
                delayEntryPage();
            }

            @Override
            public void onPermissionDenied() {
                XPermission.showTipsDialog(SplashActivity.this);
            }
        });
    }

}
