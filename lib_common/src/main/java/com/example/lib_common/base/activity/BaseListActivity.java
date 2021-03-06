package com.example.lib_common.base.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsListView;

import com.example.lib_common.base.BaseItem;
import com.example.lib_common.base.BasePresenter;
import com.example.lib_common.base.BaseView;
import com.example.lib_common.base.States;
import com.example.lib_common.util.ViewUtil;

import java.util.List;

/**
 * project: Monkey
 * author : 叶天华
 * date   : 2018/11/17
 * time   : 13:09
 * email  : 15869107730@163.com
 * note   : 封装有RecyclerView的BaseActivity
 */
public abstract class BaseListActivity<V extends BaseView, T extends BasePresenter<V>> extends BaseActivity implements AbsListView.OnScrollListener {

    protected RecyclerView mRecyclerView;
    protected List<BaseItem> mItems;
    protected View mEmpty;
    protected View mProgress;
    protected SwipeRefreshLayout mRefreshLayout;

    private int mState;

    public void setEmptyViewVisible(boolean visible, boolean netWorkException, String text) {
        ViewUtil.setEmptyViewVisible(mEmpty, this, visible, netWorkException, text);
    }

    @Override
    public void onScroll(AbsListView absListView, int i, int i1, int i2) {
        if (mState == States.RECYCLER_GET_MORE && (i + i1) == i2) {
            List<BaseItem> items = mItems;
            if (items != null && items.size() > 0) {
                BaseItem baseItem = items.get(items.size() - 1);
                if (baseItem != null && baseItem.itemType == States.LOAD_MORE) {
                    onLoadMore();
                }
            }
        }
    }

    protected void onLoadMore() {

    }

    private void setState(int state) {
        this.mState = state;
    }
}
