package com.example.cuncurrentlistview;

import java.util.concurrent.TimeUnit;

import com.example.cuncurrentlistview.ConcurrentItemManager.TaskStatusChangedListener;

public class ItemTask implements Runnable {
	private Item mItem;
	private TaskStatusChangedListener mCallback;

	public ItemTask(Item item,TaskStatusChangedListener callback) {
		mItem = item;
		mCallback = callback;
		mCallback.onCreate(); 
	}
	
	public TaskStatusChangedListener getCallback(){
		return mCallback;
	}

	@Override
	public void run() {
		
		while (mItem.mProgress < 100) {

			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			mItem.mProgress += 1;
			mCallback.onUpdate();
		}
	mCallback.onComplete();
	}

}
