package com.erp.dao;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.erp.domain.ProductMaster;
import com.erp.utility.HibernateUtil;


public class ProductMasterDAOImpl implements ProductMasterDAO {
 private static final String HQL_GET_ALL_PRODUCTS="from  ProductMaster";
 private static final String HQL_GET_PRODUCT="from  ProductMaster where name=?";
 private static final String HQL_DELETE_PRODUCT="Delete from  ProductMaster where name=?";
	
 @Override
	public int addProduct(ProductMaster prod) {
		Session ses=null;
		ses=HibernateUtil.getSession();
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		try{
		 tx=ses.beginTransaction();
		   //save objs
		 idVal=(int)ses.save(prod);
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
	public List<ProductMaster> loadAllProducts() {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<ProductMaster> listprod = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_ALL_PRODUCTS);
		try {
			listprod = query.list();
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
		return listprod;
	}//method
 
 
	@Override
	public int deleteProduct(String name) {
	Session ses = null;
	ses = HibernateUtil.getSession();
	Transaction tx=null;
	int count=0;
	Query query = null;
	// prepare query
	query = ses.createQuery(HQL_DELETE_PRODUCT);
	query.setParameter(0, name);
	try{
	 tx=ses.beginTransaction();
	   //delete objs
	 query.executeUpdate();
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
	@Override
		public List<ProductMaster> getProduct(String name) {
		Session ses = null;
		ses = HibernateUtil.getSession();
		boolean flag = false;
		List<ProductMaster> listprod = null;
		Query query = null;
		// prepare query
		query = ses.createQuery(HQL_GET_PRODUCT);
		query.setParameter(0, name);
		try {
			listprod = query.list();
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
		return listprod;
		}

}//class
