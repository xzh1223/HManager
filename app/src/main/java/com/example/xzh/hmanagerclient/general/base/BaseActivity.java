package com.example.xzh.hmanagerclient.general.base;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.example.xzh.hmanagerclient.R;
import com.example.xzh.hmanagerclient.general.bean.User;

import static com.example.xzh.hmanagerclient.general.utils.Constants.ACCOUNT;
import static com.example.xzh.hmanagerclient.general.utils.Constants.ID;

/**
 * Created by xzh on 2017/10/28.
 * <p>
 * activity 基类
 */

public abstract class BaseActivity extends AppCompatActivity {

    public final String TAG = "HManager";
    public SharedPreferences prefs;
    public Context mContext;

    // 初始化布局文件
    public abstract int initLayout();

    // 初始化控件
    public abstract void initView();

    // 设置事件
    protected abstract void initEvent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        setContentView(initLayout());

        initView();
        initEvent();

    }

    /**
     * 跳转页面
     *
     * @param c 转向的页面
     */
    public void toActivity(Class<?> c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
        finish();
    }

    /**
     * 保存用户信息
     */
    public void saveUser(User user) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(ACCOUNT, user.getAccount());
        editor.putInt(ID, user.getId());
        editor.apply();
    }

    /**
     * 自定义toolbar
     */
    public void initToolBar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //隐藏默认标题
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * 设置返回按钮
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }


}
