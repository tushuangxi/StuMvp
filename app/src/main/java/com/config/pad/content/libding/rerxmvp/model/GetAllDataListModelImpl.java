package com.config.pad.content.libding.rerxmvp.model;

import com.config.pad.content.libding.entry.GetMvpRsp;
import com.config.pad.content.libding.entry.PostListRsp;
import com.config.pad.content.libding.entry.GetListRsp;
import com.config.pad.content.libding.http.manager.RetrofitManager;
import com.config.pad.content.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;

import java.util.Map;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;

/**
 * Created by tushuangxi 2019.1.26
 */
public class GetAllDataListModelImpl implements interfaceUtilsAll.SubjectBookListModel {

    @Override
    public Subscription requestGetListRspList(final interfaceUtilsAll.RequestCallback<GetListRsp> callback, Map<String, String> params) {
        return RetrofitManager.getInstance().getGetListRspObservable(params)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        // 订阅之前回调回去显示加载动画
                        callback.onBefore();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GetListRsp>() {
                    @Override
                    public void onCompleted() {
                        callback.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e);
                    }

                    @Override
                    public void onNext(GetListRsp getListRsp) {

                        callback.onSuccess(getListRsp);
                    }
                });
    }

    @Override
    public Subscription requestPostListRspList(final interfaceUtilsAll.RequestCallback<PostListRsp> callback, Map<String, String> params) {
        return RetrofitManager.getInstance().getPostListRspObservable(params)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        // 订阅之前回调回去显示加载动画
                        callback.onBefore();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PostListRsp>() {
                    @Override
                    public void onCompleted() {
                        callback.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e);
                    }

                    @Override
                    public void onNext(PostListRsp postListRsp) {

                        callback.onSuccess(postListRsp);
                    }
                });
    }

    @Override
    public Subscription requestGetMvpRspList(final interfaceUtilsAll.RequestCallback<GetMvpRsp> callback, Map<String, String> params) {
        return RetrofitManager.getInstance().getGetMvpRspObservable(params)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        // 订阅之前回调回去显示加载动画
                        callback.onBefore();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GetMvpRsp>() {
                    @Override
                    public void onCompleted() {
                        callback.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError(e);
                    }

                    @Override
                    public void onNext(GetMvpRsp getMvpRsp) {

                        callback.onSuccess(getMvpRsp);
                    }
                });
    }



}
