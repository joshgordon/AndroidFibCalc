package net.gordonator.androidfibcalc;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity {

	public final static String SEQUENCE_LENGTH = "net.gordonator.androidfibcalc.SEQLEN"; 
	public final static String DELIMITER = "net.gordonator.androidfibcalc.delimiter"; 
	public final static String WRAP = "net.gordonator.androidfibcalc.wrap"; 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDelimiter(View view) 
    { 
    	TextView delimiterText = (TextView) findViewById(R.id.delimiterText);
    	delimiterText.setEnabled(true); 
    	
    	EditText delimiter = (EditText) findViewById(R.id.delimiter); 
    	delimiter.setEnabled(true); 
    	
    }
    
    public void hideDelimiter(View view) 
    { 
    	TextView delimiterText = (TextView) findViewById(R.id.delimiterText);
    	delimiterText.setEnabled(false); 
    	
    	EditText delimiter = (EditText) findViewById(R.id.delimiter); 
    	delimiter.setEnabled(false); 
    }
    
    
    
    
    
    public void calculate(View view)
    {
        Intent intent = new Intent(this, Display.class); 
        EditText editText = (EditText) findViewById(R.id.seqLen); 
        EditText delimiter = (EditText) findViewById(R.id.delimiter); 
        
        RadioButton wrap = (RadioButton) findViewById(R.id.wrapRadio); 
        
        
        
        int seqLen = Integer.parseInt(editText.getText().toString()); 
        intent.putExtra(SEQUENCE_LENGTH, seqLen); 
        intent.putExtra(DELIMITER, delimiter.getText().toString()); 
        intent.putExtra(WRAP, wrap.isChecked()); 
        startActivity(intent); 

    }
}
