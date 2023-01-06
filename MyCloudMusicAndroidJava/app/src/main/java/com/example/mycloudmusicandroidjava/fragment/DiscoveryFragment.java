package com.example.mycloudmusicandroidjava.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.mycloudmusicandroidjava.R;
import com.example.mycloudmusicandroidjava.activity.SimplePlayerActivity;
import com.example.mycloudmusicandroidjava.adapter.DiscoveryAdapter;
import com.example.mycloudmusicandroidjava.api.HttpObserver;
import com.example.mycloudmusicandroidjava.databinding.FragmentDiscoveryBinding;
import com.example.mycloudmusicandroidjava.modle.Song;
import com.example.mycloudmusicandroidjava.modle.response.ListResponse;
import com.example.mycloudmusicandroidjava.repository.DefaultRepository;

/**
 * 发现界面
 */
public class DiscoveryFragment extends BaseViewModelFragment<FragmentDiscoveryBinding>{
    private DiscoveryAdapter adapter;

    @Override
    protected void initViews() {
        super.initViews();
        //高度固定 便于提高性能

        binging.list.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getHostActivity());
        binging.list.setLayoutManager(layoutManager);

        //分割线
        DividerItemDecoration decoration = new DividerItemDecoration(binging.list.getContext(), RecyclerView.VERTICAL);
        binging.list.addItemDecoration(decoration);
    }

    @Override
    protected void initDatum() {
        super.initDatum();
        adapter = new DiscoveryAdapter(R.layout.item_song);
        binging.list.setAdapter(adapter);

        loadData();
    }

    private void loadData() {
        DefaultRepository
                .getInstance()
                .songs()
                .subscribe(new HttpObserver<ListResponse<Song>>() {
                    @Override
                    public void onSucceeded(ListResponse<Song> data) {
                        adapter.setNewInstance(data.getData().getData());
                    }
                });
    }

    @Override
    protected void initListeners() {
        super.initListeners();
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                startActivity(SimplePlayerActivity.class);
            }
        });
    }

    public static DiscoveryFragment newInstance() {
        
        Bundle args = new Bundle();
        
        DiscoveryFragment fragment = new DiscoveryFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
