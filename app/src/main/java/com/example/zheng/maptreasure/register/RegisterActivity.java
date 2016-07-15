package com.example.zheng.maptreasure.register;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.example.zheng.maptreasure.MainActivity;
import com.example.zheng.maptreasure.R;
import com.example.zheng.maptreasure.commons.ActivityUtils;
import com.example.zheng.maptreasure.home.HomeActivity;
import com.hannesdorfmann.mosby.mvp.MvpActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhengshujuan on 2016/7/12.
 */
public class RegisterActivity extends MvpActivity<RegisterView, RegisterPresenter> implements RegisterView {
    @BindView(R.id.et_register_user)
    EditText etRegisterUser;
    @BindView(R.id.et_register_password)
    EditText etRegisterPassword;
    @BindView(R.id.et_register_pass)
    EditText etRegisterPass;
    @BindView(R.id.btn_regist)
    Button btnRegist;
    @BindView(R.id.toolBar_register)
    Toolbar toolBarRegister;

    //保存用户和密码
    private String userName;
    private String passWord;

    private ActivityUtils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        utils = new ActivityUtils(this);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);

        setSupportActionBar(toolBarRegister);
        //设置左上角的小图标
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(getTitle());
        }

        etRegisterUser.addTextChangedListener(watcher);
        etRegisterPassword.addTextChangedListener(watcher);
        etRegisterPass.addTextChangedListener(watcher);
    }

    @NonNull
    @Override
    public RegisterPresenter createPresenter() {
        return new RegisterPresenter();
    }

    @OnClick(R.id.btn_regist)
    public void register() {
        //执行业务逻辑
        getPresenter().register(new User(userName,passWord));
    }

    //选项菜单处理
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private final TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            userName = etRegisterUser.getText().toString();
            passWord = etRegisterPassword.getText().toString();
            String confrim = etRegisterPass.getText().toString();
            boolean canClick = !TextUtils.isEmpty(userName) && !TextUtils.isEmpty(passWord) &&
                    !TextUtils.isEmpty(confrim);
            btnRegist.setEnabled(canClick);
        }
    };
    private ProgressDialog progressDialog;

    //显示弹窗视图
    @Override
    public void showProgress() {
        utils.hideSoftKeyboard();
        progressDialog = ProgressDialog.show(this, null, "注册中,请稍后.......");
    }

    //隐藏视图
    @Override
    public void hideProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void EnterHomeActivty() {
        utils.startActivity(HomeActivity.class);
        finish();
        //关闭入口的main界面,发送广播
        Intent intent = new Intent(MainActivity.ACTION_ENTER_HOME);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    @Override
    public void showMessage(String s) {

    }
}
