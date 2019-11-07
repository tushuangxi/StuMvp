package com.config.pad.content.libding.rerxmvp.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.config.pad.content.R;
import com.config.pad.content.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import com.config.pad.content.libding.utils.AppActivityManager;
import com.config.pad.content.libding.utils.XPermission;
import com.config.pad.content.libding.utils.XStatusBar;
import com.config.pad.content.libding.widget.LoadingView;
import com.config.pad.content.libding.widget.LoadingActivityDialog;
import com.config.pad.content.libding.widget.StatusBarCompat;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by tushuangxi 2019.1.26
 */
public abstract class BaseActivity extends FragmentActivity implements interfaceUtilsAll.IBaseView {

    private LoadingActivityDialog loadDialogView1;
    public static List<Activity> allActivity1 = new ArrayList<>();//这个区别于MainService的allActivity ，包含了所有的。而main里不包含注册登陆等。便于用户首次登陆后退出
    private LoadingView loadingView = new LoadingView();
    public Context mContext = BaseActivity.this;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doBeforeSetcontentView();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());

        AppActivityManager.getInstance().addActivity(this);//新建时添加到栈

        ButterKnife.bind(this);//绑定Activity 必须在setContentView之后

        allActivity1.add(this);
        initView();
        initArgsData();
    }

    /**
     * 设置layout前配置
     */
    private void doBeforeSetcontentView() {
        //保持竖屏
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //当系统版本为4.4或者4.4以上时可以使用沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        // 无标题
//        NoTitleWindow();
        // 设置竖屏

        // 默认着色状态栏
        SetStatusBarColor();
    }

    protected void NoTitleWindow() {
        Window window = getWindow();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        window.setFlags(flag, flag);
    }
    /**
     * 着色状态栏（4.4以上系统有效）
     */
    protected void SetStatusBarColor() {
//        StatusBarCompat.setStatusBarColor(this, ContextCompat.getColor(this, R.color.role_yellow_gray));

        XStatusBar.setColor(this, getResources().getColor(R.color.colorPrimary),0);
    }
    /**
     * 着色状态栏（4.4以上系统有效）
     */
    protected void SetStatusBarColor(int color) {
        StatusBarCompat.setStatusBarColor(this, color);
    }

    /**
     * 沉浸状态栏（4.4以上系统有效）
     */
    protected void SetTranslanteBar() {
        StatusBarCompat.translucentStatusBar(this);
    }

    protected abstract int getLayoutId();

    protected void initArgsData() {
    }

    protected abstract void initView();

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void showProgress() {
//        loadingView.showLoading(getRootView());
        loadDialogView1 = LoadingActivityDialog.createDialog(mContext);
        loadDialogView1.show();
    }

    @Override
    public void hideProgress() {
//        loadingView.hideLoading();
        loadDialogView1.dismiss();
    }

    @Override
    public void showToast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }

    protected abstract View getRootView();


    protected void onDestroy() {
        super.onDestroy();
        Log.e("BaseActivity", "onDestroy: " + getClass().getSimpleName());
        AppActivityManager.getInstance().killActivity(this);
    }


    /**
     * @param clazz
     * @param bundle 跳转页面
     */
    protected void readyGo(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle)
            intent.putExtras(bundle);
        startActivity(intent);
    }

    protected void readyGo(Class<?> clazz) {
        readyGo(clazz, null);
    }
    /**
     * @param clazz  目标Activity
     * @param bundle 数据
     */
    protected void readyGoThenKill(Class<?> clazz, Bundle bundle) {
        readyGo(clazz, bundle);
        finish();
    }

    /**
     * startActivityForResult
     *
     * @param clazz       目标Activity
     * @param requestCode 发送判断值
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, requestCode);
    }

    /**
     * startActivityForResult with bundle
     *
     * @param clazz       目标Activity
     * @param requestCode 发送判断值
     * @param bundle      数据
     */
    protected void readyGoForResult(Class<?> clazz, int requestCode, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        if (null != bundle) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }
    /**
     * Android M 全局权限申请回调
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[]
            grantResults) {
        XPermission.onRequestPermissionsResult(requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
