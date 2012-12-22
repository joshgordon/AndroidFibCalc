package net.gordonator.androidfibcalc;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

public class Display extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display);
		
		TextView output = (TextView) findViewById(R.id.Numbers); 
		TextView time = (TextView) findViewById(R.id.timeDisplay);
		TextView header = (TextView) findViewById(R.id.displayInfo); 
		Intent intent = getIntent(); 
		int seqLen = intent.getIntExtra(MainActivity.SEQUENCE_LENGTH, 0); 
		String delimiter = intent.getStringExtra(MainActivity.DELIMITER);
		boolean wrap = intent.getBooleanExtra(MainActivity.WRAP, false) ;
		boolean print = intent.getBooleanExtra(MainActivity.PRINT, true); 
		
		long startTime = Calendar.getInstance().getTimeInMillis(); 
		
		ArrayList<String> fibSeq = getFibSequence(seqLen); 
		
		long midTime = Calendar.getInstance().getTimeInMillis(); 
		
				
		StringBuilder str = new StringBuilder(); 
		Iterator<String> itr = fibSeq.iterator(); 
		if (print)
		{
		if (wrap)
		{
			while (itr.hasNext())
			{ 
				str.append(itr.next() + delimiter); 
			}
		} 
		else
		{ 
			for (int ii = 1; itr.hasNext(); ii++)
			{
				str.append(ii + ": "); 
				str.append(itr.next()); 
				str.append("\n\n");
			}
		}
		}
		long endTime = Calendar.getInstance().getTimeInMillis(); 
		
		long totalTime = endTime - startTime; 
		long firstHalf = midTime - startTime; 
		long secondHalf = endTime - midTime; 
		header.setText("Here are your " + seqLen + " calculated fibonacci values."); 
		if(print)
			output.setText(str); 
		time.setText(firstHalf + " + " + secondHalf + " = " + totalTime + "\n" +
					"calc + stringBuilding = total"); 
		
	
	
	}
	
	
	
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
