package com.example.newcarapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newcarapp.Data.DBManager;

public class ModifyWishActivity extends AppCompatActivity implements OnClickListener {

    private EditText wishText;
    private Button deleteWish, updateWish;

    private long _id;

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Modify Wish");

        setContentView(R.layout.activity_modify_wish);

        dbManager = new DBManager(this);
        dbManager.open();

        wishText = (EditText) findViewById(R.id.description_edittext);
        updateWish = (Button) findViewById(R.id.btn_update);
        deleteWish = (Button) findViewById(R.id.btn_delete);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String wish = intent.getStringExtra("wish");

        _id = Long.parseLong(id);

        //wishText.setText(wish);

        updateWish.setOnClickListener(this);
        deleteWish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn_update:
                String wish = wishText.getText().toString();

                dbManager.update(_id,wish);
                Intent intent = new Intent(getApplicationContext(),WishListActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

                break;

            case R.id.btn_delete:
                dbManager.delete(_id);
                Intent intent2 = new Intent(getApplicationContext(),WishListActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent2);

                break;

        }
    }
}
