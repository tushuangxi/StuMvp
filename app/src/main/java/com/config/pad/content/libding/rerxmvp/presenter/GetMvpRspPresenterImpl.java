package com.config.pad.content.libding.rerxmvp.presenter;

import com.config.pad.content.libding.rerxmvp.base.BasePresenter;
import com.config.pad.content.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import com.config.pad.content.libding.rerxmvp.model.GetAllDataListModelImpl;
import com.config.pad.content.libding.entry.GetMvpRsp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by tushuangxi on 2019/4/3.
 *
 * @author tushuangxi
 */

public class GetMvpRspPresenterImpl extends BasePresenter<interfaceUtilsAll.GetMvpRspView, GetMvpRsp> implements interfaceUtilsAll.GetMvpRspPresenter {

    private int page = 0;
    private boolean isRefresh;
    private GetAllDataListModelImpl iGetMvpRspInteractor;
    private List<GetMvpRsp> newsList = new ArrayList<>();

    public GetMvpRspPresenterImpl(interfaceUtilsAll.GetMvpRspView mView) {
        super(mView);
        iGetMvpRspInteractor = new GetAllDataListModelImpl();
    }

    @Override
    public void requestGetMvpRspList(boolean isRefresh, Map<String, String> params) {
        this.isRefresh = isRefresh;
        if (isRefresh) {
            page = 0;
        }
        mSubscription = iGetMvpRspInteractor.requestGetMvpRspList(this, params);
    }

    @Override
    public void onSuccess(GetMvpRsp iGetMvpRspjson) {
        super.onSuccess(iGetMvpRspjson);
        mView.dismissRefreshView();
        mView.updateGetMvpRsp(iGetMvpRspjson);
        // if (iGetMvpRspjson.getData() == null || iGetMvpRspjson.getData().size() == 0) return;
        if (iGetMvpRspjson == null) return;
        page++;
        if (isRefresh) this.newsList.clear();
        //   this.newsList.addAll(iGetMvpRspjson.getData());
        mView.updateGetMvpRspList(this.newsList);
    }

}
