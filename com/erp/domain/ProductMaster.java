package com.erp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="ERP_PRODUCT")
/*,uniqueConstraints=
{@UniqueConstraint(columnNames={"NAME"}),
	@UniqueConstraint(columnNames={"COMPANY"})})*/
public class ProductMaster {
/*	@EmbeddedId
	private CompId name;*/
	private int pid;
	private String name;
	private String type;
	private String company;
	private float cost;
	private int quantity;
	private float warranty;
	
	public ProductMaster() {
		System.out.println("ProductMaster:0-param constructor");
	}
/*	
	 public CompId getName() {
		return name;
	}

	public void setName(CompId name) {
		this.name = name;
	}*/

	@Id
	 @GenericGenerator(name="gen1",strategy="increment")
	 @GeneratedValue(generator="gen1")
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Column(length=20,nullable=false)
	@Type(type="string")
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Column(length=10,nullable=false)
	@Type(type="float")
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	@Column(length=10,nullable=false)
	@Type(type="int")
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Column(length=10,nullable=false)
	@Type(type="float")
	public float getWarranty() {
		return warranty;
	}
	public void setWarranty(float warranty) {
		this.warranty = warranty;
	}

}
