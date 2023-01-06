package com.example.mycloudmusicandroidjava.api;

import com.example.mycloudmusicandroidjava.modle.Feed;
import com.example.mycloudmusicandroidjava.modle.Song;
import com.example.mycloudmusicandroidjava.modle.response.DetailResponse;
import com.example.mycloudmusicandroidjava.modle.response.ListResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/*默认远程数据源*/
public interface DefaultService {
    /*单曲*/
    @GET("v1/songs")
    Observable<ListResponse<Song>> songs(@Query(value = "category") String category, @Query("size") int size);

    /*动态列表*/
    @GET("v1/feeds")
    Observable<ListResponse<Feed>> feeds();


    /**
     *音乐详情
     * @param testHeader 单个传递请求头 无实际作用
     * @param id 数据id
     * @return
     */
    @GET("v1/songs/{id}")
    Observable<DetailResponse<Song>> songDetail(@Header("testHeader") String testHeader, @Path("id") String id);
}
