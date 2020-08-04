package com.example.shopping;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.shopping.ui.Orderslist;

import java.util.ArrayList;

public class AdapterOrder extends ArrayAdapter<Orderslist> {


    Context context;
    SQLiteDatabase database;
    Cursor cursor;
    HelperS helper;
    AdapterOrder adapter;
    int resource;
    public ArrayList<Orderslist> orderslists = new ArrayList<Orderslist>();

    public AdapterOrder(@NonNull Context context, int resource, @NonNull ArrayList<Orderslist> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        helper = new HelperS(context);
        database = helper.getWritableDatabase();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        String phone = getItem(position).getPhone();
        String email = getItem(position).getEmail();
        String city = getItem(position).getCity();
        String address = getItem(position).getAddress();
        String date = getItem(position).getDate();

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);


        TextView tvname = convertView.findViewById(R.id.ofullname);
        TextView tvpn = convertView.findViewById(R.id.ophn);
        TextView tvemail = convertView.findViewById(R.id.omail);
        TextView tvcity = convertView.findViewById(R.id.ocity);
        TextView tvaddress = convertView.findViewById(R.id.oaddress);
        TextView tvdate = convertView.findViewById(R.id.odate);


            tvname.setText(name);
            tvpn.setText(phone);
            tvemail.setText(email);
            tvcity.setText(city);
            tvaddress.setText(address);
            tvdate.setText(date);

            return convertView;
        }

}

