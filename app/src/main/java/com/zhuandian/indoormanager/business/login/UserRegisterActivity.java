package com.zhuandian.indoormanager.business.login;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.zhuandian.indoormanager.R;
import com.zhuandian.indoormanager.base.BaseActivity;
import com.zhuandian.indoormanager.entity.UserEntity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class UserRegisterActivity extends BaseActivity {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.rb_viewer)
    RadioButton rbViewer;
    @BindView(R.id.rb_business)
    RadioButton rbBusiness;
    @BindView(R.id.rg_container)
    RadioGroup rgContainer;
    private String userName;
    private String passWord;
    private int roleId = 1;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_register;
    }

    @Override
    protected void setUpView() {

    }


    @OnClick(R.id.tv_register)
    public void onClick() {
        doRegister();
    }

    private void doRegister() {
        userName = etUsername.getText().toString();
        passWord = etPassword.getText().toString();
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(passWord)) {
            Toast.makeText(this, "请完善注册信息...", Toast.LENGTH_SHORT).show();
        } else {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(userName);
            userEntity.setPassword(passWord);
            userEntity.setRoleId(roleId);
            userEntity.signUp(new SaveListener<Object>() {
                @Override
                public void done(Object o, BmobException e) {
                    if (e == null) {
                        showRegisterDialog();
                    } else {
                        Toast.makeText(UserRegisterActivity.this, "注册失败...", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void showRegisterDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("注册成功")
                .setMessage("注册成功，是否马上去登陆？")
                .setNegativeButton("稍后登陆", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("马上登陆", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                })
                .show();
    }


    @OnClick({R.id.rb_viewer, R.id.rb_business})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_viewer:
                roleId = 1;
                break;
            case R.id.rb_business:
                roleId = 2;
                break;
        }
    }
}
