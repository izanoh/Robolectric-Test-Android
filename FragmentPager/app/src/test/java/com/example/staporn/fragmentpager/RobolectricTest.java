package com.example.staporn.fragmentpager;

import android.support.v4.app.FragmentActivity;
import android.widget.ListView;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.util.ActivityController;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.robolectric.util.FragmentTestUtil.startFragment;

/**
 * Created by staporn on 6/3/2015 AD.
 */
@RunWith(CustomRobolectricRunner.class)
public class RobolectricTest {

    private static final String FRAGMENT_TAG = "fragment";

    private ActivityController controller;
    private FragmentActivity activity;
   // private Fragment fragment;

    @Test
    public void OneFragmentNotNull() throws Exception{
        OneFragment fragment = new OneFragment();
        startFragment(fragment);
        assertNotNull(fragment);
    }

    @Test
    public void TwoFragmentNotNull() throws Exception{
        TwoFragment fragment = new TwoFragment();
        startFragment(fragment);
        assertNotNull(fragment);
    }

    @Test
    public void OneFragmentCheck() throws Exception{
        OneFragment onefragment = new OneFragment();
        startFragment(onefragment, MainActivity.class);
        assertNotNull(onefragment);

        ListView listview = (ListView) onefragment.getActivity().findViewById(R.id.FragmentoneList1);
        assertEquals((String)listview.getItemAtPosition(0),"a");
         assertEquals((String) listview.getItemAtPosition(1), "b");

        TextView textView = (TextView) onefragment.getActivity().findViewById(R.id.tvFragmentOne);

        listview.performItemClick(listview.getAdapter().getView(0, null, null)
                , 0, listview.getItemIdAtPosition(0));
        assertEquals(textView.getText().toString(), (String) listview.getItemAtPosition(0));

        listview.performItemClick(listview.getAdapter().getView(1, null, null)
                , 1, listview.getItemIdAtPosition(1));
        assertEquals(textView.getText().toString(), (String) listview.getItemAtPosition(1));
    }

    @Test
    public void TwoFragmentCheck() throws Exception{
        TwoFragment twofragment = new TwoFragment();
        startFragment(twofragment, MainActivity.class);
        assertNotNull(twofragment);

        ListView listview = (ListView) twofragment.getActivity().findViewById(R.id.FragmentoneList2);
        assertEquals((String)listview.getItemAtPosition(0),"1");
        assertEquals((String) listview.getItemAtPosition(1), "2");

        TextView textView = (TextView) twofragment.getActivity().findViewById(R.id.tvFragmentTwo);

        listview.performItemClick(listview.getAdapter().getView(0, null, null)
                , 0, listview.getItemIdAtPosition(0));
        assertEquals(textView.getText().toString(), (String) listview.getItemAtPosition(0));

        listview.performItemClick(listview.getAdapter().getView(1, null, null)
                , 1, listview.getItemIdAtPosition(1));
        assertEquals(textView.getText().toString(), (String) listview.getItemAtPosition(1));
    }

}
