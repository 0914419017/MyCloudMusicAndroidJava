package com.example.mycloudmusicandroidjava.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.mycloudmusicandroidjava.fragment.DiscoveryFragment;
import com.example.mycloudmusicandroidjava.fragment.FeedFragment;
import com.example.mycloudmusicandroidjava.fragment.MeFragment;

/**
 * 主界面的ViewPager的Adapter
 */
public class MainAdapter extends BaseFragmentStatePagerAdapter<Integer>{
    public MainAdapter(Context context, @NonNull FragmentManager fm) {
        super(context, fm);
    }

    /**
     * 返回要显示的Fragment
     * @param position
     * @return
     */
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 1:
                return FeedFragment.newInstance();
            case 2:
                return MeFragment.newInstance();
            default:
                return DiscoveryFragment.newInstance();
        }
    }
}
