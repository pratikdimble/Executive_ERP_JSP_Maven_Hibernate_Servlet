package com.erp.dao;

import java.util.List;

import com.erp.domain.RegionMaster;

public interface RegionMasterDAO {
	public List<RegionMaster> loadAllRegions();
	public  int addRegion(RegionMaster region);
	
}
