package com.sp.bean;

import org.springframework.hateoas.RepresentationModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Employee extends RepresentationModel<Employee>{

	private int empId;
	private String empName;
	private Role empRole;
	private String empContact;
	private float empSalary;
	private Department empDepart;
	
}
