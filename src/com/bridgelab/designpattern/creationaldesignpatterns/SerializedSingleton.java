package com.bridgelab.designpattern.creationaldesignpatterns;

import java.io.Serializable;

public class SerializedSingleton implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SerializedSingleton(){}
	
	private static class SingletonHelper{
		private static final SerializedSingleton SERIALIZED_SINGLETON = 
				new SerializedSingleton();
	}
	
	public static SerializedSingleton getIntance(){
		return SingletonHelper.SERIALIZED_SINGLETON;
	}
	
	protected Object readResolve(){
		return getIntance();
	}
}
