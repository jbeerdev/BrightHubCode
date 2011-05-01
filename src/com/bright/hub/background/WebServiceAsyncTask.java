package com.bright.hub.background;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.AsyncTask;
import android.util.Log;

import com.bright.hub.web.BasicWebService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class WebServiceAsyncTask extends AsyncTask<Object, Boolean, String> {

	WebServiceBackgroundActivity callerActivity;
	
	
	@Override
	protected String doInBackground(Object... params) {	
		String serviceUrl = (String) params[0];
		callerActivity = (WebServiceBackgroundActivity) params[1];
		
		BasicWebService webService = new BasicWebService(serviceUrl);
		Map<String, String> serviceParams = new HashMap<String, String>();
		serviceParams.put("var", "");	
		return webService.webGet("", serviceParams);
	}

	@Override
	protected void onPostExecute(String response) {
		try
		{
			Type collectionType = new TypeToken<List<Alertas>>(){}.getType();
			List<Alertas> alertas = new Gson().fromJson(response, collectionType);
			callerActivity.populateListWithAlerts(alertas);
		}
		catch(Exception e)
		{
			Log.d("Error: ", e.getMessage());
		}
		super.onPostExecute(response);
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
	}
	
	

}
