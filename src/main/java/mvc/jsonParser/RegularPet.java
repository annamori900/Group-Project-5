package mvc.jsonParser;

import java.util.ArrayList;

import mvc.model.adapter.ExoticAnimalAdapter;
import mvc.model.pets.*;

public class RegularPet {	
	
	Integer id;
	String name;
	String type;
	String species;
	int age;
	boolean adopted;
	
	public void parser(ArrayList<Pet> pets) {
		
		Pet pet = null;

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
