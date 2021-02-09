package com.sp.dao;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sp.dto.EmployeeDTO;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {

	@Autowired
	private EntityManager entityManager;

	@Override
	public boolean modifyEmployee(EmployeeDTO emp) {
		boolean isModified = false;
		Transaction trans = null;
		try(Session session = entityManager.unwrap(Session.class)){
			trans = session.beginTransaction();
			session.merge(emp);
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
