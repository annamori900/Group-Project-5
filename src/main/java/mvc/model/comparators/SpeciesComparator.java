package mvc.model.comparators;

import java.util.Comparator;

import mvc.model.pets.Pet;

public class SpeciesComparator implements Comparator<Pet> {

	/**
	 * This method is the implementation from the Comparator interface to compare Pet objects, specifically pet's species' alphabetically
	 * @param p1 The first Pet object to be compared
	 * @param p2 The second Pet object to be compared to the first
	 * @return Returns a negative primitive integer if the first pet's species is after the second pet's name in the alphabet
	 *                   zero if the first pet's species and the second pet's species are the same
	 *                   or a positive primitive integer if the first pet's species is before the second pet's name in the alphabet
	 */
	@Override
	public int compare(Pet p1, Pet p2) {
		return p1.getSpecies().compareToIgnoreCase(p2.getSpecies());
	}
	
}