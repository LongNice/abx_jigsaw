package com.example.croptheimage;

import android.os.Bundle;
import android.view.View;
import come.example.base.UIBase;

/**
 * The home page of the application.
 * @author kawachi
 *
 */
public class Home extends UIBase {

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
		    	actClearAndTop(SelectMission.class);
		    	
			    break;
		    case R.id.about:
			    break;
			default:
				break;
			
		}
	}

	
	
}
