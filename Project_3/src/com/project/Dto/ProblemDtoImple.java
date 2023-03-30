package com.project.Dto;

public class ProblemDtoImple implements ProblemDto {
//problem_name | category | pstatus | Enid | empid |
	
	private String ProblemName;
	private String category;
	private int pstatus;
	private String Enid;
	private int empid;
	public ProblemDtoImple(String problemName, String category, int pstatus, String enid, int empid) {
		
		this.ProblemName = problemName;
		this.category = category;
		this.pstatus = pstatus;
		this.Enid = enid;
		this.empid = empid;
	}
   public ProblemDtoImple(String problemName, String category, int pstatus, int empid) {
		
		this.ProblemName = problemName;
		this.category = category;
		this.pstatus = pstatus;
		this.Enid = "0000";
		this.empid = empid;
	}
	@Override
	public String getProblemName() {
		return ProblemName;
	}
	@Override
	public void setProblemName(String problemName) {
		ProblemName = problemName;
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
	public int getPstatus() {
		return pstatus;
	}
	@Override
	public void setPstatus(int pstatus) {
		this.pstatus = pstatus;
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
	public int getEmpid() {
		return empid;
	}
	@Override
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	@Override
	public String toString() {
		return "ProblemName=" + ProblemName + ", category=" + category + ", pstatus=" + pstatus
				+ ", Enid=" + Enid + ", empid=" + empid ;
	}
	
	
}
