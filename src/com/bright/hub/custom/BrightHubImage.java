package com.bright.hub.custom;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bright.hub.R;

public class BrightHubImage extends LinearLayout implements OnLongClickListener{

	private CharSequence toastMessage;
	private CharSequence footNoteMessage;
	private Drawable image;
	private Context cxt;
	private TextView footNoteText;
	private ImageView brightImage;
	
	public BrightHubImage(Context context) {
		super(context);
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.bright_image,this);
		this.setOnLongClickListener(this);
		cxt = context;
		
	}

	public BrightHubImage(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.bright_image,this);
		
		this.setOnLongClickListener(this);
		cxt = context;
		
		/** We initialize the elements form our UI because we are going to modify them **/
		
		footNoteText = (TextView) findViewById(R.id.footnote);
		brightImage = (ImageView) findViewById(R.id.image);
		
		/** We get the attributes from the XML file attrs.xml **/
		TypedArray styleAttributes = context.obtainStyledAttributes(attrs, R.styleable.BrighHubImage);
		toastMessage = styleAttributes.getString(R.styleable.BrighHubImage_message_string);
		image = styleAttributes.getDrawable(R.styleable.BrighHubImage_bright_image);
		footNoteMessage = styleAttributes.getString(R.styleable.BrighHubImage_footnote_string);
		
		footNoteText.setText(footNoteMessage);
		brightImage.setBackgroundDrawable(image);

	}
	
	@Override
	public boolean onLongClick(View arg0) {
		
		Toast.makeText(cxt, toastMessage, Toast.LENGTH_LONG).show();
		
		return false;
	}
	

}
