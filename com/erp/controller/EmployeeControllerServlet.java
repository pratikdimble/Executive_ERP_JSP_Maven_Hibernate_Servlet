package com.erp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.delegate.EmployeeOperationsBusinessDelegate;
import com.erp.dto.EmployeeDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;

//@WebServlet("/controller")
public class EmployeeControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String pval=null;
       EmployeeOperationsBusinessDelegate delegate=null;
       List<EmployeeDTO> listEmployeeDTOs=null;
       List<EmployeeDTO> listEmpDTOs=null;
       List<EmployeeDTO> findEmployeeDTOs=null;
       RequestDispatcher rd=null;
       String employeeRemovalMsg=null;
       String empName=null,empAddr=null,empCity=null,designation=null,qualification=null,
    		   			workExp=null,doj=null,empMail=null,empUsername=null,empPassword=null;
       int empId=0,pin=0;
       long mobile=0;
         String insertResult=null;
       
		//read additional req param value
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link1")){
    	delegate=new EmployeeOperationsBusinessDelegate();
    	try{
    	listEmployeeDTOs=delegate.getAllEmployee();
    	req.setAttribute("listEmployeeDTOs",listEmployeeDTOs);
    	rd=req.getRequestDispatcher("/list_employee.jsp");
    	rd.forward(req,res);
    	}
    	catch(InternalProblemException ipe){
    		req.setAttribute("errMsg",ipe.getMessage());
    		rd=req.getRequestDispatcher("/error.jsp");
    		rd.forward(req,res);
    	}
      }
    	 else if(pval.equalsIgnoreCase("link2")){
    	try{
        	listEmpDTOs=delegate.getAllEmployee();
        	req.setAttribute("listEmployeeDTOs",listEmpDTOs);
        	rd=req.getRequestDispatcher("/empdetails.jsp");
        	rd.forward(req,res);
        	}
        	catch(InternalProblemException ipe){
        		req.setAttribute("errMsg",ipe.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res);
        	}
      }//if
      
    //condition for ADD
        else if(pval.equalsIgnoreCase("Register")){
    	  empName=req.getParameter("name");
    	  empAddr=req.getParameter("local");
    	  empUsername=req.getParameter("uname");
    	  empPassword=req.getParameter("password");
    	  empCity=req.getParameter("city");
    	  pin=Integer.parseInt(req.getParameter("pin"));
    	  
    	  designation=req.getParameter("dsgn");
    	  qualification=req.getParameter("qual");
    	  workExp=req.getParameter("exp");
    	  
    	  String day=req.getParameter("day");
    	  String month=req.getParameter("month");
    	  String year=req.getParameter("year");
    	  doj=day+"-"+month+"-"+year+"";
    	  
    	  mobile=Long.parseLong(req.getParameter("mob"));
    	  empMail=req.getParameter("email");
   	  
    	  
    	//use Delegage
    	  delegate=new EmployeeOperationsBusinessDelegate();
    	  try{
    	  insertResult=delegate.addEmployee(empName, empAddr, empCity, pin, designation, qualification, workExp, doj, mobile, empMail,empUsername,empPassword);
          req.setAttribute("insertMsg",insertResult);
          	rd=req.getRequestDispatcher("/emp_ack.jsp");
  				rd.forward(req,res);
          
          
          listEmployeeDTOs=delegate.getAllEmployee();
          req.setAttribute("listEmployeeDTOs",listEmployeeDTOs);
          
         	rd=req.getRequestDispatcher("/list_employee.jsp");
          	rd.forward(req,res);

    	  }//try close
    	  catch(InsertOperationProblemException iop){
    		  req.setAttribute("errMsg",iop.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res); 
    	  }//catch
    	  catch(InternalProblemException ipe){
    		  req.setAttribute("errMsg",ipe.getMessage());
      		rd=req.getRequestDispatcher("/error.jsp");
      		rd.forward(req,res); 
    	  }//catch
    	  catch(Exception e){
    		  req.setAttribute("errMsg",e.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res);   
    	  }//catch
    	  
      }//else-->if
      //condition for FIND
/*        else if(pval.equalsIgnoreCase("FIND")){
      	  sid=Integer.parseInt(req.getParameter("id"));
   	  
      	//use Delegage
      	delegate=new EmployeeOperationsBusinessDelegate();
    	try{
    	listEmployeeDTOs=delegate.findEmployee(sid);
    	req.setAttribute("findEmployeeDTOs",findEmployeeDTOs);
    	rd=req.getRequestDispatcher("/search_Employee.jsp");
    	rd.forward(req,res);
    	}
    	catch(InternalProblemException ipe){
    		req.setAttribute("errMsg",ipe.getMessage());
    		rd=req.getRequestDispatcher("/error.jsp");
    		rd.forward(req,res);
    	}
      }//else-->if
*/        
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)
}//class
