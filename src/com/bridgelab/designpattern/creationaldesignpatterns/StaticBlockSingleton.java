package com.bridgelab.designpattern.creationaldesignpatterns;

public class StaticBlockSingleton {

	private static StaticBlockSingleton staticBlockSingleton;
	
	private StaticBlockSingleton(){}
	
	static{
		try{
			staticBlockSingleton = new StaticBlockSingleton();
		}catch(Exception e){
			System.out.print("\n"+e.toString());
		}
	}
	
	public static StaticBlockSingleton getInstance(){
		return staticBlockSingleton;
	}
	
}
