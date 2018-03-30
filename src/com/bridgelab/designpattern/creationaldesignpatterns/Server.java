package com.bridgelab.designpattern.creationaldesignpatterns;

public class Server extends Computer{

	private String RAM;
	private String HDD;
	private String CPU;
	
	public Server(String RAM,String HDD,String CPU){
		this.RAM = RAM;
		this.CPU=CPU;
		this.HDD= HDD;
	}
	
	@Override
	public String getRAM() {
		return RAM;
	}

	@Override
	public String getHDD() {
		return HDD;
	}

	@Override
	public String getCPU() { 
		return CPU;
	}

}
