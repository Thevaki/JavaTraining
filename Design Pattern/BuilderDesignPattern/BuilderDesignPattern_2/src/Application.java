
public class Application {
	
	public static void main(String[] args) {
		Employee employee = new Employee.Builder()
				.setFirstName("Anne").setLastName("David").setAge(34).setAddress("10,Station road,Colombo").setEmail("anne@gmail.com").build();
		
		System.out.println(employee);
	}

}
