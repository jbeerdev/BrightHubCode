package com.bright.hub.background;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bright.hub.R;

public class AlertasAdapter extends BaseAdapter {
	
	Context localContext;
	List<Alertas> elements;

	public AlertasAdapter(Context context, List<Alertas> alertasList) {

		localContext = context;
		elements = alertasList;
	}
	

	public int getCount() {

		return elements.size();
	}

	public Alertas getItem(int position) {

		return elements.get(position);
	}

	public long getItemId(int position) {

		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		TextView rowText = null;
		if (convertView == null) {
			rowText = (TextView) LayoutInflater.from(localContext).inflate(R.layout.alert_row, parent, false);
		} else {
			rowText = (TextView) convertView;
		}
		((TextView) rowText.findViewById(R.id.alert_text)).setText(elements.get(position).toString());
		
		return rowText; 
	}

}
