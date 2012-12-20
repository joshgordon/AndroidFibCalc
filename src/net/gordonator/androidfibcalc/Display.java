package net.gordonator.androidfibcalc;

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
		
		int [] fibArray = intent.getIntArrayExtra(Calculate.FIB_ARRAY);
		int timeTaken = intent.getIntExtra(Calculate.TIME, 9999); 
		
		String str = ""; 
		for (int ii = 0; ii < fibArray.length; ii++)
		{ 
			str += (ii + 1) + ": "; 
			str += fibArray[ii] + "\n"; 
		}
		
		output.setText(str); 
		time.setText("It took " + timeTaken + " ms to complete the calculation."); 
		
	
	}

}
