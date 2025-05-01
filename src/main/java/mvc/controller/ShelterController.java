package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import mvc.model.Shelter;
import mvc.model.pets.Pet;
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
			Pet pet = view.getPetFromPetTextFields();
			// TODO check valid input
			model.getPets().add(pet);
			view.addPetToPetList(pet);
			view.showShelterOnList(model);
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
			detailsView = new DetailsView();
			detailsView.updateDetails(model.getPets().get(view.getSelectedPet()));
			detailsView.getFrame().setVisible(true);
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
			if (model.getPets().get(view.getSelectedPet()).isAdopted()) {
				System.out.println(model.getPets().get(view.getSelectedPet()).getName() + " has already been adopted.");
			}
			else {
				model.getPets().get(view.getSelectedPet()).setAdopted(true);
				System.out.println(model.getPets().get(view.getSelectedPet()).getName() + " has just been adopted.");
			}
		}
	}
	
	private class ComboBoxListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
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

}
