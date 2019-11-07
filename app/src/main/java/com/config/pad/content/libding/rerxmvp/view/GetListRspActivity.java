package com.config.pad.content.libding.rerxmvp.view;


import android.view.View;
import android.widget.Button;

import com.anarchy.library.JsonFormatDialogFragment;
import com.config.pad.content.libding.config.application.AppProfile;
import com.config.pad.content.libding.entry.GetListRsp;
import com.config.pad.content.libding.http.manager.RetrofitManager;
import com.config.pad.content.libding.rerxmvp.presenter.GetListRspPresenterImpl;
import com.config.pad.content.libding.utils.ToastUtil;
import com.config.pad.content.R;
import com.config.pad.content.libding.rerxmvp.base.BaseActivity;
import com.config.pad.content.libding.http.ServiceMapParams;
import com.config.pad.content.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by tushuangxi 2019.1.26
 */
public class GetListRspActivity extends BaseActivity implements interfaceUtilsAll.GetListRspView, interfaceUtilsAll.TestJson {

    private interfaceUtilsAll.GetListRspPresenter getListRspPresenter;

    @BindView(R.id.commit)
    Button commit;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        RetrofitManager.getInstance().setTestJson( this);
    }

    @Override
    protected View getRootView() {
        return findViewById(R.id.root);
    }

    @OnClick({R.id.commit})
    public void onClick(View v) {

        switch (v.getId()) {
           case R.id.commit:

               getListRspPresenter = new GetListRspPresenterImpl(this);
               getListRspPresenter.requestGetListRspList(true,ServiceMapParams.getGetListRspMapParams());
                break;

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getListRspPresenter.onDestroy();
    }

    @Override
    public void dismissRefreshView() {

    }

    @Override
    public void updateGetListRsp(GetListRsp getListRsp) {
        ToastUtil.showToast(AppProfile.context,"请求成功!");

    }

    @Override
    public void updateGetListRspList(List<GetListRsp.FemaleEntity> newsList) {

    }

    @Override
    public void showJson(String json) {
        JsonFormatDialogFragment jsonFormatDialogFragment = JsonFormatDialogFragment.newInstance(json.toString());
        jsonFormatDialogFragment.show(getSupportFragmentManager(),"");
    }
}
