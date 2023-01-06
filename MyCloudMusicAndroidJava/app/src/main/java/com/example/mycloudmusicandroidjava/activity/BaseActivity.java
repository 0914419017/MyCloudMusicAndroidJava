package com.example.mycloudmusicandroidjava.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    //找控件
    protected void initViews(){

    }
    //设置数据
    protected void initDatum() {
    }
    //设置监听器
    protected void initListeners() {
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initViews();
        initDatum();
        initListeners();
    }




}
