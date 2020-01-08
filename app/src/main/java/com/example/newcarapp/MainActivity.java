package com.example.newcarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    final String EMAIL = "atkncamurcu@gmail.com";
    final String PASSWORD = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onResume() {
        super.onResume();
        EditText emailText = (EditText) findViewById(R.id.emailText);
        EditText passwordText = (EditText) findViewById(R.id.passwordText);
        emailText.setText("");
        passwordText.setText("");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }

    public void login(View view){
        EditText emailText = (EditText) findViewById(R.id.emailText);
        String userEmail = emailText.getText().toString();

        EditText passwordText = (EditText) findViewById(R.id.passwordText);
        String userPassword = passwordText.getText().toString();

        if(authenticator(userEmail,userPassword)){
            Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
            startActivity(intent);
        }


    }


    public boolean authenticator(String userEmail, String userPassword){

        if(TextUtils.isEmpty(userEmail) || TextUtils.isEmpty(userPassword)){
            Log.d("TAG","Email or Password is empty or null");
            return false;
        }

        if(EMAIL.equals(userEmail) && PASSWORD.equals(userPassword))
            return true;

        return false;
    }
}
