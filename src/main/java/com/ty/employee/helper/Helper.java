package com.ty.employee.helper;

import java.util.List;

import com.ty.employee.entity.Employee;

public class Helper {
	public static void returnElements(List<Employee> ls) {
		
		if(ls!=null && ls.isEmpty()==false) {
			for(Employee e:ls) {
				//Employee emp=e;
				System.out.println(e);
			}
		}
		else {
			System.out.println("NOt present");
		}
	
		
	}
	public static void forEach(Employee e) {
	if(e!=null)
	{
		System.out.println("-------------------------");
		System.out.println(e.getEid());
		System.out.println(e.getName());
		System.out.println(e.getEmail());
		System.out.println(e.getRole());
		System.out.println("--------------------------");
//		System.out.println(e.getName());
	}
	else
		System.out.println("Given parameter not present");
	}

}
