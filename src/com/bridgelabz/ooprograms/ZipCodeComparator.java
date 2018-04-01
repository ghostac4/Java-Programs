package com.bridgelab.ooprograms;

import java.util.Comparator;

public class ZipCodeComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		if (o1.getZipcode() == o2.getZipcode())
			return 0;
		else if(o1.getZipcode() > o2.getZipcode())
			return 1;
		else
			return -1;
	}

}
