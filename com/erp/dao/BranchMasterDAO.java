package com.erp.dao;

import java.util.List;

import com.erp.domain.BranchMaster;

public interface BranchMasterDAO {
	public List<BranchMaster> loadAllBranch();
	public  int addBranch(BranchMaster branch);
	public int  deleteBranch(int id);
	
}
