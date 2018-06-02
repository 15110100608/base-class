package com.xiaoye.baseclass.base;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xiaoye.baseclass.utils.DensityUtil;

import java.util.List;

/**
 * 文件名：BaseAdapter
 * 描  述：Adapter基类
 * 作  者：小烨
 * 时  间：2018.6.1
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter {
    public Context context;
    public LayoutInflater layoutInflater;
    public List<T> list;

    /*
     * 传入上下文
     * 动态加载布局
     */
    public BaseAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    /*
     * 设置数据
     */
    public void setList(List<T> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    /*
     * 追加设置数据
     */
    public void appendList(List<T> newList){
        list.addAll(newList);
        notifyItemRangeChanged(list.size()-1,newList.size()+1,"add"+list.size());
    }

    @NonNull
    @Override
    abstract public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    /*
     * 获取数据个数
     */
    @Override
    public int getItemCount() {
        if (list == null)
            return 0;
        return list.size();
    }

    /*
     * 获取item的位置
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /*
     * 获取item的位置
     */
    @Override
    public int getItemViewType(int position) {
        return position;
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
}
