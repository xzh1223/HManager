package com.example.xzh.hmanagerclient.general.activity;

import com.example.xzh.hmanagerclient.R;
import com.example.xzh.hmanagerclient.general.base.BaseActivity;

/**
 * Created by Administrator on 2017/10/28.
 */

public class WelcomeActivity extends BaseActivity {
    @Override
    public int initLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initView() {

    }

    @Override
    protected void initEvent() {
        toActivity(LoginActivity.class);
    }
}
