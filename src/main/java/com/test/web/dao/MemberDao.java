package com.test.web.dao;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDao {
	
	@Resource (name = "redisTemplate")
	private RedisTemplate<String, Object> redisTemplate;
	
	@Resource(name = "strRedisTemplate")
	private StringRedisTemplate strRedisTemplate;
	
	public boolean existMember(String userId){
		boolean result = false;
		try {
			HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
			result = hashOps.hasKey("USER", userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Map<String, String> getMemberList(){
		Map<String, String> userMap = new HashMap<String, String>();
		try {
			HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
			userMap = hashOps.entries("USER");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return userMap;
	}
	
	public String getMember(String userId){
		String member = null;
		
		try {
			HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
			member = hashOps.get("USER", userId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return member;
	}
	
	public void createMember(String userId, String memberInfo){
		try{
			HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
			hashOps.put("USER", userId, memberInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void updateMember(String userId, String memberInfo){
		try{
			HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
			hashOps.put("USER", userId, memberInfo);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void deleteMember(String userId){
		try{
			HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
			hashOps.delete("USER", userId);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
