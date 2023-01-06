package com.example.mycloudmusicandroidjava.activity;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;

import com.example.mycloudmusicandroidjava.R;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

@SuppressWarnings({"all"})
/**
 * 通用标题界面
 * @param <VB>
 */
public class BaseTitleActivity<VB extends ViewBinding> extends BaseViewModelActivity<VB> {
    protected Toolbar toolbar;

    @Override
    protected void initViews() {
        super.initViews();
        toolbar = findViewById(R.id.toolbar);

        //初始化
        setSupportActionBar(toolbar);
        setTitle("音乐");
        //状态栏文字颜色 对于系统而言只有黑色和白色两种颜色 在真机上有效
        //QMUIStatusBarHelper.setStatusBarLightMode(this);

        //showBackMenu();

        //是否显示返回按钮
        if (isShowBackMenu()){
            showBackMenu();
        }
    }
    //显示返回按钮

    protected boolean isShowBackMenu() {
        return true;
    }

    //显示返回按钮
    protected void showBackMenu() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //返回按钮点击
                backClick();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void backClick() {
        onBackPressed();
    }
}
