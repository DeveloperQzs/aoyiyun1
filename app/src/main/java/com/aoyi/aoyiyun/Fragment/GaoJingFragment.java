package com.aoyi.aoyiyun.Fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.aoyi.aoyiyun.Base.BaseFragment;
import com.aoyi.aoyiyun.R;
import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;

/**
 * Created by qzs on 2016/11/1.
 */
public class GaoJingFragment extends BaseFragment {

    public GaoJingFragment(Activity mactivity) {
        super(mactivity);
    }
    @Override
    public View initView() {
       view=View.inflate(context, R.layout.fragment_gaojing,null);
        return view;
    }

    @Override
    public void initData() {
    }

}
