package com.example.croptheimage;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.Bundle;
import android.view.View;
import come.example.base.UIBase;
import come.example.dataobject.MissionData;
import come.example.service.TelegramService;
import come.example.util.Util;

/**
 * The home page of the application.
 * @author kawachi
 *
 */
public class Home extends UIBase {

//	String getAllUrl = "http://192.168.100.100:8080/CI_System/api/mission/get_all";
	String getAllUrl = "http://ec2-54-64-121-65.ap-northeast-1.compute.amazonaws.com/CI_System/api/mission/get_all";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
	}

	@Override
	protected void onStart() {
		super.onStart();
		// register listener
		findViewById(R.id.tutorial).setOnClickListener(this);
		findViewById(R.id.start_game).setOnClickListener(this);
		findViewById(R.id.about).setOnClickListener(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// dismiss listener
		findViewById(R.id.tutorial).setOnClickListener(null);
		findViewById(R.id.start_game).setOnClickListener(null);
		findViewById(R.id.about).setOnClickListener(null);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		switch (view.getId()) {
		    case R.id.tutorial:
			    break;
		    case R.id.start_game:
		    	TelegramService telegramTask = new TelegramService(this);
		    	telegramTask.execute(getAllUrl);
		    	
			    break;
		    case R.id.about:
			    break;
			default:
				break;
			
		}
	}

	@Override
	public boolean onParseResponse(String response) {
		super.onParseResponse(response);
		try {
			JSONObject jObj = new JSONObject(response);
			missionList = new ArrayList<MissionData>();
			if (jObj.getBoolean("success")) {
				JSONArray missionArray = jObj.getJSONArray("mission");
				if (missionArray.length() >0) {
					for (int i = 0; i < missionArray.length(); i++) {
						JSONObject object = missionArray.getJSONObject(i);
						MissionData mData = new MissionData();
						mData.setId(object.getInt("id"));
						mData.setName(object.getString("name"));
						mData.setImageUrl(object.getString("image_url"));
						mData.setCostPoint(object.getInt("cost_point"));
						mData.setPrizePoint(object.getInt("prize_point"));
						mData.setHardLvl(object.getInt("hard_level"));
						missionList.add(mData);
						
					}
					// 前往關卡選擇畫面
			    	actClearAndTop(SelectMission.class);
			    	return true;
				} else {
					Util.showDialog(this, "取得0筆資料。").show();
				}
				
			} else {
				Util.showDialog(this, "取得資料失敗。").show();
			}
			
		} catch (JSONException e) {
			Util.showDialog(this, "資料解析錯誤。").show();
			e.printStackTrace();
		}
		return false;
		
	}

	
	
}
