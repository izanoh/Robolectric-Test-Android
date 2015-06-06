package com.example.staporn.fragmentwithdatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by staporn on 6/4/2015 AD.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_PATH = Environment.getExternalStorageDirectory()
            .getAbsolutePath()+"/FragmentDataBase/DB_Book.db";
    public static final String DATABASE_NAME ="DB_Book.db";
    public static final int DATABASE_VERSION = 2;
    public static final String TABLE = "book";

    private final String TAG = getClass().getSimpleName();

    private  SQLiteDatabase sqLiteDatabase;

    public DBHelper(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BOOK_TABLE = String.format("CREATE TABLE %s ( %s INTEGER PRIMARY " +
                        "KEY AUTOINCREMENT , %s TEXT , %s TEXT , %s TEXT )",
                TABLE,
                Book.Column.BOOKID,
                Book.Column.BOOKNAME,
                Book.Column.BOOKTYPE,
                Book.Column.BOOKPRICE);

        Log.i(TAG, CREATE_BOOK_TABLE);

        db.execSQL(CREATE_BOOK_TABLE);

        insertData(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion < newVersion) {
            String DROP_BOOK_TABLE = "DROP TABLE IF EXISTS " + TABLE;

            db.execSQL(DROP_BOOK_TABLE);

            Log.i(TAG, "Upgrade Database from " + oldVersion + " to " + newVersion);

            onCreate(db);
        }
    }

    public List<String> getBookList(String filter){
        List<String> book = new ArrayList<String>();

        sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(TABLE, null, null, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        while (!cursor.isAfterLast()){
            if(filter.equalsIgnoreCase(cursor.getString(2))) {
                        book.add(cursor.getString(1));
            }

            cursor.moveToNext();
        }

        sqLiteDatabase.close();

        return book;
    }

    public void insertData(SQLiteDatabase db){
        db.execSQL("INSERT INTO "+TABLE+" ( "+Book.Column.BOOKID+","+Book.Column.BOOKNAME+
                ","+Book.Column.BOOKTYPE+ ","+Book.Column.BOOKPRICE+") " +
                "VALUES ('1','ONEPIECE','CARTOON','50$');");
        db.execSQL("INSERT INTO "+TABLE+" ( "+Book.Column.BOOKID+","+Book.Column.BOOKNAME+
                ","+Book.Column.BOOKTYPE+ ","+Book.Column.BOOKPRICE+") " +
                "VALUES ('2','CONAN','CARTOON','45$');");
        db.execSQL("INSERT INTO "+TABLE+" ( "+Book.Column.BOOKID+","+Book.Column.BOOKNAME+
                ","+Book.Column.BOOKTYPE+ ","+Book.Column.BOOKPRICE+") " +
                "VALUES ('3','FAIRY TAIL','CARTOON','55$');");
        db.execSQL("INSERT INTO "+TABLE+" ( "+Book.Column.BOOKID+","+Book.Column.BOOKNAME+
                ","+Book.Column.BOOKTYPE+ ","+Book.Column.BOOKPRICE+") " +
                "VALUES ('4','GONE GIRL','BOOK','335$');");
        db.execSQL("INSERT INTO "+TABLE+" ( "+Book.Column.BOOKID+","+Book.Column.BOOKNAME+
                ","+Book.Column.BOOKTYPE+ ","+Book.Column.BOOKPRICE+") " +
                "VALUES ('5','BEFORE I GO TO SLEEP','BOOK','280$');");

    }
}
