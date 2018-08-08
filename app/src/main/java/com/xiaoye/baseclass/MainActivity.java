package com.xiaoye.baseclass;

import android.view.View;
import android.widget.Button;

import com.xiaoye.baseclass.base.BaseActivity;
import com.xiaoye.baseclass.base.TopBar;

public class MainActivity extends BaseActivity {
    private TopBar topBar;
    private Button button1;

    @Override
    public int getLayoutFile() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        button1 = findViewById(R.id.button1);
    }

    @Override
    public void initEvent() {
        topBar=findViewById(R.id.topbar);
        initImmersionBarForTopBar(topBar);
        button1.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                startActivity(TopBarActivity.class);
                break;
        }
    }
}
