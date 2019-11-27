package com.config.pad.content.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.config.pad.content.R;
import com.config.pad.content.libding.widget.recyclerlist.TestRecyclerViewBaseActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

    }
    //第三种方式(Android1.6版本及以后的版本中提供了)
    public void SplashActivity(View view){
        startActivity(new Intent(MainActivity.this, SplashActivity.class));

    }
    public void LoginActivity(View view){
        startActivity(new Intent(MainActivity.this, LoginActivity.class));

    }
    public void MainSmartActivity(View view){
        startActivity(new Intent(MainActivity.this, MainSmartActivity.class));

    }

    public void RecyclerViewBaseList(View view){
        startActivity(new Intent(MainActivity.this, TestRecyclerViewBaseActivity.class));

    }

    public void LoginTemplateView(View view){
        startActivity(new Intent(MainActivity.this, LoginTemplateActivity.class));

    }
}
