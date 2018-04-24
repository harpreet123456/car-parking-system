package com.example.macstudent.parkingsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.macstudent.parkingsystem.db.DBUser;
import com.example.macstudent.parkingsystem.model.User;


public class SignUpActivity extends AppCompatActivity {

    private static final String TAG = SignUpActivity.class.getName();


    EditText editname;
    EditText editPwd;
    EditText edtConfirmPassword;

    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editname = (EditText) findViewById(R.id.editname);
        editPwd = (EditText) findViewById(R.id.editpwd);
        edtConfirmPassword = (EditText) findViewById(R.id.editconfirmpwd);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);




        btnSignUp.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                if (validate()) {
                    User user = new User();
                    user.setEmail(editname.getText().toString());
                    user.setPassword(editPwd.getText().toString());

                    DBUser dbUser = new DBUser(SignUpActivity.this);
                    dbUser.insertUser(user);

                    dbUser.getAllUser();
                    finish();
                }
            }

            public boolean validate() {
                if (editPwd.getText().toString().length() != 0) {
                    if (editPwd.getText().toString().equals(edtConfirmPassword.getText().toString())) {
                        return true;
                    } else {
                        edtConfirmPassword.setError("Confirm Password not matched");
                    }
                } else {
                    editPwd.setError("Enter Password");
                }

                return false;

            }

        });
    }
}


