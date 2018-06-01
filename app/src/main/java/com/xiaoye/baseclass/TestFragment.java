package com.xiaoye.baseclass;

import android.view.View;
import android.widget.ImageView;

import com.xiaoye.baseclass.base.BaseFragment;

public class TestFragment extends BaseFragment{
    private ImageView imageView;
    @Override
    public int getLayoutFile() {
        return 0;
    }

    @Override
    public void initView() {
        imageView=findViewById(R.id.all);
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {

    }
}
