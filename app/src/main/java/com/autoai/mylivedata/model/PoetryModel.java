package com.autoai.mylivedata.model;

import com.autoai.mylivedata.model.bean.PoetryData;
import com.yanghaoyi.net.client.OnGetDataListener;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author : YangHaoYi on  2019/5/2111:14.
 * Email  :  yang.haoyi@qq.com
 * Description :请求数据Model
 * Change : YangHaoYi on  2019/5/2111:14.
 * Version : V 1.0
 */
public class PoetryModel extends AbstractBaseModel{

    public void request(final OnGetDataListener<PoetryData> listener,String name){
        Observable<PoetryData> response = api.getNearbyStation(name);
        response.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<PoetryData>() {
                    @Override
                    public void onCompleted() {
                        //请求完成
                    }
                    @Override
                    public void onError(Throwable throwable) {
                        listener.fail(null,"");
                    }
                    @Override
                    public void onNext(PoetryData netData) {
                        listener.success(netData);
                    }
                });
    }

}
