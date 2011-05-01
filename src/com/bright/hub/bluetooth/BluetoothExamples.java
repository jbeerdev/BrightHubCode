package com.bright.hub.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.util.Log;

public class BluetoothExamples {



	public static void startBluetooth(){
		try{
			BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
			btAdapter.enable();
		}catch(NullPointerException ex){
			Log.e("Bluetooth","Device not avaliable");
		}
	}

	public static void stopBluetooth(){

		BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
		btAdapter.disable();
	}

	public static boolean isBluetoothEnabled(){
		BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
		return btAdapter.isEnabled();
	}

}
