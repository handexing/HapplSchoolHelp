package com.hsh.school.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.hsh.school.MainActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * @author ���� E-mail: 908716835@qq.com
 * @date ����ʱ�䣺2015-8-2 ����2:36:52
 * @version 1.0
 */
public abstract class BasePage {

	public View view;
	public Context context;
	public SlidingMenu sm;

	/**
	 * 1�������� 2����ʼ������
	 */
	public BasePage(Context context) {
		this.context = context;
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view = initView(inflater);
		sm = ((MainActivity) context).getSlidingMenu();
	}

	public View getRootView() {
		return view;
	}

	// ��ʼ��view
	public abstract View initView(LayoutInflater inflater);

	// ��ʼ������
	public abstract void initData();

}
