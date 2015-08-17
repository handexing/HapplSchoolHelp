package com.hsh.school;

import android.os.Bundle;

import com.hsh.school.fragment.FastEntryFragment;
import com.hsh.school.fragment.HomeFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

	private SlidingMenu sm;
	private FastEntryFragment fastEntryFragment;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setBehindContentView(R.layout.slidingmenu);
		setContentView(R.layout.activity_main);
		initSlidingMenu();
	}

	/**
	 * 设置侧滑菜单
	 */
	private void initSlidingMenu() {
		sm = getSlidingMenu();// 实例化一个slidingmenu
		sm.setMode(SlidingMenu.RIGHT);// slidingmenu出现的屏幕左右方向
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);// 设置主页面在slidingmenu上显示的宽度
		sm.setShadowDrawable(R.drawable.shadow);// 设置主页面和slidingmenu页面之间的阴影图片
		sm.setShadowWidthRes(R.dimen.shadow_width);// 设置阴影的宽度
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);// 设置滑出slidingmenu的地方

		fastEntryFragment = new FastEntryFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.menu_frame, fastEntryFragment, "FastEntry")
				.commit();
		
		HomeFragment homeFragment = new HomeFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_fragment, homeFragment, "Home")
				.commit();
	}
}
