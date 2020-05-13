
public class PrototypePatternDemo {
	public static void main(String[] args) {
		AnimalCache.loadCache();

		Animal clonedAnimal = (Animal) AnimalCache.getAnimal("1");
		System.out.println("Animal : " + clonedAnimal.getType());

		Animal clonedAnimal2 = (Animal) AnimalCache.getAnimal("2");
		System.out.println("Animal : " + clonedAnimal2.getType());

		Animal clonedAnimal3 = (Animal) AnimalCache.getAnimal("3");
		System.out.println("Animal : " + clonedAnimal3.getType());
	}
}
