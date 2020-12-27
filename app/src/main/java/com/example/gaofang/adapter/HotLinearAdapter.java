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
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.gaofang.R;
import com.example.gaofang.bean.HomeBean;

import java.util.ArrayList;

public class HotLinearAdapter extends DelegateAdapter.Adapter {
    private Context mContext;
    private LinearLayoutHelper linearLayoutHelper;
    private ArrayList<HomeBean.DataBean.HotGoodsListBean> mHotGoodsListBeans;

    public HotLinearAdapter(Context mContext, LinearLayoutHelper linearLayoutHelper, ArrayList<HomeBean.DataBean.HotGoodsListBean> mHotGoodsListBeans) {
        this.mContext = mContext;
        this.linearLayoutHelper = linearLayoutHelper;
        this.mHotGoodsListBeans = mHotGoodsListBeans;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_hotgoods, parent, false);
        return new HotGoodsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBean.DataBean.HotGoodsListBean bean = mHotGoodsListBeans.get(position);
        HotGoodsViewHolder goodsViewHolder= (HotGoodsViewHolder) holder;
        Glide.with(mContext).load(bean.getList_pic_url()).into(goodsViewHolder.img);
        goodsViewHolder.name.setText(bean.getName());
        goodsViewHolder.brief.setText(bean.getGoods_brief());
        goodsViewHolder.price.setText("￥"+bean.getRetail_price());
    }

    @Override
    public int getItemCount() {
        return mHotGoodsListBeans.size();
    }
    class HotGoodsViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name;
        private TextView brief;
        private TextView price;
        public HotGoodsViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.item_home_hotgoods_img);
            name = (TextView) itemView.findViewById(R.id.item_home_hotgoods_tv_name);
            brief = (TextView) itemView.findViewById(R.id.item_home_hotgoods_tv_brief);
            price = (TextView) itemView.findViewById(R.id.item_hotgoods_tv_price);
        }
    }
}
