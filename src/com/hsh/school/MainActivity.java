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
	 * ���ò໬�˵�
	 */
	private void initSlidingMenu() {
		sm = getSlidingMenu();// ʵ����һ��slidingmenu
		sm.setMode(SlidingMenu.RIGHT);// slidingmenu���ֵ���Ļ���ҷ���
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);// ������ҳ����slidingmenu����ʾ�Ŀ��
		sm.setShadowDrawable(R.drawable.shadow);// ������ҳ���slidingmenuҳ��֮�����ӰͼƬ
		sm.setShadowWidthRes(R.dimen.shadow_width);// ������Ӱ�Ŀ��
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);// ���û���slidingmenu�ĵط�

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
