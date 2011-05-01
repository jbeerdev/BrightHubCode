package com.bright.hub.background;

import java.util.List;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;

import com.bright.hub.R;

public class WebServiceBackgroundActivity extends ListActivity{

	private static final String WEB_SERVICE_URL = "http://www.sumasoftware.com/alerts/GetAlerts.php";
	ProgressDialog dialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alertas_list);
		initializeDialog();
		startWebServiceTask();
		
	}

	private void startWebServiceTask() {
		WebServiceAsyncTask webServiceTask = new WebServiceAsyncTask();
		webServiceTask.execute(WEB_SERVICE_URL,this);
	}

	private void initializeDialog() {
		dialog = ProgressDialog.show(WebServiceBackgroundActivity.this, "", "LoadingData. Wait...", true);
		dialog.show();
	}
	
	public void populateListWithAlerts(List<Alertas> alertList){
		AlertasAdapter ad = new AlertasAdapter(this, alertList);
		this.setListAdapter(ad);	
		dialog.dismiss();
	}

}


