package mvc.model.pets;

public class Rabbit extends Pet {
	
	private final String type = "Rabbit"; // A string representing the pet's type is a rabbit

	/**
	 * This is a parameterized constructor to set the member values for the Rabbit object
	 * @param id A primitive integer parameter representing the rabbit's ID number
	 * @param name A string parameter representing the rabbit's name
	 * @param species A string parameter representing the rabbit's species
	 * @param age A primitive integer parameter representing the rabbit's age in years
	 * @param adopted A boolean parameter representing the rabbit's adoption status
	 */
	public Rabbit(int id, String name, String species, int age, boolean adopted) {
		super(id, name, species, age, adopted);
	}

	/**
	 * This method is the implementation from the abstract Pet class and is a getter for the rabbit's type
	 * @return Returns a string of the rabbit's type
	 */
	@Override
	public String getType() {
		return type;
	}

}