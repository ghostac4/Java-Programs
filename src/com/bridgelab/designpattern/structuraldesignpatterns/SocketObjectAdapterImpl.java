package com.bridgelab.designpattern.structuraldesignpatterns;

public class SocketObjectAdapterImpl implements SocketAdapter{

	Socket socket = new Socket();
	
	@Override
	public Volt get120Volt() {
		Volt volt = socket.getVolt();
		return volt;
	}

	@Override
	public Volt get12Volt() {
		Volt volt = socket.getVolt();
		return convertTo(volt, 10);
	}

	@Override
	public Volt get3Volt() {
		Volt volt = socket.getVolt();
		return convertTo(volt, 40);
	}

	private Volt convertTo(Volt volt, int i){
		return new Volt(volt.getVolts()/i);
	}
}
