package mvc.model.adapter;

import mvc.model.pets.ExoticAnimal;
import mvc.model.pets.Pet;

public class ExoticAnimalAdapter extends Pet {
	
	private ExoticAnimal exoticAnimal;

	/**
	 * This is a parameterized constructor to set the member values for the ExoticAnimalAdapter object
	 * @param a An ExoticAnimal object parameter to be adapted to act as a Pet object
	 */
	public ExoticAnimalAdapter(ExoticAnimal a) {
		super(Integer.parseInt(a.getUniqueId().replaceAll("[^0-9]", "9")), a.getAnimalName(), a.getSubSpecies(), a.getYearsOld(), false);
		this.exoticAnimal = a;
	}

	/**
	 * This method is the implementation from the abstract Pet class and is a getter for the ExoticAniaml's type
	 * @return Returns a string of the ExoticAnimal's type
	 */
	@Override
	public String getType() {
		return exoticAnimal.getCategory();
	}

}
