package com.websourcecode.williamgillihanmvc;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
/*
Class ThirdScreen extends Activity
*/
public class ThirdScreen extends Activity
{
   /*
   Name: onCreate Override
   Description: runs when you initialize your activity.
   Parameters: reference to a Bundle object.
   */
   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_third_screen);
      TextView showCartContent = (TextView) findViewById(R.id.showCart);
      // get global controller class object
      // (see application tag in AndroidManifest.xml)
      final Controller appController = (Controller) getApplicationContext();
      int cartSize = appController.getCart().getCartSize();
      String showString = "";
      // display cart products on screen
      for (int i = 0; i < cartSize; i++)
      {
         // get product details
         String productName =
            appController.getCart().getProducts(i).getProductName();
         int productPrice =
            appController.getCart().getProducts(i).getProductPrice();
         String productDesc =
            appController.getCart().getProducts(i).getProductDesc();
         // product display string
         showString += "\n\n" +
            "Product Name : " + productName + "\n" +
            "Price : $" + productPrice + "\n" +
            "Description : " + productDesc + "" +
            getString(R.string.product_line);
      }
      showCartContent.setText(showString);
   }
}
