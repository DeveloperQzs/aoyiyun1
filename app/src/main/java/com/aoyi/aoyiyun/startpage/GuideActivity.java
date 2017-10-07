package com.aoyi.aoyiyun.startpage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.aoyi.aoyiyun.R;
import com.aoyi.aoyiyun.Activity.HomeActivity;
import com.aoyi.aoyiyun.Base.BasicActivity;


import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/31.
 */
public class GuideActivity extends BasicActivity{
    private ArrayList<ImageView> list;
    private ViewPager viewpager_guide;
    private TextView tv_tiyan;
    @Override
    public void initSetView() {
        viewpager_guide.setAdapter(new MyPagerAdapter(list));
        viewpager_guide.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position==list.size()-1){
                    tv_tiyan.setVisibility(View.VISIBLE);
                    tv_tiyan.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(GuideActivity.this,HomeActivity.class));
                        }
                    });
                }else {
                    tv_tiyan.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void initLoadView(Bundle savedInstanceState) {
setContentView(R.layout.activity_guide);
        tv_tiyan= (TextView) findViewById(R.id.tv_tiyan);
        viewpager_guide= (ViewPager) findViewById(R.id.viewpager_guide);
    }

    @Override
    public void initLoadData() {
        list = new ArrayList<ImageView>();
        ImageView img1 = new ImageView(getApplicationContext());
        img1.setBackgroundResource(R.mipmap.ic_launcher);
        ImageView img2 = new ImageView(getApplicationContext());
        img2.setBackgroundResource(R.mipmap.ic_launcher);
        list.add(img1);
        list.add(img2);


    }
    class MyPagerAdapter extends PagerAdapter {
        private ArrayList<ImageView> al = new ArrayList<ImageView>();
        public MyPagerAdapter(ArrayList<ImageView> list) {
            this.al = list;
        }

        @Override
        public int getCount() {
            if(al!=null){
                return al.size();
            }else{
                return 0;
            }
        }
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return (arg0==arg1);
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(al.get(position));
            return al.get(position);
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }
}
