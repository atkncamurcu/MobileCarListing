package com.example.newcarapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetailsActivity extends AppCompatActivity {

    private static final String TAG = "DetailsActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Log.d(TAG,"onCreate: started");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        String serial = extras.getString("Serial");
        String model = extras.getString("Model");
        String year = extras.getString("Year");
        String fuel = extras.getString("Fuel");

        if(extras != null){
            ImageView carImage = (ImageView) findViewById(R.id.detailImage);
            Bitmap bitmap = extras.getParcelable("image");
            carImage.setImageBitmap(bitmap);
        }

        //Image çekilecek


        final TextView serialText = (TextView) findViewById(R.id.detailSerial);
        TextView modelText = (TextView) findViewById(R.id.detailModel);
        TextView yearText = (TextView) findViewById(R.id.detailYear);
        TextView fuelText = (TextView) findViewById(R.id.detailFuel);
        //ImageView carImage = (ImageView) findViewById(R.id.detailImage);





        serialText.setText(serial);
        modelText.setText(model);
        yearText.setText(year);
        fuelText.setText(fuel);
    }

    public void shareIt(View view){
        Button share = (Button) findViewById(R.id.share_button);
        TextView modelText = (TextView) findViewById(R.id.detailModel);
        TextView serialText = (TextView) findViewById(R.id.detailSerial);
        TextView yearText = (TextView) findViewById(R.id.detailYear);
        TextView fuelText = (TextView) findViewById(R.id.detailFuel);

        String model = modelText.getText().toString();
        String serial = serialText.getText().toString();
        String year = yearText.getText().toString();
        String fuel = fuelText.getText().toString();
        String message ="This car is really good. Its model is " + model + " and its serial is " + serial + ". This car made in " + year + " and " + fuel + "-powered";


        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,message);
        startActivity(intent);
    }

}
