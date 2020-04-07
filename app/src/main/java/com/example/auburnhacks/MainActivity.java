package com.example.auburnhacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.google.firebase.database.*;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getApplicationContext().getSharedPreferences("USER_INFO",0);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Toast.makeText(this,preferences.getString("uName", null),Toast.LENGTH_SHORT).show();
    }

    public void editUserInfo(View view) {
        Intent intent = new Intent(MainActivity.this, UserInfo.class);
        startActivity(intent);
    }

    public void openFilters(View view) {
        Intent intent = new Intent(MainActivity.this, Filters.class);
        startActivity(intent);
    }

    public void changeLocation(View view) {
        Intent intent = new Intent(MainActivity.this, Location.class);
        startActivity(intent);
    }
}
