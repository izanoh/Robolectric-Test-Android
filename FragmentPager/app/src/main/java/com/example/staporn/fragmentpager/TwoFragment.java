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
public class TwoFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        final ListView listView = (ListView) view.findViewById(R.id.FragmentoneList2);
        final TextView textView = (TextView) view.findViewById(R.id.tvFragmentTwo);

        String[] txtList = new String[]{"1","2"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getActivity(),android.R.layout.simple_list_item_2,android.R.id.text2,txtList);

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