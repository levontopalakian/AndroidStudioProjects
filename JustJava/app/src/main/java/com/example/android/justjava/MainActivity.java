
package com.example.android.justjava;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 0;

    private String createOrderSummery(int price, boolean haswhippedCream,boolean haschocolate) {
        String priceMessage = "Name : Levon Topalakian";
        priceMessage += "\nAdd Whipped Cream? " + haswhippedCream;
        priceMessage += "\nAdd Chocolate? " + haschocolate;
        priceMessage += "\nQuantity : " + quantity;
        priceMessage += "\nTotal: $" + price + "\nThank You";

        displayMessage(priceMessage);
        return priceMessage;
    }

    public void submitOrder(View view) {
       //Log.v ("MainActivity","Has whipped cream: "+haswhippedCream);
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whippedCream);
        boolean haswhippedCream = whippedCream.isChecked();
        int price = calculatePrice();
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate);
        boolean haschocolate = chocolate.isChecked();
        createOrderSummery(price,haswhippedCream,haschocolate);
    }

    public void increment(View view) {
        quantity++;
        display(quantity);
    }

    public void decrament(View view) {
        quantity--;
        display(quantity);
    }



    private int calculatePrice() {
        int price = quantity * 8;
        return price;

    }


    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}