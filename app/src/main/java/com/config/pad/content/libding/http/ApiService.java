package com.config.pad.content.libding.http;

import com.config.pad.content.libding.entry.GetListRsp;
import com.config.pad.content.libding.entry.GetMvpRsp;
import com.config.pad.content.libding.entry.PostListRsp;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by tushuangxi 2019.1.26
 */
public interface ApiService {

    boolean isDebugHost = AppConfig.isDebug;
    //正式环境host
    String hostRelease = "http://api.zhuishushenqi.com";//正式接口

    //测试环境host
    String hostDebug = "http://api.zhuishushenqi.com";

    // 服务器域名  http://api.zhuishushenqi.com/cats/lv2/statistics
    String SERVER_ADDRESS = isDebugHost ? hostDebug : hostRelease;

    /**
     * GetListRsp
     */
    @GET("/cats/lv2/statistics/")
    Observable<GetListRsp> requestGetListRspList(@QueryMap Map<String, String> params);

    /**
     * PostListRsp
     */
    @GET("/cats/lv2/statistics/")
    Observable<PostListRsp> requestPostListRspList(@QueryMap Map<String, String> params);

    /**
     * GetMvpRsp
     */
    @GET("/cats/lv2/statistics/")
    Observable<GetMvpRsp> requestGetMvpRspList(@QueryMap Map<String, String> params);


}
