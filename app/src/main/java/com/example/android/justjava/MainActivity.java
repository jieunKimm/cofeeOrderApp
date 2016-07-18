package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;



/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {
    int quantity=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCream = (CheckBox) findViewById(R.id.checkBox);
        CheckBox chocolate = (CheckBox) findViewById(R.id.choco_checkBox);
        EditText name = (EditText) findViewById(R.id.nameText);
        String username = name.getText().toString();
        boolean haschoco = chocolate.isChecked();
        boolean haswhipped = whippedCream.isChecked();
        String priceMessage = createOrderSummary(haswhipped, haschoco, username);
        displayMessage(priceMessage);
    }
    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity=quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        quantity=quantity - 1;
        displayQuantity(quantity);
    }


    public String createOrderSummary(boolean whipped, boolean choco, String username){
        int price = calculatePrice(whipped, choco);
        String priceMessage = "Name : " + username;
        priceMessage += "\nAdd whipped cream? " + whipped;
        priceMessage += "\nAdd chocolate? " + choco;
        priceMessage += "\nQuantity : "+ quantity;
        priceMessage += "\nTotal : $"+ price;
        priceMessage += "\nthank you!";

        return priceMessage;
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private int calculatePrice(boolean whipped, boolean choco){
        int price = quantity*5;
        if (choco) {
            price = price+quantity;
        } else {
        }
        if (whipped) {
            price = price+quantity;
        } else {
        }
        return price;
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}