package com.example.matchgame;

import java.util.Arrays;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private Integer[] images = {R.drawable.clubsace, R.drawable.clubsking, R.drawable.clubsqueen, R.drawable.clubsjack,
			R.drawable.clubs10, R.drawable.heartsace, R.drawable.heartsking, R.drawable.heartsqueen, R.drawable.heartsjack,
			R.drawable.hearts10,R.drawable.clubsace, R.drawable.clubsking, R.drawable.clubsqueen, R.drawable.clubsjack,
			R.drawable.clubs10, R.drawable.heartsace, R.drawable.heartsking, R.drawable.heartsqueen, R.drawable.heartsjack,
			R.drawable.hearts10};
	private Boolean[] flipped = {false, false, false, false, false, false, false, false, false, false, false, false, false,
			 false, false, false, false, false, false, false};
	private Boolean[] matched = {false, false, false, false, false, false, false, false, false, false, false, false, false,
			 false, false, false, false, false, false, false};	

	public class flippedCard {
		public ImageButton card = null;
		public int index = 0;
	}
	flippedCard firstCard = new flippedCard();
	flippedCard secondCard = new flippedCard();
	private Handler myHandler;
	private Timer mytimer;
	TextView text = null;
	
	Chronometer mChronometer;
	class CustomTimerTask extends TimerTask {
		 
        @Override
        public void run() {
            myHandler.sendEmptyMessage(0);
        }
    }

       class CustomHandler extends Handler{


        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.e("handleMessage", firstCard.toString());
            if (firstCard.card != null && matched[firstCard.index] != true) {            	
            	firstCard.card.setImageResource(R.drawable.cardback);
            	flipped[firstCard.index] = false;
            	firstCard.card = null;
            }
            if (matched[secondCard.index] != true && secondCard.card != null){
            	secondCard.card.setImageResource(R.drawable.cardback);
            	flipped[secondCard.index] = false;
            	secondCard.card = null;
            }
            if (mytimer != null) {
	            mytimer.cancel();
	            mytimer= null;
            }
        }
       }
	
   public void checkForMatch() {
	   Log.e("checkForMatch", "Checking for match");
	   if (secondCard.card != null && firstCard.card != null) {
		   if (getResources().getDrawable(images[firstCard.index]).getConstantState().equals
            (getResources().getDrawable(images[secondCard.index]).getConstantState())) {
			   matched[firstCard.index] = true;
			   matched[secondCard.index]= true;

			   firstCard.card = null;
			   secondCard.card = null;
			   if (mytimer != null) {
		            mytimer.cancel();
		            mytimer= null;
	           }
		   }
	    }
	   boolean allmatch = true;
	   for (int i = 0; i < 20; i++) {
		   if (matched[i] == false) {
			   allmatch = false;
		   }
	   }
	   if (allmatch == true) {
		   mChronometer.stop();
		   mChronometer.setVisibility(View.INVISIBLE);;
		   text.setText("You won!");
		   
	   }
   }
   
   public void clicked(int index, ImageButton imgBttn) {
	   if (matched[index] != true) {
			imgBttn.setImageResource(images[index]);
			flipped[index] = true;
			if (firstCard.card == null) {
	           	firstCard.card = imgBttn;
	           	firstCard.index = index;
	           	checkForMatch();
	           	Log.e("onClick", "button " + index + " set as first card");
            }
			else if (secondCard.card == null) {
	           	secondCard.card = imgBttn;
	           	secondCard.index = index;
	           	Log.e("onClick", "button " + index + " set as second card");
	           	checkForMatch();
           }
			else {
				Log.e("onClick", "button " + index + " set as third card");
				if (matched[firstCard.index] != true) {
					firstCard.card.setImageResource(R.drawable.cardback);
					flipped[firstCard.index] = false;
				}
				if (matched[secondCard.index] != true) {
					secondCard.card.setImageResource(R.drawable.cardback);
					flipped[secondCard.index] = false;
				}
				firstCard.card = imgBttn;
	           	firstCard.index = index;
	           	secondCard.card = null;
			}
			mytimer = new Timer();
            CustomTimerTask customTimerTask = new CustomTimerTask();
            mytimer.schedule(customTimerTask, 3000);
		}
   }
       
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		myHandler = new CustomHandler();
		mChronometer = (Chronometer) findViewById(R.id.chronometer1);
		
		final ImageButton imageBttn1 = (ImageButton)findViewById(R.id.imageButton1);
		final ImageButton imageBttn2 = (ImageButton)findViewById(R.id.imageButton2);
		final ImageButton imageBttn3 = (ImageButton)findViewById(R.id.imageButton3);
		final ImageButton imageBttn4 = (ImageButton)findViewById(R.id.imageButton4);
		final ImageButton imageBttn5 = (ImageButton)findViewById(R.id.imageButton5);
		final ImageButton imageBttn6 = (ImageButton)findViewById(R.id.imageButton6);
		final ImageButton imageBttn7 = (ImageButton)findViewById(R.id.imageButton7);
		final ImageButton imageBttn8 = (ImageButton)findViewById(R.id.imageButton8);
		final ImageButton imageBttn9 = (ImageButton)findViewById(R.id.imageButton9);
		final ImageButton imageBttn10 = (ImageButton)findViewById(R.id.imageButton10);
		final ImageButton imageBttn11 = (ImageButton)findViewById(R.id.imageButton11);
		final ImageButton imageBttn12 = (ImageButton)findViewById(R.id.imageButton12);
		final ImageButton imageBttn13 = (ImageButton)findViewById(R.id.imageButton13);
		final ImageButton imageBttn14 = (ImageButton)findViewById(R.id.imageButton14);
		final ImageButton imageBttn15 = (ImageButton)findViewById(R.id.imageButton15);
		final ImageButton imageBttn16 = (ImageButton)findViewById(R.id.imageButton16);
		final ImageButton imageBttn17 = (ImageButton)findViewById(R.id.imageButton17);
		final ImageButton imageBttn18 = (ImageButton)findViewById(R.id.imageButton18);
		final ImageButton imageBttn19 = (ImageButton)findViewById(R.id.imageButton19);
		final ImageButton imageBttn20 = (ImageButton)findViewById(R.id.imageButton20);
		
		imageBttn1.setEnabled(false);
		imageBttn2.setEnabled(false);
		imageBttn3.setEnabled(false);
		imageBttn4.setEnabled(false);
		imageBttn5.setEnabled(false);
		imageBttn6.setEnabled(false);
		imageBttn7.setEnabled(false);
		imageBttn8.setEnabled(false);
		imageBttn9.setEnabled(false);
		imageBttn10.setEnabled(false);
		imageBttn11.setEnabled(false);
		imageBttn12.setEnabled(false);
		imageBttn13.setEnabled(false);
		imageBttn14.setEnabled(false);
		imageBttn15.setEnabled(false);
		imageBttn16.setEnabled(false);
		imageBttn17.setEnabled(false);
		imageBttn18.setEnabled(false);
		imageBttn19.setEnabled(false);
		imageBttn20.setEnabled(false);
		
		
		final Button startButton = (Button)findViewById(R.id.StartButton);
		final Button resetButton = (Button)findViewById(R.id.ResetButton);
		
		text = (TextView)findViewById(R.id.textView1);
		
		setupGame();
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		
		
		imageBttn1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				clicked(0, imageBttn1);
            }
        });
		
		imageBttn2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				clicked(1, imageBttn2);
				
            }
        });
		
		imageBttn3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				clicked(2, imageBttn3);
            }
        });
		
		imageBttn4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				clicked(3, imageBttn4);
            }
        });
		
		imageBttn5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				clicked(4, imageBttn5);
            }
        });
		
		imageBttn6.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				clicked(5, imageBttn6);
            }
        });
		
		imageBttn7.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				clicked(6, imageBttn7);
            }
        });
		
		imageBttn8.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				clicked(7, imageBttn8);
            }
        });
		
		imageBttn9.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				clicked(8, imageBttn9);
            }
        });
		
		imageBttn10.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				clicked(9, imageBttn10);
            }
        });
		
		imageBttn11.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				clicked(10, imageBttn11);
            }
        });
		
		imageBttn12.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				clicked(11, imageBttn12);
            }
        });
		
		imageBttn13.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				clicked(12, imageBttn13);
            }
        });
		
		imageBttn14.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				clicked(13, imageBttn14);
            }
        });
		
		imageBttn15.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				clicked(14, imageBttn15);
            }
        });
		
		imageBttn16.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				clicked(15, imageBttn16);
            }
        });
		
		imageBttn17.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				clicked(16, imageBttn17);
            }
        });
		
		imageBttn18.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				clicked(17, imageBttn18);
            }
        });
		
		imageBttn19.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				clicked(18, imageBttn19);
            }
        });
		
		imageBttn20.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				clicked(19, imageBttn20);
            }
        });
		
		startButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				imageBttn1.setEnabled(true);
				imageBttn2.setEnabled(true);
				imageBttn3.setEnabled(true);
				imageBttn4.setEnabled(true);
				imageBttn5.setEnabled(true);
				imageBttn6.setEnabled(true);
				imageBttn7.setEnabled(true);
				imageBttn8.setEnabled(true);
				imageBttn9.setEnabled(true);
				imageBttn10.setEnabled(true);
				imageBttn11.setEnabled(true);
				imageBttn12.setEnabled(true);
				imageBttn13.setEnabled(true);
				imageBttn14.setEnabled(true);
				imageBttn15.setEnabled(true);
				imageBttn16.setEnabled(true);
				imageBttn17.setEnabled(true);
				imageBttn18.setEnabled(true);
				imageBttn19.setEnabled(true);
				imageBttn20.setEnabled(true);
				mChronometer.setBase(SystemClock.elapsedRealtime());
				mChronometer.start();
				
            }
        });
		
		resetButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setupGame();
            }
        });
		
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    if (item.getItemId() == R.id.config) {
	    	Intent i = new Intent(MainActivity.this, FileListAct.class);
			startActivity(i); 
	    	return true;
	    }
	    else {
	    	return false;
	    }	  
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.	
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return true;
	}
	
	
	
	
	public void setupGame() {
		
		Collections.shuffle(Arrays.asList(images));
		
		for (int i = 0; i < 20; i++) {
			flipped[i] = false;
			matched[i] = false;
		}
		
		firstCard.card = null;
		firstCard.index = 0;
		secondCard.card = null;
		secondCard.index = 0;
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		
		
			
		
	}

}
