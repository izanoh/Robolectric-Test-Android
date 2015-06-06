package com.izanoh.sathapond.list;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.selectListView);

        String[] textlist = new String[]{"a","b"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,android.R.id.text1,textlist);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String itemSelect = (String) listView.getItemAtPosition(position);
                Log.i("result",itemSelect);

                    Intent intent = new Intent(MainActivity.this, next.class);
                    intent.putExtra("KeyA",itemSelect);
                    SetupJson();
                    startActivity(intent);
            }
        });
    }

    public void SetupJson(){
        /*try{
            final File dir = new File(Environment.getExternalStorageDirectory()
                    .getAbsolutePath()+"/twoListView/");

            if(!dir.exists())
            {
                dir.mkdirs();
            }

            final File myFile = new File(dir+"output.json");
            if(!myFile.exists())
            {
                myFile.createNewFile();
            }

            JsonListItem jsonListItem = new JsonListItem();
            jsonListItem.genItemListA();
            jsonListItem.genItemListB();

            Writer writer = new OutputStreamWriter(new FileOutputStream(myFile),"UTF8");
            Gson gson = new GsonBuilder().create();
            gson.toJson(jsonListItem, writer);
            writer.close();

        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            Toast.makeText(this, "File not Found", Toast.LENGTH_LONG);
        } catch (UnsupportedEncodingException e) {
            //e.printStackTrace();
            Toast.makeText(this,"Unsupported Encoding",Toast.LENGTH_LONG);
        } catch (IOException e) {
            //e.printStackTrace();
            Toast.makeText(this,"Input Output Error",Toast.LENGTH_LONG);
        }*/
        GenJsonFile.getInstance().genData();
    }

}