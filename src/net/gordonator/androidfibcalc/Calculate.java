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
		
		int [] fibSeq = getFibSequence(seqLen); 
		
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
	
	
	public int [] getFibSequence(int seqLen)
	{ 
		LinkedList<Integer> fib = new LinkedList<Integer>();
		fib.addFirst(1); 
		fib.addFirst(1); 
		
		while(fib.size() <= seqLen)
		{ 
			fib.addFirst(fib.get(0) + fib.get(1)); 
		}
		
		int [] fibArray = new int[fib.size()]; 
		Iterator<Integer> itr = fib.iterator(); 
		for (int ii = fib.size() - 1; itr.hasNext(); ii--)
		{ 
			fibArray[ii] = itr.next(); 
		}
		
		return fibArray; 
	}

}
