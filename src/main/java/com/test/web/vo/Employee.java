package com.test.web.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private Integer age;
	
	public Employee(){}
	
	public Employee(String id,String name){
		this.id = id;
		this.name = name;
	}
	
	public Employee(String id,String name, int age){
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	 
}
