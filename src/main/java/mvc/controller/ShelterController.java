package mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import mvc.model.Shelter;
import mvc.model.adapter.ExoticAnimalAdapter;
import mvc.model.pets.*;
import mvc.view.*;

public class ShelterController {
	
	private Shelter<Pet> model;
	private ShelterView view;
	private DetailsView detailsView = null;
	
	/**
	 * This is a parameterized constructor to set the controller's model and view members.
	 * The constructor also adds the contents of the model to the view's list and adds listener's to the view's interactive elements.
	 * @param model A Shelter<> object parameter to be the model of the controller
	 * @param view A ShelterView object parameter to be the view of the controller
	 */
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
	
	/**
	 * This method initiates the Swing GUI to be visible and thus interactive.
	 */
	public void initiate() {
		view.getFrame().setVisible(true);
	}
	
	private class AddButtonListener implements ActionListener {

		/**
		 * This method implements the action taken by the controller when the view's add button is interacted with.
		 * This method adds a pet to the model and view using parameters provided in the view's text fields and prints a dialog to the console.
		 * If inputs are invalid, there is no change.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			Pet pet;
			
			// check if any text fields are empty
			if (view.getIdFromTextField().equals("") ||
				view.getNameFromTextField().equals("") ||
				view.getTypeFromTextField().equals("") ||
				view.getSpeciesFromTextField().equals("") ||
				view.getAgeFromTextField().equals("")) { return; }
			
			// check if ID contains non-digit characters
			for (char c : view.getIdFromTextField().toCharArray()) {
	            if (!Character.isDigit(c)) {
	            	System.out.println("ID cannot contain non-digit values.");
	                return;
	            }
	        }
			
			// check if ID matches current ID in shelter
			for (Pet p : model.getPets()) {
				if (p.getId() == Integer.parseInt(view.getIdFromTextField())) {
					System.out.println("ID already exists");
					return;
				}
			}
			
			// check if age contains non-digit characters
			for (char c : view.getAgeFromTextField().toCharArray()) {
	            if (!Character.isDigit(c)) {
	            	System.out.println("Age cannot contain non-digit values.");
	                return;
	            }
	        }
			
			// check if age is less than 0
			if (Integer.parseInt(view.getAgeFromTextField()) < 0) {
				System.out.println("Age cannot be less than 0.");
                return;
			}
			
			// make pet object depending on pet type
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
			
			// add pet to model and view
			model.getPets().add(pet);
			view.addPetToPetList(pet);
			sortListByComboBox();
			System.out.println(pet.getName() + " has been added to pet list.");
		}
	}
	
	private class RemoveButtonListener implements ActionListener {

		/**
		 * This method implements the action taken by the controller when the view's remove button is interacted with.
		 * This method removes a pet(s) from the model and view using selection on the view's list and prints a dialog to the console.
		 * If no pets are selected, there is no change.
		 */
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
				System.out.println(pet.getName() + " has been removed from pet list.");
			}
		}
	}
	
	private class ViewDetailsButtonListener implements ActionListener {

		/**
		 * This method implements the action taken by the controller when the view's view details button is interacted with.
		 * This method uses selection on the view's list to make visible a selected pet's details on a new Swing GUI window.
		 * If no pet is selected, no window is made visible.
		 */
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

		/**
		 * This method implements the action taken by the controller when the view's save button is interacted with.
		 * This method converts data stored in a shelter to JSON format and saves it to file.
		 */
		@Override
		public void actionPerformed(ActionEvent a) {
			
			ArrayList<Pet> pets = model.getPets();
			
	        LocalDateTime now = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
	        
			String filename = System.getProperty("user.dir") + "\\src\\main\\resources\\" + now.format(formatter) + "_pets.json";
			
	        File file = new File(filename);
			
	        ObjectMapper mapper = new ObjectMapper();
	        try {
	            mapper.writerWithDefaultPrettyPrinter().writeValue(file, pets);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			
	        System.out.println("Pet list saved.");
		}
	}
	
	private class AdoptButtonListener implements ActionListener {

		/**
		 * This method implements the action taken by the controller when the view's adopt button is interacted with.
		 * This method uses selection on the view's list and clicking the button to change a pet's status to be adopted and prints a dialog to the console.
		 * If no pets are selected, there is no change.
		 * If the selected pet is already adopted, a dialog is printed to the console.
		 */
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

		/**
		 * This method implements the action taken by the controller when the view's combo box is interacted with.
		 * This method uses selection on the view's combo box to change the sorting order of the view's list.
		 * Initially the blank selection is chosen and the pets are displayed in the order they were added to the shelter.
		 * If the blank selection is chosen after choosing a sorting method, the pets are displayed in the order most recently chosen.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			sortListByComboBox();
		}
	}
	
	/**
	 * This is a helper method that sorts the pets in the view's list depending on the selected value of the combo box.
	 */
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
