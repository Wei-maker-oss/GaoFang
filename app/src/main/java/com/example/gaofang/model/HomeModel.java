package com.example.gaofang.model;

import com.example.gaofang.contract.HomeContract;
import com.example.mylibrary.utils.net.INteCallBack;
import com.example.mylibrary.utils.net.RetrofitUtils;

public class HomeModel implements HomeContract.IModel {
    @Override
    public <T> void getModel(String url, INteCallBack<T> callBack) {
        RetrofitUtils.getRetrofitUtils().get(url,callBack);
    }
}
