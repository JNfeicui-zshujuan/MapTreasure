package com.example.zheng.maptreasure.home;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.zheng.maptreasure.R;
import com.example.zheng.maptreasure.commons.ActivityUtils;
import com.example.zheng.maptreasure.map.MapFragment;

import butterknife.BindView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.toolBar_home)
    Toolbar toolbar;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    private ImageView imageView;
    private FragmentManager fraManager;
    private MapFragment mapFragment;
    private ActivityUtils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        utils = new ActivityUtils(this);
        fraManager = getSupportFragmentManager();
        mapFragment = fraManager.findFragmentById(R.id.mapFragment);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }
}
