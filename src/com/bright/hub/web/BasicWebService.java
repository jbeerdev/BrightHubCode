package com.bright.hub.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class BasicWebService{

	DefaultHttpClient httpClient;
	HttpContext localContext;
	String returnedValue;

	HttpResponse response = null;
	HttpPost httpPost = null;
	HttpGet httpGet = null;
	String webServiceUrl;

	public BasicWebService(String serviceName){
		HttpParams myParams = new BasicHttpParams();

		HttpConnectionParams.setConnectionTimeout(myParams, 10000);
		HttpConnectionParams.setSoTimeout(myParams, 10000);
		httpClient = new DefaultHttpClient(myParams);
		localContext = new BasicHttpContext();
		webServiceUrl = serviceName;

	}
	
	public String webGet(String methodName, Map<String, String> params) {
		String getUrl = webServiceUrl + methodName;

		getUrl = generateUrl(params, getUrl);

		httpGet = new HttpGet(getUrl);
		Log.e("WebGetURL: ",getUrl);
		try {
			response = httpClient.execute(httpGet);
			returnedValue = EntityUtils.toString(response.getEntity());
		} catch (IOException e) {
			Log.e("WebService:", " Messaje " +  e.getMessage());
		} catch (Exception e) {
			Log.e("WebService:", " Messaje " + e.getMessage());
		}

		return returnedValue;
	}

	private String generateUrl(Map<String, String> params, String getUrl) {
		int i = 0;
		for (Map.Entry<String, String> param : params.entrySet())
		{
			if(i == 0){
				getUrl += "?";
			}
			else{
				getUrl += "&";
			}

			try {
				getUrl += param.getKey() + "=" + URLEncoder.encode(param.getValue(),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			i++;
		}
		return getUrl;
	}
}