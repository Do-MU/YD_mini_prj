package com.yd.java.miniprj.product;

import java.util.List;

public interface ProductDAO {
	List<ProductVO> productSelectAll(String category);
	ProductVO productSelectOne(int prd_id);
	int productInsert(ProductVO prd);
}
