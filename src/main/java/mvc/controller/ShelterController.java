package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import mvc.model.Shelter;
import mvc.model.adapter.ExoticAnimalAdapter;
import mvc.model.pets.Cat;
import mvc.model.pets.Dog;
import mvc.model.pets.ExoticAnimal;
import mvc.model.pets.Pet;
import mvc.model.pets.Rabbit;
import mvc.view.DetailsView;
import mvc.view.ShelterView;

public class ShelterController {
	
	private Shelter<Pet> model;
	private ShelterView view;
	private DetailsView detailsView = null;
	
	public ShelterController(Shelter<Pet> model, ShelterView view) {
		this.model = model;
		this.view = view;
		this.view.showShelterOnList(model);
		this.view.addListenerToAddButton(new AddButtonListener());
		this.view.addListenerToRemoveButton(new RemoveButtonListener());
		this.view.addListenerToViewDetailsButton(new ViewDetailsButtonListener());
		this.view.addListenerToSaveButton(new SaveButtonListener());
		this.view.addListenerToAdoptButton(new AdoptButtonListener());
		this.view.addListenerToComboBox(new ComboBoxListener());
	}
	
	public void initiate() {
		view.getFrame().setVisible(true);
	}
	
	private class AddButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Pet pet;
			
			if (view.getIdFromTextField().equals("") ||
				view.getNameFromTextField().equals("") ||
				view.getTypeFromTextField().equals("") ||
				view.getSpeciesFromTextField().equals("") ||
				view.getAgeFromTextField().equals("")) { return; }
			
			for (char c : view.getIdFromTextField().toCharArray()) {
	            if (!Character.isDigit(c)) {
	            	System.out.println("ID cannot contain non-digit values.");
	                return;
	            }
	        }
			for (Pet p : model.getPets()) {
				if (p.getId() == Integer.parseInt(view.getIdFromTextField())) {
					System.out.println("ID already exists");
					return;
				}
			}
			
			for (char c : view.getAgeFromTextField().toCharArray()) {
	            if (!Character.isDigit(c)) {
	            	System.out.println("Age cannot contain non-digit values.");
	                return;
	            }
	        }
			if (Integer.parseInt(view.getAgeFromTextField()) < 0) {
				System.out.println("Age cannot be less than 0.");
                return;
			}
			
			switch(view.getTypeFromTextField().toLowerCase()) {
			case "dog":
				pet = new Dog(Integer.parseInt(view.getIdFromTextField()), view.getNameFromTextField(), view.getSpeciesFromTextField(), Integer.parseInt(view.getAgeFromTextField()), false);
				break;
			case "cat":
				pet = new Cat(Integer.parseInt(view.getIdFromTextField()), view.getNameFromTextField(), view.getSpeciesFromTextField(), Integer.parseInt(view.getAgeFromTextField()), false);
				break;
			case "rabbit":
				pet = new Rabbit(Integer.parseInt(view.getIdFromTextField()), view.getNameFromTextField(), view.getSpeciesFromTextField(), Integer.parseInt(view.getAgeFromTextField()), false);
				break;
			default:
				ExoticAnimal ea = new ExoticAnimal(view.getIdFromTextField(), view.getNameFromTextField(), view.getTypeFromTextField(), view.getSpeciesFromTextField(), Integer.parseInt(view.getAgeFromTextField()));
				pet = new ExoticAnimalAdapter(ea);
				break;
			}
			
			model.getPets().add(pet);
			view.addPetToPetList(pet);
			sortListByComboBox();
			System.out.println(pet.getName() + " has been added to pet list.");
		}
	}
	
	private class RemoveButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int[] selectedPets = view.getMultipleSelectedPets();
			ArrayList<Pet> toBeRemovedList = new ArrayList<>();
			for (int i = 0; i < selectedPets.length; i++) {
				toBeRemovedList.add(view.getPetList().get(selectedPets[i]));
			}
			for (Pet pet : toBeRemovedList) {
				view.getPetList().removeElement(pet);
				model.getPets().remove(pet);
				System.out.println(pet.getName() + "has been removed from pet list.");
			}
		}
	}
	
	private class ViewDetailsButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				detailsView = new DetailsView();
				detailsView.updateDetails(model.getPets().get(view.getSelectedPet()));
				detailsView.getFrame().setVisible(true);
			} catch (Exception x) {
				
			}
			
		}
	}
	
	private class SaveButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	private class AdoptButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if (model.getPets().get(view.getSelectedPet()).isAdopted()) {
					System.out.println(model.getPets().get(view.getSelectedPet()).getName() + " has already been adopted.");
				}
				else {
					model.getPets().get(view.getSelectedPet()).setAdopted(true);
					System.out.println(model.getPets().get(view.getSelectedPet()).getName() + " has just been adopted.");
				}
			} catch (Exception x) {
				
			}
		}
	}
	
	private class ComboBoxListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			sortListByComboBox();
		}
	}
	
	private void sortListByComboBox() {
		switch(view.getComboBox().getSelectedItem().toString()) {
		case "Name":
			model.sortByName();
			view.showShelterOnList(model);
			break;
		case "Age":
			model.sortByAge();
			view.showShelterOnList(model);
			break;
		case "Species":
			model.sortBySpecies();
			view.showShelterOnList(model);
			break;
		default:
			view.showShelterOnList(model);
			break;
		}
	}

}
