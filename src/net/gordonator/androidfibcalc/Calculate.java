package net.gordonator.androidfibcalc;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

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
		
		ArrayList<String> fibSeq = getFibSequence(seqLen); 
		
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
	
	
	public ArrayList<String> getFibSequence(int seqLen)
	{ 
		ArrayList<BigInteger> fib = new ArrayList<BigInteger>(seqLen);
		fib.add(new BigInteger("1")); 
		fib.add(new BigInteger("1")); 
		
		while(fib.size() <= seqLen)
		{ 
			fib.add(fib.get(fib.size()-1).add(fib.get(fib.size()-2))); 
		}
		
		ArrayList<String> fibStrings = new ArrayList<String>(seqLen); 
		
		Iterator<BigInteger> itr = fib.iterator(); 
		
		while (itr.hasNext())
		{ 
			fibStrings.add(itr.next().toString()); 
		}

		return fibStrings; 
	}

}
