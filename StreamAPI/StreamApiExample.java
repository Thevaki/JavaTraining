package comparatorSample;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiExample {

	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Vijay", 87));
		employees.add(new Employee("Ajay", 35));
		employees.add(new Employee("Jai", 55));
		
		List<Employee> filterEmployees = employees.stream().filter(e->e.getName().contains("y")).collect(Collectors.toList());
		System.out.println(filterEmployees);
		
		List<Employee> employeesDr = employees.stream().map(e->new Employee("Dr."+e.getName(),e.getMarks())).collect(Collectors.toList());
		System.out.println(employeesDr);
		
		List<Employee> sortEmployees = employees.stream().sorted(Comparator.comparing(Employee:: getName)).collect(Collectors.toList());
		System.out.println(sortEmployees);
	
		//List<Employee> compareEmployees = employees.stream().sorted(e1,e2) -> new Integer(e1.getName().length()).compareTo(e2.getName().length()).collect(Collectors.toList());
		//System.out.println(compareEmployees);
	}

}
