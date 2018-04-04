package com.bridgelabz.ooprograms;

import java.util.Comparator;

public class NameComparator implements Comparator<Person>
{

   @Override
   public int compare(Person o1, Person o2)
   {
      if (o1.getLastName().equals(o2.getLastName()))
         return 0;
      else if (o1.getLastName().compareTo(o2.getLastName()) > 0)
         return 1;
      else
         return -1;
   }

}
