/**
 * 
 */
package come.example.service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import come.example.util.Util;

import android.util.Log;

/**
 * @author kawachi
 *
 */
public class HttpClientService {
	
	public static String doGetRequest(String url, String params) {
		String result =""; 
        HttpClient client = new DefaultHttpClient();
        String uri = url;
        if (params != "") {
        	uri = uri + "?" + params;
        }
        Log.d("httpClient", "uri: " + uri);
        HttpGet request = new HttpGet(uri);
        HttpResponse response;
        try {
            response = client.execute(request);
            Util.logD("httpClient", "httpClient is executed.");
            // 取得狀態碼
            int statusCode = response.getStatusLine().getStatusCode();
            // 取得response
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
            // 釋放資源
            entity.consumeContent();
            // 結束Client
            client.getConnectionManager().shutdown();
            
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        return result;
    }

}
