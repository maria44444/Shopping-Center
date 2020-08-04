package com.example.shopping.ui.gallery;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.shopping.HelperS;
import com.example.shopping.Main5Activity;
import com.example.shopping.MainActivity;
import com.example.shopping.R;
import com.example.shopping.iteminfolist;

import org.iiui.shoppingapp.AdapterClass;

import java.util.ArrayList;

import static com.example.shopping.Main3Activity.itemInfoList;


public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    public AdapterClass adapterClass;

    boolean flag=true;

    public static int subtotal=0;
    SQLiteDatabase database;
    Cursor cursor;
    HelperS helper;
    iteminfolist obj;
   public ArrayList<iteminfolist> cartitems=new ArrayList<iteminfolist>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        helper = new HelperS(getContext());
        database = helper.getWritableDatabase();
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);

        View root = inflater.inflate(R.layout.activity_main3, container, false);



        final TextView ty1 = root.findViewById(R.id.rps);

        final ListView ls =root.findViewById(R.id.listid);


        final Button mm1 = root.findViewById(R.id.conshp);
        final Button mm2 = root.findViewById(R.id.chkout);
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

        int count=0;

        int c=0;
        cursor = database.rawQuery("SELECT ItemID,Name,Total,Price,Pic FROM CartItems_INFO", null);
        while (cursor.moveToNext()) {
           String ID= cursor.getString(0);
            String name= cursor.getString(1);
            int Total=Integer.parseInt(cursor.getString(2));
            String Price=cursor.getString(3);
            int Pic=Integer.parseInt(cursor.getString(4));
            c++;
            if(Total==0)
            {
                count++;
            }
            else
            {
                obj = new iteminfolist(Pic, name, Price, Total, ID);

                cartitems.add(obj);
            }


        }
        adapterClass = new AdapterClass(getContext(), R.layout.cart_item_info,cartitems);
        ls.setAdapter(adapterClass);
        registerForContextMenu(ls);
        if(c==count)
        {
            root = inflater.inflate(R.layout.activity_main4, container, false);
            final TextView t1=root.findViewById(R.id.cls);
            t1.setOnClickListener(new View.OnClickListener() {                    //Checkout
                @Override
                public void onClick(View view) {

                    Intent intent=new Intent(getContext(), MainActivity.class);
                    startActivity(intent);

                }
            });
        }

        for (int i = 0; i < cartitems.size(); i++) {
            int ttt = cartitems.get(i).getTotal();
            String po = cartitems.get(i).getPri();
            String[] arr = po.split("\\.");
            int prc1 = Integer.parseInt(arr[1]);
            prc1 = prc1 * ttt;
            subtotal = subtotal + prc1;
            ty1.setText(String.valueOf(subtotal));


        }

        return root;
    }

}