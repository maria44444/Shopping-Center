package com.example.shopping;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

class AdapterCheckout extends ArrayAdapter<iteminfolist> {
    Context context;
    // boolean flag=true;

    int layoutrid;
    ArrayList<iteminfolist> items;
    HelperS helper;
    SQLiteDatabase database;

    Cursor cursor;
    iteminfolist it;


    public AdapterCheckout(Context context, int resource, ArrayList<iteminfolist> items) {
        super(context, resource, items);
        this.context = context;
        this.layoutrid = resource;
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        helper = new HelperS(context);
        database = helper.getWritableDatabase();
        Integer image1 = getItem(position).getImg();
        final String name12 = getItem(position).getNam();
        final String[] pr1 = {getItem(position).getPri()};
        final int[] total1 = {getItem(position).getTotal()};
        final String uu1 = getItem(position).getId1();

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(layoutrid, parent, false);


        final ImageView img1 = convertView.findViewById(R.id.chkimg1);
        final TextView tvname1 = convertView.findViewById(R.id.chkname);
        final TextView tvpr1 = convertView.findViewById(R.id.chkpri);
        final TextView tvimg1 = convertView.findViewById(R.id.chkidimg1);
        final TextView tvdig = convertView.findViewById(R.id.digit1);

        img1.setImageResource(image1);
        tvname1.setText(name12);
        //  tvpr1.setText(pr1[0]);
        tvdig.setText(String.valueOf(total1[0]));
        cursor = database.rawQuery("SELECT ItemID,Name,Price,Code,Quantity FROM Item_Info", null);
        while (cursor.moveToNext()) {
            String nid = cursor.getString(0);

            if (nid.equals(uu1)) {

                String []arr1= pr1[0].split("\\.");
                int pp=Integer.parseInt(arr1[1]);
                int pt= pp*total1[0];
                tvpr1.setText(String.valueOf(pt));

                break;
            }
        }
        cursor = database.rawQuery("SELECT ItemID,Name,Price,Code,Quantity FROM Jewellery_INFO", null);
        while (cursor.moveToNext()) {
            String nid = cursor.getString(0);

            if (nid.equals(uu1)) {

                String []arr1= pr1[0].split("\\.");
                int pp=Integer.parseInt(arr1[1]);
                int pt= pp*total1[0];
                tvpr1.setText(String.valueOf(pt));

                break;
            }
        }


        return convertView;
    }
}
