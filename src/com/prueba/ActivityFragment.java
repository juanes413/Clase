package com.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

public class ActivityFragment extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment);
		Intent intent = getIntent();
		int i = intent.getIntExtra("id", 0);
		System.out.println("i: " + i);
//		getSupportFragmentManager().beginTransaction().add(R.id.container, new Vista1(), "vista1").commit();
//		getSupportFragmentManager().beginTransaction().add(R.id.container2, new Vista2(), "vista2").commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.vista1:
			//getSupportFragmentManager().beginTransaction().replace(R.id.container, new Vista2(), "vista2").commit();
			break;			
		case R.id.vista2:
			//getSupportFragmentManager().beginTransaction().replace(R.id.container2, new Vista1(), "vista1").commit();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
