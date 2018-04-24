package com.example.macstudent.parkingsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.macstudent.parkingsystem.db.DBAddTcket;
import com.example.macstudent.parkingsystem.db.DBhelper;
import com.example.macstudent.parkingsystem.model.AddTicket;
import com.example.macstudent.parkingsystem.model.User;

import java.util.List;

public class AddTicketActivity extends AppCompatActivity {
    EditText edtVehicleno;
    EditText edtVehiclebrand;
    Spinner Spincolor;
    RadioButton rbt1;
    RadioButton rbt2;
    RadioButton rbt3;
    RadioButton rbt4;
    RadioButton rbt5;
    Spinner Spinlane;
    Spinner Spinparking;
    Spinner Spinpayment;
    ImageButton imgbtnSave;
    RadioGroup rgtimings;
    RadioButton time;
    TextView amount;
    String color;
    int amt[]={5,10,15,20,25};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ticket);
        AddTicket addTicket=new AddTicket();



        edtVehicleno = (EditText) findViewById(R.id.edtVehicleno);
        edtVehiclebrand = (EditText) findViewById(R.id.edtVehiclebrand);
        Spincolor = (Spinner) findViewById(R.id.Spincolor);


        rbt1 = (RadioButton) findViewById(R.id.rbt1);
        rbt2 = (RadioButton) findViewById(R.id.rbt2);
        rbt3 = (RadioButton) findViewById(R.id.rbt3);
        rbt4 = (RadioButton) findViewById(R.id.rbt4);
        rbt5 = (RadioButton) findViewById(R.id.rbt5);
        Spinlane = (Spinner) findViewById(R.id.Spinlane);
        Spinparking = (Spinner) findViewById(R.id.Spinparking);
        Spinpayment = (Spinner) findViewById(R.id.Spinpayment);
        imgbtnSave = (ImageButton) findViewById(R.id.imgbtnSave);
        rgtimings = (RadioGroup) findViewById(R.id.rgtimings);
        amount = (TextView) findViewById(R.id.textamount);

        int rgs = rgtimings.getCheckedRadioButtonId();
        final RadioButton radioButton = (RadioButton) rgtimings.findViewById(rgs);

        rgtimings.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbt1:
                        amount.setText("$10");
                        break;
                    case R.id.rbt2:
                        amount.setText("$20");
                        break;
                    case R.id.rbt3:
                        amount.setText("$30");
                        break;
                    case R.id.rbt4:
                        amount.setText("$80");
                        break;
                    case R.id.rbt5:
                        amount.setText("100");
                }
            }
        });


        imgbtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AddTicket addTicket1 = new AddTicket();
                addTicket1.setVehicleno(edtVehicleno.getText().toString());
                addTicket1.setVehiclebrand(edtVehiclebrand.getText().toString());
                addTicket1.setSpincolor(Spincolor.getSelectedItem().toString());
                addTicket1.setSpinlane(Spinlane.getSelectedItem().toString());
                addTicket1.setSpinparking(Spinparking.getSelectedItem().toString());
                addTicket1.setSpinpayment(Spinpayment.getSelectedItem().toString());

                loadSpinnerData();
                DBAddTcket dbAddTcket = new DBAddTcket(AddTicketActivity.this);
                dbAddTcket.insertticket(addTicket1);
                dbAddTcket.getAlltickets();
                //dbAddTcket.get();


                Intent in = new Intent(AddTicketActivity.this, HomeActivity.class);
                startActivity(in);

            }
        });
    }
    private void loadSpinnerData() {
        // database handler
        DBhelper db = new DBhelper(getApplicationContext());
        // Spinner Drop down elements
        List<String> lables = db.getAllLabels();


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,lables);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
    }
}




