package com.example.shopping;


import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Main10Activity extends AppCompatActivity {

    HelperS helper;
    SQLiteDatabase database;
    Cursor cursor;
    String name1, price1, qn, id, qua;
    JewAdapterClass adapterClass;
    jewinfolist obj;
    int qn1, t, ch, qnd;
    ListView ls;
    static ArrayList<jewinfolist> itemInfoList;

    boolean flag=true;
    TextView ty1;
    static int subtotal=0;
    int prc;
    Button mm1,mm2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        helper = new HelperS(this);
        database = helper.getWritableDatabase();
        mm1=(Button) findViewById(R.id.conshp);
        mm2=(Button) findViewById(R.id.chkout);
        mm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        mm2.setOnClickListener(new View.OnClickListener() {                    //Checkout
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(view.getContext(),Main11Activity.class);
                intent.putExtra("arraylist1",itemInfoList);
                startActivity(intent);

            }
        });
        ty1=(TextView)findViewById(R.id.rps);

        ls = (ListView) findViewById(R.id.listid);
        load();
        // load1();
        /*
      for(int i=0 ; i<itemInfoList.size(); i++)
      {
          itemInfoList.remove(i);
      }
*/



        Intent intent = getIntent();
        id = intent.getStringExtra("idd");
        qn = intent.getStringExtra("tot");
        qn1 = Integer.parseInt(qn);


        cursor = database.rawQuery("SELECT ItemID,Name,Price,Code,Quantity FROM Jewellery_INFO", null);
        while (cursor.moveToNext()) {
            String s = cursor.getString(0);

            if (s.equals(id) && s.equals("img1")) {
                name1 = cursor.getString(1);
                price1 = cursor.getString(2);
                qua = cursor.getString(4);
                qnd = Integer.parseInt(qua);


                for (int i = 0; i < itemInfoList.size(); i++) {
                    if (itemInfoList.get(i).getId1() == null) {

                        flag = false;


                        obj = new jewinfolist(R.drawable.jimg1, name1, price1, qn1, s);
                        itemInfoList.add(obj);
                        break;
                    } else {
                        if (itemInfoList.get(i).getId1().equals(s)) {

                            flag = false;
                            t = itemInfoList.get(i).getTotal();
                            ch = t + qn1;

                            if (ch <= qnd) {



                                itemInfoList.get(i).setTotal(ch);

                            }

                            break;
                        }
                    }
                }
                if (flag == true) {
                    obj = new jewinfolist(R.drawable.jimg1, name1, price1, qn1, s);
                    itemInfoList.add(obj);

                }
            }

            if (s.equals(id) && s.equals("img2")) {
                name1 = cursor.getString(1);
                price1 = cursor.getString(2);
                qua = cursor.getString(4);
                qnd = Integer.parseInt(qua);

                for (int i = 0; i < itemInfoList.size(); i++) {
                    if (itemInfoList.get(i).getId1() == null) {
                        flag = false;

                        obj = new jewinfolist(R.drawable.jimg2, name1, price1, qn1, s);
                        itemInfoList.add(obj);
                    } else {
                        if (itemInfoList.get(i).getId1().equals(s)) {
                            flag = false;
                            t = itemInfoList.get(i).getTotal();
                            ch = t + qn1;

                            if (ch <= qnd) {


                                itemInfoList.get(i).setTotal(ch);
                            }

                            break;
                        }
                    }
                }
                if (flag == true) {
                    obj = new jewinfolist(R.drawable.jimg2, name1, price1, qn1, s);
                    itemInfoList.add(obj);

                }

            }

            if (s.equals(id) && s.equals("img3")) {
                name1 = cursor.getString(1);
                price1 = cursor.getString(2);

                qua = cursor.getString(4);
                qnd = Integer.parseInt(qua);

                for (int i = 0; i < itemInfoList.size(); i++) {

                    if (itemInfoList.get(i).getId1() == null) {
                        flag=false;

                        obj = new jewinfolist(R.drawable.jimg3, name1, price1, qn1, s);
                        itemInfoList.add(obj);
                    } else {


                        if (itemInfoList.get(i).getId1().equals(s)) {
                            flag = false;
                            t = itemInfoList.get(i).getTotal();
                            ch = t + qn1;

                            if (ch <= qnd) {


                                itemInfoList.get(i).setTotal(ch);
                            }

                            break;
                        }
                    }
                }
                if(flag==true)
                {
                    obj = new jewinfolist(R.drawable.jimg3, name1, price1, qn1,s);
                    itemInfoList.add(obj);

                }

            }
            if (s.equals(id) && s.equals("img4")) {
                name1 = cursor.getString(1);
                price1 = cursor.getString(2);

                qua = cursor.getString(4);
                qnd = Integer.parseInt(qua);

                for (int i = 0; i < itemInfoList.size(); i++) {

                    if (itemInfoList.get(i).getId1() == null) {
                        flag=false;


                        obj = new jewinfolist(R.drawable.jimg4, name1, price1, qn1, s);
                        itemInfoList.add(obj);
                    } else {

                        if (itemInfoList.get(i).getId1().equals(s)) {
                            flag = false;
                            t = itemInfoList.get(i).getTotal();
                            ch = t + qn1;

                            if (ch <= qnd) {

                                itemInfoList.get(i).setTotal(ch);
                            }

                            break;
                        }
                    }
                }
                if(flag==true)
                {
                    obj = new jewinfolist(R.drawable.jimg4, name1, price1, qn1,s);
                    itemInfoList.add(obj);

                }




            }
            if (s.equals(id) && s.equals("img5")) {
                name1 = cursor.getString(1);
                price1 = cursor.getString(2);

                qua = cursor.getString(4);
                qnd = Integer.parseInt(qua);

                for (int i = 0; i < itemInfoList.size(); i++) {
                    if (itemInfoList.get(i).getId1() == null) {
                        flag=false;

                        obj = new jewinfolist(R.drawable.jimg5, name1, price1, qn1, s);
                        itemInfoList.add(obj);
                    } else {

                        if (itemInfoList.get(i).getId1().equals(s)) {
                            flag = false;
                            t = itemInfoList.get(i).getTotal();
                            ch = t + qn1;

                            if (ch <= qnd) {


                                itemInfoList.get(i).setTotal(ch);
                            }
                            break;

                        }
                    }
                }
                if(flag==true)
                {
                    obj = new jewinfolist(R.drawable.jimg5, name1, price1, qn1,s);
                    itemInfoList.add(obj);

                }

            }
            if (s.equals(id) && s.equals("img6")) {

                name1 = cursor.getString(1);
                price1 = cursor.getString(2);

                qua = cursor.getString(4);
                qnd = Integer.parseInt(qua);

                for (int i = 0; i < itemInfoList.size(); i++) {


                    if (itemInfoList.get(i).getId1() == null) {
                        flag=false;

                        obj = new jewinfolist(R.drawable.jmg6, name1, price1, qn1, s);
                        itemInfoList.add(obj);
                    } else {

                        if (itemInfoList.get(i).getId1().equals(s)) {
                            flag = false;
                            t = itemInfoList.get(i).getTotal();
                            ch = t + qn1;

                            if (ch <= qnd) {



                                itemInfoList.get(i).setTotal(ch);
                            }

                            break;
                        }
                    }
                }
                if(flag==true)
                {
                    obj = new jewinfolist(R.drawable.jmg6, name1, price1, qn1,s);
                    itemInfoList.add(obj);

                }

            }
            if (s.equals(id) && s.equals("img7")) {
                name1 = cursor.getString(1);
                price1 = cursor.getString(2);

                qua = cursor.getString(4);
                qnd = Integer.parseInt(qua);

                for (int i = 0; i < itemInfoList.size(); i++) {
                    if (itemInfoList.get(i).getId1() == null) {
                        flag=false;

                        obj = new jewinfolist(R.drawable.jimg7, name1, price1, qn1, s);
                        itemInfoList.add(obj);
                    } else {

                        if (itemInfoList.get(i).getId1().equals(s)) {
                            flag = false;
                            t = itemInfoList.get(i).getTotal();
                            ch = t + qn1;

                            if (ch <= qnd) {


                                itemInfoList.get(i).setTotal(ch);
                            }
                            break;

                        }
                    }
                }
                if(flag==true)
                {
                    obj = new jewinfolist(R.drawable.jimg7, name1, price1, qn1,s);
                    itemInfoList.add(obj);

                }

            }
            if (s.equals(id) && s.equals("img8")) {
                name1 = cursor.getString(1);
                price1 = cursor.getString(2);

                qua = cursor.getString(4);
                qnd = Integer.parseInt(qua);

                for (int i = 0; i < itemInfoList.size(); i++) {
                    if (itemInfoList.get(i).getId1() == null) {
                        flag=false;

                        obj = new jewinfolist(R.drawable.jimg8, name1, price1, qn1, s);
                        itemInfoList.add(obj);
                    } else {
                        if (itemInfoList.get(i).getId1().equals(s)) {
                            flag = false;
                            t = itemInfoList.get(i).getTotal();
                            ch = t + qn1;

                            if (ch <= qnd) {
                                itemInfoList.get(i).setTotal(ch);


                            }

                            break;
                        }
                    }
                }
                if(flag==true)
                {
                    obj = new jewinfolist(R.drawable.jimg8, name1, price1, qn1,s);
                    itemInfoList.add(obj);

                }

            }




/*
            cursor = database.rawQuery("SELECT ItemID,Name,Price,Code,Quantity FROM Item_Info", null);
            while (cursor.moveToNext()) {
                String nid = cursor.getString(0);

                if (nid.equals(uu)) {
                    pr[0] =(cursor.getString(2));
                    String[] arr=  pr[0].split("\\.");
                    prc= Integer.parseInt(arr[1]);
                    prc=prc*total[0];
                    ty1.setText(String.valueOf(prc));


                    break;
                }

          */










            adapterClass = new JewAdapterClass(this, R.layout.cart_jew_info, itemInfoList);
            ls.setAdapter(adapterClass);
            adapterClass.notifyDataSetChanged();
            // itemInfoList= getlist();



            SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", 0);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            Gson gson = new Gson();

            String json = gson.toJson(itemInfoList);
            editor.putString("task list1", json);
            editor.apply();

            for(int i=0 ; i<itemInfoList.size() ; i++)
            {
                int ttt=Main10Activity.itemInfoList.get(i).getTotal();
                String po=Main10Activity.itemInfoList.get(i).getPri();
                String[] arr=  po.split("\\.");
                int prc1= Integer.parseInt(arr[1].trim());
                prc1= prc1*ttt;
                subtotal=subtotal+prc1;
                ty1.setText(String.valueOf(subtotal));









            }
            subtotal=0;
/*
            SharedPreferences sharedPreferences1 = getSharedPreferences("shared preferences", 0);
            SharedPreferences.Editor editor1 = sharedPreferences1.edit();

            editor.putInt("task list1", subtotal);
            editor.apply();
            */


/*
            Intent y=new Intent(this,AdapterClass.class);
            y.putExtra("arraylist1",itemInfoList);
            startActivityForResult(y,5);
            */



        }
    }
    void load() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", 0);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list1", null);
        Type type = new TypeToken<ArrayList<jewinfolist>>() {
        }.getType();
        itemInfoList = gson.fromJson(json, type);
        if (itemInfoList == null) {
            itemInfoList = new ArrayList<>();
        }
    }




}














