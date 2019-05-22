package com.autoai.mylivedata.view.impl;

import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.autoai.commonstylelibrary.view.dialog.LoadingDialog;
import com.autoai.mylivedata.view.IPoetryView;

/**
 * @author : YangHaoYi on  2019/5/2115:03.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on  2019/5/2115:03.
 * Version : V 1.0
 */
public class PoetryViewImpl implements IPoetryView {

    private TextView tvTest;
    private FragmentActivity activity;

    public PoetryViewImpl(FragmentActivity activity,TextView tvTest) {
        this.tvTest = tvTest;
        this.activity = activity;
    }

    @Override
    public void showLoading() {
        LoadingDialog.getInstance().show(activity.getSupportFragmentManager(),"Loading");
    }

    @Override
    public void hideLoading() {
        LoadingDialog.getInstance().dismiss();
    }

    /**  更新诗歌 **/
    @Override
    public void updatePoetry(String poetry) {
        tvTest.setText(poetry);
    }
}
