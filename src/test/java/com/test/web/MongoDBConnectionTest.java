package com.test.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MongoDBConnectionTest {
	
	@Inject
	private MongoTemplate mongoTemplate;

	
	@Test	
	public void testTemplate(){
		System.out.println(mongoTemplate);
	}
}
