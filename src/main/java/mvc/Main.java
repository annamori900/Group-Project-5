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
