package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
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
        displayMessage(createOrderSummary());
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
    public String createOrderSummary(){
        int price = calculatePrice();
        String priceMessage = "Name : Kaptain Kunal\n"+"Quantity :"+quantity+"\nTotal : $"+ price+"\nthank you!";
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

    private int calculatePrice(){
        int price = quantity*5;
        return price;
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);
    }
}