package com.bright.hub.preferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.bright.hub.R;

public class PreferencesActivity extends PreferenceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.layout.preference_screen);
		// Get the custom preference
		Preference customPref = (Preference) findPreference("customPref");
		customPref.setOnPreferenceClickListener(new OnPreferenceClickListener() {

			public boolean onPreferenceClick(Preference preference) {
				Toast.makeText(getBaseContext(),"Preferencia Personalizada pulsada",Toast.LENGTH_LONG).show();
				SharedPreferences customSharedPreference = getSharedPreferences("myCustomSharedPrefs", Activity.MODE_PRIVATE);
				SharedPreferences.Editor editor = customSharedPreference.edit();
				editor.putString("myCustomPref","click!");
				editor.commit();
				return true;
			}
		});
	}

	private void getPrefs() {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean CheckboxPreference = prefs.getBoolean("checkboxPref", true);
		String ListPreference = prefs.getString("listPref", "USA");
		String editTextPreference = prefs.getString("editTextPref","Nada, todo vacio");
		String ringtonePreference = prefs.getString("ringtonePref","DEFAULT_RINGTONE_URI");
		String secondEditTextPreference = prefs.getString("SecondEditTextPref","Nada dentro");
		SharedPreferences mySharedPreferences = getSharedPreferences("myCustomSharedPrefs", Activity.MODE_PRIVATE);
		String customPref = mySharedPreferences.getString("myCusomPref", "");
	}
}
