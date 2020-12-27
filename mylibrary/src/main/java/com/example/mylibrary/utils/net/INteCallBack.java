package com.example.mylibrary.utils.net;

public interface INteCallBack<T> {
    void onSuccess(T t);
    void onFail(String err);
}
