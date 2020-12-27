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

public class GridLayout5Adapter extends RecyclerView.Adapter {
    private Context mContext;
    private ArrayList<HomeBean.DataBean.CategoryListBean.GoodsListBean> goodsListBeans;

    public GridLayout5Adapter(Context mContext, ArrayList<HomeBean.DataBean.CategoryListBean.GoodsListBean> goodsListBeans) {
        this.mContext = mContext;
        this.goodsListBeans = goodsListBeans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_category, parent,false);
        return new GridLayout5ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GridLayout5ViewHolder holder1= (GridLayout5ViewHolder) holder;
        HomeBean.DataBean.CategoryListBean.GoodsListBean goodsListBean = goodsListBeans.get(position);
        holder1.tvHomeGird5Name.setText(goodsListBean.getName());
        holder1.tvHomeGrid5Sprice.setText("￥"+goodsListBean.getRetail_price());
        Glide.with(mContext).load(goodsListBean.getList_pic_url()).into(holder1.ivHomeGrid5Img);
    }

    @Override
    public int getItemCount() {
        return goodsListBeans.size();
    }
    class GridLayout5ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivHomeGrid5Img;
        private TextView tvHomeGird5Name;
        private TextView tvHomeGrid5Sprice;
        public GridLayout5ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivHomeGrid5Img = (ImageView) itemView.findViewById(R.id.item_home_category_img);
            tvHomeGird5Name = (TextView) itemView.findViewById(R.id.item_home_category_tv_name);
            tvHomeGrid5Sprice = (TextView) itemView.findViewById(R.id.item_home_category_tv_price);
        }
    }
}
