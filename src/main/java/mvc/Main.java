package mvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import mvc.controller.ShelterController;
import mvc.jsonParser.JSONParser;
import mvc.model.Shelter;
import mvc.model.pets.*;
import mvc.view.ShelterView;

public class Main {
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				// Initiates a shelter and gets pet list to load from file
		        Shelter<Pet> shelter = new Shelter<>();
		        ArrayList<Pet> pets = shelter.getPets();
				
		        // Gets filename of starting files to load
				String regularPetFile = System.getProperty("user.dir") + "\\src\\main\\resources\\pets.json";
				String exoticPetFile = System.getProperty("user.dir") + "\\src\\main\\resources\\exotic_animals.json";
				
				try {
					
			        ObjectMapper mapper = new ObjectMapper();

			        // Load regular pets JSON from file and parse
			        File file = new File(regularPetFile);
			        JsonNode root = mapper.readTree(file);
			        JSONParser.regularPet(root, pets);
			        
			        // Load exotic pets JSON from file and parse
			        file = new File(exoticPetFile);
			        root = mapper.readTree(file);
			        JSONParser.exoticPet(root, pets);

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				// Creates controller with loaded shelter animal list
				ShelterController controller = new ShelterController(shelter, new ShelterView());
				controller.initiate();
			}
		});
	
	}

}
