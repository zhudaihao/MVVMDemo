package cn.zdh.mvvmdemo.model;

import cn.zdh.mvvmdemo.viewModel.UserBean;

/**
 * 获取数据（网络 或者 本地）
 */

public class UserModel {

    boolean isSuccess = true;

    public void getUser(OnCallBack onCallBack) {
        //这里可以做网络请求后数据处理

        if (isSuccess) {
            onCallBack.onSuccess(new UserBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529059576774&di=f124b00ca01a0f672dc6ffb3bcf442c8&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F4afbfbedab64034f8c730299a3c379310b551df7.jpg", "张三", "123456"));
        } else {
            onCallBack.onFail("失败");

        }



    }


    public interface OnCallBack {

        void onSuccess(UserBean userBean);

        void onFail(String error);

    }
}
