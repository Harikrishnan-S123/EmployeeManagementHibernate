package com.ty.employee.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private String eid;
	private String name;
	private String email;
	private String pwd;
	private String role;
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", email=" + email + ", pwd=" + pwd + ", role=" + role + "]";
	}
	public Employee(String eid, String name, String email, String pwd, String role) {
		super();
		this.eid = eid;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.role = role;
	}
	public Employee() {}
	

}
