package com.example.gaofang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.gaofang.R;
import com.example.gaofang.bean.HomeBean;

import java.util.ArrayList;

public class TopiclinearAdapter extends DelegateAdapter.Adapter {
    private Context mContext;
    private LinearLayoutHelper linearLayoutHelper;
    private ArrayList<HomeBean.DataBean.TopicListBean> mTopicListBeans;

    public TopiclinearAdapter(Context mContext, LinearLayoutHelper linearLayoutHelper, ArrayList<HomeBean.DataBean.TopicListBean> mTopicListBeans) {
        this.mContext = mContext;
        this.linearLayoutHelper = linearLayoutHelper;
        this.mTopicListBeans = mTopicListBeans;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_topicb, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        viewHolder.rlv.setLayoutManager(linearLayoutManager);
        Linear11Adapter linear11Adapter = new Linear11Adapter(mContext, mTopicListBeans);
        viewHolder.rlv.setAdapter(linear11Adapter);
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView rlv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rlv = (RecyclerView) itemView.findViewById(R.id.item_topicb_rlv);
        }
    }
}
