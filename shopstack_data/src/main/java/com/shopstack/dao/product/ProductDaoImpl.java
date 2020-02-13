package com.shopstack.dao.product;
/**
 * @author RAY-ABEL
 *
 */
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopstack.entities.product.Product;
@Transactional
@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private SessionFactory factory;
	
	private Logger logger =Logger.getLogger(ProductDao.class);
	
	@Override
	public void addProduct(Product theProduct) {
	Session session =factory.getCurrentSession();
	session.save(theProduct);
	
		
	}

	@Override
	public List<Product> getProduct() {
		Session session = factory.getCurrentSession();
		try {
			List<Product> resultList= null;
			Query<Product> query = session.createQuery("from Product",Product.class);
			resultList = query.getResultList();
			
		}catch(RuntimeException exc) {
			logger.info("Exception was thrown "+ exc.toString());
			
			exc.printStackTrace();
		}
		return null;
	}
	


}
