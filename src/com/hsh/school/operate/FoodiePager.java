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
 * @author ���� E-mail: 908716835@qq.com
 * @date ����ʱ�䣺2015-8-2 ����3:04:54
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
	 * @Description: ��ʼ������
	 * @Author: �����ˣ����ߣ�
	 * @Version: V1.00 ���汾�ţ�
	 * @Create Date: 2015-8-2 ����3:05:52 ���������ڣ�
	 * @Parameters: LayoutInflater inflater ���������
	 * @Return: View
	 */
	@Override
	public View initView(LayoutInflater inflater) {
		view = inflater.inflate(R.layout.setting_fragment, null);
		titleName = (TextView) view.findViewById(R.id.titleName);
		titleName.setText("�Ի���");
		ImageView ivBack = (ImageView) view.findViewById(R.id.back);
		ivBack.setVisibility(View.GONE);
		im_sliding = (ImageView) view.findViewById(R.id.im_sliding);
		im_sliding.setOnClickListener(this);
		return view;
	}

	/**
	 * @Name: initData
	 * @Description: ��ʼ������
	 * @Author: �����ˣ����ߣ�
	 * @Version: V1.00 ���汾�ţ�
	 * @Create Date: 2015-8-2 ����3:05:52 ���������ڣ�
	 * @Parameters: ��
	 * @Return: ��
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
