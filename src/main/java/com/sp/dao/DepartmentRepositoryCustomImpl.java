package com.sp.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.dto.DepartmentDTO;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class DepartmentRepositoryCustomImpl implements DepartmentRepositoryCustom {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public boolean modifyDepartment(DepartmentDTO depart) {
		boolean isModified = false;
		Transaction trans = null;
		try(Session session = entityManager.unwrap(Session.class)){
			trans = session.beginTransaction();
			session.update(depart);
			trans.commit();
			isModified = true;
		} catch (Exception e) {
			if (trans != null) {
				trans.rollback();
			}
			log.error(getClass().getCanonicalName()+" error message :: {}", e.getMessage());
		}
		return isModified;
	}

}
