package com.bright.hub.background;

import java.lang.reflect.Type;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;

import com.bright.hub.R;
import com.bright.hub.web.BasicWebService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class WebServiceActivity extends ListActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alertas_list);

		BasicWebService webService = new BasicWebService("http://www.sumasoftware.com/alerts/GetAlerts.php");
		String response = webService.webGet();

		try{
			Type collectionType = new TypeToken<List<Alertas>>(){}.getType();
			List<Alertas> alertas = new Gson().fromJson(response, collectionType);
			AlertasAdapter ad = new AlertasAdapter(this, alertas);
			this.setListAdapter(ad);		

		}catch(Exception e){
			Log.d("Error: ", e.getMessage());
		}
	}

}


