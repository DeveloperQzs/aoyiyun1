package com.aoyi.aoyiyun.Fragment;

import android.app.Activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.aoyi.aoyiyun.Base.BaseFragment;
import com.aoyi.aoyiyun.R;
/**
 * Created by Administrator on 2016/11/11.
 */
public class Fragment_jidian_huiliuxiang extends BaseFragment {
    private MyhuiliuxiangAdapter adapter;
    private ListView lv_huiliuxiang_jidian;
    private String [] arr={"1#汇流箱","2#汇流箱","3#汇流箱","4#汇流箱","5#汇流箱","6#汇流箱","7#汇流箱","8#汇流箱","9#汇流箱","10#汇流箱"};
    public Fragment_jidian_huiliuxiang(Activity mactivity) {
        super(mactivity);
    }


    @Override
    public View initView() {
        view=View.inflate(context, R.layout.fragment_jidian_huiliuxiang,null);
        lv_huiliuxiang_jidian= (ListView) view.findViewById(R.id.lv_huiliuxiang_jidian);
        adapter=new MyhuiliuxiangAdapter();
        lv_huiliuxiang_jidian.setAdapter(adapter);
        lv_huiliuxiang_jidian.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, (position+1)+"", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void initData() {
    }
    class MyhuiliuxiangAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arr.length;
        }

        @Override
        public Object getItem(int position) {
            return arr[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder_huiliuxiang holder=null;
            if (convertView==null){
                holder=new ViewHolder_huiliuxiang();
                convertView=View.inflate(context,R.layout.item_jidian_huiliuxiang,null);
                holder.item_tv_huiliuxiang= (TextView) convertView.findViewById(R.id.item_tv_huiliuxiang);
                convertView.setTag(holder);
            }else {
                holder= (ViewHolder_huiliuxiang) convertView.getTag();
            }
            holder.item_tv_huiliuxiang.setText(arr[position]);
            return convertView;
        }
    }
    class ViewHolder_huiliuxiang{
        TextView item_tv_huiliuxiang;
    }
}
