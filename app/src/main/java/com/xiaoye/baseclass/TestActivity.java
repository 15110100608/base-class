package com.xiaoye.baseclass;

import android.view.View;

import com.xiaoye.baseclass.base.BaseActivity;
import com.xiaoye.baseclass.utils.LoadDialog;

public class TestActivity extends BaseActivity {
    @Override
    public int getLayoutFile() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        loadDialog.show();
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
