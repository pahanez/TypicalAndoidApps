package com.example.cuncurrentlistview;

import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ConcurrentItemManager {
	private Executor mExecutor = Executors.newCachedThreadPool();
	private TreeMap<String, ItemTask> taskQueue = new TreeMap<String, ItemTask>();
	
	private static ConcurrentItemManager sInstance;
	
	private ConcurrentItemManager(){}
	
	public static synchronized ConcurrentItemManager getInstance(){
		return sInstance == null ? sInstance = new ConcurrentItemManager(): sInstance;
	}
	
	public void addTaskToQueue(Item item,ItemTask task){
		synchronized (taskQueue) {
			taskQueue.put(item.mName, task);
		}
	}
	
	public void removeFromQueue(Item item){
		synchronized (taskQueue) {
			taskQueue.remove(item.mName);
		}
	}
	
	public boolean hasInQueue(Item item){
		synchronized (taskQueue) {
			return taskQueue.containsKey(item.mName);
		}
	}
	
	public ItemTask getTaskFromQuue(Item item) {
		synchronized (taskQueue) {
			return taskQueue.get(item.mName);
		}
	}
	
	public interface TaskStatusChangedListener{
		void onCreate();
		void onComplete();
		void onUpdate();
	}
	
	public void execute(final Item item,TaskStatusChangedListener callback){
		ItemTask task = new ItemTask(item,callback);
		
		addTaskToQueue(item, task);
		mExecutor.execute(task);
		
	}
	
	
}
