package com.test.web.vo;


import java.util.Date;

import lombok.Data;

@Data
public class Board {

	private String b_id;
	private String b_title;
	private String b_content;
	private String b_writer;
	private Date b_createdDate;
	private Date b_updatedDate;
	private Integer b_cnt;
	
	public Board(){}
	
	public Board(String b_title, String b_content, String b_writer){
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_writer = b_writer;
	}
	
	public Board(String b_id, String b_title, String b_content, String b_writer, Date b_createdDate, Date b_updatedDate){
		this.b_id = b_id;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_writer = b_writer;
		this.b_createdDate = b_createdDate;
		this.b_updatedDate = b_updatedDate;
	}
}
