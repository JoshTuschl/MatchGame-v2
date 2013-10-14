package com.example.matchgame;

import java.util.ArrayList;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;

public class FileListFrag extends ListFragment {
	

	private ArrayList<FileClass> mCat; 
	
	@Override 
	public void onCreate(Bundle saved) {
		super.onCreate(saved); 
		
		
		mCat = Catalog.get(getActivity()).getRecords(); 
		Log.d("debug", mCat+""); 
		//ArrayAdapter<Record> adapter = new ArrayAdapter<Record>(getActivity(), 
		//		android.R.layout.simple_list_item_1, mCat);
		
		RecordAdapter adapter = new RecordAdapter(mCat); 
		setListAdapter(adapter);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int pos, long id){
		
//		
//		Intent i = new Intent(getActivity(), FileListAct.class);
//		startActivity(i); 
	}
	
	private class RecordAdapter extends ArrayAdapter<FileClass> {
		public RecordAdapter(ArrayList<FileClass> files) {
			super(getActivity(), 0, files); 
		}
		
		@Override
		public View getView(int pos, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item,  null); 
				
			}
			
			// configure the view
			final FileClass r = getItem(pos); 
			
			ImageButton changeImg = (ImageButton)convertView.findViewById(R.id.imageButton1);
            changeImg.setImageURI(Uri.fromFile(r.getFile()));
			
			final CheckBox cb = 
					(CheckBox) convertView.findViewById(R.id.checkInsured); 
			cb.setChecked(r.isInsured());
			cb.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					
					if (r.isInsured()) {
						r.setInsured(false);
					}
					else {
						r.setInsured(true);
					}
					Log.d("debug", "item " + ": " + r.getmTitle() + "=" + r.isInsured() ); 			
				}
			});
			
			changeImg.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					
					if (r.isInsured()) {
						r.setInsured(false);
						cb.setChecked(r.isInsured());
					}
					else {
						r.setInsured(true);
						cb.setChecked(r.isInsured());
					}
					Log.d("debug", "item " + ": " + r.getmTitle() + "=" + r.isInsured() ); 	
				}
			});
			return convertView; 
		}
	}

}
