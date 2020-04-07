package com.example.auburnhacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Location extends AppCompatActivity {

    Spinner changeLocSpinner;
    SharedPreferences filters;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        changeLocSpinner = (Spinner)findViewById(R.id.changeLocSpinner);
        filters = getApplicationContext().getSharedPreferences("FILTER",0);

        List<String> cLSpinner = new ArrayList<String>();
        cLSpinner.add("1");
        cLSpinner.add("2");
        cLSpinner.add("3");
        cLSpinner.add("4");
        cLSpinner.add("5");

        ArrayAdapter<String> cLAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cLSpinner);
        cLAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        changeLocSpinner.setAdapter(cLAdapter );

        changeLocSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String zone = parent.getItemAtPosition(position).toString();
                editor = filters.edit();
                editor.putString("zone",zone);
                editor.apply();
//                Toast toast = Toast.makeText(parent.getContext(), "Selected " + zone, Toast.LENGTH_SHORT);
//                toast.show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
