package com.bright.hub.web;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class BasicWebService{

	DefaultHttpClient httpClient;
	String returnedValue;

	HttpResponse response = null;
	HttpGet httpGet = null;
	String webServiceUrl;

	public BasicWebService(String serviceName){
		HttpParams myParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(myParams, 10000);
		httpClient = new DefaultHttpClient();
		webServiceUrl = serviceName;

	}
	
	public String webGet() {
		httpGet = new HttpGet(webServiceUrl);
		Log.e("WebGetURL: ",webServiceUrl);
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
}