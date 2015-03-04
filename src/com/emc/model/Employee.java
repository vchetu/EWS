package com.emc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee_WS")
public class Employee {

	@Id
	@Column(name="emp_id")
	private int employeeID;
	private String name;
	private String workspaceID;
	private String shiftType;
	
		
	public String getShiftType() {
		return shiftType;
	}

	public void setShiftType(String shiftType) {
		this.shiftType = shiftType;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWorkspaceID() {
		return workspaceID;
	}

	public void setWorkspaceID(String workspaceID) {
		this.workspaceID = workspaceID;
	}

	public Employee(int employeeID, String name, String workspaceID, String shiftType) {
		super();
		this.employeeID = employeeID;
		this.name = name;
		this.workspaceID = workspaceID;
		this.shiftType = shiftType;
	}

	public Employee() {
		super();
	}
	
}
