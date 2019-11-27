package com.config.pad.content.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.config.pad.content.libding.widget.view.LoginTemplateView;


//LoginTemplateView   UI 快速开发 模板
public class LoginTemplateActivity extends AppCompatActivity {
    LoginTemplateView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view=new LoginTemplateView(this);
        setContentView(view);
        //设置点击事件
        view.setLoginListener(new LoginTemplateView.LoginListener() {
            @Override
            public void login(View v) {
                Toast.makeText(getApplicationContext(),view.getLoginName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
