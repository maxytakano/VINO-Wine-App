package com.yoloswag.vino;

import java.util.List;

import com.yoloswag.vino.db.DatabaseManager;
import com.yoloswag.vino.main.VINOActivity;
import com.yoloswag.vino.model.Entry;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class NewEntryActivity extends Activity {
	
	private Bitmap mImageBitmap;
	private ImageView mImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_entry);
		//DatabaseManager.init(this);
	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_entry, menu);
		return true;
	}
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_new_entry, container, false);
        View button = rootView.findViewById(R.id.new_entry_button);
        
        Button b = (Button) button;

        b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg1) {
				// TODO Auto-generated method stub
				Entry e = new Entry();
				//EditText title = (EditText)rootView.findViewById(R.id.grapeAutoComplete);
				EditText location = (EditText)rootView.findViewById(R.id.location);
				//EditText vintageYear = (EditText)rootView.findViewById(R.id.vintageYear);
				//EditText color = (EditText)rootView.findViewById(R.id.color);
				//EditText smell = (EditText)rootView.findViewById(R.id.smell);
				//EditText taste = (EditText)rootView.findViewById(R.id.taste);
				//EditText comments = (EditText)rootView.findViewById(R.id.comments);

				//e.title = title.getText().toString();
				//Toast.makeText(getActivity(), e.title, Toast.LENGTH_SHORT).show();
				e.location = location.getText().toString();
				//Toast.makeText(getActivity(), e.location, Toast.LENGTH_SHORT).show();
				
				
				e.save();

				//((VINOActivity)getActivity()).onSubmit();	
			}
        });

        return rootView;
    }
  */  
    /** Checking if the intent is even available */
   /* public static boolean isIntentAvailable(Context context, String action) 
    {
        final PackageManager packageManager = context.getPackageManager();
        final Intent intent = new Intent(action);
        List<ResolveInfo> list =
                packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }
    */
    /** Getting the image */
    /*private void handleSmallCameraPhoto(Intent intent) 
    {
        Bundle extras = intent.getExtras();
        Bitmap mImageBitmap = (Bitmap) extras.get("data");
        mImageView.setImageBitmap(mImageBitmap);
    }*/
    
    

}
