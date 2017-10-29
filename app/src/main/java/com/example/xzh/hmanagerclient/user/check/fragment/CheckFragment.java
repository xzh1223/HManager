package com.example.xzh.hmanagerclient.user.check.fragment;

import android.view.View;

import android.widget.TextView;
import com.example.xzh.hmanagerclient.R;
import com.example.xzh.hmanagerclient.user.base.fragment.BaseFragment;

/**
 * Created by Administrator on 2017/10/28.
 */

public class CheckFragment extends BaseFragment {

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_check, null);

        // 设置标题文字
        TextView mTextTitle = (TextView) view.findViewById(R.id.tv_header_title);
        mTextTitle.setText(getString(R.string.nav_check));

        return view;
    }

}
