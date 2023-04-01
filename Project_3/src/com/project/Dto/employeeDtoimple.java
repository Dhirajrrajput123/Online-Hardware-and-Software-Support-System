package com.project.Dto;

public class employeeDtoimple  implements employeeDto{

	private String name;
	private String password;
	public employeeDtoimple(String name, String password) {
		this.name = name;
		this.password = password;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return " name= " + name + ", password= " + password ;
	}
	
	
}
