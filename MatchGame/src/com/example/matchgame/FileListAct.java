package com.example.matchgame;

import com.example.matchgame.FileItem;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class FileListAct extends FragmentActivity {
	
	private static final String CHECKED = "records";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recordact);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		FragmentManager fm = getSupportFragmentManager(); 
		
		Fragment frag = fm.findFragmentById(R.id.fragmentContainer); 
		
		if (frag == null) {
			frag = new FileListFrag(); // RecordFragment();  
			//frag = new RecordFragment(); 
			FragmentTransaction fta = fm.beginTransaction(); 
			fta.add(R.id.fragmentContainer, frag);
			fta.commit(); 
		}
		
	}

}
