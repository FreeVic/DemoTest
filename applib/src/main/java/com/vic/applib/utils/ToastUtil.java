/**
 * 
 */
package com.vic.applib.utils;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;

import com.vic.applib.GlobalApplication;

public class ToastUtil {
	public static Toast toast = Toast.makeText(GlobalApplication.getApplication(),"",Toast.LENGTH_SHORT);

	public static void show(Context context, String info) {
		toast.setText(info);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.show();
	}
	
	public static void show(String info){
		toast.setText(info);
		toast.setDuration(Toast.LENGTH_SHORT);
		toast.show();
	}
	public static void show(int resId){
		Toast.makeText(GlobalApplication.getApplication(), resId, Toast.LENGTH_SHORT).show();
	}

	public static void show(Context context, int info) {
		Toast.makeText(context, info, Toast.LENGTH_LONG).show();
	}

	public static String getStringResourse(int resId){
		try{
			return GlobalApplication.getApplication().getResources().getString(resId);
		}catch(Resources.NotFoundException e){
			return "";
		}
	}

	public static String[] getStringArray(int resId){
		try{
			return GlobalApplication.getApplication().getResources().getStringArray(resId);
		}catch(Resources.NotFoundException e){
			return null;
		}
	}
}
