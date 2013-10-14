package com.example.matchgame;


import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;

public class Catalog {
	private static Catalog sCat;
	private Context mAppContext; 
	private static ArrayList<FileClass> mFiles; 
	
	private Catalog(Context cxt) {
		mAppContext = cxt;
		File filePath = Environment.getExternalStorageDirectory();
		File[] listOfFiles = filePath.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.toLowerCase().endsWith(".png");
		    }
		});
		
		mFiles = new ArrayList<FileClass>(); 
		for (int i=0; i< listOfFiles.length; i++) {
			FileClass c = new FileClass();
			c.setmTitle(listOfFiles[i].toString());
			c.setFile(listOfFiles[i]);
			mFiles.add(c); 
			
			
		}
	}
	
	public static Catalog get(Context c) {
		if (sCat == null) {
			sCat = new Catalog(c.getApplicationContext());
		}
		
		return sCat; 
	}

	public ArrayList<FileClass> getRecords() {
		return mFiles; 
	}
	
	public static ArrayList<Uri> getCheckedRecordsURIs() {
		ArrayList<Uri> checked = new ArrayList<Uri>();
		for (int i = 0; i < mFiles.size(); i++) {
			if (mFiles.get(i).isInsured()) {
				checked.add(Uri.fromFile((mFiles.get(i)).getFile()));
			}
		}
		return checked;
	}
	
	public static ArrayList<Uri> getCheckedRecordsUrisAtStartup() {
		ArrayList<Uri> checked = new ArrayList<Uri>();
		for (int i = 0; i < 10; i++) {
			checked.add(Uri.fromFile((mFiles.get(i)).getFile()));			
		}
		return checked;
	}
	
	public FileClass getOneRec(UUID id) {
		for (FileClass r: mFiles) {
			if (r.getId().equals(id)) {
				return r; 
			}
		}
		return null; 
	}
}



