package com.example.shopping;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Main9Activity extends AppCompatActivity {
    TextView tt1, tt2, tt3;
    ImageView i1;
    Intent intent;
    HelperS helper;
    SQLiteDatabase database;
    Cursor cursor;
    String na, pr, co,h,qua;
    Button b1,b2,b3,ct;


    int qn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        helper = new HelperS(this);
        database = helper.getWritableDatabase();
        tt1 = (TextView) findViewById(R.id.nam);
        tt2 = (TextView) findViewById(R.id.pr);
        tt3 = (TextView) findViewById(R.id.code);
        i1 = (ImageView) findViewById(R.id.imgg1);
        b1 = (Button) findViewById(R.id.minus);
        b2 = (Button) findViewById(R.id.dig);
        b3 = (Button) findViewById(R.id.plus);
        ct = (Button) findViewById(R.id.cart);


        intent = getIntent();

        h = intent.getStringExtra("id1");
        ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent(view.getContext(), Main3Activity.class);
                in.putExtra("idd", h);
                in.putExtra("tot", b2.getText().toString());
                startActivity(in);


            }

        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f = b2.getText().toString();
                int ff = Integer.parseInt(f);
                if (ff > 1) {
                    b1.setBackgroundColor(getResources().getColor(R.color.white));
                    b1.setTextColor(getResources().getColor(R.color.black));
                    b1.setEnabled(true);
                    int c = ff - 1;
                    String ht = String.valueOf(c);
                    b2.setText(ht);
                }
                if (ff == 1) {
                    b1.setBackgroundColor(getResources().getColor(R.color.black));
                    b1.setTextColor(getResources().getColor(R.color.white));
                    b1.setEnabled(false);
                }
                if (ff <= qn) {
                    b3.setBackgroundColor(getResources().getColor(R.color.white));
                    b3.setTextColor(getResources().getColor(R.color.black));
                    b3.setEnabled(true);
                }

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (h.equals("img1")) {
                    cursor = database.rawQuery("SELECT ItemID,Name,Price,Code,Quantity FROM Jewellery_INFO", null);

                    while (cursor.moveToNext()) {
                        String s = cursor.getString(0);

                        if (s.equals("img1")) {
                            qua = cursor.getString(4);
                            qn = Integer.parseInt(qua);
                            String j = b2.getText().toString();
                            int jj = Integer.parseInt(j);
                            if (qn > jj) {
                                b3.setBackgroundColor(getResources().getColor(R.color.white));
                                b3.setTextColor(getResources().getColor(R.color.black));
                                b3.setEnabled(true);
                                jj = jj + 1;
                                b2.setText(String.valueOf(jj));
                            }
                            if (qn <= jj) {

                                b3.setBackgroundColor(getResources().getColor(R.color.black));
                                b3.setTextColor(getResources().getColor(R.color.white));
                                b3.setEnabled(false);
                            }
                            if (jj > 1) {
                                b1.setBackgroundColor(getResources().getColor(R.color.white));
                                b1.setTextColor(getResources().getColor(R.color.black));
                                b1.setEnabled(true);
                            }


                        }


                    }
                }


                if (h.equals("img2")) {

                    cursor = database.rawQuery("SELECT ItemID,Name,Price,Code,Quantity FROM Jewellery_INFO", null);

                    while (cursor.moveToNext()) {
                        String s = cursor.getString(0);

                        if (s.equals("img2")) {
                            qua = cursor.getString(4);
                            qn = Integer.parseInt(qua);
                            String j = b2.getText().toString();
                            int jj = Integer.parseInt(j);
                            if (qn > jj) {
                                b3.setBackgroundColor(getResources().getColor(R.color.white));
                                b3.setTextColor(getResources().getColor(R.color.black));
                                b3.setEnabled(true);
                                jj = jj + 1;
                                b2.setText(String.valueOf(jj));
                            }
                            if (qn <= jj) {

                                b3.setBackgroundColor(getResources().getColor(R.color.black));
                                b3.setTextColor(getResources().getColor(R.color.white));
                                b3.setEnabled(false);
                            }
                            if (jj > 1) {
                                b1.setBackgroundColor(getResources().getColor(R.color.white));
                                b1.setTextColor(getResources().getColor(R.color.black));
                                b1.setEnabled(true);
                            }


                        }


                    }
                }

                if (h.equals("img3")) {

                    cursor = database.rawQuery("SELECT ItemID,Name,Price,Code,Quantity FROM Jewellery_INFO", null);

                    while (cursor.moveToNext()) {
                        String s = cursor.getString(0);

                        if (s.equals("img3")) {
                            qua = cursor.getString(4);
                            qn = Integer.parseInt(qua);
                            String j = b2.getText().toString();
                            int jj = Integer.parseInt(j);
                            if (qn > jj) {
                                b3.setBackgroundColor(getResources().getColor(R.color.white));
                                b3.setTextColor(getResources().getColor(R.color.black));
                                b3.setEnabled(true);
                                jj = jj + 1;
                                b2.setText(String.valueOf(jj));
                            }
                            if (qn <= jj) {

                                b3.setBackgroundColor(getResources().getColor(R.color.black));
                                b3.setTextColor(getResources().getColor(R.color.white));
                                b3.setEnabled(false);
                            }
                            if (jj > 1) {
                                b1.setBackgroundColor(getResources().getColor(R.color.white));
                                b1.setTextColor(getResources().getColor(R.color.black));
                                b1.setEnabled(true);
                            }


                        }


                    }
                }

                if (h.equals("img4")) {

                    cursor = database.rawQuery("SELECT ItemID,Name,Price,Code,Quantity FROM Jewellery_INFO", null);

                    while (cursor.moveToNext()) {
                        String s = cursor.getString(0);

                        if (s.equals("img4")) {
                            qua = cursor.getString(4);
                            qn = Integer.parseInt(qua);
                            String j = b2.getText().toString();
                            int jj = Integer.parseInt(j);
                            if (qn > jj) {
                                b3.setBackgroundColor(getResources().getColor(R.color.white));
                                b3.setTextColor(getResources().getColor(R.color.black));
                                b3.setEnabled(true);
                                jj = jj + 1;
                                b2.setText(String.valueOf(jj));
                            }
                            if (qn <= jj) {

                                b3.setBackgroundColor(getResources().getColor(R.color.black));
                                b3.setTextColor(getResources().getColor(R.color.white));
                                b3.setEnabled(false);
                            }
                            if (jj > 1) {
                                b1.setBackgroundColor(getResources().getColor(R.color.white));
                                b1.setTextColor(getResources().getColor(R.color.black));
                                b1.setEnabled(true);
                            }


                        }


                    }
                }
                if (h.equals("img5")) {

                    cursor = database.rawQuery("SELECT ItemID,Name,Price,Code,Quantity FROM Jewellery_INFO", null);

                    while (cursor.moveToNext()) {
                        String s = cursor.getString(0);

                        if (s.equals("img5")) {
                            qua = cursor.getString(4);
                            qn = Integer.parseInt(qua);
                            String j = b2.getText().toString();
                            int jj = Integer.parseInt(j);
                            if (qn > jj) {
                                b3.setBackgroundColor(getResources().getColor(R.color.white));
                                b3.setTextColor(getResources().getColor(R.color.black));
                                b3.setEnabled(true);
                                jj = jj + 1;
                                b2.setText(String.valueOf(jj));
                            }
                            if (qn <= jj) {

                                b3.setBackgroundColor(getResources().getColor(R.color.black));
                                b3.setTextColor(getResources().getColor(R.color.white));
                                b3.setEnabled(false);
                            }
                            if (jj > 1) {
                                b1.setBackgroundColor(getResources().getColor(R.color.white));
                                b1.setTextColor(getResources().getColor(R.color.black));
                                b1.setEnabled(true);
                            }


                        }


                    }
                }

                if (h.equals("img6")) {

                    cursor = database.rawQuery("SELECT ItemID,Name,Price,Code,Quantity FROM Jewellery_INFO", null);

                    while (cursor.moveToNext()) {
                        String s = cursor.getString(0);

                        if (s.equals("img6")) {
                            qua = cursor.getString(4);
                            qn = Integer.parseInt(qua);
                            String j = b2.getText().toString();
                            int jj = Integer.parseInt(j);
                            if (qn > jj) {
                                b3.setBackgroundColor(getResources().getColor(R.color.white));
                                b3.setTextColor(getResources().getColor(R.color.black));
                                b3.setEnabled(true);
                                jj = jj + 1;
                                b2.setText(String.valueOf(jj));
                            }
                            if (qn <= jj) {

                                b3.setBackgroundColor(getResources().getColor(R.color.black));
                                b3.setTextColor(getResources().getColor(R.color.white));
                                b3.setEnabled(false);
                            }
                            if (jj > 1) {
                                b1.setBackgroundColor(getResources().getColor(R.color.white));
                                b1.setTextColor(getResources().getColor(R.color.black));
                                b1.setEnabled(true);
                            }


                        }


                    }
                }
                if (h.equals("img7")) {

                    cursor = database.rawQuery("SELECT ItemID,Name,Price,Code,Quantity FROM Jewellery_INFO", null);

                    while (cursor.moveToNext()) {
                        String s = cursor.getString(0);

                        if (s.equals("img7")) {
                            qua = cursor.getString(4);
                            qn = Integer.parseInt(qua);
                            String j = b2.getText().toString();
                            int jj = Integer.parseInt(j);
                            if (qn > jj) {
                                b3.setBackgroundColor(getResources().getColor(R.color.white));
                                b3.setTextColor(getResources().getColor(R.color.black));
                                b3.setEnabled(true);
                                jj = jj + 1;
                                b2.setText(String.valueOf(jj));
                            }
                            if (qn <= jj) {

                                b3.setBackgroundColor(getResources().getColor(R.color.black));
                                b3.setTextColor(getResources().getColor(R.color.white));
                                b3.setEnabled(false);
                            }
                            if (jj > 1) {
                                b1.setBackgroundColor(getResources().getColor(R.color.white));
                                b1.setTextColor(getResources().getColor(R.color.black));
                                b1.setEnabled(true);
                            }


                        }


                    }
                }
                if (h.equals("img8")) {

                    cursor = database.rawQuery("SELECT ItemID,Name,Price,Code,Quantity FROM Jewellery_INFO", null);

                    while (cursor.moveToNext()) {
                        String s = cursor.getString(0);

                        if (s.equals("img8")) {
                            qua = cursor.getString(4);
                            qn = Integer.parseInt(qua);
                            String j = b2.getText().toString();
                            int jj = Integer.parseInt(j);
                            if (qn > jj) {
                                b3.setBackgroundColor(getResources().getColor(R.color.white));
                                b3.setTextColor(getResources().getColor(R.color.black));
                                b3.setEnabled(true);
                                jj = jj + 1;
                                b2.setText(String.valueOf(jj));
                            }
                            if (qn <= jj) {

                                b3.setBackgroundColor(getResources().getColor(R.color.black));
                                b3.setTextColor(getResources().getColor(R.color.white));
                                b3.setEnabled(false);
                            }
                            if (jj > 1) {
                                b1.setBackgroundColor(getResources().getColor(R.color.white));
                                b1.setTextColor(getResources().getColor(R.color.black));
                                b1.setEnabled(true);
                            }


                        }


                    }
                }


            }


        });

        if (h.equals("img1")) {
            i1.setImageResource(R.drawable.jimg1);
            cursor = database.rawQuery("SELECT ItemID,Name,Price,Code FROM Jewellery_INFO", null);
            while (cursor.moveToNext()) {
                String s = cursor.getString(0);

                if (s.equals("img1")) {
                    na = cursor.getString(1);
                    pr = cursor.getString(2);
                    co = cursor.getString(3);
                    tt1.setText(na);
                    tt2.setText(pr);
                    tt3.setText(co);
                    break;


                }


            }
            cursor.close();
        } else if (h.equals("img2")) {
            i1.setImageResource(R.drawable.jimg2);
            cursor = database.rawQuery("SELECT ItemID,Name,Price,Code FROM Jewellery_INFO", null);
            while (cursor.moveToNext()) {
                String s = cursor.getString(0);


                if (s.equals("img2")) {
                    na = cursor.getString(1);
                    pr = cursor.getString(2);
                    co = cursor.getString(3);
                    tt1.setText(na);
                    tt2.setText(pr);
                    tt3.setText(co);
                    break;


                }


            }
            cursor.close();
        } else if (h.equals("img3")) {
            i1.setImageResource(R.drawable.jimg3);
            cursor = database.rawQuery("SELECT ItemID,Name,Price,Code FROM Jewellery_INFO", null);
            while (cursor.moveToNext()) {
                String s = cursor.getString(0);


                if (s.equals("img3")) {
                    na = cursor.getString(1);
                    pr = cursor.getString(2);
                    co = cursor.getString(3);
                    tt1.setText(na);
                    tt2.setText(pr);
                    tt3.setText(co);
                    break;


                }


            }
            cursor.close();
        } else if (h.equals("img4")) {
            i1.setImageResource(R.drawable.jimg4);
            cursor = database.rawQuery("SELECT ItemID,Name,Price,Code FROM Jewellery_INFO", null);
            while (cursor.moveToNext()) {
                String s = cursor.getString(0);


                if (s.equals("img4")) {
                    na = cursor.getString(1);
                    pr = cursor.getString(2);
                    co = cursor.getString(3);
                    tt1.setText(na);
                    tt2.setText(pr);
                    tt3.setText(co);
                    break;


                }


            }
            cursor.close();
        } else if (h.equals("img5")) {
            i1.setImageResource(R.drawable.jimg5);
            cursor = database.rawQuery("SELECT ItemID,Name,Price,Code FROM Jewellery_INFO", null);
            while (cursor.moveToNext()) {
                String s = cursor.getString(0);


                if (s.equals("img5")) {
                    na = cursor.getString(1);
                    pr = cursor.getString(2);
                    co = cursor.getString(3);
                    tt1.setText(na);
                    tt2.setText(pr);
                    tt3.setText(co);
                    break;


                }


            }
            cursor.close();
        } else if (h.equals("img6")) {
            i1.setImageResource(R.drawable.jmg6);
            cursor = database.rawQuery("SELECT ItemID,Name,Price,Code FROM Jewellery_INFO", null);
            while (cursor.moveToNext()) {
                String s = cursor.getString(0);


                if (s.equals("img6")) {
                    na = cursor.getString(1);
                    pr = cursor.getString(2);
                    co = cursor.getString(3);
                    tt1.setText(na);
                    tt2.setText(pr);
                    tt3.setText(co);
                    break;


                }


            }
            cursor.close();
        } else if (h.equals("img7")) {
            i1.setImageResource(R.drawable.jimg7);
            cursor = database.rawQuery("SELECT ItemID,Name,Price,Code FROM Jewellery_INFO", null);
            while (cursor.moveToNext()) {
                String s = cursor.getString(0);


                if (s.equals("img7")) {
                    na = cursor.getString(1);
                    pr = cursor.getString(2);
                    co = cursor.getString(3);
                    tt1.setText(na);
                    tt2.setText(pr);
                    tt3.setText(co);
                    break;


                }


            }
            cursor.close();
        } else if (h.equals("img8")) {
            i1.setImageResource(R.drawable.jimg8);
            cursor = database.rawQuery("SELECT ItemID,Name,Price,Code FROM Jewellery_INFO", null);
            while (cursor.moveToNext()) {
                String s = cursor.getString(0);


                if (s.equals("img8")) {
                    na = cursor.getString(1);
                    pr = cursor.getString(2);
                    co = cursor.getString(3);
                    tt1.setText(na);
                    tt2.setText(pr);
                    tt3.setText(co);
                    break;


                }


            }
            cursor.close();
        }


    }


}


