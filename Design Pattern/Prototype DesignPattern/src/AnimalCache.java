import java.util.Hashtable;

public class AnimalCache {
	private static Hashtable<String, Animal> animalMap  = new Hashtable<String, Animal>();

	   public static Animal getAnimal(String animalId) {
		   Animal cachedAnimal = animalMap.get(animalId);
	      return (Animal) cachedAnimal.clone();
	   }
	   
	   public static void loadCache() {
	      Dog dog = new Dog();
	      dog.setId("1");
	      animalMap.put(dog.getId(),dog);

	      Cat cat = new Cat();
	      cat.setId("2");
	      animalMap.put(cat.getId(),cat);

	      Elephant elephant = new Elephant();
	      elephant.setId("3");
	      animalMap.put(elephant.getId(), elephant);
	   }
}
