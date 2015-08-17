package com.hsh.school.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hsh.school.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

/**
 * @author ���� E-mail: 908716835@qq.com
 * @date ����ʱ�䣺2015-8-2 ����2:48:24
 * @version 1.0
 */
public class FastEntryFragment extends Fragment {

	private static final String TAG = "FastEntryFragment";
	private View view;
	private ListView lv_menu;
	private Message msg;
	public SlidingMenu sm;
	private static final String menus[] = { "�㻹δ��½","������","�Ի���","��Ʊ","����СQ","����", "�������", "������", "��������" };
	private static final int LOGIN = 0;// ����Ƿ��½
	private static final int SOFT_INFO = 1;// �������
	private static final int CHECK_UPDATE = 2;// ������
	private static final int ABOUT_US = 3;// ��������

	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {
		@SuppressLint("ShowToast")
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case LOGIN:// ����Ƿ��½
				Toast.makeText(getActivity(), "����Ƿ��½", 1).show();
				break;
			case SOFT_INFO:// �������
				Toast.makeText(getActivity(), "�������", 1).show();
				break;
			case CHECK_UPDATE:// ������
				Toast.makeText(getActivity(), "������", 1).show();
				break;
			case ABOUT_US:// ��������
				Toast.makeText(getActivity(), "��������", 1).show();
				break;
			}
		}
	};

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.i(TAG, "onActivityCreated");
		sm = ((SlidingFragmentActivity) getActivity()).getSlidingMenu();
		initViews();
	}

	private void initViews() {
		lv_menu = (ListView) view.findViewById(R.id.lv_menu);
		lv_menu.setAdapter(new MenuAdapter());
		lv_menu.setOnItemClickListener(new OnItemClickListener() {
			@SuppressLint("ShowToast")
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String m = menus[position];
				if (m.equals("�㻹δ��½")) {
					msg = new Message();
					msg.what = LOGIN;
					handler.sendMessage(msg);
				} else if (m.equals("�������")) {
					msg = new Message();
					msg.what = SOFT_INFO;
					handler.sendMessage(msg);
				} else if (m.equals("������")) {
					msg = new Message();
					msg.what = CHECK_UPDATE;
					handler.sendMessage(msg);
				} else if (m.equals("��������")) {
					msg = new Message();
					msg.what = ABOUT_US;
					handler.sendMessage(msg);
				} 
				sm.toggle();
			}
		});
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i(TAG, "onCreate");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i(TAG, "onCreateView");
		view = LayoutInflater.from(getActivity()).inflate(
				R.layout.fastentry_fragment, null);
		return view;
	}

	/**
	 * ���˵�adapter
	 */
	private class MenuAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return menus.length;
		}

		@Override
		public Object getItem(int position) {
			return menus[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = View.inflate(getActivity(), R.layout.sliding_menu_item,
					null);
			TextView tv = (TextView) view.findViewById(R.id.tv_menu_name);
			tv.setText(menus[position]);
			return view;
		}

	}
}
