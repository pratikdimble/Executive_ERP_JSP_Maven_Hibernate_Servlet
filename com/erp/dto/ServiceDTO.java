package com.erp.dto;



public class ServiceDTO {
	private int sid;
	private String name;
	private String provider;
	
	
	 public int getSid() {
			return sid;
		}
		public void setSid(int sid) {
			this.sid = sid;
		}
	
	public String getName() {
		return name;
	}
	
	public String getProvider() {
		return provider;
	}
	
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
