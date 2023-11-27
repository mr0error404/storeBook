package com.example.newassahgm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spinner ;
    Button plus ,nig,addToCart;
    TextView txtPrice,txtQuantity;
    ImageView imageView;

    int counter =1,price=0,idSpinner=0;

    String [] bookS={
            "KILING",
            "BOOK RED",
            "ALONE",
            "A MILLION"
    };
    int [] priceArray={
        5,3,11,9
    };


    int [] images = {
            R.drawable.book1,
            R.drawable.book2,
            R.drawable.book3,
            R.drawable.book4,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //binding
        spinner=findViewById(R.id.spinner);
        plus=findViewById(R.id.button);
        nig=findViewById(R.id.button2);
        addToCart=findViewById(R.id.button3);
        txtPrice=findViewById(R.id.textView4);
        txtQuantity=findViewById(R.id.textView6);
        imageView=findViewById(R.id.imageView3);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,bookS);
        spinner.setAdapter(arrayAdapter);
        imageView.setImageResource(images[0]);
        txtPrice.setText(String.valueOf(priceArray[0]*counter));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                idSpinner=(int) adapterView.getSelectedItemId();
                imageView.setImageResource(images[idSpinner]);
                txtPrice.setText(String.valueOf(priceArray[idSpinner]*counter));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                txtQuantity.setText(String.valueOf(counter));
                price=priceArray[idSpinner]*counter;
                txtPrice.setText(String.valueOf(price));
            }
        });
        nig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counter >1){
                counter--;
                txtQuantity.setText(String.valueOf(counter
                ));
                price=priceArray[idSpinner]*counter;
                txtPrice.setText(String.valueOf(price));
                }else{
                    counter=1;
                    price=priceArray[idSpinner]*counter;
                    txtPrice.setText(String.valueOf(price));
                }
            }
        });


    }
}