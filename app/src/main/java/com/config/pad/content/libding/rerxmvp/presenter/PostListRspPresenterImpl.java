package com.config.pad.content.libding.rerxmvp.presenter;

import com.config.pad.content.libding.rerxmvp.base.BasePresenter;
import com.config.pad.content.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import com.config.pad.content.libding.rerxmvp.model.GetAllDataListModelImpl;
import com.config.pad.content.libding.entry.PostListRsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by tushuangxi on 2019/4/3.
 *
 * @author tushuangxi
 */

public class PostListRspPresenterImpl extends BasePresenter<interfaceUtilsAll.PostListRspView, PostListRsp> implements interfaceUtilsAll.PostListRspPresenter {

    private int page = 0;
    private boolean isRefresh;
    private GetAllDataListModelImpl iPostListRspInteractor;
    private List<PostListRsp.FemaleEntity> newsList = new ArrayList<>();

    public PostListRspPresenterImpl(interfaceUtilsAll.PostListRspView mView) {
        super(mView);
        iPostListRspInteractor = new GetAllDataListModelImpl();
    }

    @Override
    public void requestPostListRspList(boolean isRefresh, Map<String, String> params) {
        this.isRefresh = isRefresh;
        if (isRefresh) {
            page = 0;
        }
        mSubscription = iPostListRspInteractor.requestPostListRspList(this, params);
    }

    @Override
    public void onSuccess(PostListRsp iPostListRspjson) {
        super.onSuccess(iPostListRspjson);
        mView.dismissRefreshView();
        mView.updatePostListRsp(iPostListRspjson);
        if (iPostListRspjson.getFemale() == null || iPostListRspjson.getFemale().size() == 0) return;
        page++;
        if (isRefresh) this.newsList.clear();
        this.newsList.addAll(iPostListRspjson.getFemale());
        mView.updatePostListRspList(this.newsList);
    }

}