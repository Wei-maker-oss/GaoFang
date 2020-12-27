package com.example.mylibrary.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView {
    protected T presenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutID(), null);
        if(presenter==null){
//            presenter=getPresnter();
//            presenter.attachView(this);
            addPresenter();
        }
        initView(view);
        initData();
        return view;
    }

//    protected abstract T getPresnter();
    private void addPresenter(){
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        Class type = (Class) actualTypeArguments[0];
        try {
            presenter = (T) type.newInstance();
            presenter.attachView(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
    }

    protected abstract void initData();

    protected abstract void initView(View view);

    protected abstract int getLayoutID();
}
