package com.aoyi.aoyiyun.Fragment;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.aoyi.aoyiyun.Base.BaseFragment;
import com.aoyi.aoyiyun.R;

/**
 * Created by qzs on 2016/11/1.
 */
public class ShuJuFragment extends BaseFragment{
    public ShuJuFragment(Activity mactivity) {
        super(mactivity);
    }

    @Override
    public View initView() {
        view=View.inflate(context, R.layout.fragment_shuju,null);
        return view;
    }

    @Override
    public void initData() {

    }
}
