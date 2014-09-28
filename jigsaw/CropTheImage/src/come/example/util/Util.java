/**
 * 
 */
package come.example.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;

/**
 * 共用工具類
 * @author kawachi
 *
 */
public class Util {

	public static AlertDialog showDialog(Context context, String msg) {
		AlertDialog.Builder aDB = new AlertDialog.Builder(context);
		aDB.setMessage(msg);
		aDB.setNegativeButton("OK", new OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				
			}
			
		});
		return aDB.create();
	}
	
	public static void logD(String tag, String msg) {
		Log.d(tag, msg);
	}
	
	/**
	 * 判斷輸入的數字是否含有小數點
	 * @param input
	 * @return
	 */
	public static boolean isInteger(double input) {
		if (input % 2 == 0 || input % 2 == 1) {
			return true;
		} else {
			return false;
		}
		
	}

}
