package com.sp;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import com.sp.bean.Department;
import com.sp.bean.Employee;
import com.sp.bean.Role;
import com.sp.service.IEmployeeService;

@EnableJpaRepositories
@EnableHypermediaSupport(type = HypermediaType.HAL)
@SpringBootApplication
public class SprhatiosApplication implements CommandLineRunner {

	@Autowired
	private IEmployeeService service;
	
	public static void main(String[] args) {
		SpringApplication.run(SprhatiosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Department department = new Department();
		department.setDepartCode(2330);
		department.setDepartName("HR");
		department.setDepartCreated(LocalDate.now());
		
		Employee employee = new Employee();
		employee.setEmpName("Rohit");
		employee.setEmpRole(Role.ADMIN);
		employee.setEmpSalary(45600.0f);
		employee.setEmpContact("8976543456");
		employee.setEmpDepart(department);
		
		Department department1 = new Department();
		department1.setDepartCode(1490);
		department1.setDepartName("IT");
		department1.setDepartCreated(LocalDate.now());
		
		Employee employee1 = new Employee();
		employee1.setEmpName("Kapil");
		employee1.setEmpRole(Role.ADMIN);
		employee1.setEmpSalary(56700.0f);
		employee1.setEmpContact("7899876655");
		employee1.setEmpDepart(department);
		
		service.saveEmployee(employee);
		service.saveEmployee(employee1);
	}
	
}
