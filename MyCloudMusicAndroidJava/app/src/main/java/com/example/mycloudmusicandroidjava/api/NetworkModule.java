package com.example.mycloudmusicandroidjava.api;

import com.chuckerteam.chucker.api.ChuckerInterceptor;
import com.example.mycloudmusicandroidjava.AppContext;
import com.example.mycloudmusicandroidjava.config.Config;
import com.example.mycloudmusicandroidjava.util.JSONUtil;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressWarnings({"all"})
/*网络相关依赖提供类*/
public class NetworkModule {
    public static OkHttpClient providerOkHttpClient() {
        //初始化okhttp
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //配置缓存
        Cache cache = new Cache(AppContext.getInstance().getCacheDir(), Config.NETWORK_CACHE_SIZE);
        builder.cache(cache);

        builder.connectTimeout(10, TimeUnit.SECONDS)//链接超时时间10秒
                .writeTimeout(10, TimeUnit.SECONDS)//将数据发送到服务端超时时间
                .readTimeout(10, TimeUnit.SECONDS);//将数据下载到本地的超时时间

        if (Config.DEBUG) {
            //调试模式
            //创建okhttp日志拦截器
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            //设置日志等级
            loggingInterceptor.level(HttpLoggingInterceptor.Level.BASIC);
            //添加到网络框架中
            builder.addInterceptor(loggingInterceptor);

            //添加chucker实现应用内显示网络请求信息拦截器
            builder.addInterceptor(new ChuckerInterceptor.Builder(AppContext.getInstance()).build());
        }
        //创建出来
        return builder.build();
    }

    /*提供Retrofit实例*/
    public static Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                //让retrofit使用okhttp
                .client(okHttpClient)
                //api地址
                .baseUrl(Config.ENDPOINT)
                //适配rxjava
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                //使用gson解析json
                //包括请求参数和响应
                .addConverterFactory(GsonConverterFactory.create(JSONUtil.createGson()))
                //创建retrofit
                .build();
    }
}
