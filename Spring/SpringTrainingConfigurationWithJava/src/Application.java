import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import com.thevaki.training.salesmanager.model.Employee;
import com.thevaki.training.salesmanager.service.EmployeeService;

@Repository("you can use any name")
public class Application {
	public static void main(String[] args) {

		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		
		EmployeeService employeeService = applicationContext.getBean("employeeService",EmployeeService.class);
		
		List<Employee> employees = employeeService.getAllEmployees();
		
		for(Employee employee : employees) {
			System.out.println(employee.getEmployeeName() + " at " +employee.getEmployeeLocation());
		}
	}
}
