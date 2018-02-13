package com.erp.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="ERP_SERVICE")
public class ServiceMaster {
	private int sid;
	private String name;
	private String provider;
	
	public ServiceMaster() {
		System.out.println("ServiceMaster:0-param constructor");
	}
	 @Id
	 @GenericGenerator(name="gen1",strategy="increment")
	 @GeneratedValue(generator="gen1")
	 public int getSid() {
			return sid;
		}
		public void setSid(int sid) {
			this.sid = sid;
		}
	
	@Column(length=30,nullable=false)
	@Type(type="string")
	public String getName() {
		return name;
	}
	
	public String getProvider() {
		return provider;
	}
	
	@Column(length=20,nullable=false)
	@Type(type="string")
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public void setName(String name) {
		this.name = name;
	}



}
