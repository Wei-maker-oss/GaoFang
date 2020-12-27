package com.example.gaofang.contract;

import com.example.mylibrary.base.BaseModel;
import com.example.mylibrary.base.BaseView;
import com.example.mylibrary.utils.net.INteCallBack;

public class HomeContract {
    public interface IModel extends BaseModel {
        <T> void getModel(String url, INteCallBack<T> callBack);
    }
    public interface IView extends BaseView{
        void onShow(Object object);
        void onHide(String str);
    }
     public interface IPresenter{
        void onStart1();
     }
}
