package com.websourcecode.williamgillihanmvc;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
/*
Class FirstScreen extends Activity
*/
public class FirstScreen extends Activity
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
      setContentView(R.layout.activity_first_screen);
      final LinearLayout linearM =
         (LinearLayout) findViewById(R.id.linearMain);
      final Button secondBtn = (Button) findViewById(R.id.second);
      // get global controller class object
      // (see application tag in AndroidManifest.xml)
      final Controller appController = (Controller) getApplicationContext();
      // product array list size to check if it has already been created
      int ProductsSize = appController.getProductsArrayListSize();
      // create product data
      if (ProductsSize < 1) // only create products once
      {
         ModelProducts productObject = null;
         String[] prod = {"SSD Drive", "Disk Drive", "Memory",
            "Monitor", "Peripheral"};
         String[] desc = {"1 TB Solid State Drive", "Blue Ray Disk",
            "16GB(8GBx2) DDR3", "26\" High Definition LED",
            "Wireless Mouse/Keyboard"};
         int[] cost = {210, 150, 80, 170, 20};
         for (int i = 0; i <= prod.length - 1; i++)
         {
            // Create product model class object
            productObject = new ModelProducts(prod[i], desc[i], cost[i]);
            //store product object to array list in controller
            appController.setProducts(productObject);
         }
      }
      // product array list size to use in processing 
      ProductsSize = appController.getProductsArrayListSize();
      // create view elements dynamically and show on activity
      // create the layout params that will be used to define how
      // button will be displayed
      LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
         LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
      // create view elements dynamically 
      for (int j = 0; j < ProductsSize; j++)
      {
         // get product data from product data array list
         String productName = appController.getProducts(j).getProductName();
         int productPrice = appController.getProducts(j).getProductPrice();
         // create LinearLayout to view elements
         LinearLayout linearL = new LinearLayout(this);
         linearL.setOrientation(LinearLayout.HORIZONTAL);
         TextView product = new TextView(this);
         product.setText(padRight(productName, 15));
         // add textView to LinearLayout
         linearL.addView(product);
         TextView price = new TextView(this);
         price.setText(padRight("$" + productPrice, 10));
         // add textView to LinearLayout
         linearL.addView(price);
         final Button btn = new Button(this);
         btn.setId(j + 1);
         btn.setText("Add To Cart");
         // set the layoutParams on the button
         btn.setLayoutParams(params);
         final int index = j;
         // create click listener for dynamically created button
         // listens for add button being clicked
         btn.setOnClickListener(new OnClickListener()
         {
            /*
            Name: onClick
            Description: fires when add button is clicked
            Parameters: View object clicked
            */
            public void onClick(View v)
            {
               // clicked button index
               Log.i("TAG", "index :" + index);
               // get product instance for index
               ModelProducts tempProdObj =
                  appController.getProducts(index);
               // check if product already exists in cart
               if (!appController.getCart().checkProductInCart(tempProdObj))
               {
                  btn.setText("Added");
                  // cart product arraylist
                  appController.getCart().setProducts(tempProdObj);
                  Toast.makeText(getApplicationContext(),
                     "Now Cart size: " +
                     appController.getCart().getCartSize(),
                     Toast.LENGTH_LONG).show();
               } else
               {
                  // cart product arraylist contains product
                  Toast.makeText(getApplicationContext(),
                     "Product " + (index + 1) + " already added in cart.",
                     Toast.LENGTH_LONG).show();
               }
            }
         });
         // add button to LinearLayout
         linearL.addView(btn);
         // add LinearLayout to XML layout
         linearM.addView(linearL);
      }
      // listen for second button click
      secondBtn.setOnClickListener(new OnClickListener()
      {
         /*
         Name: onClick
         Description: fires when second button is clicked.
         Parameters: View object clicked.
         */
         public void onClick(View v)
         {
            Intent i = new Intent(getBaseContext(), SecondScreen.class);
            startActivity(i);
         }
      });
   }
   /*
   Name: padRight
   Description: used to format strings for first screen
   Parameters: String to be padded, int size to be padded to.
   Returns: String that has been padded.
   */
   public String padRight(String str, int n)
   {
      return String.format("%1$-" + n + "s", str);
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