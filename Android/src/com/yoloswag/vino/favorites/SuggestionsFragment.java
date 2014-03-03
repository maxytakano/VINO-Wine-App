package com.yoloswag.vino.favorites;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.HorizontalScrollView;
import android.widget.ListView;

import com.yoloswag.vino.R;
import com.yoloswag.vino.favorites.*;
import com.yoloswag.vino.model.Wine;

public class SuggestionsFragment extends Fragment
{
	
	 //public boolean OPEN = false;

	 public static final Wine[][] names = new Wine[][] { {Wine.a, Wine.b, Wine.c, Wine.d},
		 											     {Wine.d, Wine.c, Wine.b, Wine.a},
	 												     {Wine.c, Wine.d, Wine.a, Wine.b} };
	 /*public static final Wine[] names2 = new Wine[] {Wine.d, Wine.c, Wine.b, Wine.a};
	 public static final Wine[] names3 = new Wine[] {Wine.c, Wine.d, Wine.a, Wine.b};*/
	 
	 public static final Integer[] images = new Integer[] {R.drawable.wineicon, R.drawable.wine,
		                                                   R.drawable.sauvignon_blanc,
		                                                   R.drawable.classicgary};
	 
	 //public static Wine[] names = null;
	 
	 ListView listView;
	 List<RowItem> rowItems;
	
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
		
		 
		
	        
		 rowItems = new ArrayList<RowItem>();
		 /*switch (FavoritesAdapter.sugPos)
		 {
		 	case 0:
		 		names = names1;
		 		break;
		 	case 1:
		 		names = names2;
		 		break;
		 	case 2:
		 		names = names3;
		 		break;
		 }*/
		 
		 for (int i = 0; i < 4; ++i)
		 {
			// RowItem item = new RowItem(images[i], names[i].varietal.varietal_name);
			 RowItem item = new RowItem();
			 rowItems.add(item);
		 }
		 
		 View rootView = inflater.inflate(R.layout.suggestions_list, container, false);
		 listView = (ListView)rootView.findViewById(R.id.list);
		 listView.setAdapter(new SuggestionsAdapter(this, R.layout.suggestions, rowItems));
		 
System.out.println("AFTER SETADAPTER");
	     return rootView;
	    }
	 
}
