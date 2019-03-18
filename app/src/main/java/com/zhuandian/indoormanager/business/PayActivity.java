package com.zhuandian.indoormanager.business;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import com.zhuandian.indoormanager.R;
import com.zhuandian.indoormanager.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PayActivity extends BaseActivity {


    @BindView(R.id.category_spiner)
    AppCompatSpinner categorySpiner;
    @BindView(R.id.pay_spiner)
    AppCompatSpinner paySpiner;
    @BindView(R.id.btn_pay)
    Button btnPay;
    @BindView(R.id.et_money)
    EditText etPayNumber;
    private String[] categoryArray;
    private String[] payArray;
    private String categoryStr;
    private String payStr;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pay;
    }

    @Override
    protected void setUpView() {
        categoryArray = getResources().getStringArray(R.array.category);
        payArray = getResources().getStringArray(R.array.pay);
        categorySpiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                categoryStr = categoryArray[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        paySpiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                payStr = payArray[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @OnClick(R.id.btn_pay)
    public void onClick() {
        new AlertDialog.Builder(this)
                .setTitle("支付成功")
                .setMessage(String.format("您使用%s支付了%s元，支付类型为：%s", payStr, etPayNumber.getText().toString(), categoryStr))
                .setNegativeButton("继续缴费", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("返回上一页", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).create()
                .show();
    }
}
