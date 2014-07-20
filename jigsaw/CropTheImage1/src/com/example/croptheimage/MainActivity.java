package com.example.croptheimage;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.R.integer;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

public class MainActivity extends Activity {
	/*private ImageView imageView1;
	private ImageView imageView2;
	private ImageView imageView3;
	private ImageView imageView4*/;
	private ImageView no1, no2;
	private Bitmap chooseimage1;
	private Bitmap chooseimage2;
	private int choose_id1;
	private int choose_id2;
	private int choose = 0;
	private Long startTime;
	private Handler handler = new Handler();
	private final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		int[] image_group = {R.drawable.fourteen,R.drawable.hundredseventynine,R.drawable.sixtynine,R.drawable.threeseventyeight};
		int random = (int) (Math.random() * image_group.length);
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
		print_random.add(R.id.imageView16);//所有imageview的ID組
		//取得目前時間
		startTime = System.currentTimeMillis();
		//設定定時要執行的方法
		handler.removeCallbacks(updateTimer);
		//設定Delay的時間
		handler.postDelayed(updateTimer, 1000);//時間單位是毫秒
		int sw = 0;// 切圖起使位址(X軸)
		int sh = 0;// 切圖起使位址(Y軸)
		Bitmap origialBitmap = BitmapFactory.decodeResource(getResources(),
				image_group[random]);
		int w = origialBitmap.getWidth() / 4;
		int h = origialBitmap.getHeight() / 4;
		for (int cut_no = 0; cut_no <= 15; cut_no++) {
			
			if (sw == origialBitmap.getWidth()) {
				sw = 0;
				sh = sh + h;
				
			}
			
			Bitmap cutBitmap = Bitmap.createBitmap(origialBitmap, sw, sh, w, h);// 前兩是原圖起始座標,後兩個是需求截圖的大小
			Log.i(TAG,"--"+sw+"--"+w);
			random = (int) (Math.random() * print_random.size());		
			ImageView random_cutimage = (ImageView) findViewById(print_random.get(random));// 隨機取任何一個imageview來呈現第一次切割的圖
			random_cutimage.setImageBitmap(cutBitmap);
			print_random.remove(random);
			sw = sw + w;
			
		}

	}

	private class ImageViewListener implements OnClickListener {
		public void onClick(View v) {
			choose++;
			if (choose % 2 == 1) {
				choose_id1 = v.getId();
				// Log.i(TAG, "--"+id1);
				no1 = (ImageView) findViewById(choose_id1);
				chooseimage1 = ((BitmapDrawable) no1.getDrawable()).getBitmap();// 從ImageView裡取得Image
			}
			if (choose % 2 == 0) {
				choose_id2 = v.getId();
				// Log.i(TAG, "--"+id2);
				no2 = (ImageView) findViewById(choose_id2);
				chooseimage2 = ((BitmapDrawable) no2.getDrawable()).getBitmap();
				no1.setImageBitmap(chooseimage2);
				no2.setImageBitmap(chooseimage1);
			}
		}
	}

	private Runnable updateTimer = new Runnable() {
		public void run() {
			final TextView time = (TextView) findViewById(R.id.timer);
			Long spentTime = System.currentTimeMillis() - startTime;
			// 計算目前已過分鐘數
			Long minius = (spentTime / 1000) / 60;
			// 計算目前已過秒數
			Long seconds = (spentTime / 1000) % 60;
			time.setText("計時: "+minius + ":" + seconds);
			handler.postDelayed(this, 1000);
		}
	};


}
