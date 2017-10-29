package com.example.xzh.hmanagerclient.user.base.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.xzh.hmanagerclient.R;

/**
 * Created by Administrator on 2017/10/28.
 * <p>
 * CheckFragment 基类
 * <p>
 * Fragment 执行顺序：
 * onCreate -> onCreateView -> onActivityCreate -> onStart -> onResume
 */

public abstract class BaseFragment extends Fragment {

    public Context mContext;
    protected SharedPreferences prefs;

    protected abstract View initView();

    /**
     * 当该类被系统创建的时候被调用
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        prefs = PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    /**
     * 当活动被创建的时候被调用
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }

    /**
     * 当子类需要联网请求数据的时候，可以重写该方法
     */
    public void initData() {
    }

    public void initToolBarTitle (String title) {
        if (getView() != null) {
            TextView mTextTitle = (TextView) getView().findViewById(R.id.tv_header_title);
            mTextTitle.setText(title);
        }
    }

    /**
     * 跳转页面
     *
     * @param c 转向的页面
     */
    public void toActivity(Class<?> c) {
        Intent intent = new Intent(mContext, c);
        startActivity(intent);
    }

}
