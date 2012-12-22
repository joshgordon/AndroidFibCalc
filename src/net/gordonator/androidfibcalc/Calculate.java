package net.gordonator.androidfibcalc;

//import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
//import java.util.Iterator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class Calculate extends Activity {

	public final static String FIB_ARRAY = "net.gordonator.androidfibcalc.array";
	public final static String TIME = "net.gordonator.androidfibcalc.time"; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculate);
		
		Intent intent = getIntent(); 
		int seqLen = intent.getIntExtra(MainActivity.SEQUENCE_LENGTH, 0); 
		
		long startTime = Calendar.getInstance().getTimeInMillis(); 
		
//		ArrayList<String> fibSeq = getFibSequence(seqLen);
		
		ArrayList<String> fibSeq = null; 
		
		Thread t = new Thread(new Compute(seqLen, fibSeq)); 
		
		t.start(); 
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		long endTime = Calendar.getInstance().getTimeInMillis(); 
		
		long totalTime = endTime - startTime; 
		
		Intent display = new Intent(this, Display.class) ;
		display.putExtra(FIB_ARRAY, fibSeq); 
		display.putExtra(TIME, totalTime); 
		startActivity(display);  
		
		
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		 Inflate the menu; this adds items to the action bar if it is present.
//		return true;
//	}
	
	

}
