package com.shopstack.dao.business;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopstack.entities.business.BusinessServiceType;

@Repository
@Transactional
public class BusinessServiceTypeDaoImpl implements BusinessServiceTypeDao{

	Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<BusinessServiceType> getBusinessServices() {
		
		List<BusinessServiceType> resultList;
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		try {
			
			Query<BusinessServiceType> query = currentSession.createQuery("from BusinessServiceType", BusinessServiceType.class);
			
			resultList = query.getResultList();
			
		} catch(Exception ex) {
			
			logger.info("Exception was thrown " + ex.toString());
			
			ex.printStackTrace();
			resultList=null;
		}
		
		return resultList;
	} 

	
}
