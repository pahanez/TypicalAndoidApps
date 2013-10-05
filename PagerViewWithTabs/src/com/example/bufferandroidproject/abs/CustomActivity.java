package com.example.bufferandroidproject.abs;

import static com.actionbarsherlock.app.ActionBar.NAVIGATION_MODE_LIST;

import java.util.List;

import org.eclipse.egit.github.core.User;

import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;

import com.actionbarsherlock.app.ActionBar;

public class CustomActivity extends TabPagerActivity<CustomPagerAdapter> implements LoaderCallbacks<List<String>>{
	
	public static final String ICON_NEWS = "\uf234";
	
    private void configureActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setNavigationMode(NAVIGATION_MODE_LIST);
    }
	
	@Override
	protected CustomPagerAdapter createAdapter() {
		return new CustomPagerAdapter(this, true);
	}

	@Override
	protected String getIcon(int position) {
		switch (position) {
		case 0:
			return ICON_NEWS;
		case 1:
			return ICON_NEWS;
		case 2:
			return ICON_NEWS;
		case 3:
			return ICON_NEWS;
		default:
			return super.getIcon(position);
		}
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		if (adapter == null){
			
			configureTabPager();
			configureActionBar();
		}

	}
	

	@Override
	public Loader<List<String>> onCreateLoader(int arg0, Bundle arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onLoadFinished(Loader<List<String>> arg0, List<String> arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLoaderReset(Loader<List<String>> arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
