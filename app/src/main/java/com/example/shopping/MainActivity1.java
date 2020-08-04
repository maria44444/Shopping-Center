package com.example.shopping;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

public class MainActivity1 extends AppCompatActivity {

    HelperS helper;
    SQLiteDatabase database;
    Intent intent;
    String j;
    Cursor cursor;
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        t1 = (TextView) findViewById(R.id.img1t1);
        t2 = (TextView) findViewById(R.id.img1t2);
        t3 = (TextView) findViewById(R.id.img1t3);
        t4 = (TextView) findViewById(R.id.img1t4);
        t5 = (TextView) findViewById(R.id.img1t5);
        t6 = (TextView) findViewById(R.id.img1t6);
        t7 = (TextView) findViewById(R.id.img1t7);
        t8 = (TextView) findViewById(R.id.img1t8);
        t9 = (TextView) findViewById(R.id.img1t9);
        t10 = (TextView) findViewById(R.id.img1t10);
        t11 = (TextView) findViewById(R.id.img1t11);
        t12 = (TextView) findViewById(R.id.img1t12);
        t13 = (TextView) findViewById(R.id.img1t13);
        t14 = (TextView) findViewById(R.id.img1t14);
        t15 = (TextView) findViewById(R.id.img1t15);
        t16 = (TextView) findViewById(R.id.img1t16);


        helper = new HelperS(this);
        database = helper.getWritableDatabase();

        cursor = database.rawQuery("SELECT ItemID,Name,Price FROM Item_Info", null);
        while (cursor.moveToNext()) {
            String s = cursor.getString(0);

            if (s.equals("img1")) {
                String na = cursor.getString(1);
                String pr = cursor.getString(2);
                t1.setText(na);
                t2.setText(pr);


            }
            if (s.equals("img2")) {
                String na = cursor.getString(1);
                String pr = cursor.getString(2);
                t3.setText(na);
                t4.setText(pr);


            }
            if (s.equals("img3")) {
                String na = cursor.getString(1);
                String pr = cursor.getString(2);
                t5.setText(na);
                t6.setText(pr);


            }
            if (s.equals("img4")) {
                String na = cursor.getString(1);
                String pr = cursor.getString(2);
                t7.setText(na);
                t8.setText(pr);


            }

            if (s.equals("img5")) {
                String na = cursor.getString(1);
                String pr = cursor.getString(2);
                t9.setText(na);
                t10.setText(pr);


            }
            if (s.equals("img6")) {
                String na = cursor.getString(1);
                String pr = cursor.getString(2);
                t11.setText(na);
                t12.setText(pr);


            }

            if (s.equals("img7")) {
                String na = cursor.getString(1);
                String pr = cursor.getString(2);
                t13.setText(na);
                t14.setText(pr);


            }
            if (s.equals("img8")) {
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
            case R.id.img1:
                intent = new Intent(getApplicationContext(), Main2Activity.class);
                // j=getResources().getResourceEntryName(view.getId());

                intent.putExtra("id1", "img1");
                startActivity(intent);
                break;

            case R.id.img2:
                intent = new Intent(getApplicationContext(), Main2Activity.class);
                // j=getResources().getResourceEntryName(view.getId());
                intent.putExtra("id1", "img2");
                startActivity(intent);
                break;

            case R.id.img3:
                intent = new Intent(getApplicationContext(), Main2Activity.class);
                // j=getResources().getResourceEntryName(view.getId());
                intent.putExtra("id1", "img3");
                startActivity(intent);
                break;
            case R.id.img4:
                intent = new Intent(getApplicationContext(), Main2Activity.class);
                // j=getResources().getResourceEntryName(view.getId());
                intent.putExtra("id1", "img4");
                startActivity(intent);
                break;


            case R.id.img5:
                intent = new Intent(getApplicationContext(), Main2Activity.class);
                // String j=getResources().getResourceEntryName(view.getId());
                intent.putExtra("id1", "img5");
                startActivity(intent);
                break;

            case R.id.img6:
                intent = new Intent(getApplicationContext(), Main2Activity.class);
                // j=getResources().getResourceEntryName(view.getId());
                intent.putExtra("id1", "img6");
                startActivity(intent);
                break;
            case R.id.img7:
                intent = new Intent(getApplicationContext(), Main2Activity.class);
                // j=getResources().getResourceEntryName(view.getId());
                intent.putExtra("id1", "img7");
                startActivity(intent);
                break;
            case R.id.img8:
                intent = new Intent(getApplicationContext(), Main2Activity.class);
                //  j=getResources().getResourceEntryName(view.getId());
                intent.putExtra("id1", "img8");
                startActivity(intent);
                break;


        }

    }
    public void FrontMove(View view)
    {
        switch (view.getId())
        {
            case R.id.movecloth:
            {
                Intent intent= new Intent(getApplicationContext(), MainActivity1.class);
                startActivity(intent);
            }
            break;
            case R.id.moveacc:
            {
                Intent intent= new Intent(getApplicationContext(), MainActivity1.class);
                startActivity(intent);
            }
            break;
        }
    }


}




