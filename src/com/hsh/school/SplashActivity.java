package com.hsh.school;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/**
 * @author ���� E-mail: 908716835@qq.com
 * @date ����ʱ�䣺2015-8-16 ����8:51:26
 * @version 1.0
 */
public class SplashActivity extends Activity {
	private View view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		view = findViewById(R.id.welocme_layout);
		AlphaAnimation animation = new AlphaAnimation(0.1f, 1.0f);// �������ɵ�Ч��
		animation.setDuration(4000);// ����ִ��ʱ��
		view.startAnimation(animation);// ִ�ж���
		animation.setAnimationListener(animationListener);// ����ִ�ж����ļ�����
	}

	private AnimationListener animationListener = new AnimationListener() {

		@Override
		public void onAnimationStart(Animation animation) {

		}

		@Override
		public void onAnimationRepeat(Animation animation) {

		}

		/**
		 * ִ���궯��ȥ������
		 */
		@Override
		public void onAnimationEnd(Animation animation) {
			Intent intent = new Intent(SplashActivity.this, MainActivity.class);
			startActivity(intent);
			finish();
		}
	};

	/**
	 * ���η��ؼ�
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return false;
	}
}
