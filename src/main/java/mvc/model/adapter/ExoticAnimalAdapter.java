package mvc.model.adapter;

import mvc.model.pets.ExoticAnimal;
import mvc.model.pets.Pet;

public class ExoticAnimalAdapter extends Pet {
	
	private ExoticAnimal exoticAnimal;

	public ExoticAnimalAdapter(ExoticAnimal a) {
		super(Integer.parseInt(a.getUniqueId()), a.getAnimalName(), a.getSubSpecies(), a.getYearsOld(), false);
		this.exoticAnimal = a;
	}

	@Override
	public String getType() {
		return exoticAnimal.getCategory();
	}

}
