package com.example.auburnhacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputEditText;

public class UserInfo extends AppCompatActivity {

    TextInputEditText userName, emailId, phoneNo, uniName, degree, major, experience;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        userName = (TextInputEditText) findViewById(R.id.userName);
        emailId = (TextInputEditText) findViewById(R.id.userEmail);
        phoneNo = (TextInputEditText) findViewById(R.id.userPhone);
        uniName = (TextInputEditText) findViewById(R.id.userUniversity);
        degree = (TextInputEditText) findViewById(R.id.userDegree);
        major = (TextInputEditText) findViewById(R.id.userMajor);
        experience = (TextInputEditText) findViewById(R.id.userExperience);

        preferences = getApplicationContext().getSharedPreferences("USER_INFO",0);

        userName.setText(preferences.getString("uName",null));
        emailId.setText(preferences.getString("uEmail",null));
        phoneNo.setText(preferences.getString("uPhone",null));
        uniName.setText(preferences.getString("uUni",null));
        degree.setText(preferences.getString("uDegree",null));
        major.setText(preferences.getString("uMajor",null));
        experience.setText(preferences.getString("uExp",null));

    }

    public void saveUserInfo(View view) {
//        Toast toast=Toast. makeText(getApplicationContext(),userName.getText().toString() + " \n" +
//                        emailId.getText().toString() + " \n" +
//                        phoneNo.getText().toString() + " \n" +
//                        uniName.getText().toString() + " \n" +
//                        degree.getText().toString() + " \n" +
//                        major.getText().toString() + " \n" +
//                        experience.getText().toString() + " \n"
//                ,Toast. LENGTH_SHORT);
//        toast. show();
        editor = preferences.edit();
        editor.putString("uName", userName.getText().toString());
        editor.putString("uEmail", emailId.getText().toString());
        editor.putString("uPhone", phoneNo.getText().toString());
        editor.putString("uUni", uniName.getText().toString());
        editor.putString("uDegree", degree.getText().toString());
        editor.putString("uMajor", major.getText().toString());
        editor.putString("uExp", experience.getText().toString());
        editor.apply();
        this.finish();
    }
}
