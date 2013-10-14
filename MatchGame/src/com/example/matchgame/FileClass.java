package com.example.matchgame;


	import java.io.File;
import java.util.Date;
import java.util.UUID;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class FileClass {

	private UUID mId;
	private String mTitle;
	private Date mDate;
	private boolean mInsured; 
	private Bitmap thumbnail;
	private File sourceFile;
	
	public FileClass() {
		mId = UUID.randomUUID(); 
		mDate = new Date(); 
	}

	public UUID getId() {
		return mId;
	}

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public Date getDate() {
		return mDate;
	}

	public void setDate(Date mDate) {
		this.mDate = mDate;
	}

	public boolean isInsured() {
		return mInsured;
	}

	public void setInsured(boolean insured) {
		mInsured = insured;
	}
	
	@Override
	public String toString() {
		return mTitle; 
	}
	
	public void setFile(File source) {
		sourceFile = source;
	}
	
	public File getFile() {
		return sourceFile;
	}
	
	public void generateThumbnail(File source) {
		
	    File image = source;

	    BitmapFactory.Options options = new BitmapFactory.Options();
	    options.inJustDecodeBounds = true;
	    options.inInputShareable = true;
	    options.inPurgeable = true;

	    BitmapFactory.decodeFile(image.getPath(), options);

	    int originalSize = (options.outHeight > options.outWidth) ? options.outHeight
	            : options.outWidth;

	    BitmapFactory.Options opts = new BitmapFactory.Options();
	    opts.inSampleSize = originalSize / 128;

	    Bitmap scaledBitmap = BitmapFactory.decodeFile(image.getPath(), opts);

	    thumbnail = scaledBitmap;  
	}

}
