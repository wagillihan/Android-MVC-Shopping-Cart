package com.websourcecode.williamgillihanmvc;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
/*
Class SecondScreen extends Activity
*/
public class SecondScreen extends Activity
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
      setContentView(R.layout.activity_second_screen);
      TextView showCartContent = (TextView) findViewById(R.id.showCart);
      final Button thirdBtn = (Button) findViewById(R.id.third);
      // get global controller class object
      // (see application tag in AndroidManifest.xml)
      final Controller appController = (Controller) getApplicationContext();
      // get cart size
      final int cartSize = appController.getCart().getCartSize();
      String showString = "";
      // display cart products on screen
      if (cartSize > 0)
      {
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
      } else
      {
         showString = "\n\n" + getString(R.string.empty_cart) + "\n\n";
      }
      showCartContent.setText(showString);
      // listen for third button click
      thirdBtn.setOnClickListener(new OnClickListener()
      {
         /*
         Name: onClick
         Description: fires when third button is clicked.
         Parameters: View object clicked.
         */
         public void onClick(View v)
         {
            if (cartSize > 0)
            {
               Intent i = new Intent(getBaseContext(), ThirdScreen.class);
               startActivity(i);
            } else
               Toast.makeText(getApplicationContext(),
                  getString(R.string.empty_cart),
                  Toast.LENGTH_LONG).show();
         }
      });
   }
   /*
   Name: onDestroy Override
   Description: final call before activity is destroyed
   */
   @Override
   protected void onDestroy()
   {
      super.onDestroy();
   }
}