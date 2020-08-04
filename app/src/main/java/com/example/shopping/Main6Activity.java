package com.example.shopping;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Date;

public class Main6Activity extends AppCompatActivity {
    Intent intent;
    ArrayList<iteminfolist> list1;
    AdapterCheckout adapterCheckout;
    ListView lo;
    String total;
    TextView show,sub;
    EditText fn,ln,add,pn,email;
    public static int idorder=0;
    TextView tvfn,tvadd,tvacc,tvemail,tvpn;
    int countfn=0,countln=0,countaddress=0,countacc=0,counte=0,countpn=0;

   String Name,Address,City,Email,Phoneno,currentDateTimeString;

    AutoCompleteTextView acc;
    static ContentValues order;
    static int count=0;
    SQLiteDatabase database;
    HelperS helper;
   public static  int countorder=0;
    String sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        show=findViewById(R.id.showtotal);
        sub=findViewById(R.id.subtotal);
        helper = new HelperS(this);
        database = helper.getWritableDatabase();
        tvfn=findViewById(R.id.tvname);
        tvadd=findViewById(R.id.tvadd);
        tvacc=findViewById(R.id.tvcity);
        tvemail=findViewById(R.id.tvemail);
        tvpn=findViewById(R.id.tvpn);

        order=new ContentValues();

        list1=(ArrayList<iteminfolist>)getIntent().getSerializableExtra("arraylist1");
        lo=(ListView)findViewById(R.id.listid1);
        adapterCheckout = new AdapterCheckout(this, R.layout.checkoutinfo, list1);
        lo.setAdapter(adapterCheckout);
        adapterCheckout.notifyDataSetChanged();

        sum=getIntent().getStringExtra("total");
         Name=getIntent().getStringExtra("Name");
         Address=getIntent().getStringExtra("Address");
         City=getIntent().getStringExtra("City");
        Email=getIntent().getStringExtra("Email");
        Phoneno=getIntent().getStringExtra("Phoneno");
        sub.setText(sum);
        show.setText(sum);

        tvfn.setText(Name);
        tvadd.setText(Address);
        tvacc.setText(City);
        tvemail.setText(Email);
        tvpn.setText("+92"+Phoneno);

    }
    public void Move(View view)
    {
        switch(view.getId())
        {
            case R.id.moveinfo:
            {
                finish();
            }
            break;

            case R.id.btcom:
            {

                count++;
                countorder=1;
                idorder++;
                currentDateTimeString= java.text.DateFormat.getDateTimeInstance().format(new Date());
                helper.addOrders(idorder,Name,City,Phoneno,Email,Address, currentDateTimeString,sum,database);


                Intent intent=new Intent(getApplicationContext(),Main7Activity.class);
                intent.putExtra("Email",Email );
                intent.putExtra("Sub",sum );
                intent.putExtra("Name",Name );
                startActivity(intent);

            }
            break;


        }
    }

}
