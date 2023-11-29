package com.example.newassahgm;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView txt1,txt2,txt3;
    ImageView img;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt1=findViewById(R.id.textView7);
        txt2=findViewById(R.id.textView9);
        txt3=findViewById(R.id.textView10);
        img=findViewById(R.id.imageView4);

        Bundle bundle=getIntent().getExtras();

        String book=bundle.getString("Book");
        String quantity=bundle.getString("Quantity");
        String total=bundle.getString("Total");
        int imgInt = bundle.getInt("ImageRes");

        txt1.setText("Book : " +book);
        txt2.setText("Quantity : "+quantity);
        txt3.setText("Total : "+total +" JOD");
        img.setImageResource(imgInt);

    }
}