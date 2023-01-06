package com.example.mycloudmusicandroidjava.modle.response;
/*详情网络请求分析类*/
public class DetailResponse<T> extends BaseResponse {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
