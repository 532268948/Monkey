package com.example.lib_common.base.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.lib_common.base.BasePresenter;
import com.example.lib_common.base.BaseView;
import com.example.lib_common.base.inter.ILifeProcessor;
import com.example.lib_common.util.ActivityManager;
import com.example.lib_common.util.MessageLooper;
import com.example.lib_common.util.MessageLooperMgr;
import com.example.lib_common.util.ToastUtil;

/**
 * project: ModuleDemo
 * author : 叶天华
 * date   : 2018/10/14
 * time   : 13:02
 * email  : 15869107730@163.com
 * note   :
 */
public abstract class BaseActivity<V, T extends BasePresenter<V>> extends AppCompatActivity implements View.OnClickListener, ILifeProcessor, BaseView {

    public T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
        initUIParams();
        initIntent(getIntent());
        initSaveInstanceState(savedInstanceState);
        if (generateIdLayout() > 0) {
            setContentView(generateIdLayout());
        } else if (generateViewLayout() != null) {
            setContentView(generateViewLayout());
        }
        mPresenter = createPresenter();
        mPresenter.attachView((V) this, this);
        initView();
        initListener();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onUnregisterMessageReceiver();
        releaseCache();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        ActivityManager.getInstance().removeActivity(this);
    }

    protected abstract T createPresenter();

    @Override
    public void showError(String message) {
        ToastUtil.showShortToastMessage(message);
    }

    @Override
    public void initUIParams() {

    }

    @Override
    public void initIntent(Intent intent) {

    }

    @Override
    public void initSaveInstanceState(Bundle savedInstanceState) {

    }


    @Override
    public View generateViewLayout() {
        return null;
    }


    @Override
    public void releaseCache() {

    }

    @Override
    public void showDialog(String message) {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showNormal() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showError(String message, String code) {

    }

    @Override
    public void onRegisterMessageReceiver() {

    }

    @Override
    public void onUnregisterMessageReceiver() {
        MessageLooperMgr.onUnregisterMessageReceiver(this);
    }

    /**
     * 注册监听器用此方法
     * @param cmd
     * @param l
     */
    public final void registerMessageReceiver(String cmd, MessageLooper.OnMessageListener l) {
        MessageLooperMgr.registerMessageReceiver(this, cmd, l);
    }

}
