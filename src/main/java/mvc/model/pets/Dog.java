package mvc.model.pets;

public class Dog extends Pet {
	
	private final String type = "Dog"; // A string representing the pet's type is a dog

	/**
	 * This is a parameterized constructor to set the member values for the Dog object
	 * @param id A primitive integer parameter representing the dog's ID number
	 * @param name A string parameter representing the dog's name
	 * @param species A string parameter representing the dog's species
	 * @param age A primitive integer parameter representing the dog's age in years
	 * @param adopted A boolean parameter representing the dog's adoption status
	 */
	public Dog(int id, String name, String species, int age, boolean adopted) {
		super(id, name, species, age, adopted);
	}

	/**
	 * This method is the implementation from the abstract Pet class and is a getter for the dog's type
	 * @return Returns a string of the dog's type
	 */
	@Override
	public String getType() {
		return type;
	}

}