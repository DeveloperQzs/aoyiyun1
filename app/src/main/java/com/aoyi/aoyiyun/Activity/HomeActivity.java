package com.aoyi.aoyiyun.Activity;

import android.os.Bundle;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;


import com.aoyi.aoyiyun.Fragment.HomeFragment;
import com.aoyi.aoyiyun.R;

/**
 * Created by Administrator on 2016/10/31.
 */
public class HomeActivity extends ActionBarActivity implements View.OnClickListener {
    private FrameLayout framelayout;
    private DrawerLayout drawlayout;
    private Toolbar toolbar;
    private ImageView iv_home_geren;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        initView();

        setActionBar();
        HomeFragment homefragment=new HomeFragment(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,homefragment,"home").commit();
   setlistener();
    }

    private void setlistener() {
        iv_home_geren.setOnClickListener(this);
    }

    private void setActionBar() {
        toolbar.setTitle("");

        setSupportActionBar(toolbar);
        //注释的几句都是为了让toolbar左侧的导航图标消失
       // getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
     //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawlayout, toolbar, 0, 0);
        toggle.setDrawerIndicatorEnabled(false);   //这句是为了让左侧导航图标失效
       // drawlayout.setDrawerListener(toggle);
        toggle.syncState();
    }

    private void initView() {
        iv_home_geren= (ImageView) findViewById(R.id.iv_home_geren);
        framelayout= (FrameLayout) findViewById(R.id.framelayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawlayout = (DrawerLayout) findViewById(R.id.drawlayout);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            Toast.makeText(getApplicationContext(),"aa",Toast.LENGTH_SHORT).show();
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_home_geren:
                drawlayout.openDrawer(Gravity.LEFT);
                break;
        }
    }
}
