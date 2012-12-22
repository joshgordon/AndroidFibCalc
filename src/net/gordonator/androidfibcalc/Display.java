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
		Intent intent = getIntent(); 
		int seqLen = intent.getIntExtra(MainActivity.SEQUENCE_LENGTH, 0); 
		String delimiter = intent.getStringExtra(MainActivity.DELIMITER);
		boolean wrap = intent.getBooleanExtra(MainActivity.WRAP, false) ;
		
		long startTime = Calendar.getInstance().getTimeInMillis(); 
		
		ArrayList<String> fibSeq = getFibSequence(seqLen); 
		
		long endTime = Calendar.getInstance().getTimeInMillis(); 
		
		long totalTime = endTime - startTime; 
		
		
		String str = ""; 
		Iterator<String> itr = fibSeq.iterator(); 
		
		if (wrap)
		{
			while (itr.hasNext())
			{ 
				str += itr.next() + delimiter; 
			}
		} 
		else
		{ 
			for (int ii = 1; itr.hasNext(); ii++)
			{
				str += ii + ": "; 
				str += itr.next(); 
				str += "\n\n";
			}
		}
		
		output.setText(str); 
		time.setText("It took " + totalTime + " ms to complete the calculation."); 
		
	
	
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
