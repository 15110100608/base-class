package com.xiaoye.baseclass.base;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 文件名：BaseAdapter
 * 描  述：Adapter基类
 * 作  者：小烨
 * 时  间：2018.6.1
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter {
    public Context context;
    private LayoutInflater layoutInflater;
    private List<T> list;

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
}
