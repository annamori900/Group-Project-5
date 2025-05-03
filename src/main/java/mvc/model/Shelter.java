package mvc.model;

import java.util.ArrayList;
import java.util.Collections;

import mvc.model.comparators.AgeComparator;
import mvc.model.comparators.SpeciesComparator;
import mvc.model.pets.Pet;	



public class Shelter<T extends Pet> {
	
	private ArrayList<T> pets;
	
	/**
	 * This is the default constructor to create a new ArrayList of generic T objects with an upper limit of the abstract Pet class stored in the pets member
	 */
	public Shelter() {
		pets = new ArrayList<>();
	}

	/**
	 * This method is a getter for the shelter's ArrayList of Pet objects
	 * @return Returns the ArrayList of pets in the shelter
	 */
	public ArrayList<T> getPets() {
		return pets;
	}

	/**
	 * This method sorts the shelter's ArrayList of pets by name alphabetically utilizing the Pet's implementation of the Comparable interface
	 */
	public void sortByName() {
		Collections.sort(pets);
	}
	
	/**
	 * This method sorts the shelter's ArrayList of pets by age in increasing order utilizing the AgeComparator class and Comparator interface
	 */
	public void sortByAge() {
		pets.sort(new AgeComparator());
	}
	
	/**
	 * This method sorts the shelter's ArrayList of pets by species alphabetically utilizing the SpeciesComparator class and Comparator interface
	 */
	public void sortBySpecies() {
		pets.sort(new SpeciesComparator());
	}

}
