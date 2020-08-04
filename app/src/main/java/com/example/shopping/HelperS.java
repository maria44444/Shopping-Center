package com.example.shopping;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HelperS extends SQLiteOpenHelper

{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Clothing And Jewellery_Info_Record15.db";
    private static final String CREATE_TBL1 = "CREATE TABLE "
            + Contract.Users.TABLE_NAME + " ("
            + Contract.Users.COL_ID + " TEXT NOT NULL, "
            + Contract.Users.COL_NAME + " TEXT NOT NULL, "
            + Contract.Users.COL_PRICE + " TEXT NOT NULL, "
            + Contract.Users.COL_CODE+ " TEXT NOT NULL, "
            + Contract.Users.COL_QUANTITY+ "  TEXT NOT NULL, "
            + Contract.Users.COL_DETAILS+ " TEXT NOT NULL)";

    private static final String CREATE_TABLE1="CREATE TABLE "
            +Contract.Shopping.TABLE_NAME+"("
            +Contract.Shopping.COL_ID+ " TEXT NOT NULL, "
            +Contract.Shopping.COL_NAME+ " TEXT NOT NULL, "
            +Contract.Shopping.COL_PRICE+ " TEXT NOT NULL, "
            +Contract.Shopping.COL_CODE+ " TEXT NOT NULL, "
            +Contract.Shopping.COL_QUANTITY+ " TEXT NOT NULL, "
            +Contract.Shopping.COL_DETAILS+ " TEXT NOT NULL)";

    private static final String CREATE_TABLE2="CREATE TABLE "
            +Contract.Orders.TABLE_NAME+"("
            +Contract.Orders.COL_ID+ " TEXT NOT NULL, "
            +Contract.Orders.COL_NAME+ " TEXT NOT NULL, "
            +Contract.Orders.COL_CITY+ " TEXT NOT NULL, "
            +Contract.Orders.COL_PHONENO+ " TEXT NOT NULL, "
            +Contract.Orders.COL_EMAIL+ " TEXT NOT NULL, "
            +Contract.Orders.COL_ADDRESS+ " TEXT NOT NULL, "
            +Contract.Orders.COL_DATE+ " TEXT NOT NULL, "
            +Contract.Orders.COL_SUBTOTAL+ " TEXT NOT NULL)";

    private static final String CREATE_TABLE3="CREATE TABLE "
            +Contract.CartItems.TABLE_NAME+"("
            +Contract.CartItems.COL_ID+ " TEXT NOT NULL, "
            +Contract.CartItems.COL_NAME+ " TEXT NOT NULL, "
            +Contract.CartItems.COL_TOTAL+ " TEXT NOT NULL, "
            +Contract.CartItems.COL_PRICE+ " TEXT NOT NULL, "
            +Contract.CartItems.COL_PIC+ " TEXT NOT NULL)";

    private static final String CREATE_TABLE4="CREATE TABLE "
            +Contract.OrderItems.TABLE_NAME+"("
            +Contract.OrderItems.COL_ID+ " TEXT NOT NULL, "
            +Contract.OrderItems.COL_NAME+ " TEXT NOT NULL, "
            +Contract.OrderItems.COL_TOTAL+ " TEXT NOT NULL, "
            +Contract.OrderItems.COL_PRICE+ " TEXT NOT NULL, "
            +Contract.OrderItems.COL_COUNT+ " TEXT NOT NULL)";

    public HelperS(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_TBL1);
        database.execSQL(CREATE_TABLE1);
        database.execSQL(CREATE_TABLE2);
        database.execSQL(CREATE_TABLE3);
        database.execSQL(CREATE_TABLE4);
        setvalues(database);

        SetValues1(database);


    }

    public void setvalues(SQLiteDatabase database)
    {

        ContentValues v=new ContentValues();
        v.put(Contract.Users.COL_ID,"img1");
        v.put(Contract.Users.COL_NAME,"2-Pc Lawn Suit");
        v.put(Contract.Users.COL_PRICE,"Rs.2299");
        v.put(Contract.Users.COL_CODE,"UO632-2PC-BGE");
        v.put(Contract.Users.COL_QUANTITY,"5");
        v.put(Contract.Users.COL_DETAILS,"Unstiched Suit-2 Piece,Printed Lawn Shirt Fabric,Trouser Plain Lawn.");

        database.insert(Contract.Users.TABLE_NAME,null,v);

        v.put(Contract.Users.COL_ID,"img2");
        v.put(Contract.Users.COL_NAME,"Embroidery 2-PC Suit");
        v.put(Contract.Users.COL_PRICE,"Rs.2488");
        v.put(Contract.Users.COL_CODE,"UO699-2PC-FGE");
        v.put(Contract.Users.COL_QUANTITY,"8");
        v.put(Contract.Users.COL_DETAILS,"Unstiched Suit-2 Piece,Embroidered Lawn Shirt Fabric,Trouser Plain Lawn.");
        database.insert(Contract.Users.TABLE_NAME,null,v);

        v.put(Contract.Users.COL_ID,"img3");
        v.put(Contract.Users.COL_NAME,"3-Pc Lawn Suit");
        v.put(Contract.Users.COL_PRICE,"Rs.3488");
        v.put(Contract.Users.COL_CODE,"YY699-3PC-UTE");
        v.put(Contract.Users.COL_QUANTITY,"7");
        v.put(Contract.Users.COL_DETAILS,"Unstiched Suit-3 Piece, Lawn Shirt Fabric,Trouser Plain Lawn,Dupatta Chiffon.");
        database.insert(Contract.Users.TABLE_NAME,null,v);

        v.put(Contract.Users.COL_ID,"img4");
        v.put(Contract.Users.COL_NAME,"Embroidery 2-Pc Suit");
        v.put(Contract.Users.COL_PRICE,"Rs.4099");
        v.put(Contract.Users.COL_CODE,"ZZ629-2PC-ZZE");
        v.put(Contract.Users.COL_QUANTITY,"3");
        v.put(Contract.Users.COL_DETAILS,"Unstiched Suit-2 Piece,Embroidered Lawn Shirt Fabric,Trouser Plain Lawn.");
        database.insert(Contract.Users.TABLE_NAME,null,v);

        v.put(Contract.Users.COL_ID,"img5");
        v.put(Contract.Users.COL_NAME,"2-Pc Lawn Suit");
        v.put(Contract.Users.COL_PRICE,"Rs.2000");
        v.put(Contract.Users.COL_CODE,"CY459-2PC-UYE");
        v.put(Contract.Users.COL_QUANTITY,"7");
        v.put(Contract.Users.COL_DETAILS,"Unstiched Suit-2 Piece, Lawn Shirt Fabric,Trouser Plain Lawn.");
        database.insert(Contract.Users.TABLE_NAME,null,v);



        v.put(Contract.Users.COL_ID,"img6");
        v.put(Contract.Users.COL_NAME,"3-Pc Lawn Suit");
        v.put(Contract.Users.COL_PRICE,"Rs.4089");
        v.put(Contract.Users.COL_CODE,"HH434-3PC-RRE");
        v.put(Contract.Users.COL_QUANTITY,"10");
        v.put(Contract.Users.COL_DETAILS,"Unstiched Suit-3 Piece, Lawn Shirt Printed,Trouser Plain Lawn.");
        database.insert(Contract.Users.TABLE_NAME,null,v);


        v.put(Contract.Users.COL_ID,"img7");
        v.put(Contract.Users.COL_NAME,"Embroidery 2-Pc Suit");
        v.put(Contract.Users.COL_PRICE,"Rs.5000");
        v.put(Contract.Users.COL_CODE,"MR435-2PC-GYE");
        v.put(Contract.Users.COL_QUANTITY,"10");
        v.put(Contract.Users.COL_DETAILS,"Unstiched Suit-2 Piece,Embroidered Lawn Shirt Fabric,Trouser Plain Lawn");
        database.insert(Contract.Users.TABLE_NAME,null,v);

        v.put(Contract.Users.COL_ID,"img8");
        v.put(Contract.Users.COL_NAME,"2-Pc Lawn Suit");
        v.put(Contract.Users.COL_PRICE,"Rs.3500");
        v.put(Contract.Users.COL_CODE,"YT475-2PC-UUE");
        v.put(Contract.Users.COL_QUANTITY,"12");
        v.put(Contract.Users.COL_DETAILS,"Unstiched Suit-2 Piece,Lawn Shirt Fabric,Trouser Plain Lawn");
        database.insert(Contract.Users.TABLE_NAME,null,v);


        //database.close();
    }


    public void addOrders(int i,String n,String c,String p,String e,String a,String d,String s,SQLiteDatabase db)
    {
        ContentValues cv=new ContentValues();
        cv.put(Contract.Orders.COL_ID,i);
        cv.put(Contract.Orders.COL_NAME,n);
        cv.put(Contract.Orders.COL_CITY,c);
        cv.put(Contract.Orders.COL_PHONENO,p);
        cv.put(Contract.Orders.COL_EMAIL,e);
        cv.put(Contract.Orders.COL_ADDRESS,a);
        cv.put(Contract.Orders.COL_DATE,d);
        cv.put(Contract.Orders.COL_SUBTOTAL,s);
        db.insert(Contract.Orders.TABLE_NAME,null,cv);
    }
    public void addCart(String i,String n,int t,String p,int pic,SQLiteDatabase db)
    {
        ContentValues cv=new ContentValues();
        cv.put(Contract.CartItems.COL_ID,i);
        cv.put(Contract.CartItems.COL_NAME,n);
        cv.put(Contract.CartItems.COL_TOTAL,t);
        cv.put(Contract.CartItems.COL_PRICE,p);
        cv.put(Contract.CartItems.COL_PIC,pic);
        db.insert(Contract.CartItems.TABLE_NAME,null,cv);
    }
    public void addOrderItems(String i,String n,int t,String p,String c,SQLiteDatabase db)
    {
        ContentValues cv=new ContentValues();
        cv.put(Contract.OrderItems.COL_ID,i);
        cv.put(Contract.OrderItems.COL_NAME,n);
        cv.put(Contract.OrderItems.COL_TOTAL,t);
        cv.put(Contract.OrderItems.COL_PRICE,p);
        cv.put(Contract.OrderItems.COL_COUNT,c);
        db.insert(Contract.OrderItems.TABLE_NAME,null,cv);
    }


    public void updateCart(String Id,int t,SQLiteDatabase database)
    {
        ContentValues cv=new ContentValues();
        cv.put(Contract.CartItems.COL_TOTAL,t);
        database.update(Contract.CartItems.TABLE_NAME, cv,  "ItemId=?", new String[]{Id});

    }
    public void updateOrder(String Id,String n,SQLiteDatabase database)
    {
        ContentValues cv=new ContentValues();
        cv.put(Contract.Orders.COL_NAME,n);
        database.update(Contract.Orders.TABLE_NAME, cv,  "orderID=?", new String[]{Id});

    }

    public void updateOrderItems(String Id,String n,SQLiteDatabase database)
    {
        ContentValues cv=new ContentValues();
        cv.put(Contract.OrderItems.COL_NAME,n);
        database.update(Contract.OrderItems.TABLE_NAME, cv,  "ItemID=?", new String[]{Id});

    }
    public void Delete(String Id,SQLiteDatabase database)
    {
        database.delete(Contract.CartItems.TABLE_NAME,"id=?",new String[]{Id});

    }


    public void SetValues1(SQLiteDatabase db)
    {

        ContentValues cv=new ContentValues();
        cv.put(Contract.Shopping.COL_ID,"imgj1");
        cv.put(Contract.Shopping.COL_NAME,"Multi Pack Studs");
        cv.put(Contract.Shopping.COL_PRICE,"Rs.699");
        cv.put(Contract.Shopping.COL_CODE,"J0022ET-FRE-GDN");
        cv.put(Contract.Shopping.COL_QUANTITY,"10");
        cv.put(Contract.Shopping.COL_DETAILS,"6 pairs of studs in different designs \n" +"Color: Gold");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        db.insert(Contract.Shopping.TABLE_NAME,null,cv);


        cv.put(Contract.Shopping.COL_ID,"imgj2");
        cv.put(Contract.Shopping.COL_NAME,"Stone Earrings");
        cv.put(Contract.Shopping.COL_PRICE,"Rs.899");
        cv.put(Contract.Shopping.COL_CODE,"J0044ER-FRE-BLU");
        cv.put(Contract.Shopping.COL_QUANTITY,"10");
        cv.put(Contract.Shopping.COL_DETAILS,"Long drop earrings with colored stones\n" + "Color: Blue");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        db.insert(Contract.Shopping.TABLE_NAME,null,cv);


        cv.put(Contract.Shopping.COL_ID,"imgj3");
        cv.put(Contract.Shopping.COL_NAME,"Chain Earrings");
        cv.put(Contract.Shopping.COL_PRICE,"Rs.799");
        cv.put(Contract.Shopping.COL_CODE,"J0066ER-FRE-WHT");
        cv.put(Contract.Shopping.COL_QUANTITY,"10");
        cv.put(Contract.Shopping.COL_DETAILS,"Semicircular stud earrings with pearl stone and hanging chain\n" +
                "Color: White and Gold");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        db.insert(Contract.Shopping.TABLE_NAME,null,cv);


        cv.put(Contract.Shopping.COL_ID,"imgj4");
        cv.put(Contract.Shopping.COL_NAME,"Leaf Earrings");
        cv.put(Contract.Shopping.COL_PRICE,"Rs.999");
        cv.put(Contract.Shopping.COL_CODE,"J0060ER-FRE-GDN");
        cv.put(Contract.Shopping.COL_QUANTITY,"10");
        cv.put(Contract.Shopping.COL_DETAILS,"Dangling earrings with metallic leaves and pearls\n" +
                "Color: Gold");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        db.insert(Contract.Shopping.TABLE_NAME,null,cv);


        cv.put(Contract.Shopping.COL_ID,"imgj5");
        cv.put(Contract.Shopping.COL_NAME,"Square Chain Earrings");
        cv.put(Contract.Shopping.COL_PRICE,"Rs.899");
        cv.put(Contract.Shopping.COL_CODE,"J0058ER-FRE-GDN");
        cv.put(Contract.Shopping.COL_QUANTITY,"10");
        cv.put(Contract.Shopping.COL_DETAILS,"Square stud earrings with hanging chains and metallic balls\n" +
                "Color: Gold");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        db.insert(Contract.Shopping.TABLE_NAME,null,cv);

        cv.put(Contract.Shopping.COL_ID,"imgj6");
        cv.put(Contract.Shopping.COL_NAME,"Beaded Earrings");
        cv.put(Contract.Shopping.COL_PRICE,"Rs.799");
        cv.put(Contract.Shopping.COL_CODE,"J0048ER-FRE-WHT");
        cv.put(Contract.Shopping.COL_QUANTITY,"10");
        cv.put(Contract.Shopping.COL_DETAILS,"Drop earrings with colored beads and pearls\n" +
                "Color: White");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        db.insert(Contract.Shopping.TABLE_NAME,null,cv);

        cv.put(Contract.Shopping.COL_ID,"imgj7");
        cv.put(Contract.Shopping.COL_NAME,"Circular Drop Earrings");
        cv.put(Contract.Shopping.COL_PRICE,"Rs.999");
        cv.put(Contract.Shopping.COL_CODE,"J0047ER-FRE-GDN");
        cv.put(Contract.Shopping.COL_QUANTITY,"10");
        cv.put(Contract.Shopping.COL_DETAILS,"Long drop earrings with circular metallic discs and stones\n" +
                "Color: Gold");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        db.insert(Contract.Shopping.TABLE_NAME,null,cv);

        cv.put(Contract.Shopping.COL_ID,"imgj8");
        cv.put(Contract.Shopping.COL_NAME,"Beaded Hoops");
        cv.put(Contract.Shopping.COL_PRICE,"Rs.799");
        cv.put(Contract.Shopping.COL_CODE,"JJ0061ER-FRE-RED");
        cv.put(Contract.Shopping.COL_QUANTITY,"10");
        cv.put(Contract.Shopping.COL_DETAILS,"Basic hoop earrings with hanging beads on bottom\n" +
                "Color: Gold and Red");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        db.insert(Contract.Shopping.TABLE_NAME,null,cv);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}



