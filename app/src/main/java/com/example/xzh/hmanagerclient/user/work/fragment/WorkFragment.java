package com.example.xzh.hmanagerclient.user.work.fragment;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.xzh.hmanagerclient.R;
import com.example.xzh.hmanagerclient.general.controller.DBController;
import com.example.xzh.hmanagerclient.user.base.fragment.BaseFragment;
import com.example.xzh.hmanagerclient.user.work.activity.WriteWorkActivity;
import com.example.xzh.hmanagerclient.user.work.adapter.WorkAdapter;
import com.example.xzh.hmanagerclient.user.work.bean.Work;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;
import static com.example.xzh.hmanagerclient.general.utils.Constants.ID;

/**
 * Created by Administrator on 2017/10/28.
 * <p>
 * Work Fragment
 */

public class WorkFragment extends BaseFragment implements View.OnClickListener {

    private RecyclerView mRVWorkList;
    private List<Work> workList = new ArrayList<>();
    private ImageButton mIBWriteWork;

    @Override
    protected View initView() {
        // 加载布局文件
        View view = View.inflate(mContext, R.layout.fragment_work, null);
        // 设置标题文字
        TextView mTextTitle = (TextView) view.findViewById(R.id.tv_header_title);
        mTextTitle.setText(getString(R.string.nav_work));

        mIBWriteWork = (ImageButton) view.findViewById(R.id.ib_add);
        // 加载图片
        Glide.with(mContext).load(R.mipmap.ic_launcher).into(mIBWriteWork);
        // 初始化RecyclerView
        mRVWorkList = (RecyclerView) view.findViewById(R.id.rv_work);

        setListener();
        return view;
    }

    /**
     * 设置监听器和事件
     */
    private void setListener() {
        mIBWriteWork.setOnClickListener(this);
    }

    @Override
    public void initData() {
        super.initData();
        // 读取保存的用户ID
        int userId = prefs.getInt(ID, 0);
        // 发送网络请求获取数据
        DBController.findWorksByUserId(userId, new Callback<List<Work>>() {
            @Override
            public void onResponse(Call<List<Work>> call, Response<List<Work>> response) {
                List<Work> works = response.body();
                if (works == null) {
                    Toast.makeText(mContext, "ERROR", Toast.LENGTH_SHORT).show();
                } else {
                    workList = works;
                }
            }

            @Override
            public void onFailure(Call<List<Work>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        // 设置RecyclerView 的适配器
        mRVWorkList.setAdapter(new WorkAdapter(mContext, workList));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_add:

                toActivity(WriteWorkActivity.class);

                break;
        }
    }
}
