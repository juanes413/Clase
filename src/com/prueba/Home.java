package com.prueba;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.prueba.fragments.Fragment1;
import com.prueba.fragments.Fragment2;
import com.prueba.fragments.Fragment3;

public class Home extends FragmentActivity implements OnItemClickListener {

	private final static String KEY_POS = "KEY_POS";
	private String title;
	private String[] items;
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	private ListView mDrawerList;
	private FragmentTransaction fragmentTransaction;
	private int pos_actual;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		mDrawerToggle = new ActionBarDrawerToggle(this, /* host Activity */
		mDrawerLayout, /* DrawerLayout object */
		R.drawable.ic_drawer, /* nav drawer icon to replace 'Up' caret */
		R.string.drawer_open, /* "open drawer" description */
		R.string.drawer_close /* "close drawer" description */
		) {

			/** Called when a drawer has settled in a completely closed state. */
			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
				setTitleApp(title);
				invalidateOptionsMenu();
			}

			/** Called when a drawer has settled in a completely open state. */
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				setTitleApp("AppMarket");
				invalidateOptionsMenu();
			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

		items = getResources().getStringArray(R.array.items);
		mDrawerList = (ListView) findViewById(R.id.home_list);

		mDrawerList.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_activated_1, items));

		mDrawerList.setOnItemClickListener(this);
		ChangeFragment(0);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		menu.findItem(R.id.menu1).setVisible(!drawerOpen);
		menu.findItem(R.id.menu2).setVisible(drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void ChangeFragment(int pos) {
		Fragment fragment;
		switch (pos) {
		case 0:
			fragment = new Fragment1();
			break;
		case 1:
			fragment = new Fragment2();
			break;
		case 2:
			fragment = new Fragment3();
			break;
		default:
			fragment = new Fragment1();
			break;
		}
		fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.replace(R.id.content_frame, fragment);
		fragmentTransaction.commit();
		title = items[pos];
		mDrawerLayout.closeDrawers();
		mDrawerList.setItemChecked(pos, true);
		setTitleApp(title);
		pos_actual = pos;
	}

	public void setTitleApp(String title) {
		getActionBar().setTitle(title);
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(KEY_POS, pos_actual);
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		pos_actual = savedInstanceState.getInt(KEY_POS, 0);
	}
	

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int pos,	long pos2) {
		if(pos_actual != pos)
		  ChangeFragment(pos);
		else
		  mDrawerLayout.closeDrawers();
		
	}
}
