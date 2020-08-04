package com.example.shopping;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main8Activity extends AppCompatActivity {

    HelperS helper;
    SQLiteDatabase database;
    Intent intent;
    String j;
    Cursor cursor;

    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        t1 = (TextView) findViewById(R.id.imgt1);
        t2 = (TextView) findViewById(R.id.imgt2);
        t3 = (TextView) findViewById(R.id.imgt3);
        t4 = (TextView) findViewById(R.id.imgt4);
        t5 = (TextView) findViewById(R.id.imgt5);
        t6 = (TextView) findViewById(R.id.imgt6);
        t7 = (TextView) findViewById(R.id.imgt7);
        t8 = (TextView) findViewById(R.id.imgt8);
        t9 = (TextView) findViewById(R.id.imgt9);
        t10 = (TextView) findViewById(R.id.imgt10);
        t11 = (TextView) findViewById(R.id.imgt11);
        t12 = (TextView) findViewById(R.id.imgt12);
        t13 = (TextView) findViewById(R.id.imgt13);
        t14 = (TextView) findViewById(R.id.imgt14);
        t15 = (TextView) findViewById(R.id.imgt15);
        t16 = (TextView) findViewById(R.id.imgt16);


        helper = new HelperS(this);
        database = helper.getWritableDatabase();

        cursor = database.rawQuery("SELECT ItemID,Name,Price FROM Jewellery_INFO", null);
        while (cursor.moveToNext()) {
            String s = cursor.getString(0);

            if (s.equals("imgj1")) {
                String na = cursor.getString(1);
                String pr = cursor.getString(2);
                t1.setText(na);
                t2.setText(pr);


            }
            if (s.equals("imgj2")) {
                String na = cursor.getString(1);
                String pr = cursor.getString(2);
                t3.setText(na);
                t4.setText(pr);


            }
            if (s.equals("imgj3")) {
                String na = cursor.getString(1);
                String pr = cursor.getString(2);
                t5.setText(na);
                t6.setText(pr);


            }
            if (s.equals("imgj4")) {
                String na = cursor.getString(1);
                String pr = cursor.getString(2);
                t7.setText(na);
                t8.setText(pr);


            }

            if (s.equals("imgj5")) {
                String na = cursor.getString(1);
                String pr = cursor.getString(2);
                t9.setText(na);
                t10.setText(pr);


            }
            if (s.equals("imgj6")) {
                String na = cursor.getString(1);
                String pr = cursor.getString(2);
                t11.setText(na);
                t12.setText(pr);


            }

            if (s.equals("imgj7")) {
                String na = cursor.getString(1);
                String pr = cursor.getString(2);
                t13.setText(na);
                t14.setText(pr);


            }
            if (s.equals("imgj8")) {
                String na = cursor.getString(1);
                String pr = cursor.getString(2);
                t15.setText(na);
                t16.setText(pr);


            }
        }
        cursor.close();


    }

    public void ftn1(View view) {
        switch (view.getId()) {
            case R.id.imgj1:
                intent = new Intent(getApplicationContext(), Main2Activity.class);
                // j=getResources().getResourceEntryName(view.getId());

                intent.putExtra("id1", "imgj1");
                startActivity(intent);
                break;

            case R.id.imgj2:
                intent = new Intent(getApplicationContext(), Main2Activity.class);
                // j=getResources().getResourceEntryName(view.getId());
                intent.putExtra("id1", "imgj2");
                startActivity(intent);
                break;

            case R.id.imgj3:
                intent = new Intent(getApplicationContext(), Main2Activity.class);
                // j=getResources().getResourceEntryName(view.getId());
                intent.putExtra("id1", "imgj3");
                startActivity(intent);
                break;
            case R.id.imgj4:
                intent = new Intent(getApplicationContext(), Main2Activity.class);
                // j=getResources().getResourceEntryName(view.getId());
                intent.putExtra("id1", "imgj4");
                startActivity(intent);
                break;


            case R.id.imgj5:
                intent = new Intent(getApplicationContext(), Main2Activity.class);
                // j=getResources().getResourceEntryName(view.getId());
                intent.putExtra("id1", "imgj5");
                startActivity(intent);
                break;

            case R.id.imgj6:
                intent = new Intent(getApplicationContext(), Main2Activity.class);
                // j=getResources().getResourceEntryName(view.getId());
                intent.putExtra("id1", "imgj6");
                startActivity(intent);
                break;
            case R.id.imgj7:
                intent = new Intent(getApplicationContext(), Main2Activity.class);
                // j=getResources().getResourceEntryName(view.getId());
                intent.putExtra("id1", "imgj7");
                startActivity(intent);
                break;
            case R.id.imgj8:
                intent = new Intent(getApplicationContext(), Main2Activity.class);
                // j=getResources().getResourceEntryName(view.getId());
                intent.putExtra("id1", "imgj8");
                startActivity(intent);
                break;


        }

    }

}