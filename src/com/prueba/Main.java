package com.prueba;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;


public class Main extends Activity{
	
	TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        text = (TextView)findViewById(R.id.text1);
        text.setText("Hola mundddooooooo");
        text.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Toast.makeText(Main.this, "texto 1", Toast.LENGTH_SHORT).show();    	
				
			}
		});
    }
   
    
    public void click(View v){
//    	Toast.makeText(this, R.string.primer_actividad, Toast.LENGTH_SHORT).show();
    	Intent intent = new Intent(this, List.class);
    	startActivity(intent);
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
	       {  case R.id.menu1:
	    	   Intent intent = new Intent(this, List.class);
	       	   startActivity(intent); 	   
	           return true;
	         default:
	        	 break;        
             }
 
        return super.onOptionsItemSelected(item);
    }

}
