package com.example.mylibrary.base;

import android.util.Log;

public abstract class BasePresenter<V extends BaseView,E extends BaseModel> {
    public V iView;
    public E iModel;
    public void attachView(V v){
        iView=v;
        iModel=getModel();
        Log.e("TAG", "attachView: "+v.toString() );
    }

    protected abstract E getModel();
}
