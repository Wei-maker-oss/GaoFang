package com.example.gaofang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gaofang.R;
import com.example.gaofang.bean.HomeBean;

import java.util.ArrayList;

public class Linear11Adapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<HomeBean.DataBean.TopicListBean> topicListBeans;

    public Linear11Adapter(Context context, ArrayList<HomeBean.DataBean.TopicListBean> topicListBeans) {
        this.context = context;
        this.topicListBeans = topicListBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_topic, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        HomeBean.DataBean.TopicListBean brandListBean = topicListBeans.get(position);
        holder1.title.setText(brandListBean.getTitle());
        holder1.subtitle.setText(brandListBean.getSubtitle());
        holder1.price.setText("￥"+brandListBean.getPrice_info());
        Glide.with(context).load(brandListBean.getScene_pic_url()).into(holder1.img);
    }

    @Override
    public int getItemCount() {
        return topicListBeans.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView price;
        TextView subtitle;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.item_home_topic_img);
            price = (TextView) itemView.findViewById(R.id.item_home_topic_tv_price);
            subtitle = (TextView) itemView.findViewById(R.id.item_home_topic_tv_subtitle);
            title = (TextView) itemView.findViewById(R.id.item_home_topic_tv_title);
        }
    }
}
