package com.aoyi.aoyiyun.startpage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.aoyi.aoyiyun.Activity.HomeActivity;
import com.aoyi.aoyiyun.Base.BasicActivity;
import com.aoyi.aoyiyun.R;


/**
 * Created by Administrator on 2016/10/31.
 */
public class StartActivity extends BasicActivity {
    @Override
    public void initSetView() {

    }

    @Override
    public void initLoadView(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_start);
        new Handler() {
            public void handleMessage(android.os.Message msg) {
                SharedPreferences sp = getSharedPreferences("config", 0);
                boolean b = sp.getBoolean("is_frist", true);
                if (b) {
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putBoolean("is_frist", false);
                    edit.commit();
                    Intent intent = new Intent(getApplicationContext(),
                            GuideActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(),
                            HomeActivity.class);
                    startActivity(intent);
                }
                finish();
            };
        }.sendEmptyMessageDelayed(100, 1500);
    }


    @Override
    public void initLoadData() {

    }
}
