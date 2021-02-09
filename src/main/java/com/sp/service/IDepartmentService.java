package com.sp.service;

import java.util.List;
import com.sp.bean.Department;

public interface IDepartmentService {
	Department saveDepartment(Department depart);
	boolean updateDepartment(Department depart);
	boolean deleteDepartment(int departId);
	Department getDepartment(int departId);
	List<Department> getDepartments();
}