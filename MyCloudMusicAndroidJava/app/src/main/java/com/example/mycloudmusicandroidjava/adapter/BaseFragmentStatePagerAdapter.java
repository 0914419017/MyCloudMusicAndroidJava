package com.example.mycloudmusicandroidjava.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseFragmentStatePagerAdapter<T> extends FragmentStatePagerAdapter {
    protected final List<T> datum = new ArrayList<>();
    private final Context context;

    public BaseFragmentStatePagerAdapter(Context context, @NonNull FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    /**
     * 数量
     * @return
     */
    @Override
    public int getCount() {
        return datum.size();
    }

    /**
     * 返回当前位置数据
     * @param position
     * @return
     */
    public T getData(int position){
        return datum.get(position);
    }

    /**
     * 在当前列表设置数据
     */
    public void setDatum(List<T> datum){
        this.datum.clear();

        if (datum!=null && datum.size()>0){
            this.datum.addAll(datum);
        }

        //数据改变
        notifyDataSetChanged();
    }
}
