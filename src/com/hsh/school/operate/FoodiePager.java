package com.hsh.school.operate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.hsh.school.R;
import com.hsh.school.base.BasePage;

/**
 * @author 作者 E-mail: 908716835@qq.com
 * @date 创建时间：2015-8-2 下午3:04:54
 * @version 1.0
 */
public class FoodiePager extends BasePage implements OnClickListener{

	private View view;
	private TextView titleName;
	private ImageView im_sliding;
	public FoodiePager(Context context) {
		super(context);
	}

	/**
	 * @Name:initView
	 * @Description: 初始化界面
	 * @Author: 韩德兴（作者）
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2015-8-2 下午3:05:52 （创建日期）
	 * @Parameters: LayoutInflater inflater 界面填充器
	 * @Return: View
	 */
	@Override
	public View initView(LayoutInflater inflater) {
		view = inflater.inflate(R.layout.setting_fragment, null);
		titleName = (TextView) view.findViewById(R.id.titleName);
		titleName.setText("吃货吧");
		ImageView ivBack = (ImageView) view.findViewById(R.id.back);
		ivBack.setVisibility(View.GONE);
		im_sliding = (ImageView) view.findViewById(R.id.im_sliding);
		im_sliding.setOnClickListener(this);
		return view;
	}

	/**
	 * @Name: initData
	 * @Description: 初始化数据
	 * @Author: 韩德兴（作者）
	 * @Version: V1.00 （版本号）
	 * @Create Date: 2015-8-2 下午3:05:52 （创建日期）
	 * @Parameters: 无
	 * @Return: 无
	 */
	@Override
	public void initData() {

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.im_sliding:
			sm.showMenu();
			break;

		default:
			break;
		}
	
	}

}
