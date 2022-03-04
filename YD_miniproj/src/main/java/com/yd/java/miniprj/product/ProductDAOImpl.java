package com.yd.java.miniprj.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yd.java.miniprj.common.DAO;

public class ProductDAOImpl implements ProductDAO {
	private Connection con = DAO.getInstance();
	private PreparedStatement pstm;
	private ResultSet rs;

	@Override
	public List<ProductVO> productSelectAll() {
		// 카테고리에 따른 제품 리스트 가져오기
		List<ProductVO> products = new ArrayList<ProductVO>();
		ProductVO vo;
		String sql = "SELECT * FROM PRODUCTS WHRER PRODUCT_CATEGORY = ? ORDER BY PRODUCT_ID DESC";
		try {
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				vo = new ProductVO();
				vo.setProductID(rs.getInt("product_id"));
				vo.setProductName(rs.getString("product_name"));
				vo.setProductImg(rs.getString("product_img"));
				vo.setProductPrice(rs.getInt("product_price"));
				vo.setProductCategory(rs.getString("product_category"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return products;
	}

	@Override
	public ProductVO productSelectOne(ProductVO prd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int productInsert(ProductVO prd) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private void close() {
	      // Connection 연결을 종료
	      try {
	         if (rs != null)
	            rs.close();
	         if (pstm != null)
	            pstm.close();
	         if (con != null)
	            con.close();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	}
}
