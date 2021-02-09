package com.sp.bean;

import java.time.LocalDate;
import org.springframework.hateoas.RepresentationModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Department extends RepresentationModel<Department> {

	private int departId;
	private int departCode;
	private String departName;
	private LocalDate departCreated;
	
}
