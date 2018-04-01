package com.bridgelab.ooprograms;

import java.util.ArrayList;
import java.util.List;

public class Doctor {

	private String name;
	private int id;
	private String speciality;
	private String availability;
	private List<Patient> appointments;

	public Doctor() {
		appointments = new ArrayList<>();
	}

	public List<Patient> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Patient> appointments) {
		this.appointments = appointments;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	public void display(){
		System.out.print("\n "+id+" -> "+name);
		System.out.print("\n                             "+speciality);
		System.out.print("\n                             "+availability);
		System.out.print("\n                             Appointments :");
		if(appointments.isEmpty()){
			System.out.print("\n                                          : No Appointments.");
		}else{
			int i=1;
			for(Patient patient : appointments){
				System.out.print("\n                                          :"+i+". "
						+patient.getName()+" "+patient.getId()+" "+" "+patient.getMobileNumber());
				i++;
			}
		}
		
	}
	
	public boolean isAvailable(){
		if(appointments.size() == 5)
			return false;
		else
			return true;
	}

}
