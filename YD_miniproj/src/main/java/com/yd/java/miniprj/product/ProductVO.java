package com.yd.java.miniprj.product;

public class ProductVO {
   private int productID;
   private String productName;
   private String productImg;
   private int productPrice;
   private String productCategory;
   
   public int getProductID() {
      return productID;
   }
   public void setProductID(int productID) {
      this.productID = productID;
   }
   public String getProductName() {
      return productName;
   }
   public void setProductName(String productName) {
      this.productName = productName;
   }
   public String getProductImg() {
      return productImg;
   }
   public void setProductImg(String productImg) {
      this.productImg = productImg;
   }
   public int getProductPrice() {
      return productPrice;
   }
   public void setProductPrice(int productPrice) {
      this.productPrice = productPrice;
   }
   public String getProductCategory() {
      return productCategory;
   }
   public void setProductCategory(String productCategory) {
      this.productCategory = productCategory;
   }

}