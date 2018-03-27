package com.bridgelab.designpattern.creationaldesignpatterns;

public class PrototypePatternTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Employee employee = new Employee();
		employee.loadData();
		
		Employee employee2 = (Employee) employee.clone();
		Employee employee3 = (Employee) employee.clone();
		
		employee2.getEmplist().add("David");
		employee3.getEmplist().remove("aniket");
		
		System.out.print("\nEmployee :"+employee.getEmplist());
		System.out.print("\nEmployee2 :"+employee2.getEmplist());
		System.out.print("\nEmployee3 :"+employee3.getEmplist());
	}

}
