package com.bright.hub.bluetooth;

import android.bluetooth.BluetoothAdapter;

public class BluetoothExamples {
	
	
	
	public static void startBluetooth(){
		
		BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
		btAdapter.enable();		
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
