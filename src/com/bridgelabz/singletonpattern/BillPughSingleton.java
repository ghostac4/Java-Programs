package com.bridgelab.designpattern.creationaldesignpatterns;

public class BillPughSingleton {

	private BillPughSingleton(){}
	
	private static class BillPughHelper{
		private static final BillPughSingleton BILL_PUGH_SINGLETON = new BillPughSingleton();
	}
	
	public static BillPughSingleton getInstance(){
		return BillPughHelper.BILL_PUGH_SINGLETON;
	}
}
