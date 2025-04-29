package mvc.model;

import java.util.ArrayList;
import java.util.Collections;

import mvc.model.comparators.AgeComparator;
import mvc.model.comparators.SpeciesComparator;
import mvc.model.pets.Pet;

public class Shelter<T extends Pet> {
	
	private ArrayList<T> pets;
	
	public Shelter() {
		pets = new ArrayList<>();
	}

	public ArrayList<T> getPets() {
		return pets;
	}

	public void setPets(ArrayList<T> pets) {
		this.pets = pets;
	}

	public void sortByName() {
		Collections.sort(pets);
	}
	
	public void sortByAge() {
		pets.sort(new AgeComparator());
	}
	
	public void sortBySpecies() {
		pets.sort(new SpeciesComparator());
	}

}
