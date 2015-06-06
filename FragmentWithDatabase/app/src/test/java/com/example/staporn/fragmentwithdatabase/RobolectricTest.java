package com.example.staporn.fragmentwithdatabase;

import android.app.Activity;
import android.content.Intent;
import android.widget.ListView;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.robolectric.Robolectric.shadowOf;
import static org.robolectric.util.FragmentTestUtil.startFragment;

/**
 * Created by staporn on 6/4/2015 AD.
 */

@RunWith(CustomRobolectricRunner.class)
public class RobolectricTest {

    @Test
    public void MainActivityNotNull() throws Exception{
        Activity activity = Robolectric.setupActivity(MainActivity.class);
        assertNotNull(activity);
    }

    @Test
    public void MyFragmentNotNull() throws Exception{
        MyFragment myFragmentCartoon = new MyFragment().init("Cartoon");
        startFragment(myFragmentCartoon, MainActivity.class);
        assertNotNull(myFragmentCartoon);

        MyFragment myFragmentBook = new MyFragment().init("Book");
        startFragment(myFragmentBook, MainActivity.class);
        assertNotNull(myFragmentBook);
    }

    @Test
    public void MyFragementListCartoonGetTextCorrect(){
        MyFragment myFragmentCartoon = new MyFragment().init("Cartoon");
        startFragment(myFragmentCartoon, MainActivity.class);
        assertNotNull(myFragmentCartoon);

        ListView listView = (ListView) myFragmentCartoon.getView().findViewById(R.id.FragmentoneList1);

        DBHelper dbHelper = new DBHelper(myFragmentCartoon.getActivity());

        List<String> ListCartoon = dbHelper.getBookList("Cartoon");
        assertNotNull(ListCartoon);

        assertEquals(listView.getCount(), ListCartoon.size());

        for (int i = 0; i < listView.getCount(); i++) {
            assertEquals( ListCartoon.get(i),listView.getItemAtPosition(i));
        }

    }

    @Test
    public void MyFragementLisBookGetTextCorrect(){
        MyFragment myFragmentBook = new MyFragment().init("Book");
        startFragment(myFragmentBook, MainActivity.class);
        assertNotNull(myFragmentBook);

        ListView listView = (ListView) myFragmentBook.getView().findViewById(R.id.FragmentoneList1);

        DBHelper dbHelper = new DBHelper(myFragmentBook.getActivity());

        List<String> ListBook = dbHelper.getBookList("Book");
        assertNotNull(ListBook);

       // assertEquals(listView.getCount(), ListBook.size());

        for (int i = 0; i < listView.getCount(); i++) {
            assertEquals( ListBook.get(i),listView.getItemAtPosition(i));
        }
    }

    @Test
    public void PassingCartoonParameterToDetail(){
        MyFragment myFragmentCartoon = new MyFragment().init("Cartoon");
        startFragment(myFragmentCartoon, MainActivity.class);

        ListView listView = (ListView) myFragmentCartoon.getActivity().findViewById(R.id.FragmentoneList1);

            listView.performItemClick(listView.getAdapter().getView(0, null, null), 0, listView.getItemIdAtPosition(0));
            Intent intent = shadowOf(myFragmentCartoon.getActivity()).getNextStartedActivity();
            String NAME =intent.getStringExtra("Name");
            assertEquals(listView.getItemAtPosition(0),NAME);

    }

    @Test
    public void PassingBookParameterToDetail(){
        MyFragment myFragmentCartoon = new MyFragment().init("Book");
        startFragment(myFragmentCartoon, MainActivity.class);

        ListView listView = (ListView) myFragmentCartoon.getActivity().findViewById(R.id.FragmentoneList1);

            listView.performItemClick(listView.getAdapter().getView(0, null, null), 0, listView.getItemIdAtPosition(0));
            Intent intent = shadowOf(myFragmentCartoon.getActivity()).getNextStartedActivity();
            String NAME =intent.getStringExtra("Name");
            assertEquals(listView.getItemAtPosition(0),NAME);

    }

    @Test
    public void GetCartoonParameterToDetail(){
        Intent intent = new Intent(Robolectric.application,MydetailActivity.class);
        intent.putExtra("Name", "CONAN");

        MydetailActivity mydetailActivity = Robolectric.buildActivity(MydetailActivity.class)
                .withIntent(intent).create().get();
        TextView textView =(TextView) mydetailActivity.findViewById(R.id.tvDetail);
        Intent intent1 = mydetailActivity.getIntent();

        assertEquals(textView.getText().toString(),intent1.getStringExtra("Name"));

    }

    @Test
    public void GetBookParameterToDetail(){
        Intent intent = new Intent(Robolectric.application,MydetailActivity.class);
        intent.putExtra("Name", "GONE GIRL");

        MydetailActivity mydetailActivity = Robolectric.buildActivity(MydetailActivity.class)
                .withIntent(intent).create().get();
        TextView textView =(TextView) mydetailActivity.findViewById(R.id.tvDetail);
        Intent intent1 = mydetailActivity.getIntent();

        assertEquals(textView.getText().toString(),intent1.getStringExtra("Name"));

    }
}
