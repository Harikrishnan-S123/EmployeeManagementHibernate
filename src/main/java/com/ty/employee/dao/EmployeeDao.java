package com.ty.employee.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.employee.entity.Employee;

public class EmployeeDao {
	private EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	private EntityManager entityManager=entityManagerFactory.createEntityManager();
	private EntityTransaction entityTransaction=entityManager.getTransaction();
	Scanner s=new Scanner(System.in);
	public Employee saveEmployee(Employee emp) {
		System.out.println("Enter id");
		String id=s.next();
		emp.setEid(id);
		System.out.println("Enter name");
		String name=s.next();
		emp.setName(name);
		System.out.println("Enter mail");
		String email=s.next();
		emp.setEmail(email);
		System.out.println("Enter pwd");
		String pwd=s.next();
		emp.setPwd(pwd);
		System.out.println("Enter role");
		String role=s.next();
		emp.setRole(role);
		entityTransaction.begin();
		entityManager.persist(emp);
		entityTransaction.commit();
		System.out.println("Inserted");
		return emp;


	}
	public Employee findEmployeeById(String eid) {
		Employee emp=entityManager.find(Employee.class, eid);
		return emp;
		
	}
	public List<Employee> findEmployeeByRole(String role) {
//		List<Employee> emps=new ArrayList<Employee>();
		Query query=entityManager.createQuery("select e from Employee e where role=?1");
		query.setParameter(1, role);
		List<Employee> ls=query.getResultList();
		if(ls!=null && ls.isEmpty()==false)
			return ls;
		return null;
	}
	public Employee findEmployeeByMailPwd(String mail, String password) {
		Employee e=null;
		Query query=entityManager.createQuery("select e from Employee e where email=?1 and pwd=?2");
		query.setParameter(1, mail);
		query.setParameter(2, password);
		List<Employee> ls=query.getResultList();
		if(ls!=null && ls.isEmpty()==false) {
			 e=ls.get(0);
		}
		
		
		return e;
	}
	public boolean deleteEmployee(String id) {
		boolean flag=false;
		Employee emp=entityManager.find(Employee.class, id);
		if(emp!=null) {
		flag=true;
		entityTransaction.begin();
		entityManager.remove(emp);
		entityTransaction.commit();
		}
		return flag;
		
		
	}
	public Employee updateUserRole(String id, String role) {
		Employee emp=null;
	    emp=entityManager.find(Employee.class, id);
		if(emp!=null) {
		emp.setRole(role);
		entityTransaction.begin();
		entityManager.merge(emp);
		entityTransaction.commit();
		System.out.println("Updated");
		}
		return emp;
		
	}


}
