package com.aoyi.aoyiyun.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;
import com.aoyi.aoyiyun.Base.BaseFragment;
import com.aoyi.aoyiyun.Fragment.Fragment_jidian_huiliuxiang;
import com.aoyi.aoyiyun.Fragment.Fragment_jidian_nibianqi;
import com.aoyi.aoyiyun.Fragment.Fragment_jidian_xiangbian;
import com.aoyi.aoyiyun.R;
import com.astuetz.PagerSlidingTabStrip;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/11.
 */
public class JiDianXiangQingActivity extends FragmentActivity {
    private ArrayList<BaseFragment> list=new ArrayList<>();
    private ArrayList<String> namelist=new ArrayList<>();
    private TextView tv_jidianxiangqing_title;
    private PagerSlidingTabStrip tab_jidianxiangqing;
    private MyJiDianXiangQingAdapter adapter;
    private ViewPager viewpager_jidianxiangqing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jidianxiangqing);
        initView();
       Intent intent=getIntent();
        tv_jidianxiangqing_title.setText(intent.getStringExtra("jidianxianlu")+"-"+intent.getStringExtra("fangzhen"));
        initdata();
    }

    private void initdata() {
        namelist.add("箱变");
        namelist.add("逆变器");
        namelist.add("汇流箱");
        list.add(new Fragment_jidian_xiangbian(this));
        list.add(new Fragment_jidian_nibianqi(this));
        list.add(new Fragment_jidian_huiliuxiang(this));
        adapter=new MyJiDianXiangQingAdapter(getSupportFragmentManager(),list);
        viewpager_jidianxiangqing.setAdapter(adapter);
        tab_jidianxiangqing.setViewPager(viewpager_jidianxiangqing);
    }
    private void initView() {
        tv_jidianxiangqing_title= (TextView) findViewById(R.id.tv_jidianxiangqing_title);
        tab_jidianxiangqing= (PagerSlidingTabStrip) findViewById(R.id.tab_jidianxiangqing);
        viewpager_jidianxiangqing= (ViewPager) findViewById(R.id.viewpager_jidianxiangqing);
        tab_jidianxiangqing.setTextColor(Color.WHITE);
    }
    class MyJiDianXiangQingAdapter extends FragmentPagerAdapter{
        private ArrayList<BaseFragment> list;
        public MyJiDianXiangQingAdapter(FragmentManager fm, ArrayList<BaseFragment> list) {
            super(fm);
            this.list=list;
        }
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }
        @Override
        public int getCount() {
            return list.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {

            return namelist.get(position);

        }
        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }
    }
}
