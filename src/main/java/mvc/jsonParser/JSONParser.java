package mvc.jsonParser;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;

import mvc.model.adapter.ExoticAnimalAdapter;
import mvc.model.pets.*;

public class JSONParser {

	
	static public void regularPet(JsonNode root, ArrayList<Pet> pets) {
        Pet pet = null;
		for (JsonNode animal : root) {
			Integer id = animal.get("id").asInt();
			String name = animal.get("name").asText();
			String type = animal.get("type").asText();
			String species = animal.get("species").asText();
			int age = animal.get("age").asInt();
			boolean adopted = animal.get("adopted").asBoolean();
        	
        	switch(type.toLowerCase()) {
			case "dog":
				pet = new Dog(id.intValue(), name, species, age, adopted);
				break;
			case "cat":
				pet = new Cat(id.intValue(), name, species, age, adopted);
				break;
			case "rabbit":
				pet = new Rabbit(id.intValue(), name, species, age, adopted);
				break;
			default:
				ExoticAnimal ea = new ExoticAnimal(id.toString(), name, type, species, age);
				pet = new ExoticAnimalAdapter(ea);
				break;
        	}
        	pets.add(pet);
        }
	}
	
	static public void exoticPet(JsonNode root, ArrayList<Pet> pets) {
		ExoticAnimal ea = null;
		Pet pet = null;
		for (JsonNode animal : root) {
			String uniqueId = animal.get("uniqueId").asText();
			String animalName = animal.get("animalName").asText();
			String category = animal.get("category").asText();
			String subSpecies = animal.get("subSpecies").asText();
			int yearsOld = animal.get("yearsOld").asInt();
        	
			ea = new ExoticAnimal(uniqueId, animalName, category, subSpecies, yearsOld);
			pet = new ExoticAnimalAdapter(ea);

        	pets.add(pet);
        }
	}
	
}
