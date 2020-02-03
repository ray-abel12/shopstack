package com.shopstack.dao.shopowner;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopstack.context.config.DataContextConfig;
import com.shopstack.entities.shopowner.ShopOwner;
import com.shopstack.entities.user.User;


/**
 * @author oluwatobi
 *
 */
@ContextConfiguration(classes= DataContextConfig.class)	
@RunWith(SpringRunner.class)
public class ShopOwnerDaoImpTest {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	@Autowired
	private ShopOwnerDao shopOwnerDaoImp;
	
	
	@Before
	public void setUp() throws Exception {
		
//	  String user = "shopstack_admin";
//	  String password = "shopStack1.0";
//	  String jdbcUrl = "jdbc:mysql://localhost:3306/shopstack?useSSL=false&serverTimezone=UTC";
//	
//
//	  Connection myCon = DriverManager.getConnection(jdbcUrl, user, password);
//
//      //Initialize the script runner
//      ScriptRunner sr = new ScriptRunner(myCon);
//      //Creating a reader object
//      Reader reader = new BufferedReader(new FileReader("shopstack-create-db.sql"));
//      //Running the script
//      sr.runScript(reader);
      
	}

	@Test
	public void initializationTest() {
		
		assertNotNull(shopOwnerDaoImp);
	}
	
	@Test
	public void dbManagerClassesInitializedTest() {
		
		logger.info("Testing that Classes under test are properlly initialized");
		assertNotNull(shopOwnerDaoImp);
	

	}

	@Test
	public void addNewShopOwner_cascadeSave_username_password() {
		
	
	try {
	
		User username1 = new User("simeon", "test123", 1, "ROLE_MANAGER");
		
		ShopOwner tempShopOwner1 =  new ShopOwner("Simeon", "ocean", "743 round street",
				"simeon@mail.com", "070746536653");
		
		tempShopOwner1.setUserDetail(username1);
		
		shopOwnerDaoImp.saveShopOwner(tempShopOwner1);
		
		User username2 = new User("tobi", "test123", 1, "ROLE_MANAGER");
		
		ShopOwner tempShopOwner2 =  new ShopOwner("Tobi", "Tosho", "743 round street",
				"tboydv1@gmail.com", "070746536653");
		
		tempShopOwner2.setUserDetail(username2);
		
		shopOwnerDaoImp.saveShopOwner(tempShopOwner2);	
		
		
	}
	catch(Exception exe) {
		
		logger.throwing(getClass().getName(), " addNewShopOwner_cascadeSave_username_password() ", exe);
		exe.printStackTrace();
	}
	}
		
	@Test
	public void getAllShopOwnersFromTheDatabase() {
		
		
		//get all shopowners saved in the database
		logger.info("Getting shopowners from the database");
		List<ShopOwner> result = shopOwnerDaoImp.getShopOwners();
		
		for(ShopOwner person: result) {
			
			logger.info(person.toString());
		}
		
	}
	
	@Test
	public void findShopOwnerByEmail() {
		
		List<ShopOwner> result = shopOwnerDaoImp.findByEmail("tboydv1@gmail.com");
		
		assertTrue(!(result == null));
		
		logger.info("Found: " + result.get(0).toString());
		
		assertEquals("tboydv1@gmail.com", result.get(0).getEmail());
		
	}
	
	
	
		
		
		
	
	
	
}