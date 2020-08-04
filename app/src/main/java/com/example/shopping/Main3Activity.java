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

import org.iiui.shoppingapp.AdapterClass;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static com.example.shopping.R.drawable.andriodpic1;
import static com.example.shopping.R.drawable.andriodpic3;
import static com.example.shopping.R.drawable.andriodpic4;
import static com.example.shopping.R.drawable.andriodpic5;
import static com.example.shopping.R.drawable.andriodpic6;
import static com.example.shopping.R.drawable.andriodpic7;
import static com.example.shopping.R.drawable.andriodpic8;
import static com.example.shopping.R.drawable.androidpic2;
import static com.example.shopping.R.drawable.jimg1;
import static com.example.shopping.R.drawable.jimg2;
import static com.example.shopping.R.drawable.jimg3;
import static com.example.shopping.R.drawable.jimg4;
import static com.example.shopping.R.drawable.jimg5;
import static com.example.shopping.R.drawable.jimg7;
import static com.example.shopping.R.drawable.jimg8;
import static com.example.shopping.R.drawable.jmg6;

public class Main3Activity extends AppCompatActivity {
     int count=0;
    HelperS helper;
    SQLiteDatabase database;
    Cursor cursor;
    String name1, price1, qua;
    public  AdapterClass adapterClass;
    int qn1, t, ch, qnd;
    ListView ls;
    public static ArrayList<iteminfolist> itemInfoList;
    iteminfolist obj;
    boolean flag=true;
    TextView ty1;
    public static int subtotal=0;
   String  qn,id;
    int prc;
    Button mm1,mm2;
    int value;
static int countcart=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent = getIntent();
        id = intent.getStringExtra("idd");
        qn = intent.getStringExtra("tot");
        qn1 = Integer.parseInt(qn);


        count = 1;
        helper = new HelperS(this);
        database = helper.getWritableDatabase();
        mm1 = (Button) findViewById(R.id.conshp);
        mm2 = (Button) findViewById(R.id.chkout);
        mm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        mm2.setOnClickListener(new View.OnClickListener() {                    //Checkout
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), Main5Activity.class);
                intent.putExtra("arraylist1", itemInfoList);
                startActivity(intent);

            }
        });
        ty1 = (TextView) findViewById(R.id.rps);

        ls = (ListView) findViewById(R.id.listid);
        load();


        cursor = database.rawQuery("SELECT ItemID,Name,Price,Code,Quantity FROM Item_Info", null);
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


                        obj = new iteminfolist(andriodpic5, name1, price1, qn1, s);
                        countcart++;
                        helper.addCart(s,name1,qn1,price1,andriodpic5,database);
                        itemInfoList.add(obj);
                        break;
                    } else {
                        if (itemInfoList.get(i).getId1().equals(s)) {

                            flag = false;
                            t = itemInfoList.get(i).getTotal();
                            ch = t + qn1;

                            if (ch <= qnd) {


                                itemInfoList.get(i).setTotal(ch);
                                countcart++;
                                helper.updateCart(s,ch,database);
                            }

                            break;
                        }
                    }
                }
                if (flag == true) {
                    obj = new iteminfolist(andriodpic5, name1, price1, qn1, s);
                    countcart++;
                    helper.addCart(s,name1,qn1,price1,andriodpic5,database);
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


                        obj = new iteminfolist(androidpic2, name1, price1, qn1, s);
                        countcart++;
                        helper.addCart(s,name1,qn1,price1,androidpic2,database);
                        itemInfoList.add(obj);
                    } else {
                        if (itemInfoList.get(i).getId1().equals(s)) {
                            flag = false;
                            t = itemInfoList.get(i).getTotal();
                            ch = t + qn1;

                            if (ch <= qnd) {


                                itemInfoList.get(i).setTotal(ch);
                                countcart++;
                                helper.updateCart(s,ch,database);
                            }

                            break;
                        }
                    }
                }
                if (flag == true) {
                    obj = new iteminfolist(androidpic2, name1, price1, qn1, s);
                    countcart++;
                    helper.addCart(s,name1,qn1,price1,androidpic2,database);
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
                        flag = false;

                        obj = new iteminfolist(andriodpic4, name1, price1, qn1, s);
                        countcart++;
                        helper.addCart(s,name1,qn1,price1,andriodpic4,database);
                        itemInfoList.add(obj);
                    } else {


                        if (itemInfoList.get(i).getId1().equals(s)) {
                            flag = false;
                            t = itemInfoList.get(i).getTotal();
                            ch = t + qn1;

                            if (ch <= qnd) {


                                itemInfoList.get(i).setTotal(ch);
                                countcart++;
                                helper.updateCart(s,ch,database);
                            }

                            break;
                        }
                    }
                }
                if (flag == true) {
                    obj = new iteminfolist(andriodpic4, name1, price1, qn1, s);
                    countcart++;
                    helper.addCart(s,name1,qn1,price1,andriodpic4,database);
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
                        flag = false;


                        obj = new iteminfolist(andriodpic6, name1, price1, qn1, s);
                        countcart++;
                        helper.addCart(s,name1,qn1,price1,andriodpic6,database);
                        itemInfoList.add(obj);
                    } else {

                        if (itemInfoList.get(i).getId1().equals(s)) {
                            flag = false;
                            t = itemInfoList.get(i).getTotal();
                            ch = t + qn1;

                            if (ch <= qnd) {

                                itemInfoList.get(i).setTotal(ch);

                                countcart++;
                                helper.updateCart(s,ch,database);
                            }

                            break;
                        }
                    }
                }
                if (flag == true) {
                    obj = new iteminfolist(andriodpic6, name1, price1, qn1, s);
                    countcart++;
                    helper.addCart(s,name1,qn1,price1,andriodpic6,database);
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
                        flag = false;

                        obj = new iteminfolist(andriodpic1, name1, price1, qn1, s);
                        countcart++;
                        helper.addCart(s,name1,qn1,price1,andriodpic1,database);
                        itemInfoList.add(obj);
                    } else {

                        if (itemInfoList.get(i).getId1().equals(s)) {
                            flag = false;
                            t = itemInfoList.get(i).getTotal();
                            ch = t + qn1;

                            if (ch <= qnd) {


                                itemInfoList.get(i).setTotal(ch);
                                countcart++;
                                helper.updateCart(s,ch,database);
                            }
                            break;

                        }
                    }
                }
                if (flag == true) {
                    obj = new iteminfolist(andriodpic1, name1, price1, qn1, s);
                    countcart++;
                    helper.addCart(s,name1,qn1,price1,andriodpic1,database);
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
                        flag = false;

                        obj = new iteminfolist(andriodpic3, name1, price1, qn1, s);
                        countcart++;
                        helper.addCart(s,name1,qn1,price1,andriodpic3,database);
                        itemInfoList.add(obj);
                    } else {

                        if (itemInfoList.get(i).getId1().equals(s)) {
                            flag = false;
                            t = itemInfoList.get(i).getTotal();
                            ch = t + qn1;

                            if (ch <= qnd) {


                                itemInfoList.get(i).setTotal(ch);
                                countcart++;
                                helper.updateCart(s,ch,database);
                            }

                            break;
                        }
                    }
                }
                if (flag == true) {
                    obj = new iteminfolist(andriodpic3, name1, price1, qn1, s);
                    countcart++;
                    helper.addCart(s,name1,qn1,price1,andriodpic3,database);
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
                        flag = false;

                        obj = new iteminfolist(andriodpic7, name1, price1, qn1, s);
                        countcart++;
                        helper.addCart(s,name1,qn1,price1,andriodpic7,database);
                        itemInfoList.add(obj);
                    } else {

                        if (itemInfoList.get(i).getId1().equals(s)) {
                            flag = false;
                            t = itemInfoList.get(i).getTotal();
                            ch = t + qn1;

                            if (ch <= qnd) {


                                itemInfoList.get(i).setTotal(ch);
                                countcart++;
                                helper.updateCart(s,ch,database);
                            }
                            break;

                        }
                    }
                }
                if (flag == true) {
                    obj = new iteminfolist(andriodpic7, name1, price1, qn1, s);
                    countcart++;
                    helper.addCart(s,name1,qn1,price1,andriodpic7,database);
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
                        flag = false;

                        obj = new iteminfolist(andriodpic8, name1, price1, qn1, s);
                        countcart++;
                        helper.addCart(s,name1,qn1,price1,andriodpic8,database);
                        itemInfoList.add(obj);
                    } else {
                        if (itemInfoList.get(i).getId1().equals(s)) {
                            flag = false;
                            t = itemInfoList.get(i).getTotal();
                            ch = t + qn1;

                            if (ch <= qnd) {
                                itemInfoList.get(i).setTotal(ch);
                                countcart++;
                                helper.updateCart(s,ch,database);


                            }

                            break;
                        }
                    }
                }
                if (flag == true) {
                    obj = new iteminfolist(andriodpic8, name1, price1, qn1, s);
                    countcart++;
                    helper.addCart(s,name1,qn1,price1,andriodpic8,database);
                    itemInfoList.add(obj);

                }

            }
        }

            cursor = database.rawQuery("SELECT ItemID,Name,Price,Code,Quantity FROM Jewellery_INFO", null);
            while (cursor.moveToNext()) {
                String s = cursor.getString(0);

                if (s.equals(id) && s.equals("imgj1")) {
                    name1 = cursor.getString(1);
                    price1 = cursor.getString(2);
                    qua = cursor.getString(4);
                    qnd = Integer.parseInt(qua);


                    for (int i = 0; i < itemInfoList.size(); i++) {
                        if (itemInfoList.get(i).getId1() == null) {

                            flag = false;


                            obj = new iteminfolist(R.drawable.jimg1, name1, price1, qn1, s);
                            helper.addCart(s,name1,qn1,price1,jimg1,database);
                            itemInfoList.add(obj);
                            break;
                        } else {
                            if (itemInfoList.get(i).getId1().equals(s)) {

                                flag = false;
                                t = itemInfoList.get(i).getTotal();
                                ch = t + qn1;

                                if (ch <= qnd) {


                                    itemInfoList.get(i).setTotal(ch);
                                    helper.updateCart(s,ch,database);

                                }

                                break;
                            }
                        }
                    }
                    if (flag == true) {
                        obj = new iteminfolist(R.drawable.jimg1, name1, price1, qn1, s);
                        helper.addCart(s,name1,qn1,price1,jimg1,database);
                        itemInfoList.add(obj);

                    }
                }

                if (s.equals(id) && s.equals("imgj2")) {
                    name1 = cursor.getString(1);
                    price1 = cursor.getString(2);
                    qua = cursor.getString(4);
                    qnd = Integer.parseInt(qua);

                    for (int i = 0; i < itemInfoList.size(); i++) {
                        if (itemInfoList.get(i).getId1() == null) {
                            flag = false;

                            obj = new iteminfolist(R.drawable.jimg2, name1, price1, qn1, s);
                            helper.addCart(s,name1,qn1,price1,jimg2,database);
                            itemInfoList.add(obj);
                        } else {
                            if (itemInfoList.get(i).getId1().equals(s)) {
                                flag = false;
                                t = itemInfoList.get(i).getTotal();
                                ch = t + qn1;

                                if (ch <= qnd) {


                                    itemInfoList.get(i).setTotal(ch);
                                    helper.updateCart(s,ch,database);
                                }

                                break;
                            }
                        }
                    }
                    if (flag == true) {
                        obj = new iteminfolist(R.drawable.jimg2, name1, price1, qn1, s);
                        helper.addCart(s,name1,qn1,price1,jimg2,database);
                        itemInfoList.add(obj);

                    }

                }

                if (s.equals(id) && s.equals("imgj3")) {
                    name1 = cursor.getString(1);
                    price1 = cursor.getString(2);

                    qua = cursor.getString(4);
                    qnd = Integer.parseInt(qua);

                    for (int i = 0; i < itemInfoList.size(); i++) {

                        if (itemInfoList.get(i).getId1() == null) {
                            flag = false;

                            obj = new iteminfolist(R.drawable.jimg3, name1, price1, qn1, s);
                            helper.addCart(s,name1,qn1,price1,jimg3,database);
                            itemInfoList.add(obj);
                        } else {


                            if (itemInfoList.get(i).getId1().equals(s)) {
                                flag = false;
                                t = itemInfoList.get(i).getTotal();
                                ch = t + qn1;

                                if (ch <= qnd) {


                                    itemInfoList.get(i).setTotal(ch);
                                    helper.updateCart(s,ch,database);
                                }

                                break;
                            }
                        }
                    }
                    if (flag == true) {
                        obj = new iteminfolist(R.drawable.jimg3, name1, price1, qn1, s);
                        helper.addCart(s,name1,qn1,price1,jimg3,database);
                        itemInfoList.add(obj);

                    }

                }
                if (s.equals(id) && s.equals("imgj4")) {
                    name1 = cursor.getString(1);
                    price1 = cursor.getString(2);

                    qua = cursor.getString(4);
                    qnd = Integer.parseInt(qua);

                    for (int i = 0; i < itemInfoList.size(); i++) {

                        if (itemInfoList.get(i).getId1() == null) {
                            flag = false;


                            obj = new iteminfolist(R.drawable.jimg4, name1, price1, qn1, s);
                            helper.addCart(s,name1,qn1,price1,jimg4,database);
                            itemInfoList.add(obj);
                        } else {

                            if (itemInfoList.get(i).getId1().equals(s)) {
                                flag = false;
                                t = itemInfoList.get(i).getTotal();
                                ch = t + qn1;

                                if (ch <= qnd) {

                                    itemInfoList.get(i).setTotal(ch);
                                    helper.updateCart(s,ch,database);
                                }

                                break;
                            }
                        }
                    }
                    if (flag == true) {
                        obj = new iteminfolist(R.drawable.jimg4, name1, price1, qn1, s);
                        helper.addCart(s,name1,qn1,price1,jimg4,database);
                        itemInfoList.add(obj);

                    }


                }
                if (s.equals(id) && s.equals("imgj5")) {
                    name1 = cursor.getString(1);
                    price1 = cursor.getString(2);

                    qua = cursor.getString(4);
                    qnd = Integer.parseInt(qua);

                    for (int i = 0; i < itemInfoList.size(); i++) {
                        if (itemInfoList.get(i).getId1() == null) {
                            flag = false;

                            obj = new iteminfolist(R.drawable.jimg5, name1, price1, qn1, s);
                            helper.addCart(s,name1,qn1,price1,jimg5,database);
                            itemInfoList.add(obj);
                        } else {

                            if (itemInfoList.get(i).getId1().equals(s)) {
                                flag = false;
                                t = itemInfoList.get(i).getTotal();
                                ch = t + qn1;

                                if (ch <= qnd) {


                                    itemInfoList.get(i).setTotal(ch);
                                    helper.updateCart(s,ch,database);


                                }
                                break;

                            }
                        }
                    }
                    if (flag == true) {
                        obj = new iteminfolist(R.drawable.jimg5, name1, price1, qn1, s);
                        helper.addCart(s,name1,qn1,price1,jimg5,database);
                        itemInfoList.add(obj);

                    }

                }
                if (s.equals(id) && s.equals("imgj6")) {

                    name1 = cursor.getString(1);
                    price1 = cursor.getString(2);

                    qua = cursor.getString(4);
                    qnd = Integer.parseInt(qua);

                    for (int i = 0; i < itemInfoList.size(); i++) {


                        if (itemInfoList.get(i).getId1() == null) {
                            flag = false;

                            obj = new iteminfolist(R.drawable.jmg6, name1, price1, qn1, s);
                            helper.addCart(s,name1,qn1,price1,jmg6,database);
                            itemInfoList.add(obj);
                        } else {

                            if (itemInfoList.get(i).getId1().equals(s)) {
                                flag = false;
                                t = itemInfoList.get(i).getTotal();
                                ch = t + qn1;

                                if (ch <= qnd) {


                                    itemInfoList.get(i).setTotal(ch);
                                    helper.updateCart(s,ch,database);
                                }

                                break;
                            }
                        }
                    }
                    if (flag == true) {
                        obj = new iteminfolist(R.drawable.jmg6, name1, price1, qn1, s);
                        helper.addCart(s,name1,qn1,price1,jmg6,database);
                        itemInfoList.add(obj);

                    }

                }
                if (s.equals(id) && s.equals("imgj7")) {
                    name1 = cursor.getString(1);
                    price1 = cursor.getString(2);

                    qua = cursor.getString(4);
                    qnd = Integer.parseInt(qua);

                    for (int i = 0; i < itemInfoList.size(); i++) {
                        if (itemInfoList.get(i).getId1() == null) {
                            flag = false;

                            obj = new iteminfolist(R.drawable.jimg7, name1, price1, qn1, s);
                            helper.addCart(s,name1,qn1,price1,jimg7,database);
                            itemInfoList.add(obj);
                        } else {

                            if (itemInfoList.get(i).getId1().equals(s)) {
                                flag = false;
                                t = itemInfoList.get(i).getTotal();
                                ch = t + qn1;

                                if (ch <= qnd) {


                                    itemInfoList.get(i).setTotal(ch);
                                    helper.updateCart(s,ch,database);
                                }
                                break;

                            }
                        }
                    }
                    if (flag == true) {
                        obj = new iteminfolist(R.drawable.jimg7, name1, price1, qn1, s);
                        helper.addCart(s,name1,qn1,price1,jimg7,database);
                        itemInfoList.add(obj);

                    }

                }
                if (s.equals(id) && s.equals("imgj8")) {
                    name1 = cursor.getString(1);
                    price1 = cursor.getString(2);

                    qua = cursor.getString(4);
                    qnd = Integer.parseInt(qua);

                    for (int i = 0; i < itemInfoList.size(); i++) {
                        if (itemInfoList.get(i).getId1() == null) {
                            flag = false;

                            obj = new iteminfolist(R.drawable.jimg8, name1, price1, qn1, s);
                            helper.addCart(s,name1,qn1,price1,jimg8,database);
                            itemInfoList.add(obj);
                        } else {
                            if (itemInfoList.get(i).getId1().equals(s)) {
                                flag = false;
                                t = itemInfoList.get(i).getTotal();
                                ch = t + qn1;

                                if (ch <= qnd) {
                                    itemInfoList.get(i).setTotal(ch);
                                    helper.updateCart(s,ch,database);


                                }

                                break;
                            }
                        }
                    }
                    if (flag == true) {
                        obj = new iteminfolist(R.drawable.jimg8, name1, price1, qn1, s);
                        helper.addCart(s,name1,qn1,price1,jimg8,database);
                        itemInfoList.add(obj);

                    }

                }



                adapterClass = new AdapterClass(this, R.layout.cart_item_info, itemInfoList);
                ls.setAdapter(adapterClass);
                registerForContextMenu(ls);


                // itemInfoList= getlist();


                SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                Gson gson = new Gson();

                String json = gson.toJson(itemInfoList);
                editor.putString("task list", json);
                editor.apply();
                value = subtotal;
                for (int i = 0; i < itemInfoList.size(); i++) {
                    int ttt = itemInfoList.get(i).getTotal();
                    String po = itemInfoList.get(i).getPri();
                    String[] arr = po.split("\\.");
                    int prc1 = Integer.parseInt(arr[1]);
                    prc1 = prc1 * ttt;
                    subtotal = subtotal + prc1;
                    ty1.setText(String.valueOf(subtotal));
                    value = subtotal;


                }
                subtotal = 0;

            }
        }
   public void load() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", 0);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list", null);
        Type type = new TypeToken<ArrayList<iteminfolist>>() {
        }.getType();
        itemInfoList = gson.fromJson(json, type);
        if (itemInfoList == null) {
            itemInfoList = new ArrayList<>();
        }
    }


}





