package com.example.mycloudmusicandroidjava.reflect;

import android.view.LayoutInflater;

import androidx.viewbinding.ViewBinding;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
@SuppressWarnings({"all"})
/*反射工具类*/
public class ReflectUtil {
    /*创建view binding*/
    public static <VB extends ViewBinding> VB newViewBing(LayoutInflater layoutInflater,Class<?> clazz){
        try {
            //获取泛型参数对象
            ParameterizedType type;
            try {
                type = (ParameterizedType) clazz.getGenericSuperclass();
            }catch (ClassCastException e){
                type = (ParameterizedType) clazz.getSuperclass().getGenericSuperclass();
            }
            Class<VB> classVB = (Class<VB>) type.getActualTypeArguments()[0];
            Method inflateMethod = classVB.getMethod("inflate",LayoutInflater.class);

            return (VB) inflateMethod.invoke(null,layoutInflater);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
