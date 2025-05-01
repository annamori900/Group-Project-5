package mvc.model.comparators;

import java.util.Comparator;

import mvc.model.pets.Pet;

public class AgeComparator implements Comparator<Pet> {

	/**
	 * This method is the implementation from the Comparator interface to compare Pet objects, specifically pet's ages
	 * @param p1 The first Pet object to be compared
	 * @param p2 The second Pet object to be compared to the first
	 * @return Returns a negative primitive integer if the first pet's age is less than the second pet's age
	 *                   zero if the first pet's age and the second pet's age are equal
	 *                   or a positive primitive integer if the first pet's age is greater than the second pet's age
	 */
	@Override
	public int compare(Pet p1, Pet p2) {
		return Integer.compare(p1.getAge(), p2.getAge());
	}

}