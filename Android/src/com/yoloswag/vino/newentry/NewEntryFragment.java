	/**
 * 
 */
package com.yoloswag.vino.newentry;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import com.yoloswag.vino.R;
import com.yoloswag.vino.main.VINOActivity;
import com.yoloswag.vino.model.Entry;
import com.yoloswag.vino.util.Util;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

/**
 * @author tiffany
 *
 */
public class NewEntryFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    public static final String ARG_SECTION_NUMBER = "section_number";
    ExpandableListView exv;
	//private Bitmap mImageBitmap;
	//private ImageView mImageView;
	//private CameraPreview mPreview;
	//private Camera mCamera;
    
    @Override
    public void onCreate (Bundle savedInstanceState) 
    {
    	super.onCreate(savedInstanceState);
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_new_entry, container, false);
        View button = rootView.findViewById(R.id.new_entry_button);

	    FileInputStream in;
		try {
			String name = getActivity().getFilesDir() + String.valueOf(Entry.getAll().length)+".jpg";
			in = new FileInputStream(name);
		    Bitmap bitmap = BitmapFactory.decodeStream(in);

			ImageView imageView = (ImageView)rootView.findViewById(R.id.image);
			imageView.setImageBitmap(bitmap);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        

		Button b = (Button) button;

        b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg1) {
				// TODO Auto-generated method stub
				Entry e = new Entry();
				//EditText title = (EditText)rootView.findViewById(R.id.grapeAutoComplete);
				EditText location = (EditText)rootView.findViewById(R.id.location);
				EditText vintageYear = (EditText)rootView.findViewById(R.id.vintageYear);
				EditText category = (EditText)rootView.findViewById(R.id.category);
				EditText region = (EditText)rootView.findViewById(R.id.region);
				RatingBar rating = (RatingBar)rootView.findViewById(R.id.rating);
				EditText comment = (EditText)rootView.findViewById(R.id.comments);

				//e.title = title.getText().toString();
				//Toast.makeText(getActivity(), e.title, Toast.LENGTH_SHORT).show();

				//save picture
				String uri = Util.getOutputMediaFileUri().toString();// Getting URI
				
				e.location = location.getText().toString();
				e.vintageYear = vintageYear.getText().toString();
				e.category = category.getText().toString();
				e.region = region.getText().toString();
				e.comment = comment.getText().toString();
				e.rating = (int)rating.getRating();
				e.uri = getActivity().getFilesDir() + String.valueOf(Entry.getAll().length)+".jpg";
				
				e.save();
				((VINOActivity)getActivity()).onSubmit();
			}
        });

        return rootView;
    }
    
    /** Checking if the intent is even available */
    public static boolean isIntentAvailable(Context context, String action) 
    {
        final PackageManager packageManager = context.getPackageManager();
        final Intent intent = new Intent(action);
        List<ResolveInfo> list =
                packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }
}
