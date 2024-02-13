package com.ty.employee.dco;

import java.util.List;
import java.util.Scanner;

import com.ty.employee.dao.EmployeeDao;
import com.ty.employee.entity.Employee;
import com.ty.employee.helper.Helper;

public class EmployeeController {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to employeeapp");
		EmployeeDao e = new EmployeeDao();
		Employee emp = new Employee();
		boolean flag = true;
		try {
		while (flag) {
			System.out.println("Enter a no");
			System.out.println("1.save the employee");
			System.out.println("2.find the employee by id");
			System.out.println("3.find the employee by role");
			System.out.println("4.find the employee by mail and password");
			System.out.println("5.delete the emeployee");
			System.out.println("6.Update the emeployee");
			System.out.println("7.exit");
			switch (s.nextInt()) {
			case 1:
				Employee temp = new Employee();
				e.saveEmployee(temp);
				break;
			case 2: {
				System.out.println("Enter id");
				Employee empbyid = e.findEmployeeById(s.next());
				Helper.forEach(empbyid);
			}
				break;
			case 3: {
				System.out.println("Enter role");
				List<Employee> emps = e.findEmployeeByRole(s.next());
				Helper.returnElements(emps);
//			    	if(emps!=null) {
//			    		for(Employee em:emps) {
//			    			System.out.println(em);
//			    		}
//			    	}
//			    	else
//			    		System.out.println("No ele present");
			}
				break;
			case 4: {
				System.out.println("Enter mail");
				String mail = s.next();
				System.out.println("Enter password");
				String password = s.next();
				Employee empres = e.findEmployeeByMailPwd(mail, password);
				Helper.forEach(empres);
			}
				break;
			case 5: {
				System.out.println("Enter id");
				String id = s.next();
				boolean f = e.deleteEmployee(id);
				if (f == true)
					System.out.println("Given id removed");
				else
					System.out.println("Given id not present");
			}
				break;
			case 6: {
				System.out.println("Enter id");
				String id = s.next();
				System.out.println("Enter role");
				String role = s.next();
				Employee empupdated = e.updateUserRole(id, role);
				Helper.forEach(empupdated);
			}
				break;
			case 7: {
				flag = false;
			}
				break;
			default:{
				System.out.println("Invalid Error");
			}

			}
		}
		}
		catch (Exception e) {
			System.out.println("Error occured");
		}

	}

}
