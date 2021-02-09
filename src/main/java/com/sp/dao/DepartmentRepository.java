package com.sp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sp.dto.DepartmentDTO;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentDTO, Integer>, DepartmentRepositoryCustom {

}