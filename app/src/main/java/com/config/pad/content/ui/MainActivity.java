package com.config.pad.content.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.config.pad.content.R;
import com.config.pad.content.libding.rerxmvp.view.activity.PostListRspActivity;
import com.config.pad.content.libding.widget.recyclerlist.TestRecyclerViewBaseActivity;
import com.config.pad.content.library.alertview.AlertView;
import com.config.pad.content.library.alertview.DialogLoading;
import com.config.pad.content.library.error.NetError;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import org.json.JSONException;

import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {

    public DialogLoading loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        loading = new DialogLoading(MainActivity.this);
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



    public void AlertView(View view){
        loading.show();

        Flowable.timer(2000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {
                    if(loading.isShowing()){
                        loading.dismiss();
                    }
//                    AlertView.showTip(MainActivity.this,"请求成功！");

                    onError(new JsonParseException(""));
                }, Throwable::printStackTrace);
    }


    public void onError(Throwable e) {
        NetError error = null;
        if (e != null) {
            if (!(e instanceof NetError)) {
                if (e instanceof UnknownHostException) {
                    error = new NetError(e, NetError.NoConnectError);
                } else if (e instanceof JSONException
                        || e instanceof JsonParseException
                        || e instanceof JsonSyntaxException) {
                    error = new NetError(e, NetError.ParseError);
                } else {
                    error = new NetError(e, NetError.OtherError);
                }
            } else {
                error = (NetError) e;
            }
            showError(error);
        }
    }

    public void showError(NetError error){
        if(loading.isShowing()){
            loading.dismiss();
        }
        if (error != null) {
            switch (error.getType()) {
                case NetError.ParseError:
                    AlertView.showTip(MainActivity.this, "数据解析异常！");
                    break;

                case NetError.NoConnectError:
                    AlertView.showTip(MainActivity.this, "网络无连接！");
                    break;

                case NetError.NoDataError:
                    AlertView.showTip(MainActivity.this, "添加失败！请重试！");
                    break;

                case NetError.OtherError:
                    AlertView.showTip(MainActivity.this, "服务器繁忙！");
                    break;
            }
        }
    }

    public void showSuccess(){
        if(loading.isShowing()){
            loading.dismiss();
        }
        AlertView.showTip(MainActivity.this, "登录成功！");
    }
}
