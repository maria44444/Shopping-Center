package com.example.shopping.ui;

import java.util.ArrayList;

public class Orderslist
{
    String name;
    String city;
    String phone;
    String email;
    String address;
    String date;
    String Subtotal;
    int ID;
    private ArrayList<Items> items = null;

    public Orderslist(int i,String n,String c,String p,String m,String a,String d,String s)
    {
        ID=i;
        name=n;
        city=c;
        phone=p;
        email=m;
        address=a;
        date=d;
        Subtotal=s;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public int getID()
    {
        return ID;
    }


    public String  getID1()
    {
        return String.valueOf(ID);
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Items> getItems() {
        return items;
    }


    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }

    public String getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(String Subtotal) {
        this.Subtotal = Subtotal;
    }
}