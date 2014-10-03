package com.prueba;

import android.app.Activity;
import android.content.Intent;





import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class List extends Activity {
	
	String[] titulos = {"lunes", "martes", "miercoles", "jueves",
			"viernes", "sabado", "domingo", "lunes", "martes", "miercoles", "jueves",
			"viernes", "sabado", "domingo"};	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		setContentView(R.layout.list);
		ListView lista = (ListView)findViewById(R.id.lista);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titulos);
		lista.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId())
	       {  case android.R.id.home:
	    	   	   finish();
	           return true;
	         default:
	        	 break;        
          }
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Toast.makeText(this, "Atras", Toast.LENGTH_SHORT).show();
		return;
	}
}
