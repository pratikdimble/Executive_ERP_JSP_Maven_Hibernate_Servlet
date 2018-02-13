package com.erp.dto;



public class RegionDTO {
	private int regId;
	private String regName;
	private String regDesc;
	
	public RegionDTO() {
		System.out.println("RegionDTO:0-param constructor");
	}
	
	public int getRegId() {
		return regId;
	}
	public void setRegId(int regId) {
		this.regId = regId;
	}
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	public String getRegDesc() {
		return regDesc;
	}
	public void setRegDesc(String regDesc) {
		this.regDesc = regDesc;
	}
	

}