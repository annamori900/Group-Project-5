package mvc.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;

import mvc.model.comparators.AgeComparator;
import mvc.model.comparators.SpeciesComparator;
import mvc.model.pets.Pet;

@SuppressWarnings("deprecation")
public class Shelter<T extends Pet> extends Observable {
	
	private ArrayList<T> pets;
	
	public Shelter() {
		pets = new ArrayList<>();
	}

	public ArrayList<T> getPets() {
		return pets;
	}

	public void setPets(ArrayList<T> pets) {
		this.pets = pets;
		setChanged();
		notifyObservers();
	}

	public void sortByName() {
		Collections.sort(pets);
		setChanged();
		notifyObservers();
	}
	
	public void sortByAge() {
		pets.sort(new AgeComparator());
		setChanged();
		notifyObservers();
	}
	
	public void sortBySpecies() {
		pets.sort(new SpeciesComparator());
		setChanged();
		notifyObservers();
	}

}
