package com.example.croptheimage;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.security.auth.PrivateCredentialPermission;
import come.example.base.UIBase;
import come.example.util.Util;
import net.simonvt.numberpicker.NumberPicker;
import android.R.integer;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
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
	public static Bitmap quession;
	/*
	 * private ImageView imageView1; private ImageView imageView2; private
	 * ImageView imageView3; private ImageView imageView4
	 */
	private ImageView no1, no2;
	private Bitmap chooseimage1;
	private Bitmap chooseimage2;
	private int choose_id1;
	private int choose_id2;
	private int choose = 0;
	private int i1;
	private Long startTime;
	private Handler handler = new Handler();
	private final String TAG = "MainActivity";
	int random;
//	int[] image_group = { R.drawable.fourteen,
//			R.drawable.hundredseventynine, R.drawable.sixtynine,
//			R.drawable.threeseventyeight };
	//int[] answer_group = {14,179,69,378};//圖庫對應答案
	TextView textView;
	NumberPicker np1,np2,np3;
	Long reciprocal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 沒有收到圖片 就返回上一畫面
		if (quession == null) {
			finish();
			return;
		}
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
//		random = (int) (Math.random() * image_group.length);
		Random r = new Random();
		i1 = r.nextInt(999 - 1) + 1;//圖片預畫上的隨機數字(1~999)
		String RandomIntToImage = String.valueOf(i1);
		//****物件指派部分****
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
		print_random.add(R.id.imageView16);// 所有imageview的ID組
		// 取得目前時間
		startTime = System.currentTimeMillis();
		// 設定定時要執行的方法
		handler.removeCallbacks(updateTimer);
		// 設定Delay的時間
		handler.postDelayed(updateTimer, 1000);// 時間單位是毫秒
		//****切圖部分****
		splitImage(RandomIntToImage, print_random);
				
	}

	/**
	 * 圖片分割與隨機擺放處理
	 * @param RandomIntToImage
	 * @param print_random
	 */
	private void splitImage(String RandomIntToImage,
			ArrayList<Integer> print_random) {
		int total_num = print_random.size();
		double num = Math.pow(total_num, 0.5);
		if (Util.isInteger(num)) {
			int oneD_num = (int) num;
			int sw = 0;// 切圖起使位址(X軸)
			int sh = 0;// 切圖起使位址(Y軸)
			Bitmap origialBitmap = drawTextToBitmap(this, quession, RandomIntToImage);
					//BitmapFactory.decodeResource(getResources(),image_group[random]);
			int width = origialBitmap.getWidth(); // 計算剩餘寬度
			int height = origialBitmap.getHeight(); //計算剩餘高度
			int w = 0; // 切割圖片的寬度
			int h = 0; // 切割圖片的高度
			int colIndex; // 用於迴圈中紀錄欄
			int rowIndex = 0; // 用於迴圈中紀錄列
			for (int cut_no = 0; cut_no < total_num ; cut_no++) {
				
				colIndex = cut_no % oneD_num;
				Util.logD("MainActivity", "width:" + width + ", height:" + height);
				// 切割圖片的高度、寬度計算
				h = height / (oneD_num - rowIndex);
				if (colIndex == 0 && cut_no != 0) {
					sw = 0;
					sh = sh + h;
					width = origialBitmap.getWidth();
					rowIndex ++;
					height -= h;
				}
				w = width / (oneD_num - colIndex);
				width -= w;
				Util.logD("MainActivity", "cut_no:" + cut_no + 
						", colIndex: " + colIndex + 
						", w: " + w + 
						", h: " + h);
				Bitmap cutBitmap = Bitmap.createBitmap(origialBitmap, sw, sh, w, h);// 前兩是原圖起始座標,後兩個是需求截圖的大小
				sw = sw + w;
				//Log.i(TAG, "--" + sw + "--" + w);
				// 切割圖片後，將圖片依亂數做擺放
				int random1 = (int) (Math.random() * print_random.size());
				ImageView random_cutimage = (ImageView) findViewById(print_random
						.get(random1));// 隨機取任何一個imageview來呈現第一次切割的圖
				random_cutimage.setImageBitmap(cutBitmap);
				print_random.remove(random1);
			}

		} else {
			Util.showDialog(this, "圖片處理程序錯誤:無法生成拼圖。");
		}
	}
		
	/**
	 * 	圖片畫上隨機數字部分
	 * @param gContext
	 * @param gbmp
	 * @param gText
	 * @return
	 */
	public Bitmap drawTextToBitmap(Context gContext, Bitmap gBitmap, String gText) {
		Resources resources = gContext.getResources();
		float scale = resources.getDisplayMetrics().density;
		//Bitmap bitmap = BitmapFactory.decodeResource(resources, gResId);
        Bitmap bitmap = gBitmap;
		android.graphics.Bitmap.Config bitmapConfig = bitmap.getConfig();
		// set default bitmap config if none
		if (bitmapConfig == null) {
			bitmapConfig = android.graphics.Bitmap.Config.ARGB_8888;
		}
		// resource bitmaps are imutable,
		// so we need to convert it to mutable one
		bitmap = bitmap.copy(bitmapConfig, true);

		Canvas canvas = new Canvas(bitmap);
		// new antialised Paint
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		// text color - #3D3D3D
		paint.setColor(Color.rgb(110, 110, 110));
		// text size in pixels
		paint.setTextSize((int) (230 * scale));
		// text shadow
		paint.setShadowLayer(1f, 0f, 1f, Color.DKGRAY);

		// draw text to the Canvas center
		Rect bounds = new Rect();
		paint.getTextBounds(gText, 0, gText.length(), bounds);
		int x = (bitmap.getWidth() - bounds.width()) / 6;
		int y = (bitmap.getHeight() + bounds.height()) / 5;

		canvas.drawText(gText, x * scale, y * scale, paint);

		return bitmap;
	}

	/**
	 * ImageView點選觸處發事件部分
	 * @author 
	 *
	 */
	private class ImageViewListener implements OnClickListener {
		@SuppressLint("NewApi")
		public void onClick(View v) {
			choose++;
			if (choose % 2 == 1) {
				choose_id1 = v.getId();
				// Log.i(TAG, "--"+id1);
				no1 = (ImageView) findViewById(choose_id1);
				no1.setBackgroundResource(R.drawable.selected_border);
				chooseimage1 = ((BitmapDrawable) no1.getDrawable()).getBitmap();// 從ImageView裡取得Image
			}
			if (choose % 2 == 0) {
				choose_id2 = v.getId();
				// Log.i(TAG, "--"+id2);
				no1.setBackgroundResource(R.drawable.unselected_border);
				no1.setBackgroundColor(Color.TRANSPARENT);
				no2 = (ImageView) findViewById(choose_id2);
				chooseimage2 = ((BitmapDrawable) no2.getDrawable()).getBitmap();
				no1.setImageBitmap(chooseimage2);
				no2.setImageBitmap(chooseimage1);
			}

		}
	}
	
	/**
	 * 作答部分
	 * @author 
	 *
	 */
	private class ButtonListener implements OnClickListener{
		public void onClick(View v){
			int bit = np3.getValue();
			int ten = np2.getValue()*10;
			int hundred = np1.getValue()*100;
			int give_answer = bit+ten+hundred;
			Log.i(TAG,"-->"+give_answer);
			//Log.i(TAG,"---"+answer_group[random]);
		if(give_answer==i1&&reciprocal>0){
			textView.setText("恭喜答對了!!");
		}
		if(give_answer!=i1||reciprocal==0){
			textView.setText("解圖失敗!!");
		}
		}
	}

	/**
	 * 時間倒數部分
	 */
	private Runnable updateTimer = new Runnable() {
		public void run() {
			final TextView time = (TextView) findViewById(R.id.timer);
			Long spentTime = System.currentTimeMillis() - startTime;
			// 計算目前已過分鐘數
			// Long minius = (spentTime / 1000) / 60;
			// 計算目前已過秒數
			Long seconds = (spentTime / 1000);
			reciprocal = 60 - seconds;
			time.setText("計時: " + reciprocal);
			handler.postDelayed(this, 1000);
			if (reciprocal <= 0) {
				time.setText("計時: 0");
			}
		}
	};

}
