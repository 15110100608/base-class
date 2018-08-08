package com.xiaoye.baseclass.base;

/**
 * Created by 小烨 on 2018/8/8.
 */

public interface BaseListener<T>{
    void onResponse(T t);
    void onFail(String msg);
}
