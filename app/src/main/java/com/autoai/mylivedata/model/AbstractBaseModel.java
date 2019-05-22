package com.autoai.mylivedata.model;

import com.autoai.mylivedata.model.api.AdvanceAPI;
import com.yanghaoyi.net.client.ApiClient;

/**
 * @author : YangHaoYi on  2019/5/2115:40.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on  2019/5/2115:40.
 * Version : V 1.0
 */
public class AbstractBaseModel {

    //请求头
    private static final String BASE_URL = "https://api.apiopen.top/";
    //请求接口
    protected AdvanceAPI api;

    public AbstractBaseModel() {
        api =  ApiClient.getInstance().setBaseUrl(BASE_URL)
                .init(AdvanceAPI.class);
    }
}
