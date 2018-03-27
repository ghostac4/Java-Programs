package com.bridgelab.designpattern.creationaldesignpatterns;

public class ThreadSafeSingleton {

	private static ThreadSafeSingleton threadSafeSingleton;
	
	private ThreadSafeSingleton(){}
	
	public static ThreadSafeSingleton getIntance(){
		if(threadSafeSingleton==null){
			synchronized (ThreadSafeSingleton.class) {
				if(threadSafeSingleton==null){
					threadSafeSingleton = new ThreadSafeSingleton();
				}
			}
		}
		return threadSafeSingleton;
	}
	
}
