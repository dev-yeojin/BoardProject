package com.test.web.dao;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository("boardDao")
public class BoardDao {

	@Resource (name = "redisTemplate")
	private RedisTemplate<String, Object> redisTemplate;
	
	@Resource(name = "strRedisTemplate")
	private StringRedisTemplate strRedisTemplate;
	

	public String getBoardList(){
		return null;
	}
	
	public String getBoard(String boardId){
		return null;
	}
	
	public void insertBoard(String json_board){
		
	}
	
	public void updateBoard(String json_board){
		
	}
	
	public void deleteBoard(String boardId){
		
	}
	
}
