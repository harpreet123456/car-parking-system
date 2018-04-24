package com.example.macstudent.parkingsystem.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.macstudent.parkingsystem.R;
import com.example.macstudent.parkingsystem.model.AddTicket;

import java.util.ArrayList;

/**
 * Created by macstudent on 2018-04-23.
 */

public class TicketAdapter extends ArrayAdapter<AddTicket> {

    public TicketAdapter(Context context, ArrayList<AddTicket> TicketArrayList)
    {
        super(context, 0, TicketArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // Get the data item for this position
        AddTicket addTicket = getItem(position);
        ViewHolder viewHolder;

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_ticket_report, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }


        else
        {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        // Populate the data into the template view using the data object
        viewHolder.edtVehicleno.setText(String.valueOf(addTicket.getVehicleno()));
        viewHolder.edtVehiclebrand.setText(String.valueOf(addTicket.getVehiclebrand()));
        //  viewHolder.etdate.setText(String.valueOf(ad.getEtdate()));

        viewHolder.Spincolor.setText(String.valueOf(addTicket.getSpincolor()));
        viewHolder.Spinparking.setText(String.valueOf(addTicket.getSpinlane()));
        viewHolder.Spinparkinglane.setText(String.valueOf(addTicket.getSpinparking()));
        viewHolder.amount.setText(String.valueOf(addTicket.getAmount()));

        viewHolder.Spinpayment.setText(String.valueOf(addTicket.getSpinpayment()));


        return convertView;
    }

    private class ViewHolder
    {
        TextView edtVehicleno;
        TextView edtVehiclebrand;
        TextView Spincolor;
        TextView amount;
        TextView Spinparking;
        TextView Spinparkinglane;
        TextView rgtimings;
        TextView Spinpayment;


        ViewHolder(View convertView)
        {
            edtVehicleno = (TextView) convertView.findViewById(R.id.edtVehicleno);
            edtVehiclebrand= (TextView) convertView.findViewById(R.id.edtVehiclebrand);
            Spincolor=(TextView) convertView.findViewById(R.id.Spincolor);
            amount = (TextView) convertView.findViewById(R.id.textamount);
            Spinparking = (TextView) convertView.findViewById(R.id.Spinparking);
            Spinparkinglane = (TextView) convertView.findViewById(R.id.Spinlane);
            rgtimings= (TextView) convertView.findViewById(R.id.rgtimings);
            Spinpayment = (TextView) convertView.findViewById(R.id.Spinpayment);
        }
    }
}

