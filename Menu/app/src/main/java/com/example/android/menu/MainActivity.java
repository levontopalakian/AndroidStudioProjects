package com.example.android.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView l1 = (TextView) findViewById(R.id.menu_item_1);

        // Find second menu item TextView and print the text to the logs
        TextView l2 = (TextView) findViewById(R.id.menu_item_2);
        // Find third menu item TextView and print the text to the logs
        TextView l3 = (TextView) findViewById(R.id.menu_item_3);
        String gl1 =  l1.getText().toString();
        String gl2 = l2.getText().toString();
        String gl3 = l3.getText().toString();

        Log.i("MainActivity",gl1);
        Log.i("MainActivity",gl2);
        Log.i("MainActivity",gl3);
    }
}