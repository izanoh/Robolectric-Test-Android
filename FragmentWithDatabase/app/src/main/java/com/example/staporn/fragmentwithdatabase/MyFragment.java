package com.example.staporn.fragmentwithdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by staporn on 6/3/2015 AD.
 */
public class MyFragment extends android.support.v4.app.Fragment {

    String Filter;

    public MyFragment init(String filter)
    {
        this.Filter = filter;
        return this;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one, container, false);

        final ListView listView = (ListView) view.findViewById(R.id.FragmentoneList1);

        TextView textView = (TextView) view.findViewById(R.id.Type);
        textView.setText(Filter);

        DBHelper dbHelper = new DBHelper(view.getContext());

        List<String> Cartoon = dbHelper.getBookList(Filter);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getActivity(),android.R.layout.simple_list_item_1,android.R.id.text1,Cartoon);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity().getApplication(),MydetailActivity.class);
                intent.putExtra("Name",(String)listView.getItemAtPosition(position));
                startActivity(intent);
            }
        });

        return view;
    }
}