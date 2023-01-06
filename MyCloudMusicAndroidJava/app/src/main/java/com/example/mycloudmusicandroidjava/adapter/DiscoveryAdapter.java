package com.example.mycloudmusicandroidjava.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.mycloudmusicandroidjava.R;
import com.example.mycloudmusicandroidjava.modle.Song;
import com.example.mycloudmusicandroidjava.util.ImageUtil;

import org.jetbrains.annotations.NotNull;

/**
 * 发现页面单曲适配器
 */
public class DiscoveryAdapter extends BaseQuickAdapter<Song, BaseViewHolder> {
    public DiscoveryAdapter(int layoutResId) {
        super(layoutResId);
    }

    /**
     * 显示数据
     * @param holder
     * @param data
     */
    @Override
    protected void convert(@NotNull BaseViewHolder holder, Song data) {
//        holder.setImageResource(R.id.icon,R.drawable.splash_banner);//本地获取图片 并不是网络获取图片->需要第三方框架

        ImageUtil.show(holder.getView(R.id.icon),data.getIcon());//获取网络图片
        holder.setText(R.id.title,data.getTitle());
        holder.setText(R.id.info,String.format("%s-%s",data.getSinger().getNickname(),"专辑名称"));
    }
}
