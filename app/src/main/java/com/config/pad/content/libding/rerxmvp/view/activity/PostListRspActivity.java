package com.config.pad.content.libding.rerxmvp.view.activity;

import android.view.View;
import android.widget.Button;

import com.anarchy.library.JsonFormatDialogFragment;
import com.config.pad.content.R;
import com.config.pad.content.libding.rerxmvp.base.BaseActivity;
import com.config.pad.content.libding.config.application.AppProfile;
import com.config.pad.content.libding.entry.PostListRsp;
import com.config.pad.content.libding.http.ServiceMapParams;
import com.config.pad.content.libding.http.manager.RetrofitManager;
import com.config.pad.content.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import com.config.pad.content.libding.rerxmvp.presenter.PostListRspPresenterImpl;
import com.config.pad.content.libding.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by tushuangxi on 2019/4/3.
 *
 * @author tushuangxi
 */
public class PostListRspActivity extends BaseActivity implements interfaceUtilsAll.PostListRspView , interfaceUtilsAll.TestJson{

    private interfaceUtilsAll.PostListRspPresenter mPostListRspPresenter;
    @BindView(R.id.commit)
    Button commit;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_postlistrsp;
    }

    @Override
    protected void initView() {

        RetrofitManager.getInstance().setTestJson( this);
    }


    @OnClick({R.id.commit})
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.commit:

                mPostListRspPresenter = new PostListRspPresenterImpl(this);
                mPostListRspPresenter.requestPostListRspList(true, ServiceMapParams.getPostListRspMapParams());

                break;

        }
    }

    @Override
    protected View getRootView() {
        return findViewById(R.id.root);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPostListRspPresenter.onDestroy();
    }

    @Override
    public void dismissRefreshView() {

    }

    @Override
    public void updatePostListRsp(PostListRsp iPostListRspjson) {
        ToastUtil.showToast(AppProfile.context, "请求成功!");

    }

    @Override
    public void updatePostListRspList(List<PostListRsp.FemaleEntity> newsList) {

    }

    @Override
    public void showJson(String json) {
        JsonFormatDialogFragment jsonFormatDialogFragment = JsonFormatDialogFragment.newInstance(json.toString());
        jsonFormatDialogFragment.show(getSupportFragmentManager(),"");
    }
}
