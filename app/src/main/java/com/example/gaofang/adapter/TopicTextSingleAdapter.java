package com.example.gaofang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.gaofang.R;

public class TopicTextSingleAdapter extends DelegateAdapter.Adapter {
    private Context mContext;
    private SingleLayoutHelper singleLayoutHelper;

    public TopicTextSingleAdapter(Context mContext, SingleLayoutHelper singleLayoutHelper) {
        this.mContext = mContext;
        this.singleLayoutHelper = singleLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_topictext, parent, false);
        return new ChoicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChoicViewHolder choicViewHolder= (ChoicViewHolder) holder;
        choicViewHolder.title.setText("专题精选");
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    class ChoicViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        public ChoicViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_topic_tv);
        }
    }
}
