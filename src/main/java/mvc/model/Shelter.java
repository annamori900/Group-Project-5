package mvc.model;

import java.util.ArrayList;
import java.util.Collections;

import mvc.model.adapter.ExoticAnimalAdapter;
import mvc.model.comparators.AgeComparator;
import mvc.model.comparators.SpeciesComparator;
import mvc.model.pets.Cat;
import mvc.model.pets.Dog;
import mvc.model.pets.ExoticAnimal;
import mvc.model.pets.Pet;
import mvc.model.pets.Rabbit;

public class Shelter<T extends Pet> {
	
	private ArrayList<T> pets;
	
	/**
	 * This is the default constructor to create a new ArrayList of generic T objects with an upper limit of the abstract Pet class stored in the pets member
	 */
	public Shelter() {
		pets = new ArrayList<>();
		
//		hard coded for testing
		
//		Dog d1 = new Dog(1, "Buddy", "Golden Retriever", 3, false);
//		Cat c = new Cat(2, "Whiskers", "Siamese", 2, false);
//		Rabbit r = new Rabbit(3, "Thumper", "Dutch", 1, false);
//		Dog d2 = new Dog(4, "Shadow", "German Shepherd", 5, false);
//		ExoticAnimal a1 = new ExoticAnimal("exo001", "Zazu", "Bird", "Toucan", 4);
//		ExoticAnimal a2 = new ExoticAnimal("exo002", "Kaa", "Reptile", "Python", 6);
//		ExoticAnimal a3 = new ExoticAnimal("exo003", "Iggy", "Reptile", "Iguana", 2);
//		Pet e1 = new ExoticAnimalAdapter(a1);
//		Pet e2 = new ExoticAnimalAdapter(a2);
//		Pet e3 = new ExoticAnimalAdapter(a3);
//		pets.add((T) d1);
//		pets.add((T) c);
//		pets.add((T) r);
//		pets.add((T) d2);
//		pets.add((T) e1);
//		pets.add((T) e2);
//		pets.add((T) e3);
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
