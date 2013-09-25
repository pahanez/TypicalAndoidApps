package com.example.bufferandroidproject.abs;

import android.content.Context;
import android.view.View;

import com.github.kevinsawicki.wishlist.SingleTypeAdapter;

public class CustomStringAdapter extends SingleTypeAdapter<String>{


	public CustomStringAdapter(Context context, String[] data) {
		super(context, android.R.layout.simple_list_item_1);
		
		setItems(data);
	}
	
	protected void updateDetails(final String str){
		setText(0, str);
	}
	
	@Override
	protected View initialize(View view) {

		return super.initialize(view);
	}

	@Override
    protected int[] getChildViewIds() {
        return new int[] { android.R.id.text1 };
    }

	@Override
	protected void update(int position, String item) {
		updateDetails(item);
	}

}
