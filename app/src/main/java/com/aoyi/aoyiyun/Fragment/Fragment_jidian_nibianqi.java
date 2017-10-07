package com.aoyi.aoyiyun.Fragment;

import android.app.Activity;
import android.view.View;

import com.aoyi.aoyiyun.Base.BaseFragment;
import com.aoyi.aoyiyun.R;

/**
 * Created by Administrator on 2016/11/11.
 */
public class Fragment_jidian_nibianqi extends BaseFragment {
    public Fragment_jidian_nibianqi(Activity mactivity) {
        super(mactivity);
    }

    @Override
    public View initView() {
        view=View.inflate(context, R.layout.activity_main,null);
        return view;
    }

    @Override
    public void initData() {

    }
}
