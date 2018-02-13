package com.erp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.erp.domain.RegionMaster;
import com.erp.utility.HibernateUtil;


public class RegionMasterDAOImpl implements RegionMasterDAO {
 private static final String HQL_GET_ALL_REGIONS="from  RegionMaster";

 @Override
 public int addRegion(RegionMaster region) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(region);
		 System.out.println("Region Saved with:: "+idVal);
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
	public List<RegionMaster> loadAllRegions() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<RegionMaster> listRegion = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_REGIONS);
		try {
			listRegion= query.list();
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
		return listRegion;
	}//method


}
