package com.config.pad.content.libding.rerxmvp.presenter;


import com.config.pad.content.libding.rerxmvp.base.BasePresenter;
import com.config.pad.content.libding.entry.GetListRsp;
import com.config.pad.content.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import com.config.pad.content.libding.rerxmvp.model.GetAllDataListModelImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by tushuangxi 2019.1.26
 */
public class GetListRspPresenterImpl extends BasePresenter<interfaceUtilsAll.GetListRspView, GetListRsp> implements interfaceUtilsAll.GetListRspPresenter{

    private int page = 0;
    private boolean isRefresh;
    private GetAllDataListModelImpl iLoginInteractor;
    private List<GetListRsp.FemaleEntity> newsList = new ArrayList<>();

    public GetListRspPresenterImpl(interfaceUtilsAll.GetListRspView mView) {
        super(mView);
        iLoginInteractor = new GetAllDataListModelImpl();
    }

    @Override
    public void requestGetListRspList(boolean isRefresh,Map<String, String> params) {
        this.isRefresh = isRefresh;
        if (isRefresh) {
            page = 0;
        }
        mSubscription = iLoginInteractor.requestGetListRspList(this,params);
    }

    @Override
    public void onSuccess(GetListRsp getListRspjson ){
        super.onSuccess(getListRspjson);

        mView.dismissRefreshView();
        mView.updateGetListRsp(getListRspjson);
        if (getListRspjson.getFemale() == null || getListRspjson.getFemale().size() == 0) return;
        page++;
        if (isRefresh) this.newsList.clear();
        this.newsList.addAll(getListRspjson.getFemale());
        mView.updateGetListRspList(this.newsList);
    }

}
