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
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.gaofang.R;
import com.example.gaofang.adapter.BannersingleLayoutAdapter;
import com.example.gaofang.adapter.TopicTextSingleAdapter;
import com.example.gaofang.adapter.TopiclinearAdapter;
import com.example.gaofang.adapter.HotLinearAdapter;
import com.example.gaofang.adapter.HotTextSingleAdapter;
import com.example.gaofang.adapter.IconAdapter;
import com.example.gaofang.adapter.MakerGridAdapter;
import com.example.gaofang.adapter.NewGoodsGridAdapter;
import com.example.gaofang.adapter.NewGoodsTextSingleAdapter;
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
    private TextAdapter mMakerTextAdapter;
    private GridLayoutHelper mMakerridLayoutHelper;
    private ArrayList<HomeBean.DataBean.BrandListBean> mNewBrandListBeans;
    private MakerGridAdapter mMakerGridAdapter;
    private SingleLayoutHelper mNewGoodsSingleLayoutHelper;
    private ArrayList<HomeBean.DataBean.NewGoodsListBean> mNewGoodsListBeans;
    private NewGoodsTextSingleAdapter mNewGoodsTextSingleAdapter;
    private GridLayoutHelper mNewGoodsGridLayoutHelper;
    private NewGoodsGridAdapter mNewGoodsGridAdapter;
    private SingleLayoutHelper mHotSingleLayoutHelper;
    private HotTextSingleAdapter mHotTextSingleAdapter;
    private LinearLayoutHelper mHotLinearLayoutHelper;
    private ArrayList<HomeBean.DataBean.HotGoodsListBean> mHotGoodsListBeans;
    private HotLinearAdapter mHotLinearAdapter;
    private SingleLayoutHelper mTopicSingleLayoutHelper;
    private TopicTextSingleAdapter mTopicTextSingleAdapter;
    private LinearLayoutHelper mTopiclinearLayoutHelper;
    private ArrayList<HomeBean.DataBean.TopicListBean> mTopicListBeans;
    private TopiclinearAdapter mTopicLinearAdapter;

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
        mHomeRlv = view.findViewById(R.id.home_rlv);
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getActivity());
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        mHomeRlv.setRecycledViewPool(recycledViewPool);
        recycledViewPool.setMaxRecycledViews(0, 10);
        // 轮播图
        mBannersingleLayoutHelper = new SingleLayoutHelper();
        mBannerDTOS = new ArrayList<>();
        mBannersingleLayoutAdapter = new BannersingleLayoutAdapter(getActivity(), mBannersingleLayoutHelper, mBannerDTOS);

        // 图标
        mIconLayoutHelper = new GridLayoutHelper(5);
        mChannelBeans = new ArrayList<>();
        mIconAdapter = new IconAdapter(getActivity(), mIconLayoutHelper, mChannelBeans);

        mTextMakersingleLayoutHelper = new SingleLayoutHelper();
        mMakerTextAdapter = new TextAdapter(getActivity(), mTextMakersingleLayoutHelper);

        // 网格（品牌制造商）
        mMakerridLayoutHelper = new GridLayoutHelper(2);
        mNewBrandListBeans = new ArrayList<>();
        mMakerGridAdapter = new MakerGridAdapter(getActivity(), mMakerridLayoutHelper, mNewBrandListBeans);

        mNewGoodsSingleLayoutHelper = new SingleLayoutHelper();
        mNewGoodsTextSingleAdapter = new NewGoodsTextSingleAdapter(getActivity(), mNewGoodsSingleLayoutHelper);

        // 网格（新品）
        mNewGoodsGridLayoutHelper = new GridLayoutHelper(2);
        mNewGoodsListBeans = new ArrayList<>();
        mNewGoodsGridAdapter = new NewGoodsGridAdapter(getActivity(), mNewGoodsGridLayoutHelper, mNewGoodsListBeans);

        mHotSingleLayoutHelper = new SingleLayoutHelper();
        mHotTextSingleAdapter = new HotTextSingleAdapter(getActivity(), mHotSingleLayoutHelper);
        // 线性（人气推荐）
        mHotLinearLayoutHelper = new LinearLayoutHelper();
        mHotGoodsListBeans = new ArrayList<>();
        mHotLinearAdapter = new HotLinearAdapter(getActivity(), mHotLinearLayoutHelper, mHotGoodsListBeans);

        mTopicSingleLayoutHelper = new SingleLayoutHelper();
        mTopicTextSingleAdapter = new TopicTextSingleAdapter(getActivity(), mTopicSingleLayoutHelper);

        // 线性（专题精选）
        mTopiclinearLayoutHelper = new LinearLayoutHelper();
        mTopicListBeans = new ArrayList<>();
        mTopicLinearAdapter = new TopiclinearAdapter(getActivity(), mTopiclinearLayoutHelper, mTopicListBeans);

        mDelegateAdapter = new DelegateAdapter(virtualLayoutManager, false);
        // 绑定适配器
        mDelegateAdapter.addAdapter(mBannersingleLayoutAdapter);
        mDelegateAdapter.addAdapter(mIconAdapter);
        mDelegateAdapter.addAdapter(mMakerTextAdapter);
        mDelegateAdapter.addAdapter(mMakerGridAdapter);
        mDelegateAdapter.addAdapter(mNewGoodsTextSingleAdapter);
        mDelegateAdapter.addAdapter(mNewGoodsGridAdapter);
        mDelegateAdapter.addAdapter(mHotTextSingleAdapter);
        mDelegateAdapter.addAdapter(mHotLinearAdapter);
        mDelegateAdapter.addAdapter(mTopicTextSingleAdapter);
        mDelegateAdapter.addAdapter(mTopicLinearAdapter);

        mHomeRlv.setLayoutManager(virtualLayoutManager);
        mHomeRlv.setAdapter(mDelegateAdapter);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    public void onShow(Object object) {
        if (object instanceof HomeBean) {
            HomeBean homeBean = (HomeBean) object;
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

            // 网格（新品）
            List<HomeBean.DataBean.NewGoodsListBean> newGoodsList = homeBean.getData().getNewGoodsList();
            mNewGoodsListBeans.addAll(newGoodsList);
            mNewGoodsGridAdapter.notifyDataSetChanged();

            // 线性（人气推荐）
            List<HomeBean.DataBean.HotGoodsListBean> hotGoodsList = homeBean.getData().getHotGoodsList();
            mHotGoodsListBeans.addAll(hotGoodsList);
            mHotLinearAdapter.notifyDataSetChanged();

            // 线性（精选）
            List<HomeBean.DataBean.TopicListBean> topicList = homeBean.getData().getTopicList();
            mTopicListBeans.addAll(topicList);
            mTopicLinearAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onHide(String str) {
        Log.e("TAG", "网络数据错误:" + str);

    }
}