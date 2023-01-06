package com.example.mycloudmusicandroidjava.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.example.mycloudmusicandroidjava.reflect.ReflectUtil;

/*通用ViewModel Activity
 * 包括ViewBinding 主要处理每次要setContentView*/
public class BaseViewModelActivity<VB extends ViewBinding> extends BaseLogicActivity {
    protected VB binding;//泛型 反射 避免直接写死

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //调用inflate方法 创建viewBinding
        binding = ReflectUtil.newViewBing(getLayoutInflater(), this.getClass());//将类传过去
        setContentView(binding.getRoot());
    }
}
