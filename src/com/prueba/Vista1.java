package com.prueba;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Vista1 extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.vista1, container, false);
		final Button b = (Button)view.findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {				
			@Override
			public void onClick(View v) {
				getFragmentManager().beginTransaction().add(R.id.container, new Vista2())
				.addToBackStack("vista1").commit();
				
			}
		});
		
		return view;
	}
	
}
