package com.websourcecode.williamgillihanmvc;
/*
ModelProducts Class
*/
class ModelProducts
{
   private String productName;
   private String productDesc;
   private int productPrice;
   /*
   Name: ModelProducts
   Description: constructor for ModelProducts.
   Parameter: String for product name.
   Parameter: String for product description.
   Parameter: int for product price.
   Returns: an instantiated object of ModelProducts type.
   */
   ModelProducts(String productName, String productDesc, int productPrice)
   {
      this.productName = productName;
      this.productDesc = productDesc;
      this.productPrice = productPrice;
   }
   /*
   Name: getProductName
   Description: used to get the product name.
   Returns: String representation of product name.
   */
   String getProductName()
   {
      return productName;
   }
   /*
   Name: getProductDesc
   Description: used to get the product description.
   Returns: String representation of product description.
   */
   String getProductDesc()
   {
      return productDesc;
   }
   /*
   Name: getProductPrice
   Description: used to get the product price.
   Returns: String representation of product price.
   */
   int getProductPrice()
   {
      return productPrice;
   }
}