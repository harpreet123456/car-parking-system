package com.example.macstudent.parkingsystem.model;

import java.io.Serializable;

/**
 * Created by macstudent on 2018-04-19.
 */

public class AddTicket implements Serializable {
    private String Vehicleno;
    private  String Vehiclebrand;
    private String amount;
    private String Spinlane;
    private String Spinparking;
    private String Spincolor;
    private String Spinpayment;


    public AddTicket() {
    }

    public AddTicket(String vehicleno, String vehiclebrand, String amount, String spinlane, String spinparking, String spincolor, String spinpayment) {
        this.Vehicleno = vehicleno;
        this.Vehiclebrand = vehiclebrand;
        this.amount = amount;
        this.Spinlane = spinlane;
        this.Spinparking = spinparking;
        this.Spincolor = spincolor;
        this.Spinpayment = spinpayment;
    }

    public String getVehicleno() {
        return Vehicleno;
    }

    public void setVehicleno(String vehicleno) {
        this.Vehicleno = vehicleno;
    }

    public String getVehiclebrand() {
        return Vehiclebrand;
    }

    public void setVehiclebrand(String vehiclebrand) {
        this.Vehiclebrand = vehiclebrand;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSpinlane() {
        return Spinlane;
    }

    public void setSpinlane(String spinlane) {
        this.Spinlane = spinlane;
    }

    public String getSpinparking() {
        return Spinparking;
    }

    public void setSpinparking(String spinparking) {
        this.Spinparking = spinparking;
    }

    public String getSpincolor() {
        return Spincolor;
    }

    public void setSpincolor(String spincolor) {
        this.Spincolor = spincolor;
    }

    public String getSpinpayment() {
        return Spinpayment;
    }

    public void setSpinpayment(String spinpayment) {
        this.Spinpayment = spinpayment;
    }

    @Override
    public String toString() {
        return "AddTicket{" +
                "Vehicleno='" + Vehicleno + '\'' +
                ", Vehiclebrand='" + Vehiclebrand + '\'' +
                ", amount='" + amount + '\'' +
                ", Spinlane='" + Spinlane + '\'' +
                ", Spinparking='" + Spinparking + '\'' +
                ", Spincolor='" + Spincolor + '\'' +
                ", Spinpayment='" + Spinpayment + '\'' +
                '}';
    }
}


