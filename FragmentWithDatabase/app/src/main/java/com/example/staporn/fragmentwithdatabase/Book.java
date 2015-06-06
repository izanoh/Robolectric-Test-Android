package com.example.staporn.fragmentwithdatabase;

import android.provider.BaseColumns;

/**
 * Created by staporn on 6/4/2015 AD.
 */
public class Book {
    private int ID;
    private String NAME;
    private String TYPE;
    private double PRICE;

    public Book(){}

    public Book(int id, String name, String type, double price){
        this.ID = id;
        this.NAME = name;
        this.TYPE = type;
        this.PRICE = price;
    }

    public class Column{
        public static final String BOOKID = BaseColumns._ID;
        public static final String BOOKNAME = "book_name";
        public static final String BOOKTYPE = "book_type";
        public static final String BOOKPRICE = "book_price";
    }
}
