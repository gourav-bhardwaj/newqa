package com.sp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sp.bean.Employee;
import com.sp.dao.EmployeeRepository;
import com.sp.dto.EmployeeDTO;
import com.sp.dto.Mapper;

@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	private EmployeeRepository empDao;
	
	@Autowired
	private Mapper<Employee, EmployeeDTO> empMapper;

	@Override
	public Employee saveEmployee(Employee emp) {
		EmployeeDTO empDto = empMapper.modelToDtoMapper(emp);
		empDto = empDao.save(empDto);
		return empMapper.dtoToModelMapper(empDto);
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		EmployeeDTO empDto = empMapper.modelToDtoMapper(emp);
		return empDao.modifyEmployee(empDto);
	}

	@Override
	public boolean deleteEmployee(int empId) {
		Optional<EmployeeDTO> empObj = empDao.findById(empId);
		if (empObj.isPresent()) {
			empDao.delete(empObj.get());
			return true;
		}
		return false;
	}

	@Override
	public Employee getEmployee(int empId) {
		Optional<EmployeeDTO> empObj = empDao.findById(empId);
		Employee empModel = null;
		if (empObj.isPresent()) {
			empModel = empMapper.dtoToModelMapper(empObj.get());
		}
		return empModel;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> empList = new ArrayList<>();
		empDao.findAll().forEach(empDto -> {
			Employee empModel = empMapper.dtoToModelMapper(empDto);
			empList.add(empModel);
		});
		return empList;
	}

}
