package mvc.model;

import java.util.ArrayList;

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

}
