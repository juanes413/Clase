package com.prueba.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.prueba.Details;
import com.prueba.R;

public class Vista1 extends ListFragment implements OnItemClickListener {

	String[] imagenes = {
			"http://4.bp.blogspot.com/-svSKrk4bAP4/TZvC1vOxjyI/AAAAAAAAAaM/b_PV_HYFZq4/s1600/los+simpson+%252811%2529.JPG",
			"http://k40.kn3.net/taringa/2/8/1/1/6/5/0/evanescence_1_re/861.jpg?1658",
			"http://michiphotography.net/wp-content/uploads/2014/02/Homero-Conversando-Con-Lisa.jpg",
			"https://fbcdn-sphotos-c-a.akamaihd.net/hphotos-ak-ash3/q71/s720x720/539107_10201028688657986_203208036_n.jpg" };
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		setListAdapter(new AdapterImage(getActivity(), imagenes));
		getListView().setOnItemClickListener(this);
	}

	private class AdapterImage extends BaseAdapter {

		private ImageLoader imageloader;
		private String[] urls;

		private final DisplayImageOptions options = new DisplayImageOptions.Builder()
				.showImageOnFail(R.drawable.image)
				.showImageOnLoading(R.drawable.image).cacheInMemory(true)
				.cacheOnDisk(true).considerExifParams(true).build();

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
				view = inflater.inflate(R.layout.list_item, parent, false);
				holder.image = (ImageView) view.findViewById(R.id.image);
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
	public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
		final Intent intent = new Intent(getActivity(), Details.class);
		intent.putExtra(Details.KEY_URL, imagenes[pos]);
		startActivity(intent);
	}

}
