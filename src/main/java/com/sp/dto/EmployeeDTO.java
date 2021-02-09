package com.sp.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import com.sp.bean.Role;
import lombok.Data;

@Entity
@Data
public class EmployeeDTO {

	@Id
	@SequenceGenerator(name = "empSeq", initialValue = 101, allocationSize = 1)
	@GeneratedValue(generator = "empSeq", strategy = GenerationType.SEQUENCE)
	@Column(name = "EMP_ID")
	private int empId;
	@Column(name = "EMP_NAME")
	private String empName;
	@Column(name = "EMP_ROLE")
	private Role empRole;
	@Column(name = "EMP_CONTACT")
	private String empContact;
	@Column(name = "EMP_SALARY")
	private float empSalary;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "EMP_DEPART")
	private DepartmentDTO empDepart;
	
}
