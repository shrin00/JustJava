/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 */

package com.example.justjava;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.justjava.R;

import java.text.NumberFormat;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int numberOfCups = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display(numberOfCups);

        /*TextView textView = new TextView(this);
        textView.setText("Hello MothFuqer!!!! :) :) :) :) :)");
        textView.setTextColor(Color.BLUE);
        textView.setTextSize(30);

        setContentView(textView);*/

        Button order = (Button) findViewById(R.id.order_id);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, orderSummary.class);
                startActivity(i);
            }
        });
    }

    /**
     * This method is called when the order button is clicked.
     */
    @SuppressLint("QueryPermissionsNeeded")
   /* public void submitOrder(View view) {
        //display(numberOfCups);
        //displayPrice(numberOfCups*15);
        //int price = numberOfCups*15;
        //int price = calculatePrice(numberOfCups);
//        String priceMessage = "Total:"+NumberFormat.getCurrencyInstance().format(price)+"\nThank you!";
//        displayMessage(priceMessage);
        CheckBox WippedCream = (CheckBox) findViewById(R.id.wipped_cream);
        boolean hasWippedCream = WippedCream.isChecked();

        CheckBox Chocalate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocalate = Chocalate.isChecked();

        EditText name = (EditText) findViewById(R.id.person_name);
        String personName = name.getText().toString();

        String orderMessage = createOrderSummary(calculatePrice(hasWippedCream, hasChocalate), hasWippedCream, hasChocalate, personName);

//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Just java order for "+personName);
//        intent.putExtra(Intent.EXTRA_TEXT, orderMessage);
//        startActivity(intent);
        //Log.v("mainactivity", "this what it is "+intent.resolveActivity(getPackageManager()));
//        if (intent.resolveActivity(getPackageManager()) == null) {
//            startActivity(intent);
//        }

        //displayMessage(orderMessage);

        Intent i = new Intent(this, orderSummary.class);
        startActivity(i);
    }*/


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */

    public void increment(View view){
        if (numberOfCups == 15){
            Toast.makeText(this, "Sorry, You can't have more than 15 cups", Toast.LENGTH_SHORT).show();
            return;
        }
        numberOfCups++;
        display(numberOfCups);
    }

    public void decrement(View view){

        if (numberOfCups == 1){
            Toast.makeText(this, "Sorry, we can't serve less than 1 cups", Toast.LENGTH_SHORT).show();
            return;
        }
        numberOfCups--;
        display(numberOfCups);
    }

    /**
     * This method displays the given text on the screen.
     */
//    private void displayMessage(String message) {
//        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
//        orderSummaryTextView.setText(message);
//        orderSummaryTextView.setTextSize(18);
//        orderSummaryTextView.setTextColor(Color.DKGRAY);
//    }

    /**
     * calculate the total amount
     * @param
     * @return
     */
    private int calculatePrice(boolean whippedCream, boolean chocalate){
        int basePrice = 5;
        if(whippedCream){
            basePrice += 1;
        }

        if (chocalate){
            basePrice += 3;
        }

        return numberOfCups*basePrice;
    }

    /**
     * order summary method
     * @param addWhippedCream is whipped cream added
     * @param price total price
     */

    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocalate, String personName){
        String orderSummary = "Name: "+personName;
        orderSummary += "\nAdd whipped cream? "+addWhippedCream;
        orderSummary += "\nAdd add Chocolate? "+addChocalate;
        orderSummary += "\nQuantity : "+ numberOfCups;
        orderSummary +=" \nTotal Price : "+NumberFormat.getCurrencyInstance().format(price);
        orderSummary += "\n"+getString(R.string.thank_you)+"!";

        return orderSummary;
        //displayMessage(orderSummary);
    }

}