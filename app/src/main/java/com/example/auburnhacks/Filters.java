package com.example.auburnhacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class Filters extends AppCompatActivity {

    Spinner jobSpinner;
    Spinner locSpinner;
    Spinner workSpinner;
    TextView majorF;

    SharedPreferences preferences;
    SharedPreferences filters;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filters);

        preferences = getApplicationContext().getSharedPreferences("USER_INFO",0);
        filters = getApplicationContext().getSharedPreferences("FILTER",0);

        jobSpinner = (Spinner) findViewById(R.id.jobTypeSpinner);
        locSpinner = (Spinner) findViewById(R.id.locationSpinner);
        workSpinner = (Spinner) findViewById(R.id.workAuthSpinner);
        majorF = (TextView) findViewById(R.id.majorFilter);

        majorF.setText(preferences.getString("uMajor",null));
        editor = filters.edit();
        editor.putString("uMajor",preferences.getString("uMajor",null));
        editor.apply();

        List<String> jobTypeCat = new ArrayList<String>();
        jobTypeCat.add("None");
        jobTypeCat.add("Full-time");
        jobTypeCat.add("Part-time");
        jobTypeCat.add("Co-op");
        jobTypeCat.add("Internship");

        ArrayAdapter<String> jobDataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, jobTypeCat);
        jobDataAdapter .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jobSpinner.setAdapter(jobDataAdapter );

        jobSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String jobType = parent.getItemAtPosition(position).toString();
                editor = filters.edit();
                editor.putString("jobType",jobType);
                editor.apply();
//                Toast toast = Toast.makeText(parent.getContext(), "Selected " + jobType, Toast.LENGTH_SHORT);
//                toast.show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        List<String> jobLocCat = new ArrayList<String>();
        jobLocCat.add("None");
        jobLocCat.add("Georgia");
        jobLocCat.add("New York");
        jobLocCat.add("California");
        jobLocCat.add("Texas");
        jobLocCat.add("North Carolina");

        ArrayAdapter<String> locDataAdapter  = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, jobLocCat);
        locDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locSpinner.setAdapter(locDataAdapter);

        locSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String jobLoc = parent.getItemAtPosition(position).toString();
                editor = filters.edit();
                editor.putString("jobLoc",jobLoc);
                editor.apply();
//                Toast toast = Toast.makeText(parent.getContext(), "Selected " + jobLoc, Toast.LENGTH_SHORT);
//                toast.show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        List<String> workAuth = new ArrayList<String>();
        workAuth.add("None");
        workAuth.add("Provides Sponsorship");
        workAuth.add("OPT/CPT");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, workAuth);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        workSpinner.setAdapter(dataAdapter);

        workSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String workAuth = parent.getItemAtPosition(position).toString();
                editor = filters.edit();
                editor.putString("workAuth",workAuth);
                editor.apply();
//                Toast toast = Toast.makeText(parent.getContext(), "Selected " + workAuth, Toast.LENGTH_SHORT);
//                toast.show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void showFilteredJobs(View view) {
//        Toast toast = Toast.makeText(getApplicationContext(), "Query: " + "\n" +
//                preferences.getString("uMajor",null) + "\n" +
//                filters.getString("jobType",null) + "\n" +
//                filters.getString("jobLoc",null) + "\n" +
//                filters.getString("workAuth",null) + "\n"
//                , Toast.LENGTH_SHORT);
//        toast.show();

        Intent intent = new Intent(Filters.this, DisplayJobs.class);
        startActivity(intent);
    }
}
