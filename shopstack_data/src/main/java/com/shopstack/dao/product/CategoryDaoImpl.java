/**
 * @author RAY-ABEL
 */
package com.shopstack.dao.product;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.shopstack.entities.product.Category;

@Transactional
@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory factory;
	
	private Logger logger =Logger.getLogger(CategoryDao.class);
	
	@Override
	public void addCategory(Category theCategory) {
	Session session =factory.getCurrentSession();
	try {
		session.save(theCategory);
		
	}catch(RuntimeException exc) {
		logger.info("Exception was thrown "+ exc.toString());
		
		exc.printStackTrace();
	
	
	}
		
	}

	@Override
	public List<Category> getCategory() {
		
		List<Category> resultList =null;
		Session session =factory.getCurrentSession();
		try {
			
			Query<Category> query = session.createQuery("from Category", Category.class);
		    resultList = query.getResultList();
			
		} catch(RuntimeException ex) {
			
			logger.info("Exception was thrown "+ ex.toString());
			
			ex.printStackTrace();
			
		}
		return resultList;
	}

}
