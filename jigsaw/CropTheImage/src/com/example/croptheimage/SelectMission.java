package com.example.croptheimage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import com.example.adapter.MissionAdapter;
import android.widget.AdapterView;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import come.example.base.UIBase;


public class SelectMission extends UIBase implements AdapterView.OnItemClickListener{

	MissionAdapter missionAdapter;
	ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_mission);
		listView = (ListView) findViewById(R.id.selection_mission_listView);
	}

	@Override
	protected void onStart() {
		
		super.onStart();
		 
		ArrayList<HashMap<String,String>> mList =new ArrayList<HashMap<String,String>>();
		HashMap<String,String> mMap;
		
		// TODO fake data
		for(int i = 0; i < 10; i++) {
			mMap = new HashMap<String,String>();
			mMap.put("name", "Mission " + i);
			mMap.put("hard", "Level " + i);
			mMap.put("challenge", i + " P");
			mMap.put("award", i + " P");
			mList.add(mMap);
		}
		
		missionAdapter = new MissionAdapter(this, mList);
		listView.setAdapter(missionAdapter);
		listView.setOnItemClickListener(this);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		super.onClick(arg0);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

		// 啟動下載任務
		new LoadImageTask(this).execute("https://lh6.googleusercontent.com/-2_iKft2oye8/VAJ_yKcebiI/AAAAAAAAD0g/rkcCMwVLdjI/s553-no/DSC_0362.JPG");
		
	}

	/**
	 * 下載網址上的圖片
	 * @author kawachi
	 *
	 */
	class LoadImageTask extends AsyncTask<String, Integer, Bitmap> {

		Bitmap bitmap = null;
		private ProgressDialog progressDialog;
		private Context context;
		
		public LoadImageTask (Context context) {
			this.context = context;
		}
		
		@Override
	    protected void onPreExecute() {

	        // 產生讀取對話框
	        this.progressDialog = new ProgressDialog(context);

	        // 設定讀取對話框文字
	        this.progressDialog.setMessage("讀取中...");

	        // 顯示讀取對話框
	        this.progressDialog.show();

	        return;
	    }
		
		@Override
		protected Bitmap doInBackground(String... param) {
			InputStream inputStream = null;
			try {
                inputStream = new URL(param[0]).openStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            
			return bitmap;
		}
		
		@Override
	    protected void onPostExecute(Bitmap bp) {
	        super.onPostExecute(bp);
	        // 如果對話框是顯示狀態則關閉對話框
	        if (progressDialog != null) {
	        	if (progressDialog.isShowing()) {
	        		progressDialog.dismiss();
	        	}
	        }
	        
	        if (bp != null) {
	        	// 將下載好的圖存放起來
	        	MainActivity.quession = bp;
		        actClearAndTop(MainActivity.class);
		        Log.d("load", "image loading is ok!");
	        } else {
	        	Log.d("load", "image loading is NG!");
	        }
	    }
	}
}
