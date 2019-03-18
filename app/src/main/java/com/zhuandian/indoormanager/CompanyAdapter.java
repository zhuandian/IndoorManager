package com.zhuandian.indoormanager;

import android.content.Context;
import android.widget.TextView;

import com.zhuandian.indoormanager.base.BaseAdapter;
import com.zhuandian.indoormanager.base.BaseViewHolder;
import com.zhuandian.indoormanager.entity.CompanyEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * desc :
 * author：xiedong
 * date：2019/3/18
 */
public class CompanyAdapter extends BaseAdapter<CompanyEntity, BaseViewHolder> {

    @BindView(R.id.tv_company_name)
    TextView tvCompanyName;
    @BindView(R.id.tv_company_category)
    TextView tvCompanyCategory;
    @BindView(R.id.tv_company_desc)
    TextView tvCompanyDesc;
    @BindView(R.id.tv_contact)
    TextView tvContact;

    public CompanyAdapter(List<CompanyEntity> mDatas, Context context) {
        super(mDatas, context);
    }

    @Override
    protected void converData(BaseViewHolder myViewHolder, CompanyEntity companyEntity, int position) {
        ButterKnife.bind(this, myViewHolder.itemView);
        tvCompanyCategory.setText(companyEntity.getCompanyCategory());
        tvCompanyName.setText(companyEntity.getCompanyName());
        tvContact.setText(String.format("%s:%s", companyEntity.getCompanyContact(), companyEntity.getPhone()));
        tvCompanyDesc.setText(companyEntity.getCompanyDesc());
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_company;
    }
}
