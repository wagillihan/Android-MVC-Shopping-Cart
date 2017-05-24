package com.websourcecode.williamgillihanmvc;
import java.util.ArrayList;
import android.app.Application;
/*
Controller Class
*/
public class Controller extends Application
{
   // array list to hold ModelProducts
   private ArrayList<ModelProducts> myProducts =
      new ArrayList<ModelProducts>();
   // instatiate ModelCart object
   private ModelCart myCart = new ModelCart();
   /*
   Name: getProducts
   Description: gets and returns the the ModelProducts at indicated position.
   Parameters: int position of ModelProducts in ArrayList.
   Returns: the ModelProducts at indicated position.
   */
   ModelProducts getProducts(int productPosition)
   {
      return myProducts.get(productPosition);
   }
   /*
   Name: setProducts
   Description: used to add ModelProducts products to array list.
   Parameters: ModelProducts object to be added.
   */
   void setProducts(ModelProducts Products)
   {
      myProducts.add(Products);
   }
   /*
   Name: getCart
   Description: used to get reference to cart.
   Returns: ModelCart object.
   */
   ModelCart getCart()
   {
      return myCart;
   }
   /*
   Name: getProductsArrayListSize
   Description: used to get the product array list size.
   Returns: int value of ArrayList size.
   */
   int getProductsArrayListSize()
   {
      return myProducts.size();
   }
}