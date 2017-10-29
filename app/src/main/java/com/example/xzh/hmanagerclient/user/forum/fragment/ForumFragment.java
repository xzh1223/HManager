package com.example.xzh.hmanagerclient.user.forum.fragment;

import android.view.LayoutInflater;
import android.view.View;

import android.widget.TextView;
import com.example.xzh.hmanagerclient.R;
import com.example.xzh.hmanagerclient.user.base.fragment.BaseFragment;

/**
 * Created by Administrator on 2017/10/28.
 */

public class ForumFragment extends BaseFragment {

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_forum, null);

        // 设置标题文字
        TextView mTextTitle = (TextView) view.findViewById(R.id.tv_header_title);
        mTextTitle.setText(getString(R.string.nav_show));

        return view;
    }

}
