package com.bridgelabz.prototypepattern;

import java.util.ArrayList;
import java.util.List;

public class Employee implements Cloneable
{

   private List<String> emplist;

   public Employee()
   {
      emplist = new ArrayList<>();
   }

   public Employee(List<String> emplist)
   {
      this.emplist = emplist;
   }

   public void loadData()
   {
      emplist.add("aniket");
      emplist.add("john");
      emplist.add("doe");
   }

   public List<String> getEmplist()
   {
      return emplist;
   }

   @Override
   public Object clone() throws CloneNotSupportedException
   {
      List<String> temp = new ArrayList<>();
      for (String emp : emplist) {
         temp.add(emp);
      }
      return new Employee(temp);
   }
}
