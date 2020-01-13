package com.config.pad.content.libding.rerxmvp.interfaceUtils;

import android.app.Activity;

import com.config.pad.content.libding.entry.GetListRsp;
import com.config.pad.content.libding.entry.GetMvpRsp;
import com.config.pad.content.libding.entry.PostListRsp;

import java.util.List;
import java.util.Map;
//import rx.Subscription;
import rx.Subscription;


public class interfaceUtilsAll {
    public interface TestJson{
        void  showJson(String json);
    }

    public interface RequestCallback<T> {
        /**
         * 请求开始之前
         */
        void onBefore();

        /**
         * 请求完成
         */
        void onCompleted();

        /**
         * 请求成功
         */
        void onSuccess(T data);

        /**
         * 请求错误
         */
        void onError(Throwable throwable);
    }

    public interface IBaseView {
        Activity getActivity();

        void showProgress();

        void hideProgress();

        void showToast(String content);

    }


    //---------------------------------------------------------------------------------------------------------------所有的Model interface
    public interface SubjectBookListModel {

        rx.Subscription requestGetListRspList(RequestCallback<GetListRsp> callback, Map<String, String> params);
        rx.Subscription requestPostListRspList(RequestCallback<PostListRsp> callback, Map<String, String> params);
        Subscription requestGetMvpRspList(RequestCallback<GetMvpRsp> callback, Map<String, String> params);


    }

    //---------------------------------------------------------------------------------------------------------------//GetListRsp   M V P
    public interface GetListRspView extends IBaseView {
        void dismissRefreshView();
        void updateGetListRsp(GetListRsp getListRsp);
        void updateGetListRspList(List<GetListRsp.FemaleEntity> newsList);
    }

    public interface GetListRspPresenter {
        void requestGetListRspList(boolean isRefresh,Map<String, String> params);
        void onDestroy();
    }
    //---------------------------------------------------------------------------------------------------------------// PostListRsp   M V P
    public interface PostListRspView extends IBaseView {
        void dismissRefreshView();
        void updatePostListRsp(PostListRsp postListRsp);
        void updatePostListRspList(List<PostListRsp.FemaleEntity> newsList);
    }

    public interface PostListRspPresenter {
        void requestPostListRspList(boolean isRefresh,Map<String, String> params);
        void onDestroy();
    }
    //---------------------------------------------------------------------------------------------------------------// GetMvpRsp   M V P
    public interface GetMvpRspView extends IBaseView {
        void dismissRefreshView();
        void updateGetMvpRsp(GetMvpRsp getMvpRsp);
        void updateGetMvpRspList(List<GetMvpRsp> newsList);
    }

    public interface GetMvpRspPresenter {
        void requestGetMvpRspList(boolean isRefresh,Map<String, String> params);
        void onDestroy();
    }

}
