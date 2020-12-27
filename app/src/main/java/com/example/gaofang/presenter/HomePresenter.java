package com.example.gaofang.presenter;

import com.example.gaofang.bean.HomeBean;
import com.example.gaofang.contract.HomeContract;
import com.example.gaofang.model.HomeModel;
import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.utils.net.INteCallBack;

public class HomePresenter extends BasePresenter<HomeContract.IView,HomeContract.IModel>
        implements HomeContract.IPresenter {

    @Override
    protected HomeContract.IModel getModel() {
        return new HomeModel();
    }
    @Override
    public void onStart1() {
        iModel.getModel("index", new INteCallBack<HomeBean>() {

            @Override
            public void onSuccess(HomeBean homeBean) {
                    iView.onShow(homeBean);
            }

            @Override
            public void onFail(String err) {
                    iView.onHide(err);
            }
        });

    }





}
