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
import com.example.gaofang.R;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

public class HomeSingleBannerAdapter extends DelegateAdapter.Adapter {
    private Context mContext;
    private SingleLayoutHelper singleLayoutHelper;

    public HomeSingleBannerAdapter(Context mContext, SingleLayoutHelper singleLayoutHelper) {
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
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_banner, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
//        viewHolder.banner.setImages().setImageLoader(new ImageLoader() {
//            @Override
//            public void displayImage(Context context, Object path, ImageView imageView) {
//
//            }
//        }).start();
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        private Banner banner;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            banner=itemView.findViewById(R.id.home_banner);
        }
    }
}
