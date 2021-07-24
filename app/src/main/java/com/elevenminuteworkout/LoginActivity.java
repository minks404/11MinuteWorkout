package com.elevenminuteworkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    public static String profile_name = "";
    public static int profile_ID = -1;


    SqliteOpenHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new SqliteOpenHelper(this, null);
        //val dbHandler = (this, null)

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

    }
    public void setName(String name){
        this.profile_name = name;
    }
    public String getName(){
        return profile_name;
    }

    public void onLogin(View view){
        TextView nameView = (TextView)findViewById(R.id.name);
        TextView passView = (TextView)findViewById(R.id.password);

        String name = nameView.getText().toString();
        String password = passView.getText().toString();

        try {
            if (name.equals(""))
                throw new Exception("Please enter a username!");
            if (password.equals(""))
                throw new Exception("Please enter a password!");



            if ( db.login(name, password)) {
                Toast.makeText(this, "Welcome " + name + "!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Invalid Username or Password!", Toast.LENGTH_LONG).show();
            }
        }catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }
    public void onRegister(View view){

        TextView nameView = (TextView)findViewById(R.id.name);
        TextView passView = (TextView)findViewById(R.id.password);

        String name = nameView.getText().toString();
        String password = passView.getText().toString();

        try {
            if (name.equals(""))
                throw new Exception("Please enter a username!");
            if (password.equals(""))
                throw new Exception("Please enter a password!");

            Log.i("MSSG", "DB OP STARTED");

            if( db.addNewProfile(name, password))
                Toast.makeText(this,"Registration Successful!", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "Registration already exists!", Toast.LENGTH_LONG).show();
        }catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    public static void logout() {
        LoginActivity.profile_ID = -1;
        LoginActivity.profile_name = "";
    }


    public static boolean checkUserLoggedIn() {
        if( LoginActivity.profile_ID == -1 || LoginActivity.profile_name == "")
            return false;
        else
            return true;
    }


}