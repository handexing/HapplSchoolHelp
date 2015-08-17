package com.hsh.school.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hsh.school.MainActivity;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public abstract class BaseFragment extends Fragment {

	public View view;
	public Context context;
	public SlidingMenu sm;
	public boolean flag = false;
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initData(savedInstanceState);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = getActivity();
		sm = ((MainActivity)getActivity()).getSlidingMenu();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = initView(inflater);
		return view;
	}

	public View getRootView(){
		return view;
	}
	// 初始化view
	public abstract View initView(LayoutInflater inflater);

	// 初始化数据
	public abstract void initData(Bundle savedInstanceState);

}
