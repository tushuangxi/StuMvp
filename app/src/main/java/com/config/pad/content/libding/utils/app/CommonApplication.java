package com.config.pad.content.libding.utils.app;


import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.util.Stack;

//application自带了ActivityLifecycleCallbacks接口回调来管理已打开的activity
//https://blog.csdn.net/Agg_bin/article/details/89853212
public class CommonApplication extends Application {

    private Stack<Activity> stack = new Stack<>();

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new CommonActivityLifecycleCallbacks());
    }

    private class CommonActivityLifecycleCallbacks implements ActivityLifecycleCallbacks{

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            stack.add(activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {

        }

        @Override
        public void onActivityResumed(Activity activity) {

        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            stack.remove(activity);
        }
    }

}
