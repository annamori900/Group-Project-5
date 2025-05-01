package mvc.model.pets;

public abstract class Pet implements Comparable<Pet> {
	
	protected int id;
	protected String name;
	protected String species;
	protected int age;
	protected boolean adopted;
	
	/**
	 * This is a parameterized constructor to set the member values for the abstract Pet
	 * @param id A primitive integer parameter representing the pet's ID number
	 * @param name A string parameter representing the pet's name
	 * @param species A string parameter representing the pet's species
	 * @param age A primitive integer parameter representing the pet's age in years
	 * @param adopted A boolean parameter representing the pet's adoption status
	 */
	public Pet(int id, String name, String species, int age, boolean adopted) {
		setId(id);
		setName(name);
		setSpecies(species);
		setAge(age);
		setAdopted(adopted);
	}

	/**
	 * This method is a getter for the pet's ID number
	 * @return Returns a primitive integer of the pet's ID number
	 */
	public int getId() {
		return id;
	}

	/**
	 * This method is a setter for the pet's ID number
	 * @param id A primitive integer parameter for the pet's ID number
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * This method is a getter for the pet's name
	 * @return Returns a string of the pet's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method is a setter for the pet's name
	 * @param name A string parameter for the pet's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method is a getter for the pet's species
	 * @return Returns a string of the pet's species
	 */
	public String getSpecies() {
		return species;
	}

	/**
	 * This method is a setter for the pet's species
	 * @param species A string parameter for the pet's species
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

	/**
	 * This method is a getter for the pet's age
	 * @return Returns a primitive integer of the pet's age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * This method is a setter for the pet's age
	 * @param age A primitive integer parameter for the pet's age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * This method is a getter for the pet's adoption status
	 * @return Returns a boolean value of the pet's adoption status. True if the pet has been adopted, false if the pet has not yet been adopted
	 */
	public boolean isAdopted() {
		return adopted;
	}

	/**
	 * This method is a setter for the pet's adoption status
	 * @param adopted A boolean parameter for the pet's adoption status. True if the pet has been adopted, false if the pet has not yet been adopted
	 */
	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}

	/**
	 * This method is the implementation from the Comparable interface to compare Pet objects, specifically pet's names alphabetically
	 * @param other A Pet object parameter to compare this Pet object to
	 * @return Returns a negative primitive integer if this pet's name is after the other pet's name in the alphabet
	 *                   zero if this pet's name and the other pet's name are the same
	 *                   or a positive primitive integer if this pet's name is before the other pet's name in the alphabet
	 */
	@Override
	public int compareTo(Pet other) {
		return this.name.compareToIgnoreCase(other.getName());
	}
	
	/**
	 * This method is a stub for an abstract getter for the pet's type
	 * @return Returns a string of the pet's type
	 */
	public abstract String getType();

	/**
	 * This method formats the pet's name, species, and age separated by commas and spaces into a string
	 * @return Returns a string formatting the pet's name, species, and age
	 */
	@Override
	public String toString() {
		return name + ",   " + species + ",   " + age;
	}

}
