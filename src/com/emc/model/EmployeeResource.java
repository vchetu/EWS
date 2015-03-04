package com.emc.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/employee")
public class EmployeeResource {
	
	@Autowired
	public EmployeeDAO employeeDAO;
	
	@RequestMapping(value="/{id}", produces={"application/json"}, method={RequestMethod.GET})
	@ResponseBody
	public Employee getEmployee(@PathVariable("id") int id) {
		return employeeDAO.findEmployee(id);
		
	}

	@RequestMapping(produces={"plain/text"}, consumes={"application/json"}, method={RequestMethod.POST})
	@ResponseBody
	public void addEmployee(@RequestBody Employee e) {
		employeeDAO.addEmployee(e);
		
	}


	@RequestMapping(produces={"plain/text"}, consumes={"application/json"}, method={RequestMethod.PUT})
	@ResponseBody
	public void updateEmployee(@RequestBody Employee e) {
		employeeDAO.updateEmployee(e);
		
	}

	@RequestMapping(value="/{id}", produces={"plain/text"}, method={RequestMethod.DELETE})
	@ResponseBody
	public void removeEmployee(@PathVariable("id") int id) {
		employeeDAO.removeEmployee(id);
		
	}
	
	@RequestMapping(produces={"application/json"}, method={RequestMethod.GET})
	@ResponseBody
	public List<Employee> getEmployees() {
		return employeeDAO.getEmployees();
		
	}
}
