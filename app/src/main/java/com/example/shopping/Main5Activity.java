package com.example.shopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Main5Activity extends AppCompatActivity {

    Intent intent;
    public  static ArrayList<iteminfolist> list1;
    AdapterCheckout adapterCheckout;
    ListView lo;
    String total;
    TextView show,sub;
    EditText fn,ln,add,pn,email;
    TextView tvfn,tvln,tvadd,tvacc,tvemail,tvpn;
    int countfn=0,countln=0,countaddress=0,countacc=0,counte=0,countpn=0;
    String cities[];
    AutoCompleteTextView acc;
    long tot;
    long sum=0;
    String pr1;
    int total1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        show=findViewById(R.id.showtotal);
        sub=findViewById(R.id.subtotal);

        fn=findViewById(R.id.etfn);
        ln=findViewById(R.id.etln);
        add=findViewById(R.id.etadd);
        pn=findViewById(R.id.etpn);
        email=findViewById(R.id.etemail);


        tvfn=findViewById(R.id.errorfn);
        tvln=findViewById(R.id.errorln);
        tvadd=findViewById(R.id.erroradd);
        tvacc=findViewById(R.id.errorc);
        tvemail=findViewById(R.id.erroremail);
        tvpn=findViewById(R.id.errorpn);

        acc=findViewById(R.id.accity);
        cities=getResources().getStringArray(R.array.cities);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cities);
        acc.setAdapter(adapter);



        list1=(ArrayList<iteminfolist>)getIntent().getSerializableExtra("arraylist1");
        lo=(ListView)findViewById(R.id.listid1);
        adapterCheckout = new AdapterCheckout(this, R.layout.checkoutinfo, list1);
        lo.setAdapter(adapterCheckout);
        adapterCheckout.notifyDataSetChanged();


        for (int i = 0; i < list1.size(); i++) {

            pr1=list1.get(i).getPri();
            total1=list1.get(i).getTotal();
            String arr1[]= pr1.split("Rs.");
            int pp=Integer.parseInt(arr1[1]);
            int pt= pp*total1;

            sum=sum+pt;
            }
        sub.setText(String.valueOf(sum));
        show.setText(String.valueOf(sum));

    }
    public void Move(View view)
    {
        switch(view.getId())
        {
            case R.id.movecart:
            {
                finish();
            }
            break;

            case R.id.btsub:
            {
                if(fn.getText().toString().isEmpty()  || fn.getText().toString().trim().isEmpty())
                {
                    tvfn.setText("Enter First Name");
                    countfn=1;
                }
                else if (fn.getText().toString().matches("[a-zA-Z ]+")==false)
                {
                    tvfn.setText("Only alphabets are allowed");
                    countfn=1;
                }
                else
                {
                    tvfn.setText("");
                    countfn=0;
                }
                if(ln.getText().toString().isEmpty()  || ln.getText().toString().trim().isEmpty())
                {
                    tvln.setText("Enter Last Name");
                    countln=1;
                }
                else if (ln.getText().toString().matches("[a-zA-Z ]+")==false)
                {
                    tvln.setText("Only alphabets are allowed");
                    countln=1;
                }
                else
                {
                    tvln.setText("");
                    countln=0;
                }

                if(add.getText().toString().isEmpty() || add.getText().toString().trim().isEmpty())
                {
                    tvadd.setText("Enter Address");
                    countaddress=1;
                }
                else
                {
                    tvadd.setText("");
                    countaddress=0;
                }
                if(pn.getText().toString().isEmpty() || pn.getText().toString().trim().isEmpty())
                {
                    tvpn.setText("Enter Phone no");
                    countpn=1;
                }
                else if (pn.getText().toString().matches("[0-9 ]+")==false)
                {
                    tvpn.setText("Only digits are allowed");
                    countpn=1;
                }
                else if (pn.getText().toString().length()<10 || pn.getText().toString().length()>10)
                {
                    tvpn.setText("Only 10 digits are allowed");
                    countpn=1;
                }

                else
                {
                    tvpn.setText("");
                    countpn =0;
                }

                if(acc.getText().toString().isEmpty() || acc.getText().toString().trim().isEmpty())
                {
                    tvacc.setText("Enter City name");
                    countacc=1;
                }
                else
                {
                    tvacc.setText("");
                    countacc =0;
                }
                if(email.getText().toString().isEmpty() || email.getText().toString().trim().isEmpty())
                {
                    tvemail.setText("Enter Gmail ID");
                    counte=1;
                }
                else if(email.getText().toString().matches("^\\w+([@])gmail+([.])com$")==false)
                {
                    tvemail.setText("Enter Valid Gmail ID");
                    counte=1;
                }
                else
                {
                    tvemail.setText("");
                    counte =0;
                }

                if(countpn ==0 && countln==0 && countaddress==0 && countfn==0 && countacc==0 && counte==0)
                {
                    String Fullname= fn.getText().toString().trim()+"  " + ln.getText().toString().trim();
                    String address= add.getText().toString().trim();
                    String city= acc.getText().toString().trim();
                    String Email= email.getText().toString().trim();
                    String phone= pn.getText().toString().trim();


                    Intent intent= new Intent(getApplicationContext(),Main6Activity.class);
                    intent.putExtra("arraylist1",list1);
                    intent.putExtra("Name",Fullname);
                    intent.putExtra("Address",address);
                    intent.putExtra("City",city);
                    intent.putExtra("Email",Email);
                    intent.putExtra("Phoneno",phone);
                    intent.putExtra("total",String.valueOf(sum));
                    startActivity(intent);
                }
            }
            break;


        }
    }
}
