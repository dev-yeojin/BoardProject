package com.test.web.vo;

import lombok.Data;

@Data
public class Member {

	private String u_id;
	private String u_pwd;
	private String u_name;
	private int u_auth;
	private String u_createdDate;
	private String u_updatedDate;
	
	public Member(){}

	public Member(String u_id, String u_pwd, String u_name,int u_auth){
		this.u_id = u_id;
		this.u_pwd = u_pwd;
		this.u_name = u_name;
		this.u_auth = u_auth;
	}
	
	public Member(String u_id, String u_pwd, String u_name, int u_auth, String u_createdDate, String u_updatedDate){
		this.u_id = u_id;
		this.u_pwd = u_pwd;
		this.u_name = u_name;
		this.u_auth = u_auth;
		this.u_createdDate = u_createdDate;
		this.u_updatedDate = u_updatedDate;
	}
}
