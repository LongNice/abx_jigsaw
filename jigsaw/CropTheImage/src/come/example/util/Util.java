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
 * �@�Τu����
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
	 * �P�_��J���Ʀr�O�_�t���p���I
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
