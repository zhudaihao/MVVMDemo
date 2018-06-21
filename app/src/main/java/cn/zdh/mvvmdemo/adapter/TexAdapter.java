package cn.zdh.mvvmdemo.adapter;

import android.content.Context;

import com.android.databinding.library.baseAdapters.BR;

import java.util.List;

import cn.zdh.mvvmdemo.R;
import cn.zdh.mvvmdemo.base.BaseRecyclerViewAdapter;
import cn.zdh.mvvmdemo.viewModel.ImageBean;

/**
 * 封装后的适配器
 */

public class TexAdapter extends BaseRecyclerViewAdapter<ImageBean> {
    public TexAdapter(Context context, List<ImageBean> list) {
        super(context, list);
    }

    @Override
    public int getItemLayout() {
        return R.layout.item_image;
    }

    @Override
    public int getBRBean() {
        return BR.ImageBean;
    }
}
