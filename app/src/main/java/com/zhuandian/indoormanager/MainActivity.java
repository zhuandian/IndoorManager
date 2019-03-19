package com.zhuandian.indoormanager;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zhuandian.indoormanager.base.BaseActivity;
import com.zhuandian.indoormanager.business.CompanyServeActivity;
import com.zhuandian.indoormanager.business.LocationActivity;
import com.zhuandian.indoormanager.business.PayActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setUpView() {

    }


    @OnClick({R.id.tv_location, R.id.tv_service, R.id.tv_pay, R.id.tv_business_service})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_location:
                startActivity(new Intent(MainActivity.this, LocationActivity.class));
                break;
            case R.id.tv_service:
                startActivity(new Intent(MainActivity.this, CompanyFeedBackActivity.class));
                break;
            case R.id.tv_pay:
                startActivity(new Intent(MainActivity.this, PayActivity.class));
                break;
            case R.id.tv_business_service:
                startActivity(new Intent(MainActivity.this, CompanyServeActivity.class));
                break;
        }
    }
}
