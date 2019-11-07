package com.config.pad.content.libding.rerxmvp.base;

import com.config.pad.content.libding.config.application.AppProfile;
import com.config.pad.content.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import com.config.pad.content.libding.utils.ToastUtil;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;

import java.io.NotSerializableException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.ParseException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscription;

/**
 * Created by tushuangxi 2019.1.26
 */
public class BasePresenter<V extends interfaceUtilsAll.IBaseView, D> implements interfaceUtilsAll.RequestCallback<D> {
    protected Subscription mSubscription;
    protected V mView;

    public BasePresenter(V mView) {
        this.mView = mView;
    }

    public void onDestroy() {
        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
        mView = null;
    }

    @Override
    public void onBefore() {
        mView.showProgress();
    }

    @Override
    public void onCompleted() {
        mView.hideProgress();
    }

    @Override
    public void onSuccess(D data) {
        mView.hideProgress();

    }

    /**
     * onError统一在这里处理
     */
    @Override
    public void onError(Throwable throwable) {
        mView.hideProgress();

        if (throwable instanceof HttpException) {

            HttpException httpException = (HttpException) throwable;
            int code = httpException.code();
            if (code == 500 || code == 404) {
                ToastUtil.showToast(AppProfile.context,"服务器错误.");
                mView.hideProgress();
//            mView.showToast("服务器错误.");
            }
        } else if (throwable instanceof ConnectException) {
            ToastUtil.showToast(AppProfile.context,"网络连接异常，请检查您的网络状态，稍后重试!");
            mView.hideProgress();
        } else if (throwable instanceof SocketTimeoutException) {
            ToastUtil.showToast(AppProfile.context,"网络连接超时，请检查您的网络状态，稍后重试!");
            mView.hideProgress();
        }
        else if (throwable instanceof ConnectTimeoutException) {
            ToastUtil.showToast(AppProfile.context,"网络连接超时，请检查您的网络状态，稍后重试!");
            mView.hideProgress();
        } else if (throwable instanceof UnknownHostException) {
            ToastUtil.showToast(AppProfile.context,"网络连接异常，请检查您的网络状态，稍后重试!");
            mView.hideProgress();
        } else if (throwable instanceof NullPointerException) {
            ToastUtil.showToast(AppProfile.context,"空指针异常!");
            mView.hideProgress();
        } else if (throwable instanceof javax.net.ssl.SSLHandshakeException) {
            ToastUtil.showToast(AppProfile.context,"证书验证失败!");
            mView.hideProgress();
        } else if (throwable instanceof ClassCastException) {
            ToastUtil.showToast(AppProfile.context,"类型转换错误!");
            mView.hideProgress();
        } else if (throwable instanceof IllegalStateException) {
            ToastUtil.showToast(AppProfile.context,"参数异常!");
            mView.hideProgress();
        }else if (throwable instanceof JsonParseException
                || throwable instanceof JSONException
                || throwable instanceof JsonSyntaxException
                || throwable instanceof JsonSerializer
                || throwable instanceof NotSerializableException
                || throwable instanceof ParseException) {
            ToastUtil.showToast(AppProfile.context,"解析错误!");
            mView.hideProgress();
        } else {  //Use JsonReader.setLenient(true) to accept malformed JSON at line 1 column 1 path $
            ToastUtil.showToast(AppProfile.context,"未知错误");
            mView.hideProgress();
        }
    }
}
