package com.izanoh.sathapond.list;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

/**
 * Created by staporn on 5/29/2015 AD.
 */
public class endPage extends Activity {
    Button button;
    TextView first,second,merge;

    String KeyA ;
    int KeyB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endpage);

//        passing from next.class
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            KeyA = bundle.getString("KeyA");
            KeyB = bundle.getInt("KeyB");
        }

        first = (TextView) findViewById(R.id.textFirst);
        second = (TextView) findViewById(R.id.textSecond);
        merge = (TextView) findViewById(R.id.textMerge);

        first.setText(KeyA);
        second.setText(KeyB+"");

        if(true) GenJsonFile.getInstance().genData();
//        get from .json
        final File dir = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath()+"/twoListView/");
        final File myFile = new File(dir+"output.json");
        try {
            Gson gson = new Gson();
            Reader reader = new InputStreamReader(new FileInputStream(myFile));

            JsonListItem jsonListItem = gson.fromJson(reader,JsonListItem.class);

            List<JsonItem> listItem = (KeyA == "a" ? jsonListItem.itemListA : jsonListItem.itemListB);
            for (JsonItem jsonItem : listItem) {
                if(KeyB == jsonItem.id)
                    merge.setText(jsonItem.detail);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        button = (Button) findViewById(R.id.btRenew);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(endPage.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}