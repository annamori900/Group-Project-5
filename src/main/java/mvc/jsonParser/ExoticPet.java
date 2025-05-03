package mvc.jsonParser;

import java.util.ArrayList;

import mvc.model.adapter.ExoticAnimalAdapter;
import mvc.model.pets.*;

public class ExoticPet {

	String uniqueId;
	String animalName;
	String category;
	String subSpecies;
	int yearsOld;

	public void parser(ArrayList<Pet> pets) {
		
		ExoticAnimal ea;
		Pet pet;
		
		ea = new ExoticAnimal(uniqueId, animalName, category, subSpecies, yearsOld);
		pet = new ExoticAnimalAdapter(ea);

    	pets.add(pet);
	}
}
