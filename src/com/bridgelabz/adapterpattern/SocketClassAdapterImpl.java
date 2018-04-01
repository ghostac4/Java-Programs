package com.bridgelab.designpattern.structuraldesignpatterns;

public class SocketClassAdapterImpl extends Socket implements SocketAdapter{

	@Override
	public Volt get120Volt() {
		return getVolt();
	}

	@Override
	public Volt get12Volt() {
		Volt volt = getVolt();
		return convertTo(volt, 10);
	}

	@Override
	public Volt get3Volt() {
		Volt volt = getVolt();
		return convertTo(volt, 40);
	}
	
	private Volt convertTo(Volt volt, int i){
		return new Volt(volt.getVolts()/i);
	}

}
