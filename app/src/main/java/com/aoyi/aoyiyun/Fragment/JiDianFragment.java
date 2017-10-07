package com.aoyi.aoyiyun.Fragment;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import com.aoyi.aoyiyun.Base.BaseFragment;
import com.aoyi.aoyiyun.R;
import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;

/**
 * Created by qzs on 2016/11/1.
 */
public class JiDianFragment extends BaseFragment {
    private MyjidianAdapter adapter;
    private ArrayList<BaseFragment> fglist=new ArrayList<BaseFragment>();
    private PagerSlidingTabStrip tab_jidian;
    private ViewPager viewpager_jidian;
    private ArrayList<String>  namelist=new ArrayList<>();
    private ImageView iv_jidian_pop;
    public JiDianFragment(Activity mactivity) {
        super(mactivity);
    }
    @Override
    public View initView() {
      view=View.inflate(context, R.layout.fragment_jidian,null);
        tab_jidian= (PagerSlidingTabStrip) view.findViewById(R.id.tab_jidian);
        viewpager_jidian= (ViewPager) view.findViewById(R.id.viewpager_jidian);
        tab_jidian.setTextColor(Color.WHITE);
        namelist.clear();
        fglist.clear();
        namelist.add("集电线路1");
        namelist.add("集电线路2");
        namelist.add("集电线路3");
        for (int i=0;i<namelist.size();i++){
            Fragment_jidian_fuyong fragment=Fragment_jidian_fuyong.newInstance(namelist.get(i));
            fglist.add(fragment);
        }
        adapter=new MyjidianAdapter(getChildFragmentManager(),fglist);
        viewpager_jidian.setAdapter(adapter);
        tab_jidian.setViewPager(viewpager_jidian);
        return view;
    }
    @Override
    public void initData() {

    }
    class MyjidianAdapter extends FragmentPagerAdapter{
        private ArrayList<BaseFragment> fglist;
        public MyjidianAdapter(FragmentManager fm, ArrayList<BaseFragment> fglist) {
            super(fm);
            this.fglist=fglist;
        }
        // 获取每个界面对应的标题
        @Override
        public CharSequence getPageTitle(int position) {

            return namelist.get(position);

        }
        @Override
        public Fragment getItem(int position) {
            return fglist.get(position);
        }

        @Override
        public int getCount() {
            return fglist.size();
        }
        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }
    }
}
