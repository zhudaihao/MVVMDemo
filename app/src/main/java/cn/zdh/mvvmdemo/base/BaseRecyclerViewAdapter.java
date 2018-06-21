package cn.zdh.mvvmdemo.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 封装适配器
 */

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<T> list;

    public BaseRecyclerViewAdapter(Context context, List<T> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(List<T> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(context), getItemLayout(), parent, false);
        View view = inflate.getRoot();
        return new MyViewHolder(view);
    }


    public abstract int getItemLayout();

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ViewDataBinding binding = DataBindingUtil.getBinding(holder.itemView);
        //setVariable参数（通过BR获取对象，通过集合获取对象）
        binding.setVariable(getBRBean(), list.get(position));
        binding.executePendingBindings();
    }

    public abstract int getBRBean();


    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
