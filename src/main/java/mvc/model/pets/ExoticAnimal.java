package mvc.model.pets;

public class ExoticAnimal {
	
	private String uniqueId;
	private String animalName;
	private String category;
	private String subSpecies;
	private int yearsOld;
	
	/**
	 * This is a parameterized constructor to set the member values for the ExoticAnimal object
	 * @param uniqueId A string parameter representing the exotic animal's ID number
	 * @param animalName A string parameter representing the exotic animal's name
	 * @param category A string parameter representing the exotic animal's category
	 * @param subSpecies A string parameter representing the exotic animal's sub-species
	 * @param yearsOld A primitive integer parameter representing the exotic animal's age in years
	 */
	public ExoticAnimal(String uniqueId, String animalName, String category, String subSpecies, int yearsOld) {
		setUniqueId(uniqueId);
		setAnimalName(animalName);
		setCategory(category);
		setSubSpecies(subSpecies);
		setYearsOld(yearsOld);
	}

	/**
	 * This method is a getter for the exotic animal's ID number
	 * @return Returns a string of the exotic animal's ID number
	 */
	public String getUniqueId() {
		return uniqueId;
	}
	
	/**
	 * This method is a setter for the exotic animal's ID number
	 * @param uniqueId A string parameter for the exotic animal's ID number
	 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	
	/**
	 * This method is a getter for the exotic animal's name
	 * @return Returns a string of the exotic animal's name
	 */
	public String getAnimalName() {
		return animalName;
	}
	
	/**
	 * This method is a setter for the exotic animal's name
	 * @param animalName A string parameter for the exotic animal's name
	 */
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	
	/**
	 * This method is a getter for the exotic animal's category
	 * @return Returns a string of the exotic animal's category
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * This method is a setter for the exotic animal's category
	 * @param category A string parameter for the exotic animal's category
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	
	/**
	 * This method is a getter for the exotic animal's sub-species
	 * @return Returns a string of the exotic animal's sub-species
	 */
	public String getSubSpecies() {
		return subSpecies;
	}
	
	/**
	 * This method is a setter for the exotic animal's sub-species
	 * @param subSpecies A string parameter for the exotic animal's sub-species
	 */
	public void setSubSpecies(String subSpecies) {
		this.subSpecies = subSpecies;
	}
	
	/**
	 * This method is a getter for the exotic animal's age
	 * @return Returns a primitive integer of the exotic animal's age
	 */
	public int getYearsOld() {
		return yearsOld;
	}
	
	/**
	 * This method is a setter for the exotic animal's age
	 * @param yearsOld A primitive integer parameter for the exotic animal's age
	 */
	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}

}
