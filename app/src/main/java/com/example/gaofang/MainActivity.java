package com.example.gaofang;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;

import com.example.gaofang.fragment.HomeFragment;
import com.example.gaofang.fragment.MyFragment;
import com.example.gaofang.fragment.ShopcarFragment;
import com.example.gaofang.fragment.SortFragment;
import com.example.gaofang.fragment.SubjectFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private FrameLayout fragmentContainer;
    private RadioGroup radioGroup;
    private RadioButton rdHome;
    private RadioButton rdSubject;
    private RadioButton rdSort;
    private RadioButton rdShopcar;
    private RadioButton rdMy;
    private HomeFragment mHomeFragment;
    private SubjectFragment mSubjectFragment;
    private SortFragment mSortFragment;
    private ShopcarFragment mShopcarFragment;
    private MyFragment mMyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        fragmentContainer = (FrameLayout) findViewById(R.id.fragment_container);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        rdHome = (RadioButton) findViewById(R.id.rd_home);
        rdSubject = (RadioButton) findViewById(R.id.rd_subject);
        rdSort = (RadioButton) findViewById(R.id.rd_sort);
        rdShopcar = (RadioButton) findViewById(R.id.rd_shopcar);
        rdMy = (RadioButton) findViewById(R.id.rd_my);
        radioGroup.setOnCheckedChangeListener(this);
        rdHome.setChecked(true);

        Drawable home = ContextCompat.getDrawable(this, R.drawable.select_home);
        home.setBounds(0, 0, 60, 60);
        rdHome.setCompoundDrawables(null, home, null, null);

        Drawable subject = ContextCompat.getDrawable(this, R.drawable.select_subject);
        subject.setBounds(0, 0, 60, 60);
        rdSubject.setCompoundDrawables(null, subject, null, null);

        Drawable sort = ContextCompat.getDrawable(this, R.drawable.select_sort);
        sort.setBounds(0, 0, 60, 60);
        rdSort.setCompoundDrawables(null, sort, null, null);

        Drawable shopcar = ContextCompat.getDrawable(this, R.drawable.select_shopcar);
        shopcar.setBounds(0, 0, 60, 60);
        rdShopcar.setCompoundDrawables(null, shopcar, null, null);

        Drawable my = ContextCompat.getDrawable(this, R.drawable.select_my);
        my.setBounds(0, 0, 60, 60);
        rdMy.setCompoundDrawables(null, my, null, null);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch (checkedId) {
            case R.id.rd_home:
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                    transaction.add(R.id.fragment_container, mHomeFragment);
                } else {
                    transaction.show(mHomeFragment);
                }
                break;
            case R.id.rd_subject:
                if (mSubjectFragment == null) {
                    mSubjectFragment = new SubjectFragment();
                    transaction.add(R.id.fragment_container, mSubjectFragment);
                } else {
                    transaction.show(mSubjectFragment);
                }
                break;
            case R.id.rd_sort:
                if (mSortFragment == null) {
                    mSortFragment = new SortFragment();
                    transaction.add(R.id.fragment_container, mSortFragment);
                } else {
                    transaction.show(mSortFragment);
                }
                break;
            case R.id.rd_shopcar:
                if (mShopcarFragment == null) {
                    mShopcarFragment = new ShopcarFragment();
                    transaction.add(R.id.fragment_container,  mShopcarFragment);
                } else {
                    transaction.show( mShopcarFragment);
                }
                break;
            case R.id.rd_my:
                if (mMyFragment == null) {
                    mMyFragment = new MyFragment();
                    transaction.add(R.id.fragment_container,  mMyFragment);
                } else {
                    transaction.show( mMyFragment);
                }
                break;
        }
        transaction.commit();
    }

    public void hideAllFragment(FragmentTransaction transaction){
        if(mHomeFragment!=null){
            transaction.hide(mHomeFragment);
        }
        if(mSubjectFragment!=null){
            transaction.hide(mSubjectFragment);
        }
        if(mSortFragment!=null){
            transaction.hide(mSortFragment);
        }
        if(mShopcarFragment!=null){
            transaction.hide(mShopcarFragment);
        }
        if(mMyFragment!=null){
            transaction.hide(mMyFragment);
        }
    }
}