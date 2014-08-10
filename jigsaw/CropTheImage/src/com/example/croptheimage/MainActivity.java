package com.example.croptheimage;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.security.auth.PrivateCredentialPermission;

import come.example.base.UIBase;

import net.simonvt.numberpicker.NumberPicker;

import android.R.integer;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.*;
import android.view.View;

public class MainActivity extends UIBase {
	/*
	 * private ImageView imageView1; private ImageView imageView2; private
	 * ImageView imageView3; private ImageView imageView4
	 */;
	private ImageView no1, no2;
	private Bitmap chooseimage1;
	private Bitmap chooseimage2;
	private int choose_id1;
	private int choose_id2;
	private int choose = 0;
	private Long startTime;
	private Handler handler = new Handler();
	private final String TAG = "MainActivity";
	int random;
	int[] image_group = { R.drawable.fourteen,
			R.drawable.hundredseventynine, R.drawable.sixtynine,
			R.drawable.threeseventyeight };
	int[] answer_group = {14,179,69,378};//�Ϯw��������
	TextView textView;
	NumberPicker np1,np2,np3;
	Long reciprocal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		np1 = (NumberPicker) findViewById(R.id.numberPicker1);
		np1.setMaxValue(9);
		np1.setMinValue(0);
		np1.setFocusable(true);
		np1.setFocusableInTouchMode(true);
		np2 = (NumberPicker) findViewById(R.id.numberPicker2);
		np2.setMaxValue(9);
		np2.setMinValue(0);
		np2.setFocusable(true);
		np2.setFocusableInTouchMode(true);
		np3 = (NumberPicker) findViewById(R.id.numberPicker3);
		np3.setMaxValue(9);
		np3.setMinValue(0);
		np3.setFocusable(true);
		np3.setFocusableInTouchMode(true);
		random = (int) (Math.random() * image_group.length);
		
		//****�����������****
		textView = (TextView)this.findViewById(R.id.textView1);
		ImageView imageView1 = (ImageView) this.findViewById(R.id.imageView1);
		imageView1.setOnClickListener(new ImageViewListener());
		ImageView imageView2 = (ImageView) this.findViewById(R.id.imageView2);
		imageView2.setOnClickListener(new ImageViewListener());
		ImageView imageView3 = (ImageView) this.findViewById(R.id.imageView3);
		imageView3.setOnClickListener(new ImageViewListener());
		ImageView imageView4 = (ImageView) this.findViewById(R.id.imageView4);
		imageView4.setOnClickListener(new ImageViewListener());
		ImageView imageView5 = (ImageView) this.findViewById(R.id.imageView5);
		imageView5.setOnClickListener(new ImageViewListener());
		ImageView imageView6 = (ImageView) this.findViewById(R.id.imageView6);
		imageView6.setOnClickListener(new ImageViewListener());
		ImageView imageView7 = (ImageView) this.findViewById(R.id.imageView7);
		imageView7.setOnClickListener(new ImageViewListener());
		ImageView imageView8 = (ImageView) this.findViewById(R.id.imageView8);
		imageView8.setOnClickListener(new ImageViewListener());
		ImageView imageView9 = (ImageView) this.findViewById(R.id.imageView9);
		imageView9.setOnClickListener(new ImageViewListener());
		ImageView imageView10 = (ImageView) this.findViewById(R.id.imageView10);
		imageView10.setOnClickListener(new ImageViewListener());
		ImageView imageView11 = (ImageView) this.findViewById(R.id.imageView11);
		imageView11.setOnClickListener(new ImageViewListener());
		ImageView imageView12 = (ImageView) this.findViewById(R.id.imageView12);
		imageView12.setOnClickListener(new ImageViewListener());
		ImageView imageView13 = (ImageView) this.findViewById(R.id.imageView13);
		imageView13.setOnClickListener(new ImageViewListener());
		ImageView imageView14 = (ImageView) this.findViewById(R.id.imageView14);
		imageView14.setOnClickListener(new ImageViewListener());
		ImageView imageView15 = (ImageView) this.findViewById(R.id.imageView15);
		imageView15.setOnClickListener(new ImageViewListener());
		ImageView imageView16 = (ImageView) this.findViewById(R.id.imageView16);
		imageView16.setOnClickListener(new ImageViewListener());
		Button button = (Button)this.findViewById(R.id.button1);
		button.setOnClickListener(new ButtonListener());
		ArrayList<Integer> print_random = new ArrayList<Integer>();
		print_random.add(R.id.imageView1);
		print_random.add(R.id.imageView2);
		print_random.add(R.id.imageView3);
		print_random.add(R.id.imageView4);
		print_random.add(R.id.imageView5);
		print_random.add(R.id.imageView6);
		print_random.add(R.id.imageView7);
		print_random.add(R.id.imageView8);
		print_random.add(R.id.imageView9);
		print_random.add(R.id.imageView10);
		print_random.add(R.id.imageView11);
		print_random.add(R.id.imageView12);
		print_random.add(R.id.imageView13);
		print_random.add(R.id.imageView14);
		print_random.add(R.id.imageView15);
		print_random.add(R.id.imageView16);// �Ҧ�imageview��ID��
		// ���o�ثe�ɶ�
		startTime = System.currentTimeMillis();
		// �]�w�w�ɭn���檺��k
		handler.removeCallbacks(updateTimer);
		// �]�wDelay���ɶ�
		handler.postDelayed(updateTimer, 1000);// �ɶ����O�@��
		
		//****���ϳ���****
		int sw = 0;// ���ϰ_�Ϧ�}(X�b)
		int sh = 0;// ���ϰ_�Ϧ�}(Y�b)
		Bitmap origialBitmap = BitmapFactory.decodeResource(getResources(),
				image_group[random]);
		int w = origialBitmap.getWidth() / 4;
		int h = origialBitmap.getHeight() / 4;
		for (int cut_no = 0; cut_no <= 15; cut_no++) {

			if (sw == origialBitmap.getWidth()) {
				sw = 0;
				sh = sh + h;

			}

			Bitmap cutBitmap = Bitmap.createBitmap(origialBitmap, sw, sh, w, h);// �e��O��ϰ_�l�y��,���ӬO�ݨD�I�Ϫ��j�p
			Log.i(TAG, "--" + sw + "--" + w);
			int random1 = (int) (Math.random() * print_random.size());
			ImageView random_cutimage = (ImageView) findViewById(print_random
					.get(random1));// �H��������@��imageview�ӧe�{�Ĥ@�����Ϊ���
			random_cutimage.setImageBitmap(cutBitmap);
			print_random.remove(random1);
			sw = sw + w;

		}
		
	}
		
	
	//****ImgageView�I��B�o�ƥ󳡤�****
	private class ImageViewListener implements OnClickListener {
		@SuppressLint("NewApi")
		public void onClick(View v) {
			choose++;
			if (choose % 2 == 1) {
				choose_id1 = v.getId();
				// Log.i(TAG, "--"+id1);
				no1 = (ImageView) findViewById(choose_id1);
				no1.setBackgroundResource(R.drawable.selected_border);
				chooseimage1 = ((BitmapDrawable) no1.getDrawable()).getBitmap();// �qImageView�̨��oImage
			}
			if (choose % 2 == 0) {
				choose_id2 = v.getId();
				// Log.i(TAG, "--"+id2);
				no1.setBackgroundColor(Color.TRANSPARENT);
				no2 = (ImageView) findViewById(choose_id2);
				chooseimage2 = ((BitmapDrawable) no2.getDrawable()).getBitmap();
				no1.setImageBitmap(chooseimage2);
				no2.setImageBitmap(chooseimage1);
			}
			
	}
	}
	
	//****�@������****
	private class ButtonListener implements OnClickListener{
		public void onClick(View v){
			int bit = np3.getValue();
			int ten = np2.getValue()*10;
			int hundred = np1.getValue()*100;
			int give_answer = bit+ten+hundred;
			Log.i(TAG,"-->"+give_answer);
			Log.i(TAG,"---"+answer_group[random]);
		if(answer_group[random]==give_answer&&reciprocal>0){
			textView.setText("���ߵ���F!!");
		}
		if(answer_group[random]!=give_answer||reciprocal==0){
			textView.setText("�ѹϥ���!!");
		}
		}
	}
	//****�ɶ��˼Ƴ���****
	private Runnable updateTimer = new Runnable() {
		public void run() {
			final TextView time = (TextView) findViewById(R.id.timer);
			Long spentTime = System.currentTimeMillis() - startTime;
			// �p��ثe�w�L������
			// Long minius = (spentTime / 1000) / 60;
			// �p��ثe�w�L���
			Long seconds = (spentTime / 1000);
			reciprocal = 60 - seconds;
			time.setText("�p��: " + reciprocal);
			handler.postDelayed(this, 1000);
			if (reciprocal <= 0) {
				time.setText("�p��: 0");
			}
		}
	};

}
