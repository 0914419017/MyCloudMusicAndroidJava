package com.example.mycloudmusicandroidjava.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
/*所有Fragment通用父类*/
public abstract class BaseFragment extends Fragment {
    //控件
    protected void initViews(){

    }
    //数据
    protected void initDatum(){

    }
    //绑定监听器
    protected void initListeners(){
    }

    /**
     * 返回显示的控件
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //获取view
        View view = getLayoutView(inflater,container,savedInstanceState);

        return view;
    }

    /**
     * 获取view
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    protected abstract View getLayoutView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * View创建
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        initDatum();
        initListeners();
    }
}
