package com.example.auburnhacks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DisplayJobs extends AppCompatActivity {

    RecyclerView recyclerView1;
    CompaniesAdapter companiesAdapter;
    List<Companies> companyList;

    DatabaseReference databaseReference;
    SharedPreferences filters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_jobs);

        companyList = new ArrayList<>();
        filters = getApplicationContext().getSharedPreferences("FILTER",0);
        //Toast.makeText(getApplicationContext(),"Firebase Success",Toast.LENGTH_SHORT).show();

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                companyList.clear();
                if (dataSnapshot.exists()){
                    for (DataSnapshot s: dataSnapshot.getChildren()){
                        Companies companies = s.getValue(Companies.class);

                        if(!filters.getString("uMajor",null).equals(companies.getMajor())){
                            continue;
                        }

                        if(!filters.getString("zone",null).equals(companies.getSectionId())){
                            continue;
                        }


                        if(!filters.getString("jobType",null).equals("None")){
                            if(!filters.getString("jobType",null).equals(companies.getJobType())){
                                continue;
                            }
                        }

                        if(!filters.getString("jobLoc",null).equals("None")) {
                            if(!filters.getString("jobLoc",null).equals(companies.getLocation())){
                                continue;
                            }
                        }

                        if(!filters.getString("workAuth",null).equals("None")) {
                            if(!filters.getString("workAuth",null).equals(companies.getWorkAuth())){
                                continue;
                            }
                        }

                        else {
                            companyList.add(companies);
                        }

                    }

                    if(companyList.isEmpty()){
                        Toast.makeText(getApplicationContext(),"No Jobs available", Toast.LENGTH_SHORT).show();
                    }
                    companiesAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("m3", "loadPost:onCancelled", databaseError.toException());
            }
        };

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Companies");
        databaseReference.addListenerForSingleValueEvent(valueEventListener);
        //Toast.makeText(getApplicationContext(),"Mello",Toast.LENGTH_SHORT).show();

        companiesAdapter = new CompaniesAdapter(this,companyList);
        recyclerView1 = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setAdapter(companiesAdapter);
    }



}

