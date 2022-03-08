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
   private PreparedStatement psmt;
   private ResultSet rs;

   @Override
   public List<ProductVO> productSelectAll(String category) {
      // 카테고리에 따른 제품 리스트 가져오기
      List<ProductVO> products = new ArrayList<ProductVO>();
      ProductVO vo;
      String sql = "SELECT * FROM PRODUCTS WHERE PRODUCT_CATEGORY = ? ORDER BY PRODUCT_ID DESC";
      try {
         psmt = con.prepareStatement(sql);
         psmt.setString(1, category);
         rs = psmt.executeQuery();
         
         while(rs.next()) {
            vo = new ProductVO();
            vo.setProductID(rs.getInt("product_id"));
            vo.setProductName(rs.getString("product_name"));
            vo.setProductImg(rs.getString("product_img"));
            vo.setProductPrice(rs.getInt("product_price"));
            vo.setProductCategory(rs.getString("product_category"));
            
            products.add(vo);
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
       // 단품 조회
         String sql = "SELECT * FROM PRODUCTS WHERE PRODUCT_ID = ?";
         try {
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, prd.getProductID());
            rs = psmt.executeQuery();
            if (rs.next()) {
               prd.setProductID(rs.getInt("product_id"));
               prd.setProductName(rs.getString("roduct_name"));
               prd.setProductImg(rs.getString("product_img"));
               prd.setProductPrice(rs.getInt("product_price"));
               prd.setProductCategory(rs.getString("product_category"));

               }
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            close();
         }
         return prd;
      }

   @Override
   public int productInsert(ProductVO prd) {
      // 제품 등록
      String sql = "INSERT INTO PRODUCTS VALUES(?,?,?,?,?)";
      int n = 0;
         try {
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, prd.getProductID());
            psmt.setString(2, prd.getProductName());
            psmt.setString(3, prd.getProductImg());
            psmt.setInt(4, prd.getProductPrice());
            psmt.setString(5, prd.getProductCategory());
            n = psmt.executeUpdate();
            
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            close();
         }
         return n;
      }
   
   private void close() {
         // Connection 연결을 종료
         try {
            if (rs != null)
               rs.close();
            if (psmt != null)
               psmt.close();
            if (con != null)
               con.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
   }
   
}