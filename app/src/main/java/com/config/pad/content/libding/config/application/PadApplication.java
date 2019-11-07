package com.config.pad.content.libding.config.application;

import com.config.pad.content.BuildConfig;
import com.config.pad.content.ui.crash.CrashHandler;
import org.litepal.LitePalApplication;


/**
 * Created by tushuangxi 2019.1.26
 */
public class PadApplication extends LitePalApplication {
    private AppProfile appProfile;
    private static final String TAG = "PadApplication";
    @Override
    public void onCreate() {
        super.onCreate();
        appProfile = AppProfile.getAppProfile(getApplicationContext());
        appProfile.init();
        MyThread myThread = new MyThread();
        new Thread(myThread).start();

    }


    /**
     * 耗时操作启动分线程
     */
    public class MyThread implements Runnable {

        @Override
        public void run() {
            //全局异常捕捉
            if (BuildConfig.DEBUG) {
                CrashHandler crashHandler = CrashHandler.getInstance();
                crashHandler.init(getApplicationContext());
            }
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        if (appProfile != null) {
            appProfile.onTerminate();
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        if (appProfile != null) {
            appProfile.onLowMemory();
        }
    }
}
