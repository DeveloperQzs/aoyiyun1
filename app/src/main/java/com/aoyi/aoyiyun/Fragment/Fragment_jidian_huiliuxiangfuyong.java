package com.aoyi.aoyiyun.Fragment;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.aoyi.aoyiyun.Base.BaseFragment;
import com.aoyi.aoyiyun.R;

/**
 * Created by Administrator on 2016/11/11.
 */
public class Fragment_jidian_huiliuxiangfuyong extends BaseFragment{
    private String str;
    private TextView tv;

    public Fragment_jidian_huiliuxiangfuyong(Activity mactivity) {
        super(mactivity);
    }

    @Override
    public View initView() {
        view=View.inflate(context, R.layout.fragment_jidian_huiliuxiangfuyong,null);
        tv= (TextView) view.findViewById(R.id.tv);
      tv.setText("wadw");
        return view;
    }

    @Override
    public void initData() {

    }
}
