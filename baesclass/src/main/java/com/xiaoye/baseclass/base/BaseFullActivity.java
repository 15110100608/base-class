package com.xiaoye.baseclass.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.xiaoye.baseclass.utils.DensityUtil;

/**
 * 文件名：BaseActivity
 * 描  述：Activity基类-全屏
 * 作  者：小烨
 * 时  间：2018.6.1
 */
public abstract class BaseFullActivity extends AppCompatActivity implements View.OnClickListener{
    public Intent intent;

    /*
    * 加载布局
    */
    abstract public @LayoutRes int getLayoutFile();

    /*
     * 初始化控件(findViewById)
     */
    abstract public void initView();

    /*
     * 初始化事件(setEvent)
     */
    abstract public void initEvent();

    /*
     * 初始化事件(setEvent)
     */
    abstract public void initData();

    /*
     * 得到intent对象
     */
    public void initOnter(){
        intent=getIntent();
    }

    /*
     * 创建Activity和初始化
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutFile());
        Window window = getWindow();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        window.setFlags(flag, flag);
        initView();
        initEvent();
        initData();
        initOnter();
    }

    /*
     * 短时间Toast的简化
     */
    public void showToastShort(String text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

    /*
     * 长时间Toast的简化
     */
    public void showToastLong(String text){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public int dip2px(float dpValue){
        return DensityUtil.dip2px(this,dpValue);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public int px2dip(float pxValue) {
        return DensityUtil.px2dip(this,pxValue);
    }
}
