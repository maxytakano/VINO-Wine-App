package com.yoloswag.vino;

import java.io.IOException;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/** A basic Camera preview class */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
	private SurfaceHolder mHolder;
	private Camera mCamera;

	public CameraPreview(Context context, Camera camera) {
		super(context);
		mCamera = camera;

		// Install a SurfaceHolder.Callback so we get notified when the
		// underlying surface is created and destroyed.
		mHolder = getHolder();
		mHolder.addCallback(this);
		// deprecated setting, but required on Android versions prior to 3.0
		mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}

	public void surfaceCreated(SurfaceHolder holder) {
		// The Surface has been created, now tell the camera where to draw the preview.
		try {
			mCamera.setPreviewDisplay(holder);
			mCamera.startPreview();
		} catch (IOException e) {
			Log.d("OH NO", "Error setting camera preview: " + e.getMessage());
		}
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		// empty. Take care of releasing the Camera preview in your activity.

		// Surface will be destroyed when we return, so stop the preview.
		if (mCamera != null) {
			/*
    	          Call stopPreview() to stop updating the preview surface.
			 */
			//mCamera.stopPreview();
		}
		
		stopPreviewAndFreeCamera();
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
		// If your preview can change or rotate, take care of those events here.
		// Make sure to stop the preview before resizing or reformatting it.

		if (mHolder.getSurface() == null){
			// preview surface does not exist
			return;
		}

		// stop preview before making changes
		try {
			mCamera.stopPreview();
		} catch (Exception e){
			// ignore: tried to stop a non-existent preview
		}

		// set preview size and make any resize, rotate or
		// reformatting changes here

		// start preview with new settings
		try {
			mCamera.setPreviewDisplay(mHolder);
			mCamera.startPreview();

		} catch (Exception e){
			Log.d("OH NO", "Error starting camera preview: " + e.getMessage());
		}

		// Set camera properties first
		Camera.Parameters parameters = mCamera.getParameters();
		parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
		mCamera.setParameters(parameters);

		mCamera.startPreview();

		mCamera.autoFocus(null);
	}
	
	/**
	  * When this function returns, mCamera will be null.
	  */
	private void stopPreviewAndFreeCamera() {

	    if (mCamera != null) {
	        /*
	          Call stopPreview() to stop updating the preview surface.
	        */
	        //mCamera.stopPreview();
	    
	        /*
	          Important: Call release() to release the camera for use by other applications. 
	          Applications should release the camera immediately in onPause() (and re-open() it in
	          onResume()).
	        */
	        mCamera.release();
	    
	        mCamera = null;
	    }
	}
}

