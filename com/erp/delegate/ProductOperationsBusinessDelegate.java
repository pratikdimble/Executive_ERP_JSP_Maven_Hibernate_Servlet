package com.erp.delegate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.erp.dao.ProductMasterDAO;
import com.erp.dao.ProductMasterDAOFactory;
import com.erp.domain.ProductMaster;
import com.erp.dto.ProductDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;
import com.erp.errors.ProductRemovalProblemException;


public class ProductOperationsBusinessDelegate {

	public String addProduct(String name,String type,String company,float cost,int quantity,float warranty)throws InsertOperationProblemException,InternalProblemException{
		ProductMasterDAO dao=null;
		ProductMaster prod=null;
		int pid=0;
		//use dAO
		dao=ProductMasterDAOFactory.getInstance();
		//prepare Product object
		prod=new ProductMaster();
		prod.setName(name);prod.setType(type);prod.setCompany(company);
		prod.setCost(cost);prod.setQuantity(quantity);prod.setWarranty(warranty);
		//invoke method
		try{
		 pid=dao.addProduct(prod);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Product Added Succesfully with Id::"+pid;
	}//method
	
	
	public List<ProductDTO> getAllProducts()throws InternalProblemException{
		ProductMasterDAO dao=null;
		List<ProductMaster> listprod=null;
		List<ProductDTO> listprodDTOs=null;
		ProductDTO prodDTO=null;
		//get DAO
		dao=ProductMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listprod=dao.loadAllProducts();	
		 //convert ListProduct to ListProductDTO 
		 listprodDTOs=new ArrayList();
		 for(ProductMaster prod:listprod){
			 //get Each DTO class object
			 prodDTO=new ProductDTO();
			 prodDTO.setPid(prod.getPid());
			 prodDTO.setName(prod.getName());
			 prodDTO.setType(prod.getType());
			 prodDTO.setCompany(prod.getCompany());
			 prodDTO.setCost(prod.getCost());
			 prodDTO.setQuantity(prod.getQuantity());
			 prodDTO.setWarranty(prod.getWarranty());

			 listprodDTOs.add(prodDTO);
		 }//for
		 return listprodDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
	public String deleteProduct(int id)throws ProductRemovalProblemException{
		ProductMasterDAO dao=null;
		int count=0;
		//get DAO
		dao=ProductMasterDAOFactory.getInstance();
		try{
		  count=dao.deleteProduct(id);
		  if(count==0)
			  return "Product is Not Deleted";
		  else
			  return "Product Is Deleted";
		}
		catch(HibernateException he){
			throw new ProductRemovalProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new ProductRemovalProblemException(e.getMessage());
		}
	}//method
	
}//class
