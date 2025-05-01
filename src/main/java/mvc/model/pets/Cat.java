package mvc.model.pets;

public class Cat extends Pet {

	private final String type = "Cat"; // A string representing the pet's type is a cat

	/**
	 * This is a parameterized constructor to set the member values for the Cat object
	 * @param id A primitive integer parameter representing the cat's ID number
	 * @param name A string parameter representing the cat's name
	 * @param species A string parameter representing the cat's species
	 * @param age A primitive integer parameter representing the cat's age in years
	 * @param adopted A boolean parameter representing the cat's adoption status
	 */
	public Cat(int id, String name, String species, int age, boolean adopted) {
		super(id, name, species, age, adopted);
	}

	/**
	 * This method is the implementation from the abstract Pet class and is a getter for the cat's type
	 * @return Returns a string of the cat's type
	 */
	@Override
	public String getType() {
		return type;
	}

}