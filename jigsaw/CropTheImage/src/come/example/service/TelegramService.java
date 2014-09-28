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
        // ����Ū����ܮ�
        this.progressDialog = new ProgressDialog(context);

        // �]�wŪ����ܮؤ�r
        this.progressDialog.setMessage("Ū����...");

        // ���Ū����ܮ�
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
		// �p�G��ܮجO��ܪ��A�h������ܮ�
        if (progressDialog != null) {
        	if (progressDialog.isShowing()) {
        		progressDialog.dismiss();
        	}
        }
        if (response == null) {
        	Util.showDialog(this.context, "�����L����!���ˬd�s�u�P�������A��A�A�����հ���C").show();
        	Util.logD("onPostExecute", "response is null");
        	return;
        } else if (response == PARAM_IS_NULL) {
        	Util.showDialog(this.context, "�L�����ѼƩΰѼƿ��~�C").show();
        	return;
        }
        boolean result = telegramInterface.onParseResponse(response);
	}
	
}
