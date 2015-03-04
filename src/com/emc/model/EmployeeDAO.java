package com.emc.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
@Component
public class EmployeeDAO {

	@Autowired
	private HibernateTemplate template;
	
	public void addEmployee(Employee e) {
		template.save(e);
	}
	
	public Employee findEmployee(int employeeID) {
		return template.get(Employee.class, employeeID);
	}
	
	public void updateEmployee(Employee e) {
		template.update(e);
	}
	
	public void removeEmployee(int employeeID) {
		template.delete(template.get(Employee.class, employeeID));
	}
	public List<Employee> getEmployees() {
		return template.find("select e from Employee as e");
	}
}
