package com.example.newcarapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

import com.example.newcarapp.Data.DBManager;

public class AddWishActivity extends AppCompatActivity implements OnClickListener {

    private Button addWishBtn;
    private EditText wishEditText;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Add Wish");

        setContentView(R.layout.activity_add_wish);

        wishEditText = findViewById(R.id.wish_editText);
        addWishBtn = findViewById(R.id.add_wish);

        dbManager = new DBManager(this);
        dbManager.open();
        addWishBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.add_wish:

                final String wish = wishEditText.getText().toString();

                dbManager.insert(wish);

                Intent intent = new Intent(AddWishActivity.this,WishListActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

                break;
        }

    }
}
