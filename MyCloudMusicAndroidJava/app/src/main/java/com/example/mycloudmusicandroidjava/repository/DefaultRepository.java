package com.example.mycloudmusicandroidjava.repository;

import com.example.mycloudmusicandroidjava.api.DefaultService;
import com.example.mycloudmusicandroidjava.api.NetworkModule;
import com.example.mycloudmusicandroidjava.modle.Song;
import com.example.mycloudmusicandroidjava.modle.response.ListResponse;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * 本项目默认仓库
 * 主意是从网络 数据库获取数据
 * 如果每个模板之间有明显的区别 就使用对应的模板
 */
public class DefaultRepository {
    private static DefaultRepository instance;
    private final DefaultService service;

    private DefaultRepository(){
        OkHttpClient okHttpClient = NetworkModule.providerOkHttpClient();
        Retrofit retrofit = NetworkModule.provideRetrofit(okHttpClient);
        service = retrofit.create(DefaultService.class);
    }

    public synchronized static DefaultRepository getInstance() {//单例模式 synchronized在同一瞬间可能调用多次
        if (instance == null){
            instance = new DefaultRepository();
        }
        return instance;
    }

    /**
     * 单曲
     * @return
     */
    public Observable<ListResponse<Song>> songs(){
        return service.songs("1",10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
