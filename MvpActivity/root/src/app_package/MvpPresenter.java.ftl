package ${packageName}.rerxmvp.presenter;

import android.content.Context;
import ${packageName}.base.BasePresenter;
import ${packageName}.rerxmvp.interfaceUtils.interfaceUtilsAll;
import ${packageName}.rerxmvp.model.GetAllDataListModelImpl;
import ${packageName}.entry.${EntryName};

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by tushuangxi on 2019/4/3.
 * @author tushuangxi
 */

public class ${EntryName}PresenterImpl extends BasePresenter<interfaceUtilsAll.${EntryName}View, ${EntryName}> implements interfaceUtilsAll.${EntryName}Presenter{

    private int page = 0;
    private boolean isRefresh;
    private GetAllDataListModelImpl i${EntryName}Interactor;
    private List<${EntryName}> newsList = new ArrayList<>();

    public ${EntryName}PresenterImpl(interfaceUtilsAll.${EntryName}View mView) {
        super(mView);
        i${EntryName}Interactor = new GetAllDataListModelImpl();
    }

    @Override
    public void request${EntryName}List(boolean isRefresh,Map<String, String> params) {
        this.isRefresh = isRefresh;
        if (isRefresh) {
            page = 0;
        }
        mSubscription = i${EntryName}Interactor.request${EntryName}List(this,params);
    }

    @Override
    public void onSuccess(${EntryName} i${EntryName}json ){
        super.onSuccess(i${EntryName}json);
        mView.dismissRefreshView();
        mView.update${EntryName}(i${EntryName}json);
       // if (i${EntryName}json.getData() == null || i${EntryName}json.getData().size() == 0) return;
        if (i${EntryName}json == null) return;
        page++;
        if (isRefresh) this.newsList.clear();
     //   this.newsList.addAll(i${EntryName}json.getData());
        mView.update${EntryName}List(this.newsList);
    }

}
