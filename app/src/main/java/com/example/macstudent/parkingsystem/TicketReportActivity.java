package com.example.macstudent.parkingsystem;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.macstudent.parkingsystem.Adapter.TicketAdapter;
import com.example.macstudent.parkingsystem.db.DBAddTcket;
import com.example.macstudent.parkingsystem.model.AddTicket;

import java.util.ArrayList;

public class TicketReportActivity extends AppCompatActivity {
    TicketAdapter ticketAdapter;
    ListView lstTicket;
    ArrayList<AddTicket> TicketList;

    public static void startIntent(Context context) {
        context.startActivity(new Intent(context, TicketReportActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_report);
        lstTicket = (ListView) findViewById(R.id.listview1);

        DBAddTcket dbAddTcket = new DBAddTcket(this);

        TicketList = (ArrayList<AddTicket>) dbAddTcket.getAlltickets();



      //  TicketAdapter ticketAdapter = new TicketAdapter(this);
      //  lstTicket.setAdapter(ticketAdapter);

        lstTicket.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AddTicket a = TicketList.get(i);
            }
        });
    }
}


