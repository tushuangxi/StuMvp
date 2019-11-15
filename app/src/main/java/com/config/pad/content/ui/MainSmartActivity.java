package com.config.pad.content.ui;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.config.pad.content.R;
import com.config.pad.content.libding.rerxmvp.base.BaseActivity;
import com.config.pad.content.library.smartLoadingView.SmartLoadingView;
import com.gyf.barlibrary.ImmersionBar;


public class MainSmartActivity extends BaseActivity implements SmartLoadingView.LoginClickListener {
    //沉浸式状态栏
    protected ImmersionBar mImmersionBar;
    private SmartLoadingView text_style_one;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main_smart;
    }

    @Override
    protected void initView() {
        text_style_one = findViewById(R.id.text_style_one);
        text_style_one.setLoginClickListener(this);
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mImmersionBar.destroy();
    }


    @Override
    protected void onResume() {
        super.onResume();
        //注意这里不需要关闭上一步的activity需要做如此操作
        text_style_one.reset();
    }

    @Override
    protected View getRootView() {
        return null;
    }

    @Override
    public void click() {
        text_style_one.netFaile("登录失败");

       /* text_style_one.loginSuccess(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(new Intent(MainSmartActivity.this, LoginActivity.class));
                finish();
                overridePendingTransition(R.anim.scale_test_home, R.anim.scale_test2);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });*/
    }
}
