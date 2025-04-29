package mvc.model.pets;

public class Dog extends Pet {
	
	private final String type = "Dog";

	public Dog(int id, String name, String species, int age, boolean adopted) {
		super(id, name, species, age, adopted);
	}

	@Override
	public String getType() {
		return type;
	}

}