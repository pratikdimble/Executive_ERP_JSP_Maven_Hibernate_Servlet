package com.erp.dao;

import java.util.List;

import com.erp.domain.ProductMaster;


public interface ProductMasterDAO {
	public List<ProductMaster> loadAllProducts();
	public  int addProduct(ProductMaster prod);
	public int  deleteProduct(int id);
}
