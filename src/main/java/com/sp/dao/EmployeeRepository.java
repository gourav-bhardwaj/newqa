package com.sp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sp.dto.EmployeeDTO;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDTO, Integer>, EmployeeRepositoryCustom {

}
