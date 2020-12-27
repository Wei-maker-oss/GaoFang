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

public class NewGoodsGridAdapter extends DelegateAdapter.Adapter {
    private Context mContext;
    private GridLayoutHelper gridLayoutHelper;
    private ArrayList<HomeBean.DataBean.NewGoodsListBean> mNewGoodsListBean;

    public NewGoodsGridAdapter(Context mContext, GridLayoutHelper gridLayoutHelper, ArrayList<HomeBean.DataBean.NewGoodsListBean> mNewGoodsListBean) {
        this.mContext = mContext;
        this.gridLayoutHelper = gridLayoutHelper;
        this.mNewGoodsListBean = mNewGoodsListBean;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_newgoods, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeBean.DataBean.NewGoodsListBean bean = mNewGoodsListBean.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        Glide.with(mContext).load(bean.getList_pic_url()).into(viewHolder.img);
        viewHolder.name.setText(bean.getName());
        viewHolder.price.setText(bean.getRetail_price());
    }

    @Override
    public int getItemCount() {
        return mNewGoodsListBean.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name;
        private TextView price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.item_home_newgoods_img);
            name = (TextView) itemView.findViewById(R.id.item_home_newgoods_tv_name);
            price = (TextView) itemView.findViewById(R.id.item_home_newgoods_tv_price);
        }
    }
}
