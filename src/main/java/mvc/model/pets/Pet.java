package mvc.model.pets;

public abstract class Pet implements Comparable<Pet> {
	
	protected int id;
	protected String name;
	protected String species;
	protected int age;
	protected boolean adopted;
	
	public Pet(int id, String name, String species, int age, boolean adopted) {
		setId(id);
		setName(name);
		setSpecies(species);
		setAge(age);
		setAdopted(adopted);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isAdopted() {
		return adopted;
	}

	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}

	@Override
	public int compareTo(Pet other) {
		return this.name.compareToIgnoreCase(other.getName());
	}
	
	public abstract String getType();

	@Override
	public String toString() {
		return name + ", " + species + ", " + age;
	}

}
