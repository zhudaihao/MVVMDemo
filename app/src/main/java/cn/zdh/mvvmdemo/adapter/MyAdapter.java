package cn.zdh.mvvmdemo.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;

import java.util.List;

import cn.zdh.mvvmdemo.R;
import cn.zdh.mvvmdemo.viewModel.ImageBean;

/**
 * dataBing绑定适配器
 */

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ImageBean> list;


    public MyAdapter(Context context, List<ImageBean> list) {
        this.context = context;
        this.list = list;

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_image, parent, false);
        View view = inflate.getRoot();

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewDataBinding binding = DataBindingUtil.getBinding(holder.itemView);

        //setVariable参数（通过BR获取对象，通过集合获取对象）
        binding.setVariable(BR.ImageBean, list.get(position));
        binding.executePendingBindings();


    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    //自定义viewHolder
    static class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }

    }


}
