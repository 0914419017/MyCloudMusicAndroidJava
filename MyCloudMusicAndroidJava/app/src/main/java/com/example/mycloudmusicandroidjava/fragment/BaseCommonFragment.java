package com.example.mycloudmusicandroidjava.fragment;

import android.content.Intent;

import com.example.mycloudmusicandroidjava.activity.BaseCommonActivity;

/**
 * 通用公共 Fragment
 */
public abstract class BaseCommonFragment  extends BaseFragment{
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
        getHostActivity().finish();//跳转完成以后直接关闭该界面
    }
    protected BaseCommonActivity getHostActivity(){
        return (BaseCommonActivity) getActivity();
    }
}
