package com.erp.dao;

import java.util.List;

import com.erp.domain.EmployeeMaster;

public interface EmployeeMasterDAO {
	public List<EmployeeMaster> loadAllEmployee();
	public  int addEmployee(EmployeeMaster emp);
	
}
