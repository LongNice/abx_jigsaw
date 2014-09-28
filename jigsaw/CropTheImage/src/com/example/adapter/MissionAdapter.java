package com.example.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.croptheimage.R;
import come.example.dataobject.MissionData;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MissionAdapter extends BaseAdapter {

	private ArrayList<MissionData> list=null;
	private LayoutInflater mInflater;
	private Context context;
	
	public MissionAdapter (Context context, ArrayList<MissionData> list) {
		this.context = context;
		this.mInflater = LayoutInflater.from(context);
		this.list = list;
	}
	
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewTag viewTag;
		if(convertView == null){
			convertView = mInflater.inflate(R.layout.select_mission_list, null);
			viewTag = new ViewTag(
					(TextView) convertView.findViewById(R.id.sml_text_mission_name),
					(TextView) convertView.findViewById(R.id.sml_text_hard),
					(TextView) convertView.findViewById(R.id.sml_text_challenge_point),
					(TextView) convertView.findViewById(R.id.sml_text_award_point)
					);
			convertView.setTag(viewTag);
		} else {
			viewTag = (ViewTag) convertView.getTag();
		}
		// set the information of mission.
		viewTag.txtMission.setText(list.get(position).getName());
		viewTag.txtHard.setText(String.valueOf(list.get(position).getHardLvl()));
		viewTag.txtChallengePoint.setText(String.valueOf(list.get(position).getCostPoint()));
		viewTag.txtAwardPoint.setText(String.valueOf(list.get(position).getPrizePoint()));
		
		return convertView;
	}

	class ViewTag{
		TextView txtMission;
		TextView txtHard;
		TextView txtChallengePoint;
		TextView txtAwardPoint;
    
        public ViewTag(TextView txtMission, TextView txtHard,
        		TextView txtChallengePoint, TextView txtAwardPoint){
            this.txtMission = txtMission;
            this.txtHard = txtHard;
            this.txtChallengePoint = txtChallengePoint;
            this.txtAwardPoint = txtAwardPoint;
        }
	}
}
