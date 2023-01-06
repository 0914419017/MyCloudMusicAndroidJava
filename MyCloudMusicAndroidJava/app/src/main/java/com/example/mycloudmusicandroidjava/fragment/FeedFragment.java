package com.example.mycloudmusicandroidjava.fragment;

import android.os.Bundle;

import com.example.mycloudmusicandroidjava.databinding.FragmentDiscoveryBinding;
import com.example.mycloudmusicandroidjava.databinding.FragmentFeedBinding;

/**
 * 动态界面
 */
public class FeedFragment extends BaseViewModelFragment<FragmentFeedBinding>{
    public static FeedFragment newInstance() {
        
        Bundle args = new Bundle();
        
        FeedFragment fragment = new FeedFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
