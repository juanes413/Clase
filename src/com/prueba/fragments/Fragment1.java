package com.prueba.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prueba.R;
import com.prueba.utils.SlidingTabLayout;

public class Fragment1 extends Fragment {

	private SlidingTabLayout mSlidingTabLayout;
	private ViewPager mViewPager;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View view =  inflater.inflate(R.layout.fragment1, container, false);
		mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
		mViewPager.setAdapter(new AppSectionsPagerAdapter(getChildFragmentManager(), getActivity()));
		mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
		mSlidingTabLayout.setViewPager(mViewPager);
		return view;
	}

	public static class AppSectionsPagerAdapter extends FragmentStatePagerAdapter {
		Context context;

		public AppSectionsPagerAdapter(FragmentManager fm, Context cont) {
			super(fm);
			context = cont;
		}

		@Override
		public Fragment getItem(int i) {
			switch (i) {
			case 0:
				return new Vista1();
			case 1:
				return new Vista2();
			case 2:
				return new Vista3();
			default:
				return null;
			}
		}

		@Override
		public int getCount() {
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			switch (position) {
			case 0:
				return context.getResources().getString(R.string.tab1);
			case 1:
				return context.getResources().getString(R.string.tab2);
			case 2:
				return context.getResources().getString(R.string.tab3);
			default:
				return null;
			}
		}
	}
}
