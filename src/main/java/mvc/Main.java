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
 * Check adapter works
 * Check Comparable&Comparator works
 * 
 * Add pet (listener to button, text fields, validate inputs)
 * Remove pet (should be good, but double check it works, Shelter<Pet> vs Pet)
 * View pets (connected to list in View)
 * Adopt pet (prompt message on GUI or in console?)
 * Sort pets (connect comboBox to controller)
 * Add dialogs for adding&viewing details? (whatever that means, i guess in console)
 * 
 * Observer in View? (update method)
 * 
 * Save pet list back to JSON file
 * 
 * SOLID principles
 */
