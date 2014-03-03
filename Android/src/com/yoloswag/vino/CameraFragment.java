package com.yoloswag.vino;

import java.io.File;
import java.io.FileOutputStream;

import com.yoloswag.vino.model.Entry;
import com.yoloswag.vino.newentry.NewEntryFragment;
import com.yoloswag.vino.util.Util;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class CameraFragment extends Fragment {

	protected static final String TAG = null;

	public static Camera getCameraInstance() {
		Camera c = null;
		try {
			c = Camera.open(); // attempt to get a Camera instance
		}
		catch (Exception e){
			// Camera is not available (in use or does not exist)
		}
		return c; // returns null if camera is unavailable
	}

	private Camera mCamera;
	private CameraPreview mPreview;

	@SuppressWarnings("deprecation")
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		// Create an instance of Camera
		mCamera = getCameraInstance();

		Camera.Parameters p = mCamera.getParameters();

		if (Integer.parseInt(Build.VERSION.SDK) >= 8)
			mCamera.setDisplayOrientation(90);
		else
		{
			if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
			{
				p.set("orientation", "portrait");
				p.set("rotation", 90);
			}
			if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
			{
				p.set("orientation", "landscape");
				p.set("rotation", 90);
			}
		}

		mCamera.setParameters(p);

		// Create our Preview view and set it as the content of our activity.
		mPreview = new CameraPreview(getActivity(), mCamera);
		FrameLayout preview = (FrameLayout)getView().findViewById(R.id.camera_preview);
		preview.addView(mPreview);
	}

	public static final int MEDIA_TYPE_IMAGE = 1;
	public static final int MEDIA_TYPE_VIDEO = 2;
	protected static final int K_STATE_FROZEN = 0;
	protected static final int K_STATE_PREVIEW = 0;
	protected static final int K_STATE_BUSY = 0;

	private PictureCallback mPicture = new PictureCallback() {

		@Override
		public void onPictureTaken(byte[] data, Camera camera) {

			try
			{
				BitmapFactory.Options opts = new BitmapFactory.Options();
				Bitmap bitmap= BitmapFactory.decodeByteArray(data, 0, data.length,opts);
				bitmap = Bitmap.createScaledBitmap(bitmap, 480, 480, false);

				Matrix matrix = new Matrix();
				matrix.postRotate(90);
				bitmap = Bitmap.createBitmap(bitmap, 0, 0, 
						bitmap.getWidth(), bitmap.getHeight(), 
						matrix, true);
				
				String name = getActivity().getFilesDir() + String.valueOf(Entry.getAll().length) + ".jpg";
				System.out.println("saving to " + name);
			    FileOutputStream out = new FileOutputStream(name);
			    bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
			    out.flush();
			    out.close();
				System.out.println("done saving to " + name);

				//ImageView imageView = (ImageView)getView().findViewById(R.id.image);
				//imageView.setImageBitmap(bitmap);
				//CameraProjectActivity.image.setImageBitmap(bitmap);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	};


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View rootView = inflater.inflate(R.layout.camera, container, false);
		View button = rootView.findViewById(R.id.button_capture);

		View accept = rootView.findViewById(R.id.button_accept);
		final Button a = (Button)accept;
		a.setVisibility(View.INVISIBLE);

		View decline = rootView.findViewById(R.id.button_decline);
		final Button d = (Button)decline;
		d.setVisibility(View.INVISIBLE);

		final Button b = (Button) button;
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg1) {
				// TODO Auto-generated method stub
				// get an image from the camera

				mCamera.takePicture(null, null, mPicture);
				a.setVisibility(View.VISIBLE);
				d.setVisibility(View.VISIBLE);
				b.setVisibility(View.INVISIBLE);
			}
		});

		a.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg1) {
				//save picture
				//String uri = Util.getOutputMediaFileUri().toString();// Getting URI
				//Entry e = 
				Environment.getExternalStorageState();// Checking that SDCard exists
				File file = Util.getOutputMediaFile();
				
				//calling NewEntryActivity
				Intent intent = new Intent(getActivity(), NewEntryActivity.class);
				getActivity().startActivity(intent);

				
				// switching to the new entry fragment 
				/*Fragment fragment = new NewEntryFragment();
				FragmentTransaction transaction = getFragmentManager().beginTransaction();

				transaction.replace(R.id.cameraFragment, fragment);
				transaction.addToBackStack(null);
				transaction.commit();*/
			}
		});

		d.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg1) {
				//change buttons
				a.setVisibility(View.INVISIBLE);
				d.setVisibility(View.INVISIBLE);
				b.setVisibility(View.VISIBLE);

				//restart camera preview
				int mPreviewState = 0;
				switch(mPreviewState) {
				case K_STATE_FROZEN:
					mCamera.startPreview();
					mPreviewState = K_STATE_PREVIEW;
					break;

				default:
					PictureCallback rawCallback = null;
					mCamera.takePicture( null, rawCallback, null);
					mPreviewState = K_STATE_BUSY;
				} // switch

			}
		});  


		return rootView;
	}
	
}
