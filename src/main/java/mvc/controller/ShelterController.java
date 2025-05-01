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

}
