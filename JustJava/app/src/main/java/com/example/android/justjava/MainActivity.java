/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    private String createOrderSummery (int price){
        String priceMessage = "Name : Levon Topalakian" ;
        priceMessage += "\nQuantity : "+quantity;
        priceMessage += "\nTotal: $"+price+"\nThank You";
        displayMessage(priceMessage);
        return priceMessage;
    }

    public void submitOrder(View view) {
        /** int price = quantity * 5;
         *

         */
        int price = calculatePrice();
        createOrderSummery(price);


    }

    public void increment(View view) {
        quantity++;
        display(quantity);
    }

    public void decrament (View view) {
        quantity--;
        display(quantity);
    }

    /**
     * Calculates the price of the order.
     *
     * @param quantity is the number of cups of coffee ordered
     * @return total price
     */
    @org.jetbrains.annotations.Contract(pure = true)

    private int calculatePrice() {
        int price = quantity * 8;
        return price;

    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}