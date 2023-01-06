package com.example.mycloudmusicandroidjava.util;

import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mycloudmusicandroidjava.R;

@SuppressWarnings({"all"})
/**
 * 图片相关工具类 将网络图片通过第三方框架实现可视化
 */
public class ImageUtil {
    /**
     * 显示图片相对路径
     *
     * @param view
     * @param data
     */
    public static void show(ImageView view, String data) {
        if (TextUtils.isEmpty(data)) {
            //没有图片 显示本地默认图片
            view.setImageResource(R.drawable.placeholder_error);
            return;
        }
        //加载本地图片
//        if (data.contains("/files/Music")){
//            showLocalImage(view,data);
//            return;
//        }

        //将图片转化为绝对地址
        data = ResourceUtil.resourceUri(data);

        showFull(view, data);
    }

//    private static void showLocalImage(ImageView view, String data) {
//
//    }

    /**
     * 显示绝对路径的图片
     *
     * @param view
     * @param data
     */
    public static void showFull(ImageView view, String data) {
        //获取功能配置
        RequestOptions options = getCommonRequestOptions();

        Glide.with(view.getContext())
                .load(data)
                .apply(options)
                .into(view);
    }

    private static RequestOptions getCommonRequestOptions() {
        //创建配置选项
        RequestOptions options = new RequestOptions();
        //占位图
        options.placeholder(R.drawable.placeholder_error);
        return options;

    }
}
