package com.autoai.mylivedata.view.activity;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.autoai.mylivedata.R;
import com.autoai.mylivedata.databinding.ActivityMainBinding;
import com.autoai.mylivedata.view.IPoetryView;
import com.autoai.mylivedata.view.impl.PoetryViewImpl;
import com.autoai.mylivedata.viewmodel.MyViewModel;
import com.autoai.mylivedata.model.bean.PoetryData;

/**
 * @author : YangHaoYi on  2019/5/2010:41.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on  2019/5/2010:41.
 * Version : V 1.0
 */
public class MainActivity extends FragmentActivity {

    /**  ViewModel **/
    private MyViewModel viewModel;
    /**  诗歌详情 **/
    private TextView tvPoetryDetail;
    /**  测试请求按钮 **/
    private TextView tvPoetryRequest;
    /**  输入框 **/
    private TextView edInput;
    /**  实现view **/
    private IPoetryView poetryView;
    /**  数据绑定 **/
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        init();
    }

    /**  初始化 **/
    private void init(){
        initView();
        initData();
        initEvent();
    }

    /**  初始化视图 **/
    private void initView(){
        tvPoetryDetail = findViewById(R.id.tvPoetryDetail);
        tvPoetryRequest = findViewById(R.id.tvPoetryRequest);
        edInput = findViewById(R.id.edInput);
        poetryView = new PoetryViewImpl(this,tvPoetryDetail);
    }

    /**  初始化数据 **/
    private void initData(){
        viewModel = new ViewModelProvider(
                this, new ViewModelProvider.AndroidViewModelFactory(getApplication())
        ).get(MyViewModel.class);
        //添加数据绑定
        viewModel.getPoetryEvent().observe(this, new Observer<PoetryData>() {
            @Override
            public void onChanged(@Nullable PoetryData data) {
                poetryView.hideLoading();
                binding.setPoetryData(data);
            }
        });
    }

    /**  初始化事件 **/
    private void initEvent(){
        tvPoetryRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poetryView.showLoading();
                poetryView.updatePoetry(getResources().getString(R.string.poetry_detail));
                viewModel.requestPoetry(edInput.getText().toString());
            }
        });
    }

}
