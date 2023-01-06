package com.example.mycloudmusicandroidjava.modle;
/*解析歌单列表*/
public class SongWrapper {
    /*状态码
    * 等于0表示成功*/
    private int status;

    private Meta data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Meta getData() {
        return data;
    }

    public void setData(Meta data) {
        this.data = data;
    }
}
