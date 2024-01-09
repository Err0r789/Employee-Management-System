package com.jsp.ems.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.jsp.ems.model.Department;
import com.jsp.ems.model.Employee;
import com.jsp.ems.model.Project;

public class Controller {

	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pgsql");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();

	public boolean AddEmployee(List<Employee> employees) {
		if (employees!=null) {
			entityTransaction.begin();
		for (Employee employee : employees) {
			entityManager.persist(employee);
		}
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public Employee FetchEmployee(int employeeid) {
		return entityManager.find(Employee.class, employeeid);
	}

	public List<Employee> FetchAllEmployee() {
		String jpql = "SELECT s FROM Employee s";
		TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
		List<Employee> resultList = query.getResultList();
		return resultList;
	}
	public boolean UpadteEmployee(int u_employeeid,String u_position) {
		Employee fetchEmployee = FetchEmployee(u_employeeid);
		if (fetchEmployee!=null) {
			fetchEmployee.setPosition(u_position);
			entityTransaction.begin();
			entityManager.merge(fetchEmployee);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	public boolean AssignDepartment(int depatmentid,Employee employee) {
		Department fetchDepartment = FetchDepartment(depatmentid);
		if (fetchDepartment!=null) {
			employee.setDepartment(fetchDepartment);
			entityTransaction.begin();
			entityManager.merge(employee);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public void RemoveEmployee(int r_employeeid) {
		Employee find = entityManager.find(Employee.class, r_employeeid);
		if (find != null) {
			entityTransaction.begin();
			entityManager.remove(find);
			entityTransaction.commit();
		}

	}

	public boolean AddDepartment(Department department) {
		if (department != null) {
			entityTransaction.begin();
			entityManager.persist(department);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public Department FetchDepartment(int depatmentid) {
		return entityManager.find(Department.class, depatmentid);
	}

	public List<Department> FetchaAllDepartment() {
		String jpql = "SELECT s FROM Department s";
		TypedQuery<Department> createQuery = entityManager.createQuery(jpql, Department.class);
		List<Department> resultList = createQuery.getResultList();
		return resultList;
	}

	public boolean RemoveDepartment(int r_depatmentid) {
		Department find = entityManager.find(Department.class, r_depatmentid);
		if (find != null) {
			entityTransaction.begin();
			entityManager.remove(find);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public boolean AddProject(Project project) {
		if (project != null) {
			entityTransaction.begin();
			entityManager.persist(project);
			entityTransaction.commit();
			return true;
		}
		return false;

	}

	public Project FindProject(int projectid) {
		return entityManager.find(Project.class, projectid);
	}
	
	

	public boolean RemoveProject(int r_projectid) {
		Project find = entityManager.find(Project.class, r_projectid);
		if (find != null) {
			entityTransaction.begin();
			entityManager.remove(find);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

}
