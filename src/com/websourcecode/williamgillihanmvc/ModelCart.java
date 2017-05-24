package com.websourcecode.williamgillihanmvc;
import java.util.ArrayList;
/*
ModelCart Class
*/
class ModelCart
{
   private ArrayList<ModelProducts> cartProducts =
      new ArrayList<ModelProducts>();
   /*
   Name: getProducts
   Description: gets and returns the the ModelProducts at indicated position.
   Parameters: int position of ModelProducts in ArrayList.
   Returns: the ModelProducts at indicated position.
   */
   ModelProducts getProducts(int productPosition)
   {
      return cartProducts.get(productPosition);
   }
   /*
   Name: setProducts
   Description: used to add ModelProducts products to array list.
   Parameters: ModelProducts object to be added.
   */
   void setProducts(ModelProducts Products)
   {
      cartProducts.add(Products);
   }
   /*
   Name: getCartSize
   Description: used to get the amout of products in cart.
   Returns: int size of cart products ArrayList.
   */
   int getCartSize()
   {
      return cartProducts.size();
   }
   /*
   Name: checkProductInCart
   Description: used to check if a product is in cart.
   Parameters: ModelProducts product to check for.
   Returns: true if product is in cart, false otherwise.
   */
   boolean checkProductInCart(ModelProducts aProduct)
   {
      return cartProducts.contains(aProduct);
   }
}