package com.example.mycloudmusicandroidjava.api;


import com.example.mycloudmusicandroidjava.modle.response.BaseResponse;
import com.example.mycloudmusicandroidjava.util.ExceptionHandlerUtil;

import io.reactivex.rxjava3.annotations.NonNull;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * 网络请求Observer
 * @param <T>
 */
public abstract class HttpObserver<T> extends ObserverAdapter<T>{

    /**
     * 请求成功
     * @param data
     */
    public abstract void onSucceeded(T data);

    /**
     * 请求失败
     * @param data
     * @param e
     * @return 自己处理  false：框架处理
     */
    public boolean onFailed(T data,Throwable e){
        return false;
    }

    @Override
    public void onNext(@NonNull T t) {
        super.onNext(t);
        if (isSucceeded(t)) {
            //请求正常
            onSucceeded(t);
        }else {
            //请求出错
            handleRequest(t,null);
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {
        super.onError(e);
        handleRequest(null,e);
    }

    /**
     * 处理网络错误请求
     * @param data
     * @param error
     */
    private void handleRequest(T data, Throwable error) {
        if (onFailed(data,error)){
            /*失败的方法*/

        }else {
            ExceptionHandlerUtil.handlerRequest(data,error);
        }
    }

    /**
     * 网路请求是否成功
     * @param t
     * @return
     */
    private boolean isSucceeded(T t){
        if (t instanceof Retrofit) {
            //获取响应对象
            Response response = (Response) t;
            //判断响应码
            if (response.code() >= 200 && response.code() <= 299){
                //网路请求正常
                return true;
            }

        }else if (t instanceof BaseResponse){
            BaseResponse response = (BaseResponse) t;

            return response.isSucceeded();
        }
        return false;
    }
}
