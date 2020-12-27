package com.example.gaofang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.gaofang.R;
import com.example.gaofang.bean.HomeBean;

import java.util.ArrayList;
import java.util.List;

public class LinearLayout2Adapter extends DelegateAdapter.Adapter {
    private Context context;
    private LinearLayoutHelper linearLayoutHelper;
    private ArrayList<HomeBean.DataBean.CategoryListBean> categoryListBeans;
    private ArrayList<HomeBean.DataBean.CategoryListBean.GoodsListBean> goodsListBeans;

    public LinearLayout2Adapter(Context context, LinearLayoutHelper linearLayoutHelper, ArrayList<HomeBean.DataBean.CategoryListBean> categoryListBeans) {
        this.context = context;
        this.linearLayoutHelper = linearLayoutHelper;
        this.categoryListBeans = categoryListBeans;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home_eight, parent, false);
        return new LinearViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        LinearViewHolder holder1= (LinearViewHolder) holder;
        HomeBean.DataBean.CategoryListBean categoryListBean = categoryListBeans.get(position);
        holder1.tvHomeEightName.setText(categoryListBean.getName());

        goodsListBeans = new ArrayList<>();
        List<HomeBean.DataBean.CategoryListBean.GoodsListBean> goodsList = categoryListBean.getGoodsList();
        goodsListBeans.addAll(goodsList);
        GridLayoutManager gridManager = new GridLayoutManager(context,2);
        holder1.rlvHomeLinear.setLayoutManager(gridManager);
        GridLayout5Adapter adapter = new GridLayout5Adapter(context, goodsListBeans);
        holder1.rlvHomeLinear.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return categoryListBeans.size();
    }
    class LinearViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rlvHomeLinear;
        TextView tvHomeEightName;
        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHomeEightName = (TextView) itemView.findViewById(R.id.tv_home_eight_name);
            rlvHomeLinear = (RecyclerView) itemView.findViewById(R.id.rlv_home_eight);
        }
    }
}
