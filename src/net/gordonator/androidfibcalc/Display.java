package net.gordonator.androidfibcalc;

import java.util.ArrayList;
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
		
		ArrayList<String> fibArray = intent.getStringArrayListExtra(Calculate.FIB_ARRAY);
		long timeTaken = intent.getLongExtra(Calculate.TIME, 9999); 
		
		String str = ""; 
		Iterator<String> itr = fibArray.iterator(); 
		
		while (itr.hasNext())
		{ 
			str += itr.next() + ",-"; 
		}
		
		output.setText(str); 
		time.setText("It took " + timeTaken + " ms to complete the calculation."); 
		
	
	}

}
