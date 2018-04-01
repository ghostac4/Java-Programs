package com.bridgelab.designpattern.structuraldesignpatterns;

public class IPhone implements MobileShop{

	@Override
	public void mobileNo() {
		System.out.print("\nIPhone X");
	}

	@Override
	public void price() {
		System.out.print("\nRs.90,000");
	}

}
