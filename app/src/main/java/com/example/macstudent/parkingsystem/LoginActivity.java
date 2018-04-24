package com.example.macstudent.parkingsystem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.macstudent.parkingsystem.db.DBUser;

public class LoginActivity extends AppCompatActivity {

    EditText editUsername;
    EditText editPassword;
    Button btnlogIn;
    Button btncreate;
    CheckBox ChkRemebrMe;
    SharedPreferences pref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //create shared preferences oject
        pref = getSharedPreferences("pref", MODE_PRIVATE);

        editUsername = (EditText)findViewById(R.id.editUsername);
        //edtUserId.setTooltipText("Please enter User ID");
        editPassword = (EditText)findViewById(R.id.editPassword);
        ChkRemebrMe = (CheckBox)findViewById(R.id.ChkRembrMe);

        //Get saved values from shared preferences
        String uid = pref.getString("userid", null);
        String pwd = pref.getString("password", null);


        //Set values to Edit text
        if (uid != null && pwd != null) {
            editUsername.setText(uid);
            editPassword.setText(pwd);
            ChkRemebrMe.setChecked(true);
        } else {
            ChkRemebrMe.setChecked(false);
        }

        btnlogIn = (Button) findViewById(R.id.btnlogIn);
        btncreate = (Button) findViewById(R.id.btncreate);

        btnlogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editUsername.getText()) || editUsername.getText().toString().length() == 0) {
                    editUsername.setError("Please Enter User Name");
                } else {

                    DBUser dbUser = new DBUser(LoginActivity.this);
                   if(dbUser.isValidUser(editUsername.getText().toString(),editPassword.getText().toString()))
                   {
                        Toast.makeText(LoginActivity.this, "User Successfully logged in ", Toast.LENGTH_LONG).show();

                        //4 - Get editor object
                        SharedPreferences.Editor editor = pref.edit();
                        if (ChkRemebrMe.isChecked())
                        {
                            //5 - Save value to Shared Preferences using editor object
                            editor.putString("userid", editUsername.getText().toString());
                            editor.putString("password", editPassword.getText().toString());
                        } else {
                            //6 - Remove values from shared preferences
                            editor.remove("userid");
                            editor.remove("password");
                        }
                        //7 - Save changes permanently to shared preferences
                        editor.apply();

                        Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                        startActivity(intent);
                    } else {
                        //Intent intent = new Intent(LoginActivity.this, StudentEntryActivity.class);
                        //startActivity(intent);
                        Toast.makeText(LoginActivity.this, "UserID/passwords invalid", Toast.LENGTH_LONG).show();

                    }
                }
            }
        });
        btncreate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {


                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

    }
}



