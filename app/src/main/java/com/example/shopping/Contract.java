package com.example.shopping;
import android.provider.BaseColumns;

public final class Contract {

    public Contract() {}
    /* Inner class that defines the table contents */
    public static abstract class Users implements BaseColumns {

        public static final String TABLE_NAME = "Item_Info";
        public static final String COL_ID = "ItemID";
        public static final String COL_NAME = " Name";
        public static final String COL_PRICE = "Price";
        public static final String COL_CODE = " Code";
        public static final String COL_QUANTITY = "Quantity";
        public static final String COL_DETAILS = "Details";
    }


    public static abstract class Shopping implements BaseColumns
    {
        public static final String TABLE_NAME="Jewellery_INFO";
        public static final String COL_ID="ItemID";
        public static final String COL_NAME="Name";
        public static final String COL_PRICE="Price";
        public static final String COL_CODE="Code";
        public static final String COL_QUANTITY="Quantity";
        public static final String COL_DETAILS="Details";

    }


    public static abstract class Orders implements BaseColumns
    {
        public static final String TABLE_NAME="Orders_INFO";
        public static final String COL_ID="orderID";
        public static final String COL_NAME="Name";
        public static final String COL_CITY="City";
        public static final String COL_PHONENO="Phoneno";
        public static final String COL_EMAIL="Email";
        public static final String COL_ADDRESS="Address";
        public static final String COL_DATE="Date";
        public static final String COL_SUBTOTAL="Subtotal";

    }


    public static abstract class CartItems implements BaseColumns
    {
        public static final String TABLE_NAME="CartItems_INFO";
        public static final String COL_ID="ItemID";
        public static final String COL_NAME="Name";
        public static final String COL_TOTAL="Total";
        public static final String COL_PRICE="Price";
        public static final String COL_PIC="Pic";

    }

    public static abstract class OrderItems implements BaseColumns
    {
        public static final String TABLE_NAME="OrderItems_INFO";
        public static final String COL_ID="ItemID";
        public static final String COL_NAME="Name";
        public static final String COL_TOTAL="Total";
        public static final String COL_PRICE="Price";
        public static final String COL_COUNT="Count";

    }

}
