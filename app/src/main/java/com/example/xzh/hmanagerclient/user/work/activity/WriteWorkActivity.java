package com.example.xzh.hmanagerclient.user.work.activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.xzh.hmanagerclient.R;
import com.example.xzh.hmanagerclient.general.base.BaseActivity;
import com.example.xzh.hmanagerclient.general.bean.User;
import com.example.xzh.hmanagerclient.general.controller.DBController;
import com.example.xzh.hmanagerclient.general.utils.ToastUtil;
import com.example.xzh.hmanagerclient.user.work.bean.Work;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.xzh.hmanagerclient.general.utils.Constants.ID;

/**
 * WriteWork
 */
public class WriteWorkActivity extends BaseActivity implements View.OnClickListener {
    private Button mBtnSubmit;
    private EditText mETWorkTime;
    private EditText mETWorkContent;
    private EditText mEtWorkTitle;

    @Override
    public int initLayout() {
        return R.layout.activity_work_write;
    }

    @Override
    public void initView() {
        initToolBar();

        mETWorkTime = (EditText) findViewById(R.id.work_et_time);
        mEtWorkTitle = (EditText) findViewById(R.id.work_et_title);
        mETWorkContent = (EditText) findViewById(R.id.work_et_content);
        mBtnSubmit = (Button) findViewById(R.id.btn_submit);

    }

    @Override
    protected void initEvent() {
        mBtnSubmit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:

                final Work work = checkWrite();

                new AlertDialog.Builder(this)
                        .setMessage("\t\t时间： " + work.getWorkTime() + "\n\t\t标题： " + work.getWorkTitle() + "\n\t\t内容： " + work.getWorkContent() + "\n\n是否提交？")
                        .setTitle(R.string.tip)
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 测试打印结果
                                ToastUtil.toast(mContext, "提交");
                                // 发送网络请求
                                postData(work);
                            }
                        })
                        .show();

                break;
        }
    }

    /**
     *  提交work数据
     */
    private void postData(Work work) {

        DBController.addWork(work, new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                Log.e(TAG, "onResponse: " + response.body());
                finish();
            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString() );
            }
        });

    }

    /**
     *  审核当前输入的数据，并保存到对象中
     */
    private Work checkWrite(){
        String time = mETWorkTime.getText().toString().trim();
        String title = mEtWorkTitle.getText().toString().trim();
        String content = mETWorkContent.getText().toString().trim();

        Work work = new Work();
        work.setWorkTime(time);
        work.setWorkTitle(title);
        work.setWorkContent(content);

        User user = new User();
        user.setId(prefs.getInt(ID, 0));

        work.setUser(user);
        return work;
    }


}
