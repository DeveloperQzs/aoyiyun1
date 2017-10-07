package com.aoyi.aoyiyun.Fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.aoyi.aoyiyun.Base.BaseFragment;
import com.aoyi.aoyiyun.Base.MyViewPager;
import com.aoyi.aoyiyun.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/1.
 */
public class HomeFragment extends BaseFragment {
    private ArrayList<BaseFragment> list=new ArrayList<>();
    private RadioGroup radiogroup;
    private MyViewPager viewpager;
    public HomeFragment(Activity mactivity) {
        super(mactivity);
    }

    @Override
    public View initView() {
        view=View.inflate(context, R.layout.activity_home_radio,null);
        viewpager= (MyViewPager) view.findViewById(R.id.viewpager);
        radiogroup= (RadioGroup) view.findViewById(R.id.radiogroup);
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_jiankong:
                        viewpager.setCurrentItem(0);
                        break;
                    case R.id.rb_gaojing:
                        viewpager.setCurrentItem(1);
                        break;
                    case R.id.rb_jidian:
                        viewpager.setCurrentItem(2);
                        break;
                    case R.id.rb_shuju:
                        viewpager.setCurrentItem(3);
                        break;
                }
            }
        });
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
           list.get(position).initData();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        radiogroup.check(R.id.rb_jiankong);
        return view;
    }

    @Override
    public void initData() {
        list.add(new JianKongFragment(getActivity()));
        list.add(new GaoJingFragment(getActivity()));
        list.add(new JiDianFragment(getActivity()));
        list.add(new ShuJuFragment(getActivity()));
        viewpager.setAdapter(new Myadapter(getChildFragmentManager(),list));

    }
    class Myadapter extends FragmentPagerAdapter{
        private ArrayList<BaseFragment> list;
        public Myadapter(FragmentManager fm, ArrayList<BaseFragment> list) {
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
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }
    }
}
