/**
 * Purpose : Implementation of address book
 * 
 * @author Aniket Chile
 * @version 1.0
 * @since 21-03-2018
 */
package com.bridgelabz.ooprograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.bridgelabz.utility.Utility;

public class AddressBook
{

   @SuppressWarnings("unchecked")
   public static void main(String[] args)
   {
      Utility utility = new Utility();
      String path = "addressBook.json";

      List<Person> personsList = new ArrayList<>();

      String abJsonString = Utility.readFromFile(path);
      JSONArray jsonArray = (JSONArray) JSONValue.parse(abJsonString);
      JSONObject jsonObject = null;

      if (jsonArray != null) {
         for (int i = 0; i < jsonArray.size(); i++) {
            Person person = new Person();
            jsonObject = (JSONObject) jsonArray.get(i);
            person.setFirstName((String) jsonObject.get("firstName"));
            person.setLastName((String) jsonObject.get("lastName"));
            person.setAddress((String) jsonObject.get("address"));
            person.setState((String) jsonObject.get("state"));
            person.setCity((String) jsonObject.get("city"));
            person.setPhoneNumber((String) jsonObject.get("phoneNumber"));
            person.setZipcode(((Long) jsonObject.get("zipcode")).intValue());
            personsList.add(person);
         }
      }

      int choice;
      do {
         System.out.print("\n                 : 1.Add");
         System.out.print("\n                 : 2.View");
         System.out.print("\n                 : 3.Edit");
         System.out.print("\n                 : 4.Delete");
         System.out.print("\n                 : 5.Save");
         System.out.print("\n                 : 6.Sort by Name");
         System.out.print("\n                 : 7.Sort by Zip");
         System.out.print("\n                 : 8.Quit");
         System.out.print("\nEnter the choice : ");
         choice = utility.readInt();
         switch (choice) {
         case 1:
            utility.readLine();
            Person person = new Person();
            System.out.print("\nEnter the First name :");
            person.setFirstName(utility.readLine());
            System.out.print("\nEnter the Last name :");
            person.setLastName(utility.readLine());
            System.out.print("\nEnter the Address :");
            person.setAddress(utility.readLine());
            System.out.print("\nEnter the city :");
            person.setCity(utility.readLine());
            System.out.print("\nEnter the state :");
            person.setState(utility.readLine());
            System.out.print("\nEnter the Phone Number :");
            person.setPhoneNumber(utility.readLine());
            System.out.print("\nEnter the Zipcode :");
            person.setZipcode(utility.readInt());
            personsList.add(person);
            break;
         case 2:
            int i = 1;
            System.out.print("\n***************************Address Book******************************");
            System.out.print("\n_____________________________________________________________________");
            for (Person person2 : personsList) {
               System.out.print("\n " + i + ". " + person2.getFirstName() + " " + person2.getLastName());
               System.out.print("\n                                         " + person2.getAddress());
               System.out.print("\n                                         " + person2.getState());
               System.out.print("\n                                         " + person2.getCity());
               System.out.print("\n                                         " + person2.getZipcode());
               System.out.print("\n                                         " + person2.getPhoneNumber());
               System.out.print("\n_________________________________________________________________");
               i++;
            }
            break;
         case 3:
            utility.readLine();
            System.out.print("\nEnter the First Name : ");
            String firstName = utility.readLine();
            System.out.print("\nEnter the Last Name : ");
            String lastName = utility.readLine();
            for (Person person2 : personsList) {
               if (person2.getFirstName().equals(firstName) && person2.getLastName().equals(lastName)) {
                  System.out.print("\n                 : 1.First Name.");
                  System.out.print("\n                 : 2.Last Name.");
                  System.out.print("\n                 : 3.Address.");
                  System.out.print("\n                 : 4.State.");
                  System.out.print("\n                 : 5.City.");
                  System.out.print("\n                 : 6.Zipcode.");
                  System.out.print("\n                 : 7.Phone Number.");
                  System.out.print("\nEnter the choice to Edit : ");
                  int choice2 = utility.readInt();
                  switch (choice2) {
                  case 1:
                     utility.readLine();
                     System.out.print("\nEnter the First name :");
                     person2.setFirstName(utility.readLine());
                     break;
                  case 2:
                     utility.readLine();
                     System.out.print("\nEnter the Last name :");
                     person2.setLastName(utility.readLine());
                     break;
                  case 3:
                     utility.readLine();
                     System.out.print("\nEnter the Address :");
                     person2.setAddress(utility.readLine());
                     break;
                  case 4:
                     utility.readLine();
                     System.out.print("\nEnter the state :");
                     person2.setState(utility.readLine());
                     break;
                  case 5:
                     utility.readLine();
                     System.out.print("\nEnter the city :");
                     person2.setCity(utility.readLine());
                     break;
                  case 6:
                     utility.readLine();
                     System.out.print("\nEnter the Phone Number :");
                     person2.setPhoneNumber(utility.readLine());
                     break;
                  case 7:
                     System.out.print("\nEnter the Zipcode :");
                     person2.setZipcode(utility.readInt());
                  default:
                     break;
                  }
               }
            }
         case 4:
            utility.readLine();
            System.out.print("\nEnter the First Name : ");
            String firstName2 = utility.readLine();
            System.out.print("\nEnter the Last Name : ");
            String lastName2 = utility.readLine();
            for (Person person2 : personsList) {
               if (person2.getFirstName().equals(firstName2) && person2.getLastName().equals(lastName2)) {
                  personsList.remove(person2);
                  break;
               }
            }
         case 5:
            JSONArray jsonArray2 = new JSONArray();
            for (Person person2 : personsList) {
               JSONObject jsonObject2 = new JSONObject();
               jsonObject2.put("firstName", person2.getFirstName());
               jsonObject2.put("lastName", person2.getLastName());
               jsonObject2.put("address", person2.getAddress());
               jsonObject2.put("state", person2.getState());
               jsonObject2.put("city", person2.getCity());
               jsonObject2.put("zipcode", person2.getZipcode());
               jsonObject2.put("phoneNumber", person2.getPhoneNumber());
               jsonArray2.add(jsonObject2);
            }
            String jsonString = JSONValue.toJSONString(jsonArray2);
            Utility.writeToFile(jsonString, path);
            break;
         case 6:
            Collections.sort(personsList, new NameComparator());
            int i1 = 1;
            System.out.print("\n***************************Address Book******************************");
            System.out.print("\n_____________________________________________________________________");
            for (Person person2 : personsList) {
               System.out.print("\n " + i1 + ". " + person2.getFirstName() + " " + person2.getLastName());
               System.out.print("\n                                         " + person2.getAddress());
               System.out.print("\n                                         " + person2.getState());
               System.out.print("\n                                         " + person2.getCity());
               System.out.print("\n                                         " + person2.getZipcode());
               System.out.print("\n                                         " + person2.getPhoneNumber());
               System.out.print("\n_________________________________________________________________");
               i1++;
            }
            break;
         case 7:
            Collections.sort(personsList, new ZipCodeComparator());
            i1 = 1;
            System.out.print("\n***************************Address Book******************************");
            System.out.print("\n_____________________________________________________________________");
            for (Person person2 : personsList) {
               System.out.print("\n " + i1 + ". " + person2.getFirstName() + " " + person2.getLastName());
               System.out.print("\n                                         " + person2.getAddress());
               System.out.print("\n                                         " + person2.getState());
               System.out.print("\n                                         " + person2.getCity());
               System.out.print("\n                                         " + person2.getZipcode());
               System.out.print("\n                                         " + person2.getPhoneNumber());
               System.out.print("\n_________________________________________________________________");
               i1++;
            }
            break;
         case 8:
         default:
            break;
         }
      } while (choice != 8);
   }
}
