package com.example.xzh.hmanagerclient.user.work.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xzh.hmanagerclient.R;
import com.example.xzh.hmanagerclient.user.work.bean.Work;

import java.util.List;

/**
 * Created by Administrator on 2017/10/28.
 *
 *  Work RecyclerView的自定义适配器
 *
 */

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.ViewHolder> {

    private final Context mContext;
    private final List<Work> mList;
    private final LayoutInflater mInflater;

    public WorkAdapter(Context context, List<Work> mList) {
        this.mContext = context;
        this.mList = mList;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_list_work, parent,false);
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (mList != null) {
            Work work = mList.get(position);
            holder.tvTime.setText(work.getWorkTime().toString());
            holder.tvTitle.setText(work.getWorkTitle());
            holder.tvContent.setText(work.getWorkContent());
        } else {

        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTime;
        TextView tvTitle;
        TextView tvContent;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time_work);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title_work);
            tvContent = (TextView) itemView.findViewById(R.id.tv_content_work);
        }
    }

}
