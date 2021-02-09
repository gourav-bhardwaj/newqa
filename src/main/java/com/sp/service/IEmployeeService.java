package com.sp.service;

import java.util.List;
import com.sp.bean.Employee;

public interface IEmployeeService {
	Employee saveEmployee(Employee emp);
	boolean updateEmployee(Employee emp);
	boolean deleteEmployee(int empId);
	Employee getEmployee(int empId);
	List<Employee> getEmployees();
}