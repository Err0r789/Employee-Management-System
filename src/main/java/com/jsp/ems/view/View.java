package com.jsp.ems.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jsp.ems.controller.Controller;
import com.jsp.ems.model.Department;
import com.jsp.ems.model.Employee;
import com.jsp.ems.model.Project;

public class View {

	static Scanner myInput = new Scanner(System.in);
	static Controller controller = new Controller();
	 
	 
	 

	public static void main(String[] args) {
		do {
			System.out.println(
					"1.Add Employee \n2.View Employee information \n3.Update Employee details \n4.Remove Employee \n5.View Department information \n6.Add Department \n7.View Project information \n8.Add Project \n0.Exit");
			System.out.println("Enter Desired output : ");
			int userinput = myInput.nextInt();
			System.out.println();
			myInput.nextLine();
			switch (userinput) {
			case 0:
				myInput.close();
				System.out.println("- - - - Exited - - - -");
				System.exit(0);

				break;
			case 1:
				System.out.println("How many Employee do you want to add : ");
				int addEmployee =myInput.nextInt();
				myInput.nextLine();
				
				ArrayList<Employee> employees =new ArrayList<>();
				
				for (int i = 0; i < addEmployee; i++) {
					Employee employee = new Employee();
					System.out.println("Enter Employee Name :  ");
					String i_employee_name = myInput.nextLine();
					employee.setEmployeeName(i_employee_name);
					
					System.out.println("Enter Employee Position");
					String i_employee_position = myInput.nextLine();
					employee.setPosition(i_employee_position);
					
					System.out.println("Enter Employee Salary : ");
					Double i_salary = myInput.nextDouble();
					myInput.nextLine();
					employee.setSalary(i_salary);
					
					
					employees.add(employee);
				}	
				
				if (controller.AddEmployee(employees)) {
					System.out.println("Data inserted successfully");
				} else {
					System.out.println("Data not Inserted");
				}

				
				break;

			case 2:
				System.out.println("Enter Employee id to fetch");
				int employeeid = myInput.nextInt();
				myInput.nextLine();
				Employee fetchEmployee = controller.FetchEmployee(employeeid);
				if (fetchEmployee!=null) {
					
					System.out.println(""+fetchEmployee.getEmployeeName());
					System.out.println(""+fetchEmployee.getPosition());
					System.out.println(""+fetchEmployee.getSalary());
					System.out.println(""+fetchEmployee.getJoiningDate());
				}
				else {

				}

				break;
			case 3:
				
				List<Department> fetchaAllDepartment = controller.FetchaAllDepartment();
				for (Department department : fetchaAllDepartment) {
					System.out.println(""+department.getDepartmentId());
					System.err.println(""+department.getDepartmentName());
				}
				System.out.println("Enter department id to assign");
				int depatmentid = myInput.nextInt();
				myInput.nextLine();
				List<Employee> fetchAllEmployee = controller.FetchAllEmployee();
				for (Employee employee2 : fetchAllEmployee) {
					System.out.println("Employee Id : " + employee2.getEmployeeId());
					System.out.println("Employee Name : " + employee2.getEmployeeName());
					System.out.println("Position : " + employee2.getPosition());
					System.out.println("Salary : " + employee2.getSalary());
				}
				System.out.println("Enter Employee id to be assigned : ");
				int empid = myInput.nextInt();
				myInput.nextLine();
				Employee employee2 = controller.FetchEmployee(empid);
				if (controller.AssignDepartment(depatmentid, employee2)) {
					System.out.println("Sucessful");
				}else {
					System.out.println("Not Successful");
				}
								
				
//				System.out.println("Enter Employee id to Update");
//				int u_employeeid = myInput.nextInt();
//				myInput.nextLine();
//				System.out.println("Enter Employee position to upadte");
//				String u_position = myInput.nextLine();
//				
//				
//				if (controller.UpadteEmployee(u_employeeid, u_position)) {
//					System.out.println("Updated");
//				}else {
//				System.out.println("Not Updated");
//				}
//				break;

			case 4:
				
				controller.FetchAllEmployee();
				System.out.println("Enter Employee id to Remove");
				int r_employeeid = myInput.nextInt();
				myInput.nextLine();

				break;

			case 5:
				System.out.println("Enter Department id to fetch");
				int departmentid = myInput.nextInt();
				myInput.nextLine();

				break;

			case 6:
				Department department = new Department();
				System.out.println("Enter Department Name : ");
				String i_departmentName = myInput.nextLine();
				department.setDepartmentName(i_departmentName);
				
				if (controller.AddDepartment(department)) {
					System.out.println("Data inserted successfully");
				}else {
					System.out.println("Data not Inserted");
				}
				
				break;

			case 7:
				System.out.println("Enter Project Description : ");
				String i_description = myInput.nextLine();

				break;

			case 8:
				Project project = new Project();
				System.out.println("Enter Project ID to fetch : ");
				int projectId = myInput.nextInt();
				break;

			default:
				System.out.println("------------Invalid Selection------------");
				break;
			}
		} while (true);

	}

}
