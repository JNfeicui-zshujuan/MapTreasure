package com.example.zheng.maptreasure.account;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zheng.maptreasure.R;
import com.example.zheng.maptreasure.commons.ActivityUtils;
import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.pkmmte.view.CircularImageView;

import org.hybridsquad.android.library.CropHandler;
import org.hybridsquad.android.library.CropHelper;
import org.hybridsquad.android.library.CropParams;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AccountActivity extends MvpActivity<AccoutView, AccountPresenter> implements AccoutView {
    @BindView(R.id.iv_userIcon)
    CircularImageView ivUserIcon;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.rl)
    RelativeLayout rl;
    @BindView(R.id.toolBar_account)
    Toolbar toolbar;
    private ActivityUtils utils;
    private IconSelectWindow selectWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        utils = new ActivityUtils(this);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        getSupportActionBar().setTitle(getTitle());
    }

    @OnClick(R.id.iv_userIcon)
    public void onClick() {
        if (selectWindow == null)
            selectWindow = new IconSelectWindow(this, listener);
        if (selectWindow.isShowing()) {
            selectWindow.dismiss();
            return;
        }
        selectWindow.show();
    }

    private CropHandler cropHandler = new CropHandler() {
        //剪切完成
        @Override
        public void onPhotoCropped(Uri uri) {
            File file = new File(uri.getPath());
            //执行头像上传任务
            getPresenter().uploadPhoto(file);

        }

        //剪切取消
        @Override
        public void onCropCancel() {
            utils.showToast("剪切取消");
        }

        //剪切失败
        @Override
        public void onCropFailed(String message) {
            utils.showToast("剪切失败");
        }

        @Override
        public CropParams getCropParams() {
            CropParams cropParams = new CropParams();
            cropParams.aspectX = 300;
            cropParams.aspectY = 300;
            return cropParams;
        }

        @Override
        public Activity getContext() {
            return AccountActivity.this;
        }
    };

    private final IconSelectWindow.Listener listener = new IconSelectWindow.Listener() {
        //到相册进行头像选择
        @Override
        public void toGallery() {
            CropHelper.clearCachedCropFile(cropHandler.getCropParams().uri);
            Intent intent = CropHelper.buildCaptureIntent(cropHandler.getCropParams().uri);
            startActivityForResult(intent, CropHelper.REQUEST_CROP);
        }

        //调用相机进行头像选择
        @Override
        public void toCamera() {
            CropHelper.clearCachedCropFile(cropHandler.getCropParams().uri);
            Intent intent = CropHelper.buildCaptureIntent(cropHandler.getCropParams().uri);
            startActivityForResult(intent, CropHelper.REQUEST_CAMERA);
        }
    };
    private ProgressDialog dialog;

    @NonNull
    @Override
    public AccountPresenter createPresenter() {
        return new AccountPresenter();
    }

    @Override
    public void showProgress() {
        dialog = ProgressDialog.show(this, " ", "头像更新中.....");
    }

    @Override
    public void hideProgress() {
        if (dialog != null) dialog.dismiss();
    }

    @Override
    public void showMessage(String string) {

    }

    @Override
    public void updataPhoto(String url) {

    }
}
