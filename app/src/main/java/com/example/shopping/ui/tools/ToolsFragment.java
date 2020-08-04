package com.example.shopping.ui.tools;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.shopping.ExpandableListAdapter;
import com.example.shopping.HelperS;
import com.example.shopping.R;
import com.example.shopping.ui.Items;
import com.example.shopping.ui.Orderslist;

import java.util.ArrayList;

import static android.os.FileObserver.DELETE;

public class ToolsFragment extends Fragment implements ExpandableListView.OnGroupClickListener, ExpandableListView.OnChildClickListener,
        ExpandableListView.OnGroupExpandListener,ExpandableListView.OnGroupCollapseListener   {

    View root;
    private ToolsViewModel toolsViewModel;
    SQLiteDatabase database;
    Cursor cursor;
    HelperS helper;
    SharedPreferences preferences;
    ExpandableListView elvMyListView;
    ExpandableListAdapter adapter;
   ArrayList<Orderslist> orderslists=new ArrayList<Orderslist>();
    ArrayList<Orderslist> orderslists1=new ArrayList<Orderslist>();
    ListView list,list1;
    LinearLayout llogin,llist;
    TextView txterror,txttop;
    public View onCreateView(@NonNull final LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {

          toolsViewModel = ViewModelProviders.of(this).get(ToolsViewModel.class);
         root = inflater.inflate(R.layout.fragment_tools, container, false);
        orderslists = new ArrayList<>();

        final EditText un = root.findViewById(R.id.etusername);
        final EditText pass = root.findViewById(R.id.etpassword);
        final Button bt = root.findViewById(R.id.btlogin);
        llogin = root.findViewById(R.id.lilogin);
       llist = root.findViewById(R.id.lilist);
      txterror = root.findViewById(R.id.showerror);
         txttop = root.findViewById(R.id.tvtop);
        elvMyListView = root. findViewById(R.id.elvMyListView);
        registerForContextMenu(elvMyListView);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper = new HelperS(getContext());
                database = helper.getWritableDatabase();
                int count=0;
                if(un.getText().toString().matches("Maria") && pass.getText().toString().matches("maria1234"))
                {

                    llogin.setVisibility(View.GONE);
                    llist.setVisibility(View.VISIBLE);
                    txttop.setVisibility(View.GONE);
                        cursor = database.rawQuery("SELECT orderID,Name,City,Phoneno,Email,Address,Date,Subtotal FROM Orders_INFO", null);
                        while (cursor.moveToNext()) {
                            int ID= Integer.parseInt(cursor.getString(0));

                            String name= cursor.getString(1);
                            String city=cursor.getString(2);
                            String phone=cursor.getString(3);
                            String email=cursor.getString(4);
                            String address=cursor.getString(5);
                            String date=cursor.getString(6);
                            String sub=cursor.getString(7);

                            if(name.matches(""))
                            {
                                continue;
                            }
                            else
                            {
                                ArrayList<Items> items = new ArrayList<>();
                                Orderslist order1 = new Orderslist(ID,name,city,phone,email,address,date,sub);

                                Cursor cursor1 = database.rawQuery("SELECT ItemID,Name,Total,Price,Count FROM OrderItems_INFO", null);
                                int count1=0;
                                while (cursor1.moveToNext()) {
                                    String ID1 = cursor1.getString(0);
                                    String name1 = cursor1.getString(1);
                                    String total = cursor1.getString(2);
                                    String price = cursor1.getString(3);
                                    String c = cursor1.getString(4);
                                    count1++;

                                    if (name1.matches("")) {
                                        continue;
                                    } else if(String.valueOf(ID).matches(c)) {
                                        items.add(new Items(name1,total,price));

                                    }

                                }
                                order1.setItems(items);
                                orderslists1.add(order1);
                                count=1;

                            }



                        }


                    if(count==0)
                    {
                        txttop.setVisibility(View.VISIBLE);
                        llogin.setVisibility(View.GONE);
                        llist.setVisibility(View.GONE);
                    }
                    else
                    {
                        adapter = new ExpandableListAdapter(getContext(), orderslists1);
                        elvMyListView.setAdapter(adapter);
                    }


                }
                else
                {
                    txterror.setText("Admin can only access it");
                }


            }
        });

        return root;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {

        super.onCreateContextMenu(menu, view, contextMenuInfo);
        menu.add(Menu.NONE, DELETE, menu.NONE, "Delete");
    }
    @Override
    public boolean onContextItemSelected(MenuItem menuItem)
    {
        final ExpandableListView.ExpandableListContextMenuInfo info = (ExpandableListView.ExpandableListContextMenuInfo) menuItem.getMenuInfo();

        final int groupPos = ExpandableListView.getPackedPositionGroup(info.packedPosition);
        switch (menuItem.getItemId())
        {
            case DELETE:
            {



                androidx.appcompat.app.AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                builder.setMessage("Are u sure to delete?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String s=orderslists1.get(groupPos).getID1();
                        helper.updateOrder(s,"",database);
                        orderslists1=new ArrayList<Orderslist>();
                        int count=0;
                        cursor = database.rawQuery("SELECT orderID,Name,City,Phoneno,Email,Address,Date,Subtotal FROM Orders_INFO", null);
                        while (cursor.moveToNext()) {
                            int ID= Integer.parseInt(cursor.getString(0));
                            String name= cursor.getString(1);
                            String city=cursor.getString(2);
                            String phone=cursor.getString(3);
                            String email=cursor.getString(4);
                            String address=cursor.getString(5);
                            String date=cursor.getString(6);
                            String sub=cursor.getString(7);

                            if(name.matches(""))
                            {
                                continue;
                            }
                            else
                            {
                                ArrayList<Items> items = new ArrayList<>();
                                Orderslist order1 = new Orderslist(ID,name,city,phone,email,address,date,sub);

                                Cursor cursor1 = database.rawQuery("SELECT ItemID,Name,Total,Price,Count FROM OrderItems_INFO", null);
                                int count1=0;
                                while (cursor1.moveToNext()) {
                                    String ID1 = cursor1.getString(0);
                                    String name1 = cursor1.getString(1);
                                    String total = cursor1.getString(2);
                                    String price = cursor1.getString(3);
                                    String c = cursor1.getString(4);
                                    count1++;

                                    if (name1.matches("")) {
                                        continue;
                                    } else if(String.valueOf(ID).matches(c)) {
                                        items.add(new Items(name1,total,price));

                                    }

                                }
                                order1.setItems(items);
                                orderslists1.add(order1);
                                count=1;
                            }



                        }


                        if(count==0)
                        {
                            txttop.setVisibility(View.VISIBLE);
                            llogin.setVisibility(View.GONE);
                            llist.setVisibility(View.GONE);
                        }
                        else
                        {
                            adapter = new ExpandableListAdapter(getContext(), orderslists1);
                            elvMyListView.setAdapter(adapter);
                        }

                    }

                });
                builder.setNegativeButton("No", null);
                builder.show();
                return true;
            }



            default:
                return  super.onContextItemSelected(menuItem);
        }

    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        return false;
    }

    @Override
    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
        return false;
    }

    @Override
    public void onGroupCollapse(int groupPosition) {

    }

    @Override
    public void onGroupExpand(int groupPosition) {

    }
}