package com.prueba;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class VerImagen extends Activity {
	
	private DisplayImageOptions options = new DisplayImageOptions.Builder()
		.showImageOnFail(R.drawable.homero)
		.cacheInMemory(true)
		.cacheOnDisk(true)
		.considerExifParams(true)
		.build();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Intent intent = getIntent();
		final String url = intent.getStringExtra("url");
		setContentView(R.layout.ver_imagen);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		final ImageView image = (ImageView)findViewById(R.id.ver_imagen);		
		ImageLoader.getInstance().displayImage(url, image, options);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.ver_imagen, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
