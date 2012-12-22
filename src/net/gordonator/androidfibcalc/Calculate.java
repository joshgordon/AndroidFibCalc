package net.gordonator.androidfibcalc;

import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;

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
		
		long [] fibSeq = getFibSequence(seqLen); 
		
		long endTime = Calendar.getInstance().getTimeInMillis(); 
		
		Intent display = new Intent(this, Display.class) ;
		display.putExtra(FIB_ARRAY, fibSeq); 
		display.putExtra(TIME, endTime - startTime); 
		startActivity(display); 
		
		
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		 Inflate the menu; this adds items to the action bar if it is present.
//		return true;
//	}
	
	
	public long [] getFibSequence(int seqLen)
	{ 
		LinkedList<Long> fib = new LinkedList<Long>();
		fib.addFirst((long)1); 
		fib.addFirst((long)1); 
		
		while(fib.size() <= seqLen)
		{ 
			fib.addFirst(fib.get(0) + fib.get(1)); 
		}
		
		long [] fibArray = new long[fib.size()]; 
		Iterator<Long> itr = fib.iterator(); 
		for (int ii = fib.size() - 1; itr.hasNext(); ii--)
		{ 
			fibArray[ii] = itr.next(); 
		}
		
		return fibArray; 
	}

}
