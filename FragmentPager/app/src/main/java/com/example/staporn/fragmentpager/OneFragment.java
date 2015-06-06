package com.example.staporn.fragmentpager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by staporn on 6/3/2015 AD.
 */
public class OneFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        final ListView listView = (ListView) view.findViewById(R.id.FragmentoneList1);
        final TextView textView = (TextView) view.findViewById(R.id.tvFragmentOne);

        String[] txtList = new String[]{"a","b"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getActivity(),android.R.layout.simple_list_item_1,android.R.id.text1,txtList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String txtResult = (String) listView.getItemAtPosition(position);
                textView.setText(txtResult);
            }
        });

        return view;
    }
}