package com.example.gaofang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.gaofang.R;
import com.example.gaofang.bean.HomeBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class BannersingleLayoutAdapter extends DelegateAdapter.Adapter {
    private Context mContext;
    private SingleLayoutHelper singleLayoutHelper;
    private ArrayList<HomeBean.DataBean.BannerBean> mBanner;

    public BannersingleLayoutAdapter(Context mContext, SingleLayoutHelper singleLayoutHelper, ArrayList<HomeBean.DataBean.BannerBean> mBanner) {
        this.mContext = mContext;
        this.singleLayoutHelper = singleLayoutHelper;
        this.mBanner = mBanner;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 加载布局
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_banner, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.homebanner.setImages(mBanner).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                HomeBean.DataBean.BannerBean bannerDate= (HomeBean.DataBean.BannerBean) path;
                Glide.with(mContext).load(bannerDate.getImage_url()).into(imageView);
            }
        }).start();
    }

    @Override
    public int getItemCount() {
        return mBanner.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private Banner homebanner;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            homebanner=itemView.findViewById(R.id.home_banner);
        }
    }
}
