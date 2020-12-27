package com.example.mylibrary.base;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView{
    protected T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        if(presenter==null){
            presenter=getPresenter();
            presenter.attachView(this);
            Log.e("TAG", "onCreate: "+this.toString());
        }
        initView();
        initData();
    }

    protected abstract void initData();
    protected abstract void initView();
    protected abstract int getLayoutID();
    public abstract T getPresenter();

}
