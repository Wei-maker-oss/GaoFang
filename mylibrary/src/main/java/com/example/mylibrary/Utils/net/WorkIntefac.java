package com.example.mylibrary.Utils.net;

public interface WorkIntefac {
    <I> void get(String url, CallBack<I> callBack);
}
