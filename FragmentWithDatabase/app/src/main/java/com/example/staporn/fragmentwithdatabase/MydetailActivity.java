package com.example.staporn.fragmentwithdatabase;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by staporn on 6/5/2015 AD.
 */
public class MydetailActivity extends Activity{
    String TYPE,NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null) {
            NAME = bundle.getString("Name");
        }

//        DBHelper dbHelper = new DBHelper(this);
//        String price = dbHelper.getPriceBook(NAME);

        TextView textView = (TextView) findViewById(R.id.tvDetail);
        textView.setText(NAME);

    }
}
