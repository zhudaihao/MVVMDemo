package cn.zdh.mvvmdemo.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.zdh.mvvmdemo.R;
import cn.zdh.mvvmdemo.adapter.TexAdapter;
import cn.zdh.mvvmdemo.databinding.ActivityMainBinding;
import cn.zdh.mvvmdemo.model.UserModel;
import cn.zdh.mvvmdemo.viewModel.ImageBean;
import cn.zdh.mvvmdemo.viewModel.UserBean;

public class MainActivity extends AppCompatActivity {

    private UserModel userModel;
    private ActivityMainBinding activityMainBinding;
    private List<ImageBean> list = new ArrayList<>();
    private TexAdapter texAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        //初始化组件
        initView();

        //获取数据
        initData();


    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        texAdapter = new TexAdapter(this, list);
        recyclerView.setAdapter(texAdapter);



    }

    private void initData() {
        userModel = new UserModel();


        userModel.getUser(new UserModel.OnCallBack() {
            @Override
            public void onSuccess(UserBean userBean) {
                //设置绑定数据
                activityMainBinding.setUserBean(userBean);

                //获取数据
                list.add(new ImageBean("http://g.hiphotos.baidu.com/image/pic/item/6f061d950a7b020855d6e2656ed9f2d3572cc813.jpg", "张三",MainActivity.this));
                list.add(new ImageBean("http://e.hiphotos.baidu.com/image/pic/item/2cf5e0fe9925bc310031061b52df8db1ca1370c0.jpg", "刘局",MainActivity.this));
                list.add(new ImageBean("http://e.hiphotos.baidu.com/image/pic/item/4afbfbedab64034f8c730299a3c379310b551df7.jpg", "张三",MainActivity.this));

                list.add(new ImageBean("http://g.hiphotos.baidu.com/image/pic/item/6f061d950a7b020855d6e2656ed9f2d3572cc813.jpg", "张三",MainActivity.this));
                list.add(new ImageBean("http://e.hiphotos.baidu.com/image/pic/item/2cf5e0fe9925bc310031061b52df8db1ca1370c0.jpg", "刘局",MainActivity.this));
                list.add(new ImageBean("http://e.hiphotos.baidu.com/image/pic/item/4afbfbedab64034f8c730299a3c379310b551df7.jpg", "张三",MainActivity.this));

                list.add(new ImageBean("http://g.hiphotos.baidu.com/image/pic/item/6f061d950a7b020855d6e2656ed9f2d3572cc813.jpg", "张三",MainActivity.this));
                list.add(new ImageBean("http://e.hiphotos.baidu.com/image/pic/item/2cf5e0fe9925bc310031061b52df8db1ca1370c0.jpg", "刘局",MainActivity.this));
                list.add(new ImageBean("http://e.hiphotos.baidu.com/image/pic/item/4afbfbedab64034f8c730299a3c379310b551df7.jpg", "张三",MainActivity.this));

                texAdapter.setList(list);

                //监听回调
                userBean.setOnClickListener(new UserBean.OnClickListener() {
                    @Override
                    public void onclick() {
                        new UserBean("https://p0.ssl.qhimg.com/t01695e6244dd7032c9.jpg", "张四**************", "123456**************");


                    }
                });

            }

            @Override
            public void onFail(String error) {
                Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
            }
        });
    }


}
