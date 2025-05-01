package mvc;

import javax.swing.SwingUtilities;

import mvc.controller.ShelterController;
import mvc.model.Shelter;
import mvc.model.pets.Pet;
import mvc.view.ShelterView;

public class Main {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ShelterController controller = new ShelterController(new Shelter<Pet>(), new ShelterView());
				controller.initiate();
			}
		});
	
	}

}

/* To-do list:
 * 
 * Load pets&exotic animals when program starts using GSON
 * 
 * Add pet (validate inputs)
 * Save pet list back to JSON file
 * 
 * SOLID principles
 * 
 */
