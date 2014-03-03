package com.yoloswag.vino.util;

import java.io.File;

import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import com.yoloswag.vino.model.Entry;

public class Util {

	/** Create a file Uri for saving an image or video */
	public static Uri getOutputMediaFileUri(){
	      return Uri.fromFile(Util.getOutputMediaFile());
	}
	
	/** Create a File for saving an image or video */
	public static File getOutputMediaFile() {
	    // To be safe, you should check that the SDCard is mounted
	    // using Environment.getExternalStorageState() before doing this.

	    File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
	              Environment.DIRECTORY_PICTURES), "VINO");
	    // This location works best if you want the created images to be shared
	    // between applications and persist after your app has been uninstalled.

	    // Create the storage directory if it does not exist
	    if (! mediaStorageDir.exists()){
	        if (! mediaStorageDir.mkdirs()){
	            Log.d("VINO", "failed to create directory");
	            return null;
	        }
	    }

	    // Create a media file name
	    //String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    String timeStamp = String.valueOf(Entry.getAll().length);
	    File mediaFile;
	    mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_"+ timeStamp + ".jpg");

	    return mediaFile;
	}
	
}
