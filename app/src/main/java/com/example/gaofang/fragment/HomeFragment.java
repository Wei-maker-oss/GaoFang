package com.example.gaofang.fragment;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.gaofang.R;
import com.example.gaofang.adapter.BannersingleLayoutAdapter;
import com.example.gaofang.adapter.IconAdapter;
import com.example.gaofang.adapter.MakerGridAdapter;
import com.example.gaofang.adapter.TextAdapter;
import com.example.gaofang.bean.HomeBean;
import com.example.gaofang.contract.HomeContract;
import com.example.gaofang.presenter.HomePresenter;
import com.example.mylibrary.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.IView {
    private RecyclerView mHomeRlv;
    private SingleLayoutHelper mBannersingleLayoutHelper;
    private ArrayList<HomeBean.DataBean.BannerBean> mBannerDTOS;
    private DelegateAdapter mDelegateAdapter;
    private BannersingleLayoutAdapter mBannersingleLayoutAdapter;
    private ArrayList<HomeBean.DataBean.ChannelBean> mChannelBeans;
    private IconAdapter mIconAdapter;
    private GridLayoutHelper mIconLayoutHelper;
    private SingleLayoutHelper mTextMakersingleLayoutHelper;
    private TextAdapter mTextAdapter;
    private GridLayoutHelper mMakerridLayoutHelper;
    private ArrayList<HomeBean.DataBean.BrandListBean> mNewBrandListBeans;
    private MakerGridAdapter mMakerGridAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    protected void initData() {
            presenter.onStart1();
    }

    @Override
    protected void initView(View view) {
        mHomeRlv=view.findViewById(R.id.home_rlv);
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getActivity());
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        mHomeRlv.setRecycledViewPool(recycledViewPool);
        recycledViewPool.setMaxRecycledViews(0,10);
        // 轮播图
        mBannersingleLayoutHelper = new SingleLayoutHelper();
        mBannerDTOS = new ArrayList<>();
        mBannersingleLayoutAdapter = new BannersingleLayoutAdapter(getActivity(), mBannersingleLayoutHelper, mBannerDTOS);

        // 图标
        mIconLayoutHelper = new GridLayoutHelper(5);
        mChannelBeans = new ArrayList<>();
        mIconAdapter = new IconAdapter(getActivity(), mIconLayoutHelper, mChannelBeans);

        mTextMakersingleLayoutHelper = new SingleLayoutHelper();
        mTextAdapter = new TextAdapter(getActivity(), mTextMakersingleLayoutHelper);

        // 网格
        mMakerridLayoutHelper = new GridLayoutHelper(2);
        mNewBrandListBeans = new ArrayList<>();
        mMakerGridAdapter = new MakerGridAdapter(getActivity(), mMakerridLayoutHelper, mNewBrandListBeans);



        mDelegateAdapter = new DelegateAdapter(virtualLayoutManager, false);
        // 绑定适配器
        mDelegateAdapter.addAdapter(mBannersingleLayoutAdapter);
        mDelegateAdapter.addAdapter(mIconAdapter);
        mDelegateAdapter.addAdapter(mTextAdapter);




        mHomeRlv.setLayoutManager(virtualLayoutManager);
        mHomeRlv.setAdapter(mDelegateAdapter);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    public void onShow(Object object) {
        if(object instanceof HomeBean){
            HomeBean homeBean= (HomeBean) object;
            List<HomeBean.DataBean.BannerBean> banner = homeBean.getData().getBanner();
            // 添加集合
            mBannerDTOS.addAll(banner);
            mBannersingleLayoutAdapter.notifyDataSetChanged();

            List<HomeBean.DataBean.ChannelBean> channel = homeBean.getData().getChannel();
            mChannelBeans.addAll(channel);
            mIconAdapter.notifyDataSetChanged();

            // 网格Maker
            List<HomeBean.DataBean.BrandListBean> brandList = homeBean.getData().getBrandList();
            mNewBrandListBeans.addAll(brandList);
            mMakerGridAdapter.notifyDataSetChanged();

        }
    }

    @Override
    public void onHide(String str) {
        Log.e("TAG","网络数据错误:"+str);

    }
}