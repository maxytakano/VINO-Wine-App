package com.yoloswag.vino.favorites;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yoloswag.vino.R;
import com.yoloswag.vino.model.Wine;

public class SuggestionsAdapter extends ArrayAdapter<RowItem> 
{

	Context context;
	
	public SuggestionsAdapter(SuggestionsFragment suggestionsFragment, int resourceId, List<RowItem> list) 
	{
		super(suggestionsFragment.getActivity(), resourceId, list);
		this.context = suggestionsFragment.getActivity();
System.out.println("CREATING SETADAPTER");
	}

	private class ViewHolder
	{
		ImageView imageView;
		TextView txtName;
		//TextView txtVarietal;
		//TextView textVintage;
	}
	
	public View getView(int position, View convertView, ViewGroup parent)
	{
		//ViewHolder holder = null;
		//RowItem rowItem = getItem(position);
		
		LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		
		if(convertView == null)
		{
			convertView = mInflater.inflate(R.layout.suggestions, null);

			// Since only 3 lists of suggestions in fake suggestions [][]
			int j = FavoritesAdapter.sugPos%3;
			
			ViewHolder holder = new ViewHolder();
			holder.txtName = (TextView) convertView.findViewById(R.id.name1);
			holder.imageView = (ImageView) convertView.findViewById(R.id.icon1);
			holder.imageView.setImageResource(SuggestionsFragment.images[0]);
			holder.txtName.setText(SuggestionsFragment.names[j][0].name.producer +
					" " + SuggestionsFragment.names[j][0].varietal.varietal_name);
			
			ViewHolder holder2 = new ViewHolder();
			holder2.txtName = (TextView) convertView.findViewById(R.id.name2);
			holder2.imageView = (ImageView) convertView.findViewById(R.id.icon2);
			holder2.imageView.setImageResource(SuggestionsFragment.images[1]);
			holder2.txtName.setText(SuggestionsFragment.names[j][1].name.producer +
					" " + SuggestionsFragment.names[j][1].varietal.varietal_name);
			
			ViewHolder holder3 = new ViewHolder();
			holder3.txtName = (TextView) convertView.findViewById(R.id.name3);
			holder3.imageView = (ImageView) convertView.findViewById(R.id.icon3);
			holder3.imageView.setImageResource(SuggestionsFragment.images[2]);
			holder3.txtName.setText(SuggestionsFragment.names[j][2].name.producer +
					" " + SuggestionsFragment.names[j][2].varietal.varietal_name);
			
			ViewHolder holder4 = new ViewHolder();
			holder4.txtName = (TextView) convertView.findViewById(R.id.name4);
			holder4.imageView = (ImageView) convertView.findViewById(R.id.icon4);
			holder4.imageView.setImageResource(SuggestionsFragment.images[3]);
			holder4.txtName.setText(SuggestionsFragment.names[j][3].name.producer +
					" " + SuggestionsFragment.names[j][3].varietal.varietal_name);
			
			convertView.setTag(holder);
		}
		/*else
			holder = (ViewHolder) convertView.getTag();
		holder.txtName.setText(rowItem.getName());
		holder.imageView.setImageResource(rowItem.getImageID());*/
		
		return convertView;
	}
}
