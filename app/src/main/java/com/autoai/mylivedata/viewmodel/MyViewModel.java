package com.autoai.mylivedata.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.autoai.mylivedata.model.PoetryModel;
import com.autoai.mylivedata.model.bean.PoetryData;
import com.yanghaoyi.net.client.OnGetDataListener;

/**
 * @author : YangHaoYi on  2019/5/2010:41.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on  2019/5/2010:41.
 * Version : V 1.0
 */
public class MyViewModel extends ViewModel {

    private MutableLiveData<PoetryData> poetryEvent = new MutableLiveData<>();

    public MutableLiveData<PoetryData> getPoetryEvent() {
        return poetryEvent;
    }

    /**  网络请求 **/
    public void requestPoetry(String name){
        new PoetryModel().request(new OnGetDataListener<PoetryData>() {
            @Override
            public void success(PoetryData response) {
                poetryEvent.setValue(response);
            }

            @Override
            public void fail(PoetryData response, String msg) {

            }
        },name);
    }
}
