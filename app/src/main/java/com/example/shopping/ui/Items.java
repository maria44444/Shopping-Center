package com.example.shopping.ui;

public class Items {

    String name;
    String total;
    String price;

    public Items()
    {
    }

    public Items(String n,String t,String p)
    {
        name=n;
        total=t;
        price=p;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}