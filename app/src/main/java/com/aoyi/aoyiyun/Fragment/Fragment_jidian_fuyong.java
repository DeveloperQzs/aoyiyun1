package com.aoyi.aoyiyun.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aoyi.aoyiyun.Activity.HomeActivity;
import com.aoyi.aoyiyun.Activity.JiDianXiangQingActivity;
import com.aoyi.aoyiyun.Base.BaseFragment;
import com.aoyi.aoyiyun.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/11/10.
 */
public class Fragment_jidian_fuyong extends BaseFragment{
    private MygridviewAdapter  mygridviewAdapter;
    private GridView gv_jidianfangzhen;
    private ArrayList<String> fangzhenlist=new ArrayList<>();
    private String str;
    public Fragment_jidian_fuyong(Activity mactivity) {
        super(mactivity);
    }

    @Override
    public View initView() {
        view=View.inflate(context, R.layout.fragment_jidian_fuyong,null);
        gv_jidianfangzhen= (GridView) view.findViewById(R.id.gv_jidianfangzhen);
        gv_jidianfangzhen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(context,JiDianXiangQingActivity.class);
                intent.putExtra("fangzhen",(position+1)+"#方阵");
                intent.putExtra("jidianxianlu",str);
                context.startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void initData() {
        // 通过getArguments--->取值
        Bundle b = getArguments();
        if (b != null) {
            str = b.getString("msg");
         //   Toast.makeText(context,"我是"+str,Toast.LENGTH_SHORT).show();
        }
        Log.e("集电线路",str+"");
        fangzhenlist.clear();
        fangzhenlist.add("#1方阵");
        fangzhenlist.add("#2方阵");
        fangzhenlist.add("#3方阵");
        fangzhenlist.add("#4方阵");
        fangzhenlist.add("#5方阵");
        fangzhenlist.add("#6方阵");
        mygridviewAdapter=new MygridviewAdapter();
        gv_jidianfangzhen.setAdapter(mygridviewAdapter);
    }

    public static Fragment_jidian_fuyong newInstance(String message) {
        Fragment_jidian_fuyong fragment = new Fragment_jidian_fuyong(null);
        // activity给fragment传值--通过fragment.setArguments(bundle)
        Bundle bundle = new Bundle();
        bundle.putString("msg", message);
        // 传值
        fragment.setArguments(bundle);
        return fragment;
    }

    /*
    方阵的适配器
     */
    class MygridviewAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return fangzhenlist.size();
        }

        @Override
        public Object getItem(int position) {
            return fangzhenlist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder=null;
            if (convertView==null){
                holder=new ViewHolder();
                convertView=View.inflate(context,R.layout.item_jidian_fangzhen,null);
                holder.item_iv_jidian_fz= (ImageView) convertView.findViewById(R.id.item_iv_jidian_fz);
                holder.item_tv_jidian_fz= (TextView) convertView.findViewById(R.id.item_tv_jidian_fz);
                convertView.setTag(holder);
            }else {
                holder= (ViewHolder) convertView.getTag();
            }
            holder.item_tv_jidian_fz.setText(fangzhenlist.get(position));
            return convertView;
        }
    }
    class ViewHolder{
        TextView item_tv_jidian_fz;
        ImageView item_iv_jidian_fz;
    }
}
