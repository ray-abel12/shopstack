package com.shopstack.dao.product;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.jboss.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import com.shopstack.context.config.DataContextConfig;
import com.shopstack.entities.business.BusinessServiceType;

@Sql(scripts= {"classpath:/db/insert-into-category-and-product-script.sql"})
@ContextConfiguration(classes= DataContextConfig.class)	
@RunWith(SpringRunner.class)

public class CategoryDaoImplTest {
	Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	
	@Test
	public void classesInitializedTest() {
		
		assertNotNull(categoryDao);
	}
	
}
