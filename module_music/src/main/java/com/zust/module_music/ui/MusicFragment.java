package com.zust.module_music.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lib_common.base.fragment.BaseTopTabFragment;
import com.zust.module_music.ui.story.MusicStoryFragment;
import com.zust.module_music.view.FloatingMusicView;
import com.example.lib_common.base.view.TitleBar;
import com.example.lib_common.test.BlankFragment;
import com.example.lib_common.util.ViewUtil;
import com.zust.module_music.R;
import com.zust.module_music.contract.MusicContract;
import com.zust.module_music.presenter.MusicPresenter;
import com.zust.module_music.ui.before.MusicBeforeFragment;

import java.util.ArrayList;

/**
 * @author 53226
 */
public class MusicFragment extends BaseTopTabFragment<MusicContract.View, MusicPresenter<MusicContract.View>> implements MusicContract.View {

    private TitleBar mTitleBar;
    private FloatingMusicView mFloatingMusicView;

    @Override
    protected MusicPresenter<MusicContract.View> createPresenter() {
        return new MusicPresenter<>();
    }

    @Override
    public View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        mViewPager = view.findViewById(R.id.view_pager);
        mTitleBar = view.findViewById(R.id.title_bar);
        mTabLayout = view.findViewById(R.id.tab_layout);
        mFloatingMusicView = view.findViewById(R.id.floating_music_view);
        addFragmentAndTitle();
        return view;
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void addFragmentAndTitle() {
        if (fragmentList == null) {
            fragmentList = new ArrayList<>();
        }
        fragmentList.add(new MusicBeforeFragment());
        fragmentList.add(new BlankFragment());
        fragmentList.add(new MusicStoryFragment());
        if (titleList == null) {
            titleList = new ArrayList<>();
        }
        titleList.add(mContext.getResources().getString(R.string.music_tab_1));
        titleList.add(mContext.getResources().getString(R.string.music_tab_2));
        titleList.add(mContext.getResources().getString(R.string.music_tab_3));
        if (mAdapter == null) {
            mAdapter = new TopTabFragmentPagerAdapter(getChildFragmentManager());
        }
        mAdapter.setData(fragmentList, titleList);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void showBigMusicView() {
        ViewUtil.setViewVisible(mFloatingMusicView);
    }

    @Override
    public void changeSmallMusicView() {

    }

    @Override
    public void changeBigMusicView() {

    }

    @Override
    public void hideMusicView() {

    }


}