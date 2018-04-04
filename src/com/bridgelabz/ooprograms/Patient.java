package com.bridgelabz.ooprograms;

public class Patient
{

   private String name;
   private int id;
   private String mobileNumber;
   private int age;

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public int getId()
   {
      return id;
   }

   public void setId(int id)
   {
      this.id = id;
   }

   public String getMobileNumber()
   {
      return mobileNumber;
   }

   public void setMobileNumber(String mobileNumber)
   {
      this.mobileNumber = mobileNumber;
   }

   public int getAge()
   {
      return age;
   }

   public void setAge(int age)
   {
      this.age = age;
   }

   public void display()
   {
      System.out.print("\nName :" + getName() + " | ID : " + getId() + " | Mobile Number :" + getMobileNumber()
            + " | Age :" + age);
   }
}
