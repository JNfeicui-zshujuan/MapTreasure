package com.example.zheng.maptreasure;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhengshujuan on 2016/7/12.
 */
public class RegisterActivity extends Activity {
    @BindView(R.id.et_register_user)
    EditText etRegisterUser;
    @BindView(R.id.et_register_password)
    EditText etRegisterPassword;
    @BindView(R.id.et_register_pass)
    EditText etRegisterPass;
    @BindView(R.id.btn_regist)
    Button btnRegist;
    //    @BindView(R.id.et_register_user)
//    EditText et_register_user;
//    @BindView(R.id.et_register_password)
//    EditText et_register_passWord;
//    @BindView(R.id.et_register_pass)
//    EditText et_register_pass;
//    @BindView(R.id.btn_regist)
//    Button btn_register;
    //保存用户和密码
    private String userName;
    private String passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
        etRegisterUser.addTextChangedListener(watcher);
        etRegisterPassword.addTextChangedListener(watcher);
        etRegisterPass.addTextChangedListener(watcher);
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
}
