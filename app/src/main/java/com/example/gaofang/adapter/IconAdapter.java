package com.example.gaofang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.gaofang.R;
import com.example.gaofang.bean.HomeBean;

import java.util.ArrayList;

public class IconAdapter extends DelegateAdapter.Adapter {
    private Context mContext;
    private GridLayoutHelper gridLayoutHelper;
    private ArrayList<HomeBean.DataBean.ChannelBean> mChannelBeans;

    public IconAdapter(Context mContext, GridLayoutHelper gridLayoutHelper, ArrayList<HomeBean.DataBean.ChannelBean> mChannelBeans) {
        this.mContext = mContext;
        this.gridLayoutHelper = gridLayoutHelper;
        this.mChannelBeans = mChannelBeans;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_icon, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        HomeBean.DataBean.ChannelBean channelBean = mChannelBeans.get(position);
        Glide.with(mContext).load(channelBean.getIcon_url()).into(viewHolder.img);
        viewHolder.tv.setText(channelBean.getName());

    }

    @Override
    public int getItemCount() {
        return mChannelBeans.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.home_icon_img);
            tv = (TextView) itemView.findViewById(R.id.home_icon_tv);
        }
    }
}
