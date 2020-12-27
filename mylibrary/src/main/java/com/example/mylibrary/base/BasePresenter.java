package com.example.mylibrary.base;

public abstract class BasePresenter <V extends BaseView,M extends BaseMode> {
    public V iview;
    public M imode;

    public void attch(V v) {
        iview = v;
        imode=setImode();
    }

    public void destroy(){
        iview=null;
        imode=null;
    }

    public abstract M setImode();
}
