/**
 * 
 */
package come.example.service;

import come.example.component.TelegramInterface;
import come.example.util.Util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

/**
 * @author kawachi
 *
 */
public class TelegramService extends AsyncTask<String, Integer, String> {

	private ProgressDialog progressDialog;
	private Context context;
	private TelegramInterface telegramInterface;
	private final String PARAM_IS_NULL = "pArAmIsNuLl";
	/**
	 * 
	 */
	public TelegramService(Activity act) {
		this.context = (Context) act;
		this.telegramInterface = (TelegramInterface) act; 
	}
	
	@Override
	protected void onPreExecute() {
        // 產生讀取對話框
        this.progressDialog = new ProgressDialog(context);

        // 設定讀取對話框文字
        this.progressDialog.setMessage("讀取中...");

        // 顯示讀取對話框
        this.progressDialog.show();

	}

	@Override
	protected String doInBackground(String... params) {
		String response = "";
		if (params[0] != null) {
			String url = params[0];
			String param = "";
			if (params.length > 1) {
				param = params[1];
			}
			response = HttpClientService.doGetRequest(url, param);
			Log.d("http", "response: " + response);
		} else {
			response = PARAM_IS_NULL;
		}
		
		return response;
	}

	@Override
	protected void onPostExecute(String response) {
		super.onPostExecute(response);
		// 如果對話框是顯示狀態則關閉對話框
        if (progressDialog != null) {
        	if (progressDialog.isShowing()) {
        		progressDialog.dismiss();
        	}
        }
        if (response == null) {
        	Util.showDialog(this.context, "網路無反應!請檢查連線與網路狀態後，再次嘗試執行。").show();
        	Util.logD("onPostExecute", "response is null");
        	return;
        } else if (response == PARAM_IS_NULL) {
        	Util.showDialog(this.context, "無網路參數或參數錯誤。").show();
        	return;
        }
        boolean result = telegramInterface.onParseResponse(response);
	}
	
}
