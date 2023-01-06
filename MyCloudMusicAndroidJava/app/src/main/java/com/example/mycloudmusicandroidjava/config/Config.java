package com.example.mycloudmusicandroidjava.config;

import com.example.mycloudmusicandroidjava.BuildConfig;

//配置文件
public class Config {
    /*是否是调试模式*/
    public static final boolean DEBUG = BuildConfig.DEBUG;
    public static final long SPLASH_DEFAULT_DELAY_TIME = 1000;
    //端点
    public static String ENDPOINT = "http://cloud-music-lite-sp.ixuea.com/";
    /*端点
     * 真机访问电脑*/
//    public static String ENDPOINT = "http:// 192.168.1.7";

    /*端点
     * 自带模拟器访问电脑*/
//    public static String ENDPOINT = "http://10.0.2.2:8080/";

    /*资源端点
     * 第三方阿里云oss层*/
    public static String RESOURCE_ENDPOINT = "http://course-music-dev.ixuea.com/%s";

    /*网络缓存目录大小*/
    public static final long NETWORK_CACHE_SIZE = 1024 * 1024 * 100;//100兆
}
