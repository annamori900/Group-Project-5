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
		this.view.addListenerToRemoveButton(new RemoveButtonListener());
		this.view.addListenerToViewDetailsButton(new ViewDetailsButtonListener());
		this.view.addListenerToAdoptButton(new AdoptButtonListener());
		this.view.addListenerToComboBox(new ComboBoxListener());
	}
	
	public void initiate() {
		view.getFrame().setVisible(true);
	}
	
	private class RemoveButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int[] selectedPets = view.getMultipleSelectedPets();
			ArrayList<Pet> list = new ArrayList<>();
			for (int i = 0; i < selectedPets.length; i++) {
				list.add(view.getPetList().get(selectedPets[i]));
			}
			for (Pet pet : list) {
				view.getPetList().removeElement(pet);
				model.getPets().remove(pet);
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
	
	private class AdoptButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (model.getPets().get(view.getSelectedPet()).isAdopted()) {
				System.out.println(model.getPets().get(view.getSelectedPet()).getName() + " is already adopted.");
			}
			else {
				model.getPets().get(view.getSelectedPet()).setAdopted(true);
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
