package com.izanoh.sathapond.list;

import android.os.Environment;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

/**
 * Created by staporn on 6/3/2015 AD.
 */
public class GenJsonFile {
    private static GenJsonFile ourInstance = new GenJsonFile();

    public static GenJsonFile getInstance() {
        return ourInstance;
    }

    private GenJsonFile() {
    }

    public void genData()
    {
        try{
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
            Log.e("write_file", "File not Found");
        } catch (UnsupportedEncodingException e) {
            //e.printStackTrace();
            Log.e("write_file", "Unsupported Encoding");
        } catch (IOException e) {
            //e.printStackTrace();
            Log.e("write_file", "Input Output Error");
        }
    }
}
