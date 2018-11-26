package com.test.web;

import javax.annotation.Resource;

import org.apache.ibatis.mapping.ResultMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class RedisConnectionTest{

	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	
	@Test
	public void test() throws Exception{
		System.out.println(redisTemplate);
	}
	
}
