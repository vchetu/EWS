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
	private String managerName;
	private String team;
	private String workspaceID;
	private String shiftStart;
	private String shiftEnd;
	
	public String getShiftStart() {
		return shiftStart;
	}

	public void setShiftStart(String shiftStart) {
		this.shiftStart = shiftStart;
	}

	public String getShiftEnd() {
		return shiftEnd;
	}

	public void setShiftEnd(String shiftEnd) {
		this.shiftEnd = shiftEnd;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
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

	public Employee(int employeeID, String name, String managerName,
			String team, String workspaceID, String shiftStart, String shiftEnd) {
		super();
		this.employeeID = employeeID;
		this.name = name;
		this.managerName = managerName;
		this.team = team;
		this.workspaceID = workspaceID;
		this.shiftStart = shiftStart;
		this.shiftEnd = shiftEnd;
	}

	public Employee() {
		super();
	}
	
}
