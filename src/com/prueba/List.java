package com.prueba;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class List extends ListActivity implements OnItemClickListener{
	
	String[] imagenes = {
			"http://4.bp.blogspot.com/-svSKrk4bAP4/TZvC1vOxjyI/AAAAAAAAAaM/b_PV_HYFZq4/s1600/los+simpson+%252811%2529.JPG",
			"http://k40.kn3.net/taringa/2/8/1/1/6/5/0/evanescence_1_re/861.jpg?1658",
			"http://michiphotography.net/wp-content/uploads/2014/02/Homero-Conversando-Con-Lisa.jpg",
			"https://fbcdn-sphotos-c-a.akamaihd.net/hphotos-ak-ash3/q71/s720x720/539107_10201028688657986_203208036_n.jpg" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		setListAdapter(new AdapterImage(this, imagenes));
		getListView().setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.list, menu);
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

	private class AdapterImage extends BaseAdapter {

		private ImageLoader imageloader;
		private String[] urls;

		private DisplayImageOptions options = new DisplayImageOptions.Builder()
				.showImageOnFail(R.drawable.homero)
				.showImageOnLoading(R.drawable.homero)
				.cacheInMemory(true)
				.cacheOnDisk(true)
				.considerExifParams(true)
				.build();

		private LayoutInflater inflater;

		public AdapterImage(Context context, String[] imagenes) {
			inflater = LayoutInflater.from(context);
			imageloader = ImageLoader.getInstance();
			this.urls = imagenes;

		}

		@Override
		public int getCount() {
			return urls.length;
		}

		@Override
		public String getItem(int pos) {
			return urls[pos];
		}

		@Override
		public long getItemId(int pos) {
			return pos;
		}

		@Override
		public View getView(int pos, View view, ViewGroup parent) {
			ViewHolder holder;
			if (view == null) {
				holder = new ViewHolder();
				view = inflater.inflate(R.layout.lista, parent, false);
				holder.image = (ImageView) view.findViewById(R.id.imagen);
				holder.text = (TextView) view.findViewById(R.id.text);
				view.setTag(holder);
			} else
				holder = (ViewHolder) view.getTag();

			holder.text.setText("Posicion " + pos);
			imageloader.displayImage(urls[pos], holder.image, options);
			return view;
		}

	}

	private static class ViewHolder {
		ImageView image;
		TextView text;
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int pos1, long pos2)
	{
		Intent  intent = new Intent(this, VerImagen.class);
		intent.putExtra("url", imagenes[pos1]);
		startActivity(intent);
		
	}

}
