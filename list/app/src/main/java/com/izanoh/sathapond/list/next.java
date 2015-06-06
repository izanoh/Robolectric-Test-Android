package com.izanoh.sathapond.list;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by staporn on 5/29/2015 AD.
 */
public class next extends Activity {

    ListView listView;
    String KeyA ;
    TextView textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next);

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){ KeyA = bundle.getString("KeyA");}

        textview = (TextView) findViewById(R.id.textView);
        textview.setText(KeyA);

       JsonListItem jsonListItem = new JsonListItem();


        int[] ID = new int[]{1,2};

        // next Choose
        listView = (ListView) findViewById(R.id.list);

        String[] textlist = new String[]{"1","2"};
//        List<JsonItem> listItem = (KeyA.equals("a")? jsonListItem.itemListA : jsonListItem.itemListB);
//        List<String> textlist = new LinkedList<>();
//        for (JsonItem jsonItem : listItem) {
//            textlist.add(jsonItem.id+"");
//        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_2,android.R.id.text2,textlist);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.i("int :",position+"");
                //int item = Integer.parseInt(adapter.getItem(position));
                Intent intent = new Intent(next.this,endPage.class);
                intent.putExtra("KeyA",KeyA);
                //intent.putExtra("KeyB",item);
                intent.putExtra("KeyB",position+1);

                startActivity(intent);

            }
        });
    }
}
