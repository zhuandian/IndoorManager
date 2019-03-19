package com.zhuandian.indoormanager;


import android.support.v7.widget.AppCompatSpinner;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zhuandian.indoormanager.base.BaseActivity;
import com.zhuandian.indoormanager.entity.CompanyEntity;
import com.zhuandian.indoormanager.entity.FeedBackEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class CompanyFeedBackActivity extends BaseActivity {


    @BindView(R.id.company_spinner)
    AppCompatSpinner companySpinner;
    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.tv_commit)
    TextView tvCommit;
    private List<String> datas = new ArrayList<>();
    private String companyName;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_company_feed_back;
    }

    @Override
    protected void setUpView() {
        initSpiner();

    }

    private void initSpiner() {
        BmobQuery<CompanyEntity> query = new BmobQuery();
        query.findObjects(new FindListener<CompanyEntity>() {
            @Override
            public void done(List<CompanyEntity> list, BmobException e) {
                if (e == null) {
                    datas.clear();
                    for (CompanyEntity companyEntity : list) {
                        datas.add(companyEntity.getCompanyName());
                    }
                    companySpinner.setAdapter(new ArrayAdapter<String>(CompanyFeedBackActivity.this, android.R.layout.simple_expandable_list_item_1, datas));
                    companySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            companyName = datas.get(position);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

            }
        });


    }


    @OnClick(R.id.tv_commit)
    public void onClick() {
        if (TextUtils.isEmpty(companyName) || TextUtils.isEmpty(etContent.getText().toString())) {
            Toast.makeText(this, "请完善反馈信息...", Toast.LENGTH_SHORT).show();
        } else {
            FeedBackEntity feedBackEntity = new FeedBackEntity();

            feedBackEntity.setCompanyName(companyName);
            feedBackEntity.setFeedBackContent(etContent.getText().toString());
            feedBackEntity.save(new SaveListener<String>() {
                @Override
                public void done(String s, BmobException e) {
                    if (e == null) {
                        Toast.makeText(CompanyFeedBackActivity.this, "反馈成功，相关企业负责人会尽快跟您联系...", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
