
public class Cat extends Animal{

	public Cat(){
	     type = "Cat";
	}
	
	@Override
	void eat() {
		System.out.println("Cat eats meat");
	}

}
