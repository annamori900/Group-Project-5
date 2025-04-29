package mvc.model.pets;

public class Cat extends Pet {

	private final String type = "Cat";

	public Cat(int id, String name, String species, int age, boolean adopted) {
		super(id, name, species, age, adopted);
	}

	@Override
	public String getType() {
		return type;
	}

}