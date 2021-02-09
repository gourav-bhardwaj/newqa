package com.sp.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sp.bean.Employee;
import com.sp.service.IEmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;

	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Link slfLink = linkTo(methodOn(EmployeeController.class).saveEmployee(employee)).withSelfRel();
		Link updtLink = linkTo(methodOn(EmployeeController.class).updateEmployee(employee)).withRel("updateEmployee");
		Link dltLink = linkTo(methodOn(EmployeeController.class).deleteEmployee(employee.getEmpId())).withRel("deleteEmployee");
		employee = service.saveEmployee(employee);
		employee.add(Arrays.asList(slfLink, updtLink, dltLink));
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping
	public ResponseEntity<Boolean> updateEmployee(@RequestBody Employee employee) {
		boolean isModified = service.updateEmployee(employee);
		return ResponseEntity.ok(isModified);
	}
	 
	@DeleteMapping("/{empId}")
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable int empId) {
		boolean isDelete = service.deleteEmployee(empId);
		return ResponseEntity.ok(isDelete);
	}
	
	@GetMapping("/{empId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int empId) {
		Employee empObj = service.getEmployee(empId);
		Link slfLink = linkTo(methodOn(EmployeeController.class).getEmployee(empId)).withSelfRel();
		Link sveLink = linkTo(methodOn(EmployeeController.class).saveEmployee(empObj)).withRel("saveEmployee");
		Link updtLink = linkTo(methodOn(EmployeeController.class).updateEmployee(empObj)).withRel("updateEmployee");
		Link dltLink = linkTo(methodOn(EmployeeController.class).deleteEmployee(empId)).withRel("deleteEmployee");
		empObj.add(Arrays.asList(slfLink, sveLink, updtLink, dltLink));
		return ResponseEntity.ok(empObj);
	}
	
	@SuppressWarnings("deprecation")
	@GetMapping
	public ResponseEntity<CollectionModel<Employee>> getAllEmployees() {
	  List<Employee> empList = service.getEmployees();
	  for (Employee empObj : empList) {
		  Link subSlfLink = linkTo(methodOn(EmployeeController.class).getEmployee(empObj.getEmpId())).withSelfRel();
		  empObj.add(Arrays.asList(subSlfLink));
	  }
	  Link slfLink = linkTo(methodOn(EmployeeController.class).getAllEmployees()).withSelfRel();
	  CollectionModel<Employee> collectionModel = new CollectionModel<>(empList, slfLink);
	  return ResponseEntity.ok(collectionModel);
	}
	
}
