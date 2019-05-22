package com.autoai.mylivedata.model.api;


import com.autoai.mylivedata.model.bean.PoetryData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author YangHaoyi on 2019/3/4.
 *         Email  : yanghaoyi@qq.com.
 *         Description :请求Api
 *         Change : YangHaoYi on 2019/3/4.
 *         Version :V 1.1
 */
public interface AdvanceAPI {

    @GET("searchAuthors")
    Observable<PoetryData> getNearbyStation(@Query("name") String name);
}
