package com.example.mycloudmusicandroidjava;

import android.app.Application;

import com.example.mycloudmusicandroidjava.reflect.toast.SuperToast;

/*全局context*/
public class AppContext extends Application {
    private static AppContext instance;
    @Override
    public void onCreate() {//只会运行一次
        super.onCreate();
        instance = this;

        SuperToast.init(getApplicationContext());
    }

    public static AppContext getInstance() {
        return instance;
    }

    public void logout() {

    }
}
