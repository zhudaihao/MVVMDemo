package cn.zdh.mvvmdemo.viewModel;

import android.app.Activity;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import cn.zdh.mvvmdemo.BR;
import cn.zdh.mvvmdemo.view.NewActivity;

/**
 * 对象
 */

public class ImageBean extends BaseObservable {

    private String url;
    private String name;
    private Activity activity;


    public ImageBean(String url, String name,Activity activity) {
        this.url = url;
        this.name = name;
        this.activity = activity;
    }

    @Bindable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        notifyPropertyChanged(BR.url);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }


    //自定义方法使用 image名字可以自定义但是必须和布局设置图片的名字一样（就是把设置图片的src替换成这里自定义的名字）
    @BindingAdapter("image")
    public static void loadImage(ImageView imageView, String string) {
        Glide.with(imageView.getContext()).load(string).into(imageView);
    }


    public void layoutClick(View view) {
      //   Toast.makeText(view.getContext(), name, Toast.LENGTH_SHORT).show();

        if (activity != null)
            activity.startActivity(new Intent(activity, NewActivity.class).putExtra("name",name));

//        if (onClickListener != null) {
//            onClickListener.onclick();
//        }
    }

    public interface OnClickListener {
        void onclick();
    }

    public OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }


}
