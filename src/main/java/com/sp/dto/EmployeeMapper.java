package com.sp.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sp.bean.Department;
import com.sp.bean.Employee;

@Component
public class EmployeeMapper implements Mapper<Employee, EmployeeDTO> {

	@Autowired
	private Mapper<Department, DepartmentDTO> departMapper;
	
	@Override
	public EmployeeDTO modelToDtoMapper(Employee model) {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmpId(model.getEmpId());
		employeeDTO.setEmpName(model.getEmpName());
		employeeDTO.setEmpContact(model.getEmpContact());
		employeeDTO.setEmpRole(model.getEmpRole());
		employeeDTO.setEmpSalary(model.getEmpSalary());
		employeeDTO.setEmpDepart(departMapper.modelToDtoMapper(model.getEmpDepart()));
		return employeeDTO;
	}

	@Override
	public Employee dtoToModelMapper(EmployeeDTO dto) {
		Employee empModel = new Employee();
		empModel.setEmpId(dto.getEmpId());
		empModel.setEmpName(dto.getEmpName());
		empModel.setEmpContact(dto.getEmpContact());
		empModel.setEmpRole(dto.getEmpRole());
		empModel.setEmpSalary(dto.getEmpSalary());
		empModel.setEmpDepart(departMapper.dtoToModelMapper(dto.getEmpDepart()));
		return empModel;
	}

}
