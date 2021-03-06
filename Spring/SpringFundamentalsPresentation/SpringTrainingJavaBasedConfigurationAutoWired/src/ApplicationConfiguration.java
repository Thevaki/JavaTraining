import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.thevaki.training.salesmanager.repository.EmployeeRepository;
import com.thevaki.training.salesmanager.repository.HibernateEmployeeRepositoryImpl;
import com.thevaki.training.salesmanager.service.EmployeeService;
import com.thevaki.training.salesmanager.service.EmployeeServiceImpl;

@Configuration
@ComponentScan("com.thevaki")
public class ApplicationConfiguration {

	@Bean(name="employeeService")
	public EmployeeService getEmployeeService() {
		EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
		return employeeService;
	}
	
	@Bean(name = "employeeRepository")
	public EmployeeRepository getEmployeeRepository() {
		return new HibernateEmployeeRepositoryImpl();
		
	}
}
