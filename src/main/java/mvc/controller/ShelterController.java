package mvc.controller;

import mvc.model.Shelter;
import mvc.model.pets.Pet;
import mvc.view.ShelterView;

public class ShelterController {
	
	private Shelter<Pet> model;
	private ShelterView view;
	
	public ShelterController(Shelter<Pet> model, ShelterView view) {
		this.model = model;
		this.view = view;
		
	}
	
	public void initiate() {
		view.setVisible(true);
	}
	
	public void addPet(Pet pet) {
		model.getPets().add(pet);
	}
	
	public void removePet(Pet pet) {
		model.getPets().remove(pet);
	}
	
	public void adoptPet(Pet pet) {
		if (pet.isAdopted()) {
			System.out.println(pet.getName() + " has already been adoped.");
			return;
		}
		pet.setAdopted(true);
	}

}
