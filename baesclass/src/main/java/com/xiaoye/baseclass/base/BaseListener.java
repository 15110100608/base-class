package com.xiaoye.baseclass.base;

/**
 * Created by 小烨 on 2017/11/6.
 */

public interface BaseListener<T>{
    void onResponse(T t);
    void onFail(String msg);
}
