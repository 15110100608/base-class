package com.xiaoye.baseclass.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;

/**
 * 文件名：BaseActivity
 * 描  述：Activity基类-普通
 * 作  者：小烨
 * 时  间：2018.8.7
 */

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{
    public Intent intent;
    public ImmersionBar immersionBar;

    /**
     * 加载布局
     */
    abstract public @LayoutRes
    int getLayoutFile();

    /**
     * 初始化控件(findViewById)
     */
    abstract public void initView();

    /**
     * 初始化事件(setEvent)
     */
    abstract public void initEvent();

    /**
     * 初始化事件(setEvent)
     */
    abstract public void initData();

    /**
     * 得到intent对象
     */
    public void initOnter(){
        intent=getIntent();
    }

    /**
     * 创建Activity和初始化
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutFile());
        initView();
        initEvent();
        initData();
        initOnter();
    }

    public Context getContext() {
        return this;
    }

    /**
     * 显示Toast
     */
    public void showToast(String text){
        Toast.makeText(this,text, Toast.LENGTH_SHORT).show();
    }

    /**
     * 开始新的Activity
     */
    public void startActivity(Class<?> cls){
        startActivity(new Intent(this,cls));
    }

    /**
     * 初始化状态栏
     */
    private void initImmersionBar() {
        if (immersionBar == null) {
            immersionBar = ImmersionBar.with(this);
            immersionBar
                    .keyboardEnable(true)
                    .navigationBarWithKitkatEnable(false)
                    .init();
        }
    }

    /**
     * 初始化状态栏:图片状态栏
     * 使用“延伸TopBar”方案
     */
    protected void initImmersionBarForTopBar(View topBar) {
        initImmersionBarForTopBar(topBar, true);
    }

    /**
     * 初始化状态栏:图片状态栏
     * 使用“延伸TopBar”方案
     */
    protected void initImmersionBarForTopBar(View topBar, boolean isStatusBarDarkFont) {
        initImmersionBar();
        float statusAlpha = isStatusBarDarkFont?0.2f:0;
        immersionBar
                .titleBar(topBar)
                .statusBarDarkFont(isStatusBarDarkFont, statusAlpha)
                .init();
    }

    /**
     * 初始化状态栏:纯色状态栏
     * 使用“改变状态栏颜色”方案
     */
    protected void initImmersionBarOfColorBar(@ColorRes int statusBarColor, boolean isStatusBarDarkFont) {
        initImmersionBar();
        immersionBar
                .fitsSystemWindows(true)
                .statusBarColor(statusBarColor)
                .statusBarDarkFont(isStatusBarDarkFont, 0.2f)
                .init();
    }

    /**
     * 初始化状态栏:全屏图片
     * 使用“透明StatusBar”方案
     */
    protected void initImmersionBarOfFullImage() {
        initImmersionBar();
        immersionBar.transparentStatusBar().init();
    }

    /**
     * 初始化状态栏:全屏图片
     * 不显示状态栏
     */
    protected void initImmersionBarOfFullImageWithOutStatusBar() {
        initImmersionBar();
        immersionBar.hideBar(BarHide.FLAG_HIDE_STATUS_BAR).init();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (immersionBar != null) {
            immersionBar.destroy();
        }
    }

}
