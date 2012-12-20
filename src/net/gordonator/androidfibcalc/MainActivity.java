package net.gordonator.androidfibcalc;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	public final static String SEQUENCE_LENGTH = "net.gordonator.androidfibcalc.SEQLEN"; 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    
    public void calculate(View view)
    {
        Intent intent = new Intent(this, Calculate.class); 
        EditText editText = (EditText) findViewById(R.id.seqLen); 
        int seqLen = Integer.parseInt(editText.getText().toString()); 
        intent.putExtra(SEQUENCE_LENGTH, seqLen); 
        
        startActivity(intent); 

    }
}
