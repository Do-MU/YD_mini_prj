package com.yd.java.miniprj.product;

import java.util.List;

public interface ProductDAO {
	List<ProductVO> productSelectAll();
	ProductVO productSelectOne(ProductVO prd);
	int productInsert(ProductVO prd);
}
