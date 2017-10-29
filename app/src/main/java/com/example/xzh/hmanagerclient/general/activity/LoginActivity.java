package com.example.xzh.hmanagerclient.general.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xzh.hmanagerclient.R;
import com.example.xzh.hmanagerclient.general.base.BaseActivity;
import com.example.xzh.hmanagerclient.general.bean.User;
import com.example.xzh.hmanagerclient.user.activity.UserIndexActivity;

/**
 * Created by Administrator on 2017/10/28.
 *
 *  登录
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "LoginActivity";
    // 账户名
    private EditText mETAccount;
    // 密码
    private EditText mETPass;
    // 登录
    private Button mBtnLogin;

    @Override
    public int initLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        mETAccount = (EditText) findViewById(R.id.et_account_login);
        mETPass = (EditText) findViewById(R.id.et_pass_login);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
    }

    @Override
    protected void initEvent() {
        mBtnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                // 直接跳转页面
                toActivity(UserIndexActivity.class);
                // 测试阶段 暂时关闭
                /*final User user = checkAccount();
                if (user == null) {
                    // 返回空值 什么都不做
                }else {
                    DBController.login(user, new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            Log.e(TAG, "onResponse " + response.body());
                            if (response.body() != null) {
                                User newUser = response.body();
                                saveUser(newUser);
                                toActivity(UserIndexActivity.class);
                            } else {
                                Toast.makeText(LoginActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {

                        }
                    });
                }*/
                break;
        }
    }

    /**
     *  检查输入的账户和密码不为空
     */
    private User checkAccount() {

        String account = mETAccount.getText().toString().trim();
        String pass = mETPass.getText().toString().trim();
        
        if (account.length() <= 0) {
            Toast.makeText(this, "Account not null", Toast.LENGTH_SHORT).show();
        } else if (pass.length() <= 0) {
            Toast.makeText(this, "Password not null", Toast.LENGTH_SHORT).show();
        } else {
            User user = new User();
            user.setAccount(account);
            user.setPassword(pass);
            return user;
        }
        return null;
    }
}
