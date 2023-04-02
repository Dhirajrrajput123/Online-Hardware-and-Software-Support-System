package com.project.Dto;

public class EngineerWithNumberOgProblem implements EngineerWithNumberOgProblemInterface {

	private String ENId;
	private int count;
	public EngineerWithNumberOgProblem(String eNId, int count) {
		this.ENId = eNId;
		this.count = count;
	}
	@Override
	public String getENId() {
		return ENId;
	}
	@Override
	public void setENId(String eNId) {
		ENId = eNId;
	}
	@Override
	public int getCount() {
		return count;
	}
	@Override
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Engineer Id=  " + ENId + ", number of problem:  " + count + "]";
	}
	
}
