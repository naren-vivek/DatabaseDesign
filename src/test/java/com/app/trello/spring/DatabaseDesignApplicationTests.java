package com.app.trello.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.app.DB.DatabaseDesignApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DatabaseDesignApplication.class)
@WebAppConfiguration
public class DatabaseDesignApplicationTests {

	@Test
	public void contextLoads() {
	}

}
