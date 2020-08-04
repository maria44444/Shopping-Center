package com.example.shopping;

import com.example.shopping.ui.Orderslist;

import java.util.Comparator;

public class DateComparator implements Comparator<Orderslist> {

    @Override
    public int compare(Orderslist o1, Orderslist o2) {
        return o1.getID() - o2.getID();
    }
}
