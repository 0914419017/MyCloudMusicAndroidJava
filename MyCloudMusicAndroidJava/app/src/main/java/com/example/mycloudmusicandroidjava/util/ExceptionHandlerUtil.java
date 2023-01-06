package com.example.mycloudmusicandroidjava.util;

import android.text.TextUtils;

import com.example.mycloudmusicandroidjava.AppContext;
import com.example.mycloudmusicandroidjava.R;
import com.example.mycloudmusicandroidjava.modle.response.BaseResponse;
import com.example.mycloudmusicandroidjava.reflect.toast.SuperToast;

import org.apache.commons.lang3.StringUtils;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.HttpException;
import retrofit2.Response;

/**
 * 错误处理辅助类
 */
public class ExceptionHandlerUtil {
    /**
     * 网络请求错误处理
     *
     * @param data
     * @param error
     * @param <T>
     */
    public static <T> void handlerRequest(T data, Throwable error) {
        if (error != null) {
            //有异常的请求
            handleException(error);
        } else {
            if (data instanceof Response) {
                Response response = (Response) data;

                //获取响应码
                int code = response.code();
                //判断响应码
                if (code >= 200 && code <= 299) {
                    //网络请求正常
                } else {
                    handleHttpError(code);
                }
            } else {
                BaseResponse response = (BaseResponse) data;
                if (TextUtils.isEmpty(response.getMessage())) {
                    //没有错误提示信息
                    SuperToast.show(R.string.error_unknown);
                } else {
                    SuperToast.show(response.getMessage());
                }
            }
        }
    }

    //处理异常
    public static void handleException(Throwable error) {
        if (error instanceof UnknownHostException) {
            SuperToast.show(R.string.error_network_unknown_host);
        } else if (error instanceof ConnectException) {
            SuperToast.show(R.string.network_error);
        } else if (error instanceof SocketTimeoutException) {
            SuperToast.show(R.string.error_network_timeout);
        } else if (error instanceof HttpException) {
            HttpException exception = (HttpException) error;

            //获取响应码
            int code = exception.code();
            handleHttpError(code);
        } else if (error instanceof IllegalArgumentException) {
            //本地参数错误
            SuperToast.show(R.string.error_parameter);
        } else {
            String message = error.getLocalizedMessage();
            if (StringUtils.isNotBlank(message)) {
                message = AppContext.getInstance().getString(R.string.error_unknown_format, message);
            } else {
                message = AppContext.getInstance().getString(R.string.error_unknown);
            }
            SuperToast.show(message);
        }
    }

    /**
     * 处理Http错误
     *
     * @param code
     */
    private static void handleHttpError(int code) {
        if (code == 401) {
            SuperToast.show(R.string.error_network_not_auto);
            AppContext.getInstance().logout();
        } else if (code == 403) {
            SuperToast.show(R.string.error_network_not_permission);
        } else if (code == 404) {
            SuperToast.show(R.string.error_network_not_found);
        } else if (code >= 500) {
            SuperToast.show(R.string.error_network_server);
        } else {
            SuperToast.show(R.string.error_unknown);
        }
    }
}
