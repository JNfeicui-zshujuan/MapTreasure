package com.example.zheng.maptreasure;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zheng.maptreasure.commons.ActivityUtils;
import com.example.zheng.maptreasure.commons.RegexUtils;
import com.example.zheng.maptreasure.register.RegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn_Login)
    Button btn_Login;
    @BindView(R.id.btn_regist)
    Button btn_regist;
    @BindView(R.id.et_login_user)
    EditText et_login_user;
    @BindView(R.id.et_login_password)
    EditText et_login_password;
    @BindView(R.id.toolBar)
    Toolbar toolbar;
    private String userName;
    private String passWord;
    private ActivityUtils utils;
public static final String ACTION_ENTER_HOME="action.enter.home";
    //广播接收器,接收广播后关闭当前页面
    public final BroadcastReceiver receiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册本地的广播接收器,动态注册
        IntentFilter filter=new IntentFilter(ACTION_ENTER_HOME);
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver,filter);

    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
//        //设置左上角小图标
//        if (getSupportActionBar()!=null){
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setTitle(getTitle());
//        }
        et_login_user.addTextChangedListener(watcher);
        et_login_password.addTextChangedListener(watcher);
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
            userName = et_login_user.getText().toString();
            passWord = et_login_password.getText().toString();
            boolean enable = !(TextUtils.isEmpty(userName) || TextUtils.isEmpty(passWord));
           btn_Login.setEnabled(enable);


        }
    };
    @OnClick(R.id.btn_Login)
    public void Login(){
        if (RegexUtils.verifyUsername(userName)!=RegexUtils.VERIFY_SUCCESS){
            Toast.makeText(MainActivity.this, "请重新输入用户名", Toast.LENGTH_SHORT).show();
        }
        if (RegexUtils.verifyPassword(passWord)!=RegexUtils.VERIFY_SUCCESS){
            Toast.makeText(MainActivity.this, "请重新输入密码", Toast.LENGTH_SHORT).show();
        }

    }
    @OnClick(R.id.btn_regist)
    public void Register(){
        utils=new ActivityUtils(this);
        utils.startActivity(RegisterActivity.class);
    }
    /**
     * 实现登录
     * 1.拿到edittext里面的数据,
     * 2.对比账号和密码,错误重新输入
     * 3.信息正确,进入主页面,登录成功.
     *
     */
    /**
     * 注册
     * 1.拿到editText里的数据,保存,
     * 2.验证密码,保存
     * 3.注册成功
     *
     */

}
