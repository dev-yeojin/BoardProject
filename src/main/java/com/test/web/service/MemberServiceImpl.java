package com.test.web.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.web.dao.MemberDao;
import com.test.web.vo.Member;

@Transactional
@Service("memberService")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDao memberDao;
	
	private Gson gson =  new GsonBuilder().serializeNulls().create();
	
	@Override
	public boolean existMember(String u_id) {
		u_id = "user_id:"+u_id;
		boolean exist = memberDao.existMember(u_id);
		return exist;
	}
	
	@Override
	public boolean checkPassword(String u_id, String u_pwd) {
		Member member = getMember(u_id);
		
		if(u_id.equals(member.getU_id()) && u_pwd.equals(member.getU_pwd())){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public String getMemberList() {
		Map<String, String> userMap = memberDao.getMemberList();
	
		List<Member> memberList = new ArrayList<Member>();
		for(String u_id : userMap.keySet()){
			Member member = gson.fromJson(userMap.get(u_id), Member.class);
			memberList.add(member);
		}
		
		return gson.toJson(memberList);
	}

	@Override
	public Member getMember(String u_id) {
		u_id = "user_id:"+u_id;
		String json_member = memberDao.getMember(u_id);
		Member member = gson.fromJson(json_member, Member.class);
		
		return member;
	}

	@Override
	public void createMember(Member member) {
		Date date = new Date();
		String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		String u_id = "user_id:"+ member.getU_id();
		
		member.setU_createdDate(now);
		member.setU_auth(0);
		
		String memberInfo = gson.toJson(member);
		memberDao.createMember(u_id, memberInfo);
	}

	@Override
	public void updateMember(Member member) {
		Date date = new Date();
		String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		String u_id = "user_id:"+ member.getU_id();
		
		member.setU_createdDate(getMember(u_id.substring(8)).getU_createdDate());
		member.setU_updatedDate(now);
		
		String memberInfo = gson.toJson(member);
		memberDao.deleteMember(u_id);
		memberDao.updateMember(u_id, memberInfo);
	}

	@Override
	public void deleteMember(String u_id) {
		u_id = "user_id:"+u_id;
		
		memberDao.deleteMember(u_id);
	}

}
