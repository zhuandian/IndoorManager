package com.zhuandian.indoormanager.business;

import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import com.zhuandian.indoormanager.CompanyAdapter;
import com.zhuandian.indoormanager.R;
import com.zhuandian.indoormanager.base.BaseActivity;
import com.zhuandian.indoormanager.entity.CompanyEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class CompanyServeActivity extends BaseActivity {


    @BindView(R.id.company_spinner)
    AppCompatSpinner companySpinner;
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    private String[] companyArray;
    private String companyLimit = "科技";


    @Override
    protected int getLayoutId() {
        return R.layout.activity_company_serve;
    }

    @Override
    protected void setUpView() {
        companyArray = getResources().getStringArray(R.array.company);
        companySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                companyLimit = companyArray[position];
                initData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        initData();
    }

    private void initData() {
        BmobQuery<CompanyEntity> query = new BmobQuery<>();
        query.addWhereEqualTo("companyCategory", companyLimit)
                .findObjects(new FindListener<CompanyEntity>() {
                    @Override
                    public void done(List<CompanyEntity> list, BmobException e) {
                        if (e == null) {
                            rvList.setAdapter(new CompanyAdapter(list, CompanyServeActivity.this));
                            rvList.setLayoutManager(new LinearLayoutManager(CompanyServeActivity.this));
                        }
                    }
                });

    }

}
