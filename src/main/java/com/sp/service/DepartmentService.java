package com.sp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sp.bean.Department;
import com.sp.dao.DepartmentRepository;
import com.sp.dto.DepartmentDTO;
import com.sp.dto.Mapper;

@Service
public class DepartmentService implements IDepartmentService {
	
	@Autowired
	private DepartmentRepository repository;
	
	@Autowired
	private Mapper<Department, DepartmentDTO> departMapper;

	@Override
	public Department saveDepartment(Department depart) {
		DepartmentDTO departDTO = departMapper.modelToDtoMapper(depart);
		departDTO = repository.save(departDTO);
		return departMapper.dtoToModelMapper(departDTO);
	}

	@Override
	public boolean updateDepartment(Department depart) {
		DepartmentDTO departDTO = departMapper.modelToDtoMapper(depart);
		return repository.modifyDepartment(departDTO);
	}

	@Override
	public boolean deleteDepartment(int departId) {
		if (repository.existsById(departId)) {
			repository.deleteById(departId);
			return true;
		}
		return false;
	}

	@Override
	public Department getDepartment(int departId) {
		Department departModel = null;
		Optional<DepartmentDTO> dto = repository.findById(departId);
		if (dto.isPresent()) {
			departModel = departMapper.dtoToModelMapper(dto.get());
		}
		return departModel;
	}

	@Override
	public List<Department> getDepartments() {
		List<Department> departList = new ArrayList<>();
		repository.findAll().forEach(departDto -> {
			Department deptModel = departMapper.dtoToModelMapper(departDto);
			departList.add(deptModel);
		});
		return departList;
	}

}
