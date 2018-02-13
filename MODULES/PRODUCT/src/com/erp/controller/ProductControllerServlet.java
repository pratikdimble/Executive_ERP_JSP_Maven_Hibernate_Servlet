package com.erp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.delegate.CompanyOperationsBusinessDelegate;
import com.erp.delegate.ProductOperationsBusinessDelegate;
import com.erp.dto.ProductDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;
import com.erp.errors.ProductRemovalProblemException;

//@WebServlet("/controller")
public class ProductControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String pval=null;
       ProductOperationsBusinessDelegate delegate=null;
       List<ProductDTO> listprodDTOs=null;
       RequestDispatcher rd=null;
       String productRemovalMsg=null;
       String name=null,type=null,company=null;
       int quantity=0;
       float cost=0,warranty=0;
       String insertResult=null;
       
		//read additional req param value
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link1")){
    	delegate=new ProductOperationsBusinessDelegate();
    	try{
    	listprodDTOs=delegate.getAllProducts();
    	req.setAttribute("listprodDTOs",listprodDTOs);
    	rd=req.getRequestDispatcher("/list_prod.jsp");
    	rd.forward(req,res);
    	}
    	catch(InternalProblemException ipe){
    		req.setAttribute("errMsg",ipe.getMessage());
    		rd=req.getRequestDispatcher("/error.jsp");
    		rd.forward(req,res);
    	}
      }//if
      else if(pval.equalsIgnoreCase("Details")){
      	delegate=new ProductOperationsBusinessDelegate();
      	try{
      	listprodDTOs=delegate.getProduct(req.getParameter("choice"));
      	req.setAttribute("listprodDTOs",listprodDTOs);
      	rd=req.getRequestDispatcher("/selectprod.jsp");
      	rd.forward(req,res);
      	}
      	catch(InternalProblemException ipe){
      		req.setAttribute("errMsg",ipe.getMessage());
      		rd=req.getRequestDispatcher("/error.jsp");
      		rd.forward(req,res);
      	}
        }//if
      else if(pval.equalsIgnoreCase("DELETE")){
    	  //use Delegage
    	  delegate=new ProductOperationsBusinessDelegate();
    	  try{
    	  productRemovalMsg=delegate.deleteProduct(req.getParameter("choice"));
    	  req.setAttribute("productRemovalMsg", productRemovalMsg);
    	   	rd=req.getRequestDispatcher("deleteprod.jsp");
        	rd.forward(req,res);
    	  listprodDTOs=delegate.getAllProducts();
      	  req.setAttribute("listprodDTO",listprodDTOs);
      /* 	rd=req.getRequestDispatcher("deleteprod.jsp");
        	rd.forward(req,res);*/

    	  }
    	  catch(ProductRemovalProblemException sepe){
    		req.setAttribute("errMsg",sepe.getMessage());
      		rd=req.getRequestDispatcher("/error.jsp");
      		rd.forward(req,res); 
    	  }
    	  catch (InternalProblemException ipe) {
    		  req.setAttribute("errMsg",ipe.getMessage());
      		rd=req.getRequestDispatcher("/error.jsp");
      		rd.forward(req,res);
   	    	}
    	  catch(Exception e){
    		  req.setAttribute("errMsg",e.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res); 
    	  }
      }//else if
        else if(pval.equalsIgnoreCase("ADD")){
    	  name=req.getParameter("name");
    	  type=req.getParameter("type");
    	  company=req.getParameter("company");
    	  cost=Float.parseFloat(req.getParameter("cost"));
    	  quantity=Integer.parseInt(req.getParameter("quantity"));
    	  warranty=Float.parseFloat(req.getParameter("warranty"));
    	  
    	//use Delegage
    	  delegate=new ProductOperationsBusinessDelegate();
    	  try{
    	  insertResult=delegate.addProduct(name, type, company, cost, quantity, warranty);
          req.setAttribute("insertMsg",insertResult);
          	rd=req.getRequestDispatcher("/ack.jsp");
  				rd.forward(req,res);
          
          
          listprodDTOs=delegate.getAllProducts();
          req.setAttribute("listprodDTOs",listprodDTOs);
          
         	rd=req.getRequestDispatcher("/list_prod.jsp");
          	rd.forward(req,res);

    	  }
    	  catch(InsertOperationProblemException iop){
    		  req.setAttribute("errMsg",iop.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res); 
    	  }
    	  catch(InternalProblemException ipe){
    		  req.setAttribute("errMsg",ipe.getMessage());
      		rd=req.getRequestDispatcher("/error.jsp");
      		rd.forward(req,res); 
    	  }
    	  catch(Exception e){
    		  req.setAttribute("errMsg",e.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res);   
    	  }
    	  
      }
      
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)
}//class
