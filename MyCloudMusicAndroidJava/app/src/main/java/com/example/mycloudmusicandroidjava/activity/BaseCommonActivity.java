package com.example.mycloudmusicandroidjava.activity;

import android.content.Intent;

//通用界面逻辑
public class BaseCommonActivity extends BaseActivity {
    /**
     * 页面跳转
     * @param clazz
     */
    protected void startActivity(Class<?> clazz) {
        startActivity(new Intent(getHostActivity(),clazz));
    }
    /**
     * 启动界面并关闭当前界面
     * @param clazz
     */
    protected void startActivityAfterFinishThis(Class<?> clazz) {
        startActivity(new Intent(getHostActivity(), clazz));
        finish();//跳转完成以后直接关闭该界面
    }

    protected BaseCommonActivity getHostActivity() {
        return this;
    }
}
