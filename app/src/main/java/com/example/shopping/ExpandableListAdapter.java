package com.example.shopping;


import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.shopping.ui.Items;
import com.example.shopping.ui.Orderslist;

import java.util.ArrayList;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    Context context = null;
    ArrayList<Orderslist> originalOrdersList;
    ArrayList<Orderslist> ordersList;

    public ExpandableListAdapter(Context context, ArrayList<Orderslist> data) {
        this.context = context;
        this.originalOrdersList = new ArrayList<Orderslist>();
        this.originalOrdersList.addAll(data);

        this.ordersList = new ArrayList<Orderslist>();
        this.ordersList.addAll(data);
    }


    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void onGroupExpanded(int i) {

    }

    @Override
    public void onGroupCollapsed(int i) {

    }

    @Override
    public boolean isEmpty() {
        if (ordersList.size() == 0)
            return true;
        else
            return false;
    }

    @Override
    public int getGroupCount() {
        return ordersList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return ordersList.get(i).getItems().size();
    }

    @Override
    public Orderslist getGroup(int i) {

        return ordersList.get(i);
    }

    @Override
    public Items getChild(int groupPosition, int childPosition) {
        return ordersList.get(groupPosition).getItems().get(childPosition);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
    @Override
    public View getGroupView(int position, boolean b, View contentView, ViewGroup parent) {

        Orderslist orders = ordersList.get(position);
        if (contentView == null) {
            contentView = LayoutInflater.from(context).inflate(R.layout.listoforders, parent, false);
        }

        String name = orders.getName();
        String phone =orders.getPhone();
        String email = orders.getEmail();
        String city = orders.getCity();
        String address = orders.getAddress();
        String date = orders.getDate();
        String subtotal = orders.getSubtotal();
        TextView lblListHeaderName = (TextView) contentView
                .findViewById(R.id.ofullname);
        TextView lblListHeaderCity = (TextView) contentView
                .findViewById(R.id.ocity);
        TextView lblListHeaderPhoneno = (TextView) contentView
                .findViewById(R.id.ophn);
        TextView lblListHeaderEmail = (TextView) contentView
                .findViewById(R.id.omail);
        TextView lblListHeaderAddress = (TextView) contentView
                .findViewById(R.id.oaddress);
        TextView lblListHeaderDate = (TextView) contentView
                .findViewById(R.id.odate);
        TextView lblListHeaderSubtotal = (TextView) contentView
                .findViewById(R.id.osubtotal);
        lblListHeaderName.setText(name);
        lblListHeaderCity.setText(city);
        lblListHeaderPhoneno.setText(phone);
        lblListHeaderEmail.setText(email);
        lblListHeaderAddress.setText(address);
        lblListHeaderDate.setText(date);
        lblListHeaderSubtotal.setText(subtotal);


        return contentView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View contentView, ViewGroup parent) {
        Items items = ordersList.get(groupPosition).getItems().get(childPosition);
        if (contentView == null) {
            contentView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }
        TextView txtListChildname = (TextView) contentView
                .findViewById(R.id.txtname);
        TextView txtListChildtotal = (TextView) contentView
                .findViewById(R.id.txttotal);
        TextView txtListChildprice = (TextView) contentView
                .findViewById(R.id.txtprice);

        txtListChildname.setText(items.getName());
        txtListChildtotal.setText("("+items.getTotal()+")");
        txtListChildprice.setText(items.getPrice());

        return contentView;
    }
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public long getCombinedChildId(long l, long l1) {
        return l1;
    }

    @Override
    public long getCombinedGroupId(long l) {
        return l;
    }



}
