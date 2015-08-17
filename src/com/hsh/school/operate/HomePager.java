package com.hsh.school.operate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hsh.school.R;
import com.hsh.school.base.BasePage;

/**
 * @author 作者 E-mail: 908716835@qq.com
 * @date 创建时间：2015-8-2 下午3:04:54
 * @version 1.0
 */
public class HomePager extends BasePage implements OnClickListener{

	private View view;
	private TextView titleName;
	private ImageView ivBack;
	private ImageView im_sliding;
	
	private LinearLayout ll_parttime;//兼职
	private LinearLayout ll_friend;//交友
	private LinearLayout ll_activity;//活动
	private LinearLayout ll_taste;//兴趣
	private LinearLayout ll_lookpeople;//看别人
	private LinearLayout ll_more;//更多

	public HomePager(Context context) {
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
		view = inflater.inflate(R.layout.home_fragment, null);
		titleName = (TextView) view.findViewById(R.id.titleName);
		ivBack = (ImageView) view.findViewById(R.id.back);
		im_sliding = (ImageView) view.findViewById(R.id.im_sliding);
		im_sliding.setOnClickListener(this);
		ivBack.setVisibility(View.GONE);
		titleName.setText("乐校帮");
		ll_parttime = (LinearLayout) view.findViewById(R.id.ll_parttime);
		ll_friend = (LinearLayout) view.findViewById(R.id.ll_friend);
		ll_activity = (LinearLayout) view.findViewById(R.id.ll_activity);
		ll_taste = (LinearLayout) view.findViewById(R.id.ll_taste);
		ll_lookpeople = (LinearLayout) view.findViewById(R.id.ll_lookpeople);
		ll_more = (LinearLayout) view.findViewById(R.id.ll_more);
		ll_parttime.setOnClickListener(this);
		ll_friend.setOnClickListener(this);
		ll_activity.setOnClickListener(this);
		ll_taste.setOnClickListener(this);
		ll_lookpeople.setOnClickListener(this);
		ll_more.setOnClickListener(this);
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
		case R.id.ll_parttime:
			Toast.makeText(context, "兼职", 1).show();
			break;
		case R.id.ll_friend:
			Toast.makeText(context, "交友", 1).show();
			break;
		case R.id.ll_activity:
			Toast.makeText(context, "活动", 1).show();
			break;
		case R.id.ll_taste:
			Toast.makeText(context, "兴趣", 1).show();
			break;
		case R.id.ll_lookpeople:
			Toast.makeText(context, "看别人", 1).show();
			break;
		case R.id.ll_more:
			Toast.makeText(context, "更多", 1).show();
			break;
		default:
			break;
		}
	}

}
