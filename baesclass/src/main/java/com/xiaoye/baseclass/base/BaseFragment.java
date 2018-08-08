package com.xiaoye.baseclass.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by 小烨 on 2018/8/8.
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
     * Toast的简化
     */
    public void showToast(String text){
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
    }

    /**
     * 简化view.findViewById
     */
    public <T extends View> T findViewById(@IdRes int id) {
        return view.findViewById(id);
    }
}
