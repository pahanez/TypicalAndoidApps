package com.example.bufferandroidproject.abs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import android.os.Bundle;
import android.support.v4.content.Loader;

import com.github.kevinsawicki.wishlist.AsyncLoader;
import com.github.kevinsawicki.wishlist.SingleTypeAdapter;

public class CustomPagerFragment extends ItemListFragment<String> {

	@Override
	public Loader<List<String>> onCreateLoader(int arg0, Bundle arg1) {
		return new AsyncLoader<List<String>>(getActivity()) {
			@Override
			public List<String> loadInBackground() {
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return Arrays.asList("data_1","data_2","data_3","data_4","data_5","data_6","data_7","data_8");
			}
		};
	}

	@Override
	protected int getErrorMessage(Exception exception) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected SingleTypeAdapter<String> createAdapter(List<String> items) {
		return new CustomStringAdapter(getActivity(),
				items.toArray(new String[items.size()]));
	}

}
