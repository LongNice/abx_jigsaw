package come.example.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

public class UIBase extends Activity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		// remote title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

	}


	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		return super.dispatchKeyEvent(event);
	}


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Activity navigation by Intent.FLAG_ACTIVITY_CLEAR_TOP.
	 * @param cls
	 */
	public void actClearAndTop(Class<?> cls) {
    	Intent intent = new Intent(getApplicationContext(),cls);
	    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
    }

	
}
