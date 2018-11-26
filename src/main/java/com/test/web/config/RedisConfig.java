package com.test.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

	@Bean
	public JedisConnectionFactory jedisConnectionFactory(){
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setHostName("10.41.10.6");
		jedisConnectionFactory.setPort(6379);
		jedisConnectionFactory.setUsePool(true);
		return jedisConnectionFactory;
	}
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate(){
	  RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
	  redisTemplate.setConnectionFactory(jedisConnectionFactory());
	  redisTemplate.setKeySerializer(new StringRedisSerializer());
	  redisTemplate.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
	  redisTemplate.setHashKeySerializer(new StringRedisSerializer());
	  redisTemplate.setHashValueSerializer(new StringRedisSerializer());
	  return redisTemplate;
	}
	
	@Bean
	public StringRedisTemplate strRedisTemplate(){
		StringRedisTemplate redisTemplate = new StringRedisTemplate();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}
}
