package com.aoyi.aoyiyun.Fragment;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.aoyi.aoyiyun.Base.BaseFragment;
import com.aoyi.aoyiyun.R;
import com.idtk.smallchart.chart.CurveChart;
import com.idtk.smallchart.data.CurveData;
import com.idtk.smallchart.data.PointShape;
import com.idtk.smallchart.interfaces.iData.ICurveData;

import java.util.ArrayList;

/**
 * Created by qzs on 2016/11/1.
 */
public class JianKongFragment extends BaseFragment {
    private CurveChart curveChart;
    private CurveData mCurveData = new CurveData();
    private ArrayList<PointF> mPointArrayList = new ArrayList<>();
    private ArrayList<ICurveData> mDataList = new ArrayList<>();
    public JianKongFragment(Activity mactivity) {
        super(mactivity);
    }

    @Override
    public View initView() {
       view=View.inflate(context, R.layout.fragment_jiankong,null);
        curveChart= (CurveChart) view.findViewById(R.id.curveChart);
        return view;
    }
    @Override
    public void initData() {
        /*
        因为viewpager总是加载数据所以当viewpager销毁后给集合移除
         */
        if (mDataList.size()!=0){
            mDataList.remove(0);
        }
        mPointArrayList.clear();
        mPointArrayList.add(new PointF(0, 100));
        mPointArrayList.add(new PointF(8, 300));
        mPointArrayList.add(new PointF(10, 600));
        mPointArrayList.add(new PointF(12, 900));
        mPointArrayList.add(new PointF(14, 800));
        mPointArrayList.add(new PointF(20, 100));

        mCurveData.setValue(mPointArrayList);
        mCurveData.setColor(Color.YELLOW);
        mCurveData.setIsTextSize(false);
        mCurveData.setIsTextSize(false);//是否显示Y的值
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.fade_red);
        mCurveData.setDrawable(drawable);
        mCurveData.setTextSize(pxTodp(10));    //曲线上的左边的字体代销
        mCurveData.setPointShape(PointShape.SOLIDROUND);
        //mCurveData.setPaintWidth(pxTodp(3));  //曲线的宽度
      //  mCurveData.setTextSize(pxTodp(10));
         mDataList.add(mCurveData);
        curveChart.setDataList(mDataList);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    protected float pxTodp(float value){
        DisplayMetrics metrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        float valueDP= TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,value,metrics);
        return valueDP;
    }
}
