package com.sp.dto;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import com.sp.bean.Role;

@Converter(autoApply = true)
public class RoleAttributeConverter implements AttributeConverter<Role, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Role attribute) {
		return attribute.getRoleId();
	}

	@Override
	public Role convertToEntityAttribute(Integer dbData) {
		return Role.getRoleById(dbData);
	}
	
}
