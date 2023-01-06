package com.example.mycloudmusicandroidjava.fragment;

import android.os.Bundle;

import com.example.mycloudmusicandroidjava.databinding.FragmentDiscoveryBinding;
import com.example.mycloudmusicandroidjava.databinding.FragmentMeBinding;

/**
 * 个人界面
 */
public class MeFragment extends BaseViewModelFragment<FragmentMeBinding>{
    public static MeFragment newInstance() {
        
        Bundle args = new Bundle();
        
        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
