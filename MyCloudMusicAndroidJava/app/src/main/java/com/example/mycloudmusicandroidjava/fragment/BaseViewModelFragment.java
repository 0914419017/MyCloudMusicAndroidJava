package com.example.mycloudmusicandroidjava.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.example.mycloudmusicandroidjava.reflect.ReflectUtil;

public abstract class BaseViewModelFragment<VB extends ViewBinding> extends BaseLogicFragment {
    protected VB binging;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binging = ReflectUtil.newViewBing(getLayoutInflater(),getClass());
    }
    //返回布局

    @Override
    protected View getLayoutView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return binging.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binging = null;
    }
}
