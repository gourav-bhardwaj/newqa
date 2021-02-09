package com.sp.dto;

import org.springframework.stereotype.Component;
import com.sp.bean.Department;

@Component
public class DepartmentMapper implements Mapper<Department, DepartmentDTO> {

	@Override
	public DepartmentDTO modelToDtoMapper(Department model) {
		DepartmentDTO departDto = new DepartmentDTO();
		departDto.setDepartId(model.getDepartId());
		departDto.setDepartCode(model.getDepartCode());
		departDto.setDepartName(model.getDepartName());
		departDto.setDepartCreated(model.getDepartCreated());
		return departDto;
	}
	
	@Override
	public Department dtoToModelMapper(DepartmentDTO dto) {
		Department departModel = new Department();
		departModel.setDepartId(dto.getDepartId());
		departModel.setDepartCode(dto.getDepartCode());
		departModel.setDepartName(dto.getDepartName());
		departModel.setDepartCreated(dto.getDepartCreated());
		return departModel;
	}

}