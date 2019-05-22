package com.autoai.mylivedata.view;

/**
 * @author : YangHaoYi on  2019/5/2115:02.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on  2019/5/2115:02.
 * Version : V 1.0
 */
public interface IPoetryView {
    /**  加载Loading **/
    void showLoading();
    /**  隐藏Loading **/
    void hideLoading();
    /**  更新诗歌 **/
    void updatePoetry(String poetry);
}
