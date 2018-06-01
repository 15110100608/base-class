package com.xiaoye.baseclass.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xiaoye.baseclass.utils.DensityUtil;

/**
 * Created by 小烨 on 2017/11/8.
 */

public abstract class BaseFragment extends Fragment implements View.OnClickListener{
    public View view=null;
    public Context context;

    public abstract @LayoutRes int getLayoutFile();

    abstract public void initView();
    abstract public void initEvent();
    abstract public void initData();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutFile(), container, false);
        context = getActivity();
        initView();
        initEvent();
        initData();
        return view;
    }

    /*
     * 短时间Toast的简化
     */
    public void showToastShort(String text){
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
    }

    /*
     * 长时间Toast的简化
     */
    public void showToastLong(String text){
        Toast.makeText(context,text,Toast.LENGTH_LONG).show();
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public float dip2px(float dpValue){
        return DensityUtil.dip2px(context,dpValue);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public float px2dip(float pxValue) {
        return DensityUtil.px2dip(context,pxValue);
    }

    /**
     * 简化view.findViewById
     */
    public <T extends View> T findViewById(@IdRes int id) {
        return view.findViewById(id);
    }
}
