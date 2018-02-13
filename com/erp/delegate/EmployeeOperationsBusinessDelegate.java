package com.erp.delegate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.erp.dao.EmployeeMasterDAO;
import com.erp.dao.EmployeeMasterDAOFactory;
import com.erp.domain.EmployeeMaster;
import com.erp.dto.EmployeeDTO;

import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;


public class EmployeeOperationsBusinessDelegate {

	public String addEmployee(String empName,String empAddr,String empCity,int pin,
								String designation,String qualification,String workExp,
								String doj,long mobile,String empMail,String empUsername,String empPassword)throws InsertOperationProblemException,InternalProblemException{
		EmployeeMasterDAO dao=null;
		EmployeeMaster employee=null;
		int empId=0;
		//use dAO
		dao=EmployeeMasterDAOFactory.getInstance();
		//prepare Employee obj
		employee=new EmployeeMaster();
		employee.setEmpName(empName);employee.setEmpAddr(empAddr);employee.setEmpCity(empCity);
		employee.setPin(pin);employee.setDesignation(designation);employee.setQualification(qualification);
		employee.setWorkExp(workExp);employee.setDoj(doj);employee.setEmpMail(empMail);
		employee.setMobile(mobile);employee.setEmpUsername(empUsername);employee.setEmpPassword(empPassword);
				//invoke method
		try{
		 empId=dao.addEmployee(employee);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Employee Added Succesfully with Id::"+empId;
	}//method
	
	
	public List<EmployeeDTO> getAllEmployee()throws InternalProblemException{
		EmployeeMasterDAO dao=null;
		List<EmployeeMaster> listEmployee=null;
		List<EmployeeDTO> listEmployeeDTOs=null;
		EmployeeDTO employeeDTO=null;
		//get DAO
		dao=EmployeeMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listEmployee=dao.loadAllEmployee();	
		 //convert ListEmployee to ListEmployeeDTO 
		 listEmployeeDTOs=new ArrayList();
		 for(EmployeeMaster employee:listEmployee){
			 //get Each DTO class object
			 employeeDTO=new EmployeeDTO();
			 employeeDTO.setEmpId(employee.getEmpId());
			 employeeDTO.setEmpName(employee.getEmpName());
			 employeeDTO.setEmpAddr( employee.getEmpAddr());
			 employeeDTO.setEmpCity(employee.getEmpCity());
			 employeeDTO.setPin( employee.getPin());
			 employeeDTO.setDesignation(employee.getDesignation());
			 employeeDTO.setQualification(employee.getQualification());
			 employeeDTO.setWorkExp(employee.getWorkExp());
			 employeeDTO.setDoj(employee.getDoj());
			 employeeDTO.setMobile( employee.getMobile());
			 employeeDTO.setEmpMail( employee.getEmpMail());
			 employeeDTO.setEmpUsername(employee.getEmpUsername());
			 employeeDTO.setEmpPassword(employee.getEmpPassword());

			 listEmployeeDTOs.add(employeeDTO);
		 }//for
		 return listEmployeeDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
	
	
	
	/*public List<EmployeeDTO> findEmployee(int sid)throws InternalProblemException{
		EmployeeMasterDAO dao=null;
		List<EmployeeMaster> listEmployee=null;
		List<EmployeeDTO> findEmployeeDTOs=null;
		EmployeeDTO EmployeeDTO=null;
		//get DAO
		dao=EmployeeMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listEmployee=dao.findEmployee(sid);
		 //convert ListEmployee to ListEmployeeDTO 
		 findEmployeeDTOs=new ArrayList();
		 for(EmployeeMaster Employee:listEmployee){
			 //get Each DTO class object
			 EmployeeDTO=new EmployeeDTO();
			 EmployeeDTO.setSid(Employee.getSid());
			 EmployeeDTO.setName(Employee.getName());
			 EmployeeDTO.setProvider(Employee.getProvider());

			 findEmployeeDTOs.add(EmployeeDTO);
		 }//for
		 return findEmployeeDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	*/
	
}//class
