package com.prueba;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class Details extends Activity {

	public final static String KEY_URL = "url";

	private static final DisplayImageOptions options = new DisplayImageOptions.Builder()
			.showImageOnFail(R.drawable.image)
			.showImageOnLoading(R.drawable.image).cacheInMemory(true)
			.cacheOnDisk(true).considerExifParams(true).build();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final String url = getIntent().getStringExtra(KEY_URL);
		setContentView(R.layout.activity_details);
		final ImageView image = (ImageView) findViewById(R.id.image);
		ImageLoader.getInstance().displayImage(url, image, options);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.details, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			break;
		default:
			break;
		}
		return super.onMenuItemSelected(featureId, item);
	}

}
