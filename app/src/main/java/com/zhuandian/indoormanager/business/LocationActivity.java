package com.zhuandian.indoormanager.business;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zhuandian.indoormanager.MainActivity;
import com.zhuandian.indoormanager.R;
import com.zhuandian.indoormanager.base.BaseActivity;
import com.zhuandian.indoormanager.business.gardenServer.DataGatherActivity;
import com.zhuandian.indoormanager.business.gardenServer.MapActivity;
import com.zhuandian.indoormanager.business.gardenServer.PathActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LocationActivity extends BaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_garden_serve;
    }

    @Override
    protected void setUpView() {

    }


    @OnClick({R.id.tv_data_gather, R.id.tv_map, R.id.tv_path})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_data_gather:
                startActivity(new Intent(LocationActivity.this, DataGatherActivity.class));
                break;
            case R.id.tv_map:
                startActivity(new Intent(LocationActivity.this, MapActivity.class));
                break;
            case R.id.tv_path:
                startActivity(new Intent(LocationActivity.this, PathActivity.class));
                break;
        }
    }
}
