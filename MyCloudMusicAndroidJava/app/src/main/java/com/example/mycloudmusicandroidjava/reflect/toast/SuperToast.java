package com.example.mycloudmusicandroidjava.reflect.toast;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.StringRes;

/*超级Toast*/
public class SuperToast {
    private static Context context;

    public static void init(Context context){
        SuperToast.context = context;
    }

    /**
     * 显示文本提示
     * @param content
     */

    public static void show(String content){
        show(content, Toast.LENGTH_SHORT);
    }

    /**
     * 显示资源提示
     * @param content
     */
    public static void show(@StringRes int content){
        show(context.getString(content), Toast.LENGTH_SHORT);
    }


    public static void show(String content, int duration) {
        Toast.makeText(context, content, duration).show();
    }
}
