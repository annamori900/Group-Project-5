package mvc.model.comparators;

import java.util.Comparator;

import mvc.model.pets.Pet;

public class SpeciesComparator implements Comparator<Pet> {

	@Override
	public int compare(Pet p1, Pet p2) {
		return p1.getSpecies().compareToIgnoreCase(p2.getSpecies());
	}

}