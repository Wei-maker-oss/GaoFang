package com.example.gaofang.fragment;

import android.os.Bundle;

import androidx.constraintlayout.widget.VirtualLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.example.gaofang.R;

public class MyFragment extends Fragment {
private RecyclerView mMyRlv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        inintView(view);
        return view;
    }

    private void inintView(View view) {
        mMyRlv=view.findViewById(R.id.my_rlv);
        // 初始化布局管理器
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(getActivity());
        RecyclerView.RecycledViewPool pool = new RecyclerView.RecycledViewPool();
        mMyRlv.setRecycledViewPool(pool);

    }
















}