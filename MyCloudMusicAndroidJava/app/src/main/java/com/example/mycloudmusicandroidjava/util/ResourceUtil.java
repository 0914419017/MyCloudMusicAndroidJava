package com.example.mycloudmusicandroidjava.util;

import com.example.mycloudmusicandroidjava.config.Config;

/**
 * 资源工具类
 */
public class ResourceUtil {
    public static String resourceUri(String data) {
        /*资源端点
         * 第三方阿里云oss层*/
        return String.format(Config.RESOURCE_ENDPOINT, data);

    }
}
