package com.erp.delegate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;


import com.erp.dao.ServiceMasterDAO;
import com.erp.dao.ServiceMasterDAOFactory;
import com.erp.domain.ServiceMaster;
import com.erp.dto.ServiceDTO;

import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;
import com.erp.errors.ServiceRemovalProblemException;


public class ServiceOperationsBusinessDelegate {

	public String addService(String name,String provider)throws InsertOperationProblemException,InternalProblemException{
		ServiceMasterDAO dao=null;
		ServiceMaster service=null;
		int sid=0;
		//use dAO
		dao=ServiceMasterDAOFactory.getInstance();
		//prepare Service obj
		service=new ServiceMaster();
		service.setName(name);service.setProvider(provider);
		//invoke method
		try{
		 sid=dao.addService(service);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Service Added Succesfully with Id::"+sid;
	}//method
	
	
	public List<ServiceDTO> getAllServices()throws InternalProblemException{
		ServiceMasterDAO dao=null;
		List<ServiceMaster> listservice=null;
		List<ServiceDTO> listserviceDTOs=null;
		ServiceDTO serviceDTO=null;
		//get DAO
		dao=ServiceMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listservice=dao.loadAllServices();	
		 //convert ListService to ListServiceDTO 
		 listserviceDTOs=new ArrayList();
		 for(ServiceMaster service:listservice){
			 //get Each DTO class object
			 serviceDTO=new ServiceDTO();
			 serviceDTO.setSid(service.getSid());
			 serviceDTO.setName(service.getName());
			 serviceDTO.setProvider(service.getProvider());

			 listserviceDTOs.add(serviceDTO);
		 }//for
		 return listserviceDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
	public String deleteService(int sid)throws ServiceRemovalProblemException{
		ServiceMasterDAO dao=null;
		int count=0;
		String msg=null;
		//get DAO
		dao=ServiceMasterDAOFactory.getInstance();
		try{
		  count=dao.deleteService(sid);
		  if(count==0)
			 
			  msg="Service is Not Removed";
		  else
			  msg="Service is  Removed";
		}
		catch(HibernateException he){
			throw new ServiceRemovalProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new ServiceRemovalProblemException(e.getMessage());
		}
		return msg;
	}//method
	
	
}//class
