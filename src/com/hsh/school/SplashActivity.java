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
 * @author 作者 E-mail: 908716835@qq.com
 * @date 创建时间：2015-8-16 下午8:51:26
 * @version 1.0
 */
public class SplashActivity extends Activity {
	private View view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		view = findViewById(R.id.welocme_layout);
		AlphaAnimation animation = new AlphaAnimation(0.1f, 1.0f);// 动画过渡的效果
		animation.setDuration(4000);// 动画执行时间
		view.startAnimation(animation);// 执行动画
		animation.setAnimationListener(animationListener);// 设置执行动画的监听器
	}

	private AnimationListener animationListener = new AnimationListener() {

		@Override
		public void onAnimationStart(Animation animation) {

		}

		@Override
		public void onAnimationRepeat(Animation animation) {

		}

		/**
		 * 执行完动画去主界面
		 */
		@Override
		public void onAnimationEnd(Animation animation) {
			Intent intent = new Intent(SplashActivity.this, MainActivity.class);
			startActivity(intent);
			finish();
		}
	};

	/**
	 * 屏蔽返回键
	 */
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return false;
	}
}
