package com.example.newcarapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.newcarapp.Data.DBManager;
import com.example.newcarapp.Data.DatabaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class WishListActivity extends AppCompatActivity {

    private DBManager dbManager;
    private ListView wishList;
    private SimpleCursorAdapter adapter;

    final String[] from = new String[] { DatabaseHelper._ID, DatabaseHelper.WISH};
    final int[] to =  new int[] { R.id.id, R.id.wish};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add_wish = new Intent(getApplicationContext(),AddWishActivity.class);
                startActivity(add_wish);
            }
        });

        dbManager = new DBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();


        wishList = findViewById(R.id.wish_list);
        wishList.setEmptyView(findViewById(R.id.empty));

        adapter = new SimpleCursorAdapter(this,R.layout.activity_view_record,cursor,from,to,0);
        adapter.notifyDataSetChanged();

        wishList.setAdapter(adapter);


        wishList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewId) {
                TextView idTextView  = (TextView) view.findViewById(R.id.id);
                TextView wishTextView = (TextView) view.findViewById(R.id.wish);

                String id = idTextView.getText().toString();
                String wish = wishTextView.getText().toString();

                Intent modify_intent = new Intent(getApplicationContext(),ModifyWishActivity.class);
                modify_intent.putExtra("id",id);
                modify_intent.putExtra("wish",wish);

                startActivity(modify_intent);
            }
        });
    }
}
