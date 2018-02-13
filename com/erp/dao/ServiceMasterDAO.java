package com.erp.dao;

import java.util.List;

import com.erp.domain.ServiceMaster;



public interface ServiceMasterDAO {
	public List<ServiceMaster> loadAllServices();
	public  int addService(ServiceMaster service);
	//public List<ServiceMaster> findService(int sid);
	public int  deleteService(int sid);
}
