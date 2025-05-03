package mvc;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import mvc.controller.ShelterController;
import mvc.jsonParser.*;
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
		        ArrayList<Pet> shelterPets = shelter.getPets();
				
		        // Gets filename of starting files to load
				String regularPetFile = System.getProperty("user.dir") + "\\src\\main\\resources\\pets.json";
				String exoticPetFile = System.getProperty("user.dir") + "\\src\\main\\resources\\exotic_animals.json";

		        Gson gson = new Gson();

		        // Parse regular pet file
		        try (FileReader reader = new FileReader(regularPetFile)) {
		        	Type userListType = new TypeToken<List<RegularPet>>() {}.getType();
		        	List<RegularPet> pets = gson.fromJson(reader, userListType);
		        	for(RegularPet pet : pets) {
		        		pet.parser(shelterPets);
		        	}
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        
		        // Parse imported exotic animal file
		        try (FileReader reader = new FileReader(exoticPetFile)) {
		        	Type userListType = new TypeToken<List<ExoticPet>>() {}.getType();
		        	List<ExoticPet> pets = gson.fromJson(reader, userListType);
		        	for(ExoticPet pet : pets) {
		        		pet.parser(shelterPets);
		        	}
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
