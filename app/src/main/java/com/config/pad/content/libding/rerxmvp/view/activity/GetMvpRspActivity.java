package com.config.pad.content.libding.rerxmvp.view.activity;

import com.config.pad.content.R;
import com.config.pad.content.libding.rerxmvp.base.BaseActivity;
import com.config.pad.content.libding.config.application.AppProfile;
import com.config.pad.content.libding.entry.GetMvpRsp;
import com.config.pad.content.libding.http.ServiceMapParams;
import com.config.pad.content.libding.http.manager.RetrofitManager;
import com.config.pad.content.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import com.config.pad.content.libding.rerxmvp.presenter.GetMvpRspPresenterImpl;
import com.config.pad.content.libding.utils.ToastUtil;
import com.config.pad.content.libding.utils.log.XLog;

import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by tushuangxi on 2019/4/3.
 *
 * @author tushuangxi
 * <p>
 * 拷贝到在android studio的D:\android-studio\plugins\android\lib\templates\activities 这个目录下存在着androidstudio新建项目的模板
 */
public class GetMvpRspActivity extends BaseActivity implements interfaceUtilsAll.GetMvpRspView , interfaceUtilsAll.TestJson {


    private interfaceUtilsAll.GetMvpRspPresenter mGetMvpRspPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_getmvprsp;
    }

    @Override
    protected void initView() {
        RetrofitManager.getInstance().setTestJson( this);

        mGetMvpRspPresenter = new GetMvpRspPresenterImpl(this);
        mGetMvpRspPresenter.requestGetMvpRspList(true, ServiceMapParams.getGetMvpRspMapParams());
    }

    @Override
    protected View getRootView() {
        return findViewById(R.id.root);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mGetMvpRspPresenter.onDestroy();
    }

    @Override
    public void dismissRefreshView() {

    }

    @Override
    public void updateGetMvpRsp(GetMvpRsp iGetMvpRspjson) {

    }

    @Override
    public void updateGetMvpRspList(List<GetMvpRsp> newsList) {
        ToastUtil.showToast(AppProfile.context, "请求成功!");
    }

    String json="{ \"data\": [ { \"time\": \"2016-04-26 00:21:26\", \"context\": \"到潍坊市【潍坊转运中心】\" }, { \"time\": \"2016-04-25 18:16:34\", \"context\": \"威海市【威海集散仓】，正发往【潍坊转运中心】\" }, { \"time\": \"2016-04-25 18:15:42\", \"context\": \"到威海市【威海集散仓】\" } ], \"phone\": \"400-956-5656\", \"url\": \"http://www.800bestex.com\", \"nu\": \"70186506140478\", \"company\": \"百世汇通\" }";
    String xml="<index><title>洗车</title><zs>较适宜</zs><tipt>洗车指数</tipt><des>较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。</des><title>旅游</title><zs>适宜</zs><tipt>旅游指数</tipt><des>天气较好，温度适宜，是个好天气哦。这样的天气适宜旅游，您可以尽情地享受大自然的风光。</des></index>";
    List<String> list=new ArrayList<>();
    Map<String,String> map=new HashMap<>();

    @Override
    public void showJson(String json) {

//        list.add("list数据 测试一");
//        list.add("list数据 测试二");
//        XLog.list(list);
//
//        map.put("name","Youth");
//        map.put("job","Android工程师");
//        XLog.map(map);

//        XLog.json(json);
//        XLog.xml(xml);

//        JsonFormatDialogFragment jsonFormatDialogFragment = JsonFormatDialogFragment.newInstance(json.toString());
//        jsonFormatDialogFragment.show(getSupportFragmentManager(),"");
    }
}
