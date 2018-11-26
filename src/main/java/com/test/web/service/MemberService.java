package com.test.web.service;

import com.test.web.vo.Member;
import java.util.*;

public interface MemberService {
	
	public boolean existMember(String u_id);
	public boolean checkPassword(String u_id, String u_pwd);
	
	public String getMemberList();
	public Member getMember(String u_id);
	public void createMember(Member member);
	public void updateMember(Member member);
	public void deleteMember(String u_id);
}
