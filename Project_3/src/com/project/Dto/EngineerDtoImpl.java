package com.project.Dto;

public class EngineerDtoImpl implements EngineerDto {
 
	private String Enid;
	private String username;
	private String password;
	private String category;
	public EngineerDtoImpl(String enid, String username, String password, String category) {
		
		this.Enid = enid;
		this.username = username;
		this.password = password;
		this.category = category;
	}
	@Override
	public String getEnid() {
		return Enid;
	}
	@Override
	public void setEnid(String enid) {
		Enid = enid;
	}
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public void setUsername(String username) {
		this.username = username;
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
	public String getCategory() {
		return category;
	}
	@Override
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Engineer id=" + Enid + ", username=" + username + ", password=" + password + ", category="
				+ category ;
	}
	
	

}
