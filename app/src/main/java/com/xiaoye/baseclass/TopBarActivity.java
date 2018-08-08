package com.xiaoye.baseclass;

import android.view.View;

import com.xiaoye.baseclass.base.BaseActivity;
import com.xiaoye.baseclass.base.TopBar;

public class TopBarActivity extends BaseActivity {
    private TopBar topBar;

    @Override
    public int getLayoutFile() {
        return R.layout.activity_topbar;
    }

    @Override
    public void initView() {
        topBar=findViewById(R.id.topbar);
        initImmersionBarForTopBar(topBar);
    }

    @Override
    public void initEvent() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {

    }
}
