package com.example.matchgame;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class FileItem extends Fragment {
	private FileClass mFileClass;
	private EditText mTitleField;

	
	@Override
	public void onCreate(Bundle saved) {
		super.onCreate(saved);
		mFileClass = new FileClass(); 
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle saved) {
		View v = inflater.inflate(R.layout.fragment_record, parent,false); 
		
		mTitleField = (EditText) v.findViewById(R.id.recordOverview);
		mTitleField.addTextChangedListener(new TextWatcher() {
			public void onTextChanged(CharSequence c, int start, int before, int count) {
				mFileClass.setmTitle(c.toString());
			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}

			
		});
		return v; 
	}


}
