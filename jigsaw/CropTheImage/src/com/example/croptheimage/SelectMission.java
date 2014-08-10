package com.example.croptheimage;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.adapter.MissionAdapter;
import android.widget.AdapterView;
import android.os.Bundle;
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

		actClearAndTop(MainActivity.class);
	}

	
}
