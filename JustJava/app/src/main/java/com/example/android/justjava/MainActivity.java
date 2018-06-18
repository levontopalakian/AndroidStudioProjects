
package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 1;

    private String createOrderSummery(int price, boolean haswhippedCream,boolean haschocolate,String customerName)  {
        String priceMessage = "Name : "+customerName;
        priceMessage += "\nAdd Whipped Cream? " + haswhippedCream;
        priceMessage += "\nAdd Chocolate? " + haschocolate;
        priceMessage += "\nQuantity : " + quantity;
        priceMessage += "\nTotal: $" + price + "\nThank You";
        displayMessage(priceMessage);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:info@halftone-sy.com.com"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order of "+customerName);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        return priceMessage;
    }


    public void submitOrder(View view) {
       //Log.v ("MainActivity","Has whipped cream: "+haswhippedCream);
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whippedCream);
        boolean haswhippedCream = whippedCream.isChecked();
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate);
        boolean haschocolate = chocolate.isChecked();
        int price = calculatePrice(haswhippedCream,haschocolate);
        EditText customername = (EditText) findViewById(R.id.nameinput);
        String customerName = customername.getText().toString();
        createOrderSummery(price,haswhippedCream,haschocolate,customerName);
    }

    public void increment(View view) {
        if (quantity == 100){
            Toast.makeText(this,"This is the maximum quantity",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity++;

        display(quantity);
    }

    public void decrament(View view) {
        if (quantity == 1){
             Toast.makeText(this,"This is the minimum quantity",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity--;

        display(quantity);
    }



    private int calculatePrice(boolean haswhippedCream,boolean haschocolate) {
        int addional = 0;
        int coffe = 5;
        if (haswhippedCream){
            addional = addional+1;
        }
        if (haschocolate) {
            addional = addional + 2;
        }
        int price = (coffe+addional)*quantity;
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