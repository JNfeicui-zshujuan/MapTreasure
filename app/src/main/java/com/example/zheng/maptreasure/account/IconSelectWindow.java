package com.example.zheng.maptreasure.account;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.example.zheng.maptreasure.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhengshujuan on 2016/7/15.
 * //用户头像更改弹出式窗口
 */
public class IconSelectWindow extends PopupWindow {
    public interface Listener{
        void toGallery();
        void toCamera();
    }
    private final Activity activity;
    private final Listener listener;

    public IconSelectWindow( Activity activity, Listener listener) {
        super(activity.getLayoutInflater().inflate(R.layout.window_select_icon,null),
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        ButterKnife.bind(this,getContentView());

        this.activity = activity;
        this.listener = listener;
        setFocusable(true);
        setBackgroundDrawable(new BitmapDrawable());
    }
    public void show(){
        showAtLocation(activity.getWindow().getDecorView(), Gravity.BOTTOM,0,0);

    }
    @OnClick({R.id.btn_gallery,R.id.btn_camera,R.id.btn_cancel})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_cancel:
                break;
            case R.id.btn_camera:
                listener.toCamera();
                break;
            case R.id.btn_gallery:
                listener.toGallery();
                break;
        }
        dismiss();
    }
}
