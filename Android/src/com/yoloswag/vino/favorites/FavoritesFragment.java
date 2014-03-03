package com.yoloswag.vino.favorites;


import com.yoloswag.vino.R;
import com.yoloswag.vino.R.id;
import com.yoloswag.vino.R.layout;
import com.yoloswag.vino.model.Entry;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.TextView;

public class FavoritesFragment extends Fragment implements OnGroupExpandListener
{
	Entry[] entries = Entry.getAll();
    ExpandableListView exv;
    
    public FavoritesFragment() 
    {
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favorites, container, false);
    	exv = (ExpandableListView)rootView.findViewById(R.id.expandableListView1);
    	exv.setOnGroupExpandListener((OnGroupExpandListener) this);
		exv.setAdapter(new FavoritesAdapter(this));
		
        return rootView;
    }
    
    /*Instantiate suggestions fragment for the given wine
    public Fragment displaySuggestions(){
    	Fragment SuggestionsFragment = new SuggestionsFragment();
    	return SuggestionsFragment;
    }*/
    
    public void onGroupExpand(int groupPosition) {
	    int len = exv.getCount();

	    for (int i = 0; i < len; i++) {
	        if (i != groupPosition) {
	            exv.collapseGroup(i);
	        }
	    }
	}
}
