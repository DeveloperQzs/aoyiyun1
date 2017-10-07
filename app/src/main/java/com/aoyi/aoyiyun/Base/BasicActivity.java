package com.aoyi.aoyiyun.Base;

import android.app.Activity;
import android.os.Bundle;

/**
 * 
 * @author qzs
 * 
 */
public abstract class BasicActivity extends Activity {
	/*
	 * 
	 * 更改activity的生命周期,方便启动页何引导页的设置
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// 加载控件 view的操作
		initLoadView(savedInstanceState);
		// 加载数据的操作
		initLoadData();
		// 填充数据
		initSetView();
	}

	public abstract void initSetView();

	public abstract void initLoadView(Bundle savedInstanceState);

	public abstract void initLoadData();
}
