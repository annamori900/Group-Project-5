package mvc.model.pets;

public class Rabbit extends Pet {
	
	private final String type = "Rabbit";

	public Rabbit(int id, String name, String species, int age, boolean adopted) {
		super(id, name, species, age, adopted);
	}

	@Override
	public String getType() {
		return type;
	}

}