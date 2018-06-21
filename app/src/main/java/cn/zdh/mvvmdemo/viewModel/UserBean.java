package cn.zdh.mvvmdemo.viewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import cn.zdh.mvvmdemo.BR;

/**
 * VM对象 实现数据和View绑定
 * get方法需要@Bindable 注解
 */

public class UserBean extends BaseObservable {
    private String image;
    private String name;
    private String pw;
    private String login;

    public UserBean() {

    }

    public UserBean(String image, String name, String pw) {
        this.image = image;
        this.name = name;
        this.pw = pw;
    }


    @Bindable
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
        notifyPropertyChanged(BR.login);
    }

    @Bindable
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
        notifyPropertyChanged(BR.image);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getPw() {
        return pw;

    }

    public void setPw(String pw) {
        this.pw = pw;
        notifyPropertyChanged(BR.pw);
    }

    //自定义方法使用 image名字可以自定义但是必须和布局设置图片的名字一样（就是把设置图片的src替换成这里自定义的名字）
    @BindingAdapter("image")
    public static void loadImage(ImageView imageView, String image) {
        Glide.with(imageView.getContext()).load(image).into(imageView);
    }


    public void loginClick(View view) {
        if (TextUtils.isEmpty(getLogin())) {
            Toast.makeText(view.getContext(), "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        if (getLogin().equals("123")) {
            Toast.makeText(view.getContext(), "密码正确", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(view.getContext(), "密码错误", Toast.LENGTH_SHORT).show();
        }


    }


    //监听参数必须为Editable
    public void change(Editable view) {
        final String text = view.toString();
        Log.e("agt", "----------------->测试" + text);
    }


    public void layoutClick(View view) {
        Toast.makeText(view.getContext(), "测试", Toast.LENGTH_SHORT).show();

        if (onClickListener != null) {
            onClickListener.onclick();
        }
    }


    public interface OnClickListener {
        void onclick();
    }

    public OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }



}
