package com.example.mycloudmusicandroidjava.modle.response;

import com.example.mycloudmusicandroidjava.modle.Meta;

/*解析列表网络请求*/
public class ListResponse<T> extends BaseResponse {
    private Meta<T> data;

    public Meta<T> getData() {
        return data;
    }

    public void setData(Meta<T> data) {
        this.data = data;
    }
}
