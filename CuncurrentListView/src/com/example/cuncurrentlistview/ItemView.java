package com.example.cuncurrentlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.kevinsawicki.wishlist.ViewFinder;

public class ItemView extends RelativeLayout{
	
	
	private TextView mTextView;
	private ProgressBar mProgressBar;

	
	public ItemView(Context context) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
		View view = inflater.inflate(R.layout.item_view, this, true);
		ViewFinder finder = new ViewFinder(view);
		mTextView = finder.find(R.id.item_text_view);
		mProgressBar = finder.find(R.id.item_progress_bar);
		mProgressBar.setMax(100);
	}
	
	public void setItem(Item item){
		mTextView.setText(item.mName);
		mProgressBar.setProgress(item.mProgress);
	}
	
}
