package com.config.pad.content.libding.rerxmvp.view.fragment;

import com.config.pad.content.R;
import com.config.pad.content.libding.rerxmvp.base.BaseFragment;
import com.config.pad.content.libding.entry.PostListRsp;
import com.config.pad.content.libding.http.ServiceMapParams;
import com.config.pad.content.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import com.config.pad.content.libding.rerxmvp.presenter.PostListRspPresenterImpl;

import android.os.Bundle;

import android.view.View;

import java.util.List;

/**
 * Created by tushuangxi on 2019/4/3.
 *
 * @author tushuangxi
 */
public class PostListRspFragment extends BaseFragment implements interfaceUtilsAll.PostListRspView {


    private interfaceUtilsAll.PostListRspPresenter mPostListRspPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_postlistrsp;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {


    }

    @Override
    public void loadData(Bundle args) {

        mPostListRspPresenter = new PostListRspPresenterImpl(this);
        mPostListRspPresenter.requestPostListRspList(true, ServiceMapParams.getPostListRspMapParams());
    }


    @Override
    public void dismissRefreshView() {

    }

    @Override
    public void updatePostListRsp(PostListRsp iPostListRspjson) {

    }

    @Override
    public void updatePostListRspList(List<PostListRsp.FemaleEntity> newsList) {

    }
}
