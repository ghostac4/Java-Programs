package com.bridgelabz.ooprograms;

public class Person
{

   private String firstName;
   private String lastName;
   private String address;
   private String city;
   private String state;
   private int zipcode;
   private String phoneNumber;

   /**
    * function to get first name
    * 
    * @return firstname is a string
    */
   public String getFirstName()
   {
      return firstName;
   }

   /**
    * function to set first name
    * 
    * @param firstName is a string
    */
   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   }

   /**
    * function to get last name
    * 
    * @return lastName is a string
    */
   public String getLastName()
   {
      return lastName;
   }

   /**
    * function to set last name
    * 
    * @param lastName is a string
    */
   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }

   /**
    * function to get address
    * 
    * @return address is a string
    */
   public String getAddress()
   {
      return address;
   }

   /**
    * function to set address
    * 
    * @param address is a string
    */
   public void setAddress(String address)
   {
      this.address = address;
   }

   /**
    * function to get city
    * 
    * @return city is a string
    */
   public String getCity()
   {
      return city;
   }

   /**
    * function to set the city
    * 
    * @param city is string
    */
   public void setCity(String city)
   {
      this.city = city;
   }

   /**
    * function to get state
    * 
    * @return state is a string
    */
   public String getState()
   {
      return state;
   }

   /**
    * function to set the state
    * 
    * @param state is s a string
    */
   public void setState(String state)
   {
      this.state = state;
   }

   /**
    * function to get zipcode
    * 
    * @return zipcode is a number
    */
   public int getZipcode()
   {
      return zipcode;
   }

   /**
    * function to set zipcode
    * 
    * @param zipcode is a number
    */
   public void setZipcode(int zipcode)
   {
      this.zipcode = zipcode;
   }

   /**
    * function to get phone number
    * 
    * @return phoneNumber is a String
    */
   public String getPhoneNumber()
   {
      return phoneNumber;
   }

   /**
    * function to set phone number
    * 
    * @param phoneNumber is a String
    */
   public void setPhoneNumber(String phoneNumber)
   {
      this.phoneNumber = phoneNumber;
   }

}
