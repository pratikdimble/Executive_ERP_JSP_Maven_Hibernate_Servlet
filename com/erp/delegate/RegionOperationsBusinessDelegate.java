package com.erp.delegate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;

import com.erp.dao.RegionMasterDAO;
import com.erp.dao.RegionMasterDAOFactory;
import com.erp.domain.RegionMaster;
import com.erp.dto.RegionDTO;

import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;
import com.sun.org.apache.regexp.internal.RE;


public class RegionOperationsBusinessDelegate {

	public String addRegion(String regName,String regDesc)throws InsertOperationProblemException,InternalProblemException{
		RegionMasterDAO dao=null;
		RegionMaster region=null;
		int regionId=0;
		//use dAO
		dao=RegionMasterDAOFactory.getInstance();
		//prepare Region obj
		region=new RegionMaster();
		region.setRegName(regName);
		region.setRegDesc(regDesc);
		//invoke method
		try{
		 regionId=dao.addRegion(region);
		}
		catch(HibernateException he){
			throw new InsertOperationProblemException(he.getMessage());
		}
		catch(Exception e){
			throw new InternalProblemException(e.getMessage());
		}
		return " Region Added Succesfully with Id::"+regionId;
	}//method
	
	
	public List<RegionDTO> getAllRegions()throws InternalProblemException{
		RegionMasterDAO dao=null;
		List<RegionMaster> listRegion=null;
		List<RegionDTO> listRegionDTOs=null;
		RegionDTO RegionDTO=null;
		//get DAO
		dao=RegionMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listRegion=dao.loadAllRegions();	
		 //convert ListRegion to ListRegionDTO 
		 listRegionDTOs=new ArrayList();
		 for(RegionMaster Region:listRegion){
			 //get Each DTO class object
			 RegionDTO=new RegionDTO();
			 RegionDTO.setRegId(Region.getRegId());
			 RegionDTO.setRegName(Region.getRegName());
			 RegionDTO.setRegDesc(Region.getRegDesc());

			 listRegionDTOs.add(RegionDTO);
		 }//for
		 return listRegionDTOs;
		}
		catch(HibernateException he){
			throw new InternalProblemException(he.getMessage());
		}
		catch(Exception he){
			throw new InternalProblemException(he.getMessage());
		}
	}//method
	
	
	
	
	/*public List<RegionDTO> findRegion(int sid)throws InternalProblemException{
		RegionMasterDAO dao=null;
		List<RegionMaster> listRegion=null;
		List<RegionDTO> findRegionDTOs=null;
		RegionDTO RegionDTO=null;
		//get DAO
		dao=RegionMasterDAOFactory.getInstance();
		//use DAO
		try{
		 listRegion=dao.findRegion(sid);
		 //convert ListRegion to ListRegionDTO 
		 findRegionDTOs=new ArrayList();
		 for(RegionMaster Region:listRegion){
			 //get Each DTO class object
			 RegionDTO=new RegionDTO();
			 RegionDTO.setSid(Region.getSid());
			 RegionDTO.setName(Region.getName());
			 RegionDTO.setProvider(Region.getProvider());

			 findRegionDTOs.add(RegionDTO);
		 }//for
		 return findRegionDTOs;
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
