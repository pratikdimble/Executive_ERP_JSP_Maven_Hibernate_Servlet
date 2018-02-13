package com.erp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.erp.domain.BranchMaster;
import com.erp.domain.ServiceMaster;
import com.erp.utility.HibernateUtil;


public class BranchMasterDAOImpl implements BranchMasterDAO {
 private static final String HQL_GET_ALL_BRANCH="from  BranchMaster";

 @Override
 public int addBranch(BranchMaster branch) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(branch);
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
	public List<BranchMaster> loadAllBranch() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<BranchMaster> listbranch = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_BRANCH);
		try {
			listbranch = query.list();
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
		return listbranch;
	}//method
 
@Override
	public int deleteBranch(int id) {
	Session ses = null;
	ses = HibernateUtil.getSession();
	Transaction tx=null;
	int count=0;
	BranchMaster br=null;
	//load  obj
	br=ses.get(BranchMaster.class,id);
	try{
	 tx=ses.beginTransaction();
	   //delete objs
	 ses.delete(br);
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
