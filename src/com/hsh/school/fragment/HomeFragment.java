package com.hsh.school.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.hsh.school.R;
import com.hsh.school.base.BaseFragment;
import com.hsh.school.base.BasePage;
import com.hsh.school.operate.HomePager;
import com.hsh.school.operate.FoodiePager;
import com.hsh.school.operate.VideoPager;
import com.hsh.school.view.LazyViewPager;
import com.hsh.school.view.LazyViewPager.OnPageChangeListener;

public class HomeFragment extends BaseFragment {

	/**
	 * 1����ʼ��viewpager ͨ��ʹ��adapter����ʽʵ��
	 */
	private View view;
	private LazyViewPager viewPager;
	private RadioGroup main_radio;
	@SuppressWarnings("unused")
	private int checkedId = R.id.rb_home;

	/**
	 * ��ʼ��view
	 */
	@Override
	public View initView(LayoutInflater inflater) {
		view = inflater.inflate(R.layout.menu_frag, null);
		viewPager = (LazyViewPager) view.findViewById(R.id.viewpager);
		main_radio = (RadioGroup) view.findViewById(R.id.main_radio);
		return view;
	}

	List<BasePage> list = new ArrayList<BasePage>();

	/**
	 * ��ʼ������
	 */
	@Override
	public void initData(Bundle savedInstanceState) {
		list.add(new HomePager(context));
		list.add(new VideoPager(context));
		list.add(new FoodiePager(context));

		HomePageAdapter adapter = new HomePageAdapter(context, list);
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// ���λ����0�����ܳ��ֻ����˵�������tab������
//				if (0 == position) {
//					sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
//				} else {
//					sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
//				}
				BasePage page = list.get(position);
				if (!flag)
					page.initData();
			}

			
			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {

			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});

		main_radio.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.rb_home:
					viewPager.setCurrentItem(0, false);
					checkedId = 0;
					break;
				case R.id.rb_draw:
					viewPager.setCurrentItem(1, false);
					checkedId = 1;
					break;
				case R.id.rb_setting:
					viewPager.setCurrentItem(2, false);
					checkedId = 2;
					break;
				}
			}
		});
	}

	@SuppressWarnings("unused")
	class HomePageAdapter extends PagerAdapter {

		private Context context;
		private List<BasePage> list;

		public HomePageAdapter(Context context2, List<BasePage> list) {
			this.context = context2;
			this.list = list;
		}

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			((LazyViewPager) container).removeView(list.get(position)
					.getRootView());
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			((LazyViewPager) container).addView(list.get(position)
					.getRootView(), 0);
			return list.get(position).getRootView();
		}

	}
}
