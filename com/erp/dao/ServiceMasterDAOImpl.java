package com.erp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.erp.domain.ServiceMaster;
import com.erp.utility.HibernateUtil;


public class ServiceMasterDAOImpl implements ServiceMasterDAO {
 private static final String HQL_GET_ALL_SERVICES="from  ServiceMaster";

 @Override
 public int addService(ServiceMaster service) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(service);
       flag=true;			
		}//try
		catch(HibernateException he){
			flag=false;
			throw he;
		}
		catch(Exception e){
			flag=false;
			throw e;
		}
		finally{
			if(flag){
				tx.commit();
				
			}
			else{
				tx.rollback();
			}
		 //close Session
			HibernateUtil.closeSession();
		}//finally
		return idVal;
	}//method
	
 
 
 
 @Override
	public List<ServiceMaster> loadAllServices() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<ServiceMaster> listservice = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_SERVICES);
		try {
			listservice = query.list();
		} // try
		catch (HibernateException he) {
			flag = false;
			throw he;
		} catch (Exception e) {
			flag = false;
			throw e;
		} finally {
			// close Session
			HibernateUtil.closeSession();
		} // finally
		return listservice;
	}//method
	
 @Override
	public int deleteService(int sid) {
	Session ses = null;
	ses = HibernateUtil.getSession();
	Transaction tx=null;
	int count=0;
	ServiceMaster service=null;
	//load  obj
	service=ses.get(ServiceMaster.class,sid);
	try{
	 tx=ses.beginTransaction();
	   //delete objs
	 ses.delete(service);
  count=1;		
	}//try
	catch(HibernateException he){
		count=0;
		throw he;
	}
	catch(Exception e){
		count=0;
		throw e;
	}
	finally{
		if(count==1){
			tx.commit();
		}
		else{
			tx.rollback();
		}
	 //close Session
		HibernateUtil.closeSession();
	}//finally	
	return count;
}//method
 
}
