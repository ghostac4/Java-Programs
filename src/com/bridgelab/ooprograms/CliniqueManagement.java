/**
 * Purpose : Program to manage doctors and patients in clinique
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 21-03-2018
 */
package com.bridgelab.ooprograms;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.bridgelab.utility.Utility;

public class CliniqueManagement {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Utility utility = new Utility();
		String pathPatients = "patientsList.json";
		String pathDoctors = "doctorsList.json";
		List<Patient> patientsList = new ArrayList<>();
		List<Doctor> doctorsList = new ArrayList<>();
		int choice;
		
		do {
			System.out.print("\n                  : 1.Read Patient & Doctor Data.");
			System.out.print("\n                  : 2.Write Data.");
			System.out.print("\n                  : 3.Search Doctor.");
			System.out.print("\n                  : 4.Search Patient.");
			System.out.print("\n                  : 5.Display Doctor/Patients Report.");
			System.out.print("\n                  : 6.Quit.");
			System.out.print("\nEnter your choice : ");
			choice = utility.readInt();
			switch (choice) {
			case 1:
				String jsonStringInput = Utility.readFromFile(pathPatients);
				JSONArray jsonArray2 = (JSONArray) JSONValue.parse(jsonStringInput);
				JSONObject jsonObject2 = null;
				
				if (jsonArray2 != null) {
					for (int i = 0; i < jsonArray2.size(); i++) {
						Patient patient = new Patient();
						jsonObject2 = (JSONObject) jsonArray2.get(i);
						patient.setName((String) jsonObject2.get("name"));
						patient.setId(((Long) jsonObject2.get("id")).intValue());
						patient.setMobileNumber((String) jsonObject2.get("mobileNumber"));
						patient.setAge(((Long) jsonObject2.get("age")).intValue());
						patientsList.add(patient);
					}
				}
				
				jsonStringInput = Utility.readFromFile(pathDoctors);
				jsonArray2 = (JSONArray) JSONValue.parse(jsonStringInput);
				if (jsonArray2 != null) {
					for (int i = 0; i < jsonArray2.size(); i++) {
						Doctor doctor = new Doctor();
						jsonObject2 = (JSONObject) jsonArray2.get(i);
						doctor.setName((String) jsonObject2.get("name"));
						doctor.setId(((Long) jsonObject2.get("id")).intValue());
						doctor.setSpeciality((String) jsonObject2.get("speciality"));
						doctor.setAvailability((String) jsonObject2.get("availability"));
						JSONArray apJsonArray = (JSONArray) jsonObject2.get("appointments");
						if (apJsonArray != null) {
							for (int j = 0; j < apJsonArray.size(); j++) {
								Patient patient = new Patient();
								JSONObject jsonObject3 = (JSONObject) apJsonArray.get(j);
								patient.setName((String) jsonObject3.get("name"));
								patient.setId(((Long) jsonObject3.get("id")).intValue());
								patient.setMobileNumber((String) jsonObject3.get("mobileNumber"));
								patient.setAge(((Long) jsonObject3.get("age")).intValue());
								doctor.getAppointments().add(patient);
							}
						}
						doctorsList.add(doctor);
					}
				}
				break;
			case 2:
				JSONArray jsonArray = new JSONArray();
				for (Patient patient : patientsList) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("name", patient.getName());
					jsonObject.put("id", patient.getId());
					jsonObject.put("mobileNumber", patient.getMobileNumber());
					jsonObject.put("age", patient.getAge());
					jsonArray.add(jsonObject);
				}
				String jsonStringOutput = JSONValue.toJSONString(jsonArray);
				Utility.writeToFile(jsonStringOutput, pathPatients);
				JSONArray jsonArray3 = new JSONArray();
				for (Doctor doctor : doctorsList) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("name", doctor.getName());
					jsonObject.put("id", doctor.getId());
					jsonObject.put("speciality", doctor.getSpeciality());
					jsonObject.put("availability", doctor.getAvailability());
					JSONArray jsonArray4 = new JSONArray();
					if (jsonArray4 != null) {
						for (Patient patient : doctor.getAppointments()) {
							JSONObject jsonObject3 = new JSONObject();
							jsonObject3.put("name", patient.getName());
							jsonObject3.put("id", patient.getId());
							jsonObject3.put("mobileNumber", patient.getMobileNumber());
							jsonObject3.put("age", patient.getAge());
							jsonArray4.add(jsonObject3);
						}
					}
					jsonObject.put("appointments", jsonArray4);
					jsonArray3.add(jsonObject);
				}
				jsonStringOutput = JSONValue.toJSONString(jsonArray3);
				Utility.writeToFile(jsonStringOutput, pathDoctors);
				break;
			case 3:
				System.out.print("\n                 : 1.Name.");
				System.out.print("\n                 : 2.ID");
				System.out.print("\n                 : 3.Specialization.");
				System.out.print("\n                 : 4.Availability.");
				System.out.print("\nSearch Doctor By : ");
				int choice2 = utility.readInt();
				Doctor doctor2 = null;
				switch (choice2) {
				case 1:
					utility.readLine();
					System.out.print("\nEnter Name (without Dr.) : ");
					String name = "Dr." + utility.readLine();
					for (Doctor doctor : doctorsList) {
						if (doctor.getName().equalsIgnoreCase(name)) {
							doctor.display();
							doctor2 = doctor;
						}
					}
					break;
				case 2:
					System.out.print("\nEnter ID number : ");
					int id = utility.readInt();
					utility.readLine();
					for (Doctor doctor : doctorsList) {
						if (doctor.getId() == id) {
							doctor.display();
							doctor2 = doctor;
						}
					}
					break;
				case 3:
					utility.readLine();
					System.out.print("\nEnter Specialization : ");
					String Specialization = utility.readLine();
					for (Doctor doctor : doctorsList) {
						if (doctor.getSpeciality().equalsIgnoreCase(Specialization)) {
							doctor.display();
							doctor2 = doctor;
						}
					}
					break;
				case 4:
					utility.readLine();
					System.out.print("\nEnter Specialization : ");
					String Availability = utility.readLine();
					for (Doctor doctor : doctorsList) {
						if (doctor.getAvailability().equalsIgnoreCase(Availability)) {
							doctor.display();
							doctor2 = doctor;
						}
					}
					break;
				}
				System.out.print("\nDo you want to take appointment ? y/n");
				String takeAppoinment = utility.readLine();
				if (takeAppoinment.equalsIgnoreCase("y")) {
					System.out.print("\nEnter Pateint-ID : ");
					int id = utility.readInt();
					for (Patient patient : patientsList) {
						if (patient.getId() == id) {
							doctor2.getAppointments().add(patient);
						}
					}
				}
				break;
			case 4:
				System.out.print("\n                 : 1.Name.");
				System.out.print("\n                 : 2.ID");
				System.out.print("\n                 : 3.Mobile Number.");
				System.out.print("\nSearch Patient By : ");
				int choice3 = utility.readInt();
				switch (choice3) {
				case 1:
					utility.readLine();
					System.out.print("\nEnter Name : ");
					String name = utility.readLine();
					for (Patient patient : patientsList) {
						if (patient.getName().equalsIgnoreCase(name)) {
							patient.display();
						}
					}
					break;
				case 2:
					System.out.print("\nEnter ID : ");
					int id = utility.readInt();
					for (Patient patient : patientsList) {
						if (patient.getId() == id) {
							patient.display();
						}
					}
					break;
				case 3:
					utility.readLine();
					System.out.print("\nEnter Mobile Number : ");
					String mobileNumber = utility.readLine();
					for (Patient patient : patientsList) {
						if (patient.getMobileNumber().equalsIgnoreCase(mobileNumber)) {
							patient.display();
						}
					}
					break;
				}
				break;
			case 5:
				System.out.print("\n_______________________Doctors__________________________");
				System.out.print("\n");
				for (Doctor doctor : doctorsList) {
					doctor.display();
					System.out.print("\n_________________________________________________________");
				}
				System.out.print("\n_______________________Patients__________________________");
				System.out.print("\n");
				for (Patient patient : patientsList) {
					System.out.print("\n");
					patient.display();
					System.out.print("\n_________________________________________________________");
				}
				break;
			case 6:
			default:
				break;
			}
		} while (choice != 6);
	}

}
