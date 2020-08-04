package com.example.shopping;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shopping.ui.JavaMailAPI;
import com.google.gson.Gson;

import static com.example.shopping.Main6Activity.idorder;

public class Main7Activity extends AppCompatActivity {
    String mail;
    Intent intent;
    public static Activity fa ;
    ListView ls;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    LinearLayout l;
    HelperS helper;
    SQLiteDatabase database;

    public static int countOrder=0;
    String Id,name,price;
    int total,pt;
    String msg="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        helper = new HelperS(this);
        database = helper.getWritableDatabase();

        mail = getIntent().getStringExtra("Email");
        ls = (ListView) findViewById(R.id.listid);
        l = findViewById(R.id.li);
        for(int i=0;i<Main3Activity.itemInfoList.size();i++)
        {
            Id=Main3Activity.itemInfoList.get(i).getId1();
             name=Main3Activity.itemInfoList.get(i).getNam();
            total=Main3Activity.itemInfoList.get(i).getTotal();
            price=Main3Activity.itemInfoList.get(i).getPri();
                String arr1[]= price.split("Rs.");
                int pp=Integer.parseInt(arr1[1]);
                 pt= pp*total;

                 msg=msg+name+"("+total+")"+"                            "+pt+"\n";
            helper.addOrderItems(Id,name,total,String.valueOf(pt),String.valueOf(idorder),database);
            countOrder++;


        }
        String sum=getIntent().getStringExtra("Sub");
        String name=getIntent().getStringExtra("Name");
        String Email=getIntent().getStringExtra("Email");
        String message = "Hey "+name+"\n\n"+"Your Order is\n"+"\n"+msg+"\n"+"    Total Price                          "+sum+"\n"+"Your Order will be delivered within 3 days\n";
        String subject = "Order Confirmed";


        JavaMailAPI javaMailAPI = new JavaMailAPI(this, Email, subject, message);

        javaMailAPI.execute();

        new Handler().postDelayed(new Runnable() {

// Using handler with postDelayed called runnable run method

            @Override

            public void run() {

                l.setVisibility(View.VISIBLE);

            }

        }, 4*1000); // wait for 5 seconds

    }

    public void sendMail(View view) {


    }

    public void Back(View view) {



        for(int i=0;i<Main3Activity.itemInfoList.size();i++)
        {
            String Id=Main3Activity.itemInfoList.get(i).getId1();
            helper.updateCart(Id,0,database);
            Main3Activity.itemInfoList.remove(i);

        }
        if(Main3Activity.itemInfoList.isEmpty())
        {
            preferences=getSharedPreferences("shared preferences",0);
            editor=preferences.edit();
            Gson gson=new Gson();
            String json=gson.toJson(Main3Activity.itemInfoList);
            editor.putString("task list",json);
            editor.apply();
        }
        else
        {
            for(int i=0;i<Main3Activity.itemInfoList.size();i++)
            {
                String Id=Main3Activity.itemInfoList.get(i).getId1();
                helper.updateCart(Id,0,database);
                Main3Activity.itemInfoList.remove(i);
            }

            preferences=getSharedPreferences("shared preferences",0);
            editor=preferences.edit();
            Gson gson=new Gson();
            String json=gson.toJson(Main3Activity.itemInfoList);
            editor.putString("task list",json);
            editor.apply();

        }

        database.execSQL("delete from "+ Contract.CartItems.TABLE_NAME);
        Intent i = new Intent(getApplicationContext(), MainActivity.class);        // Specify any activity here e.g. home or splash or login etc
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("EXIT", true);
        startActivity(i);
        finish();

    }
}
