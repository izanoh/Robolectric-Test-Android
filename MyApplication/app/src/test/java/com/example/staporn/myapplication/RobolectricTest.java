package com.example.staporn.myapplication;


import android.app.Activity;
import android.widget.ListView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.shadows.ShadowToast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(CustomRobolectricRunner.class)
public class RobolectricTest {

    @Test
    public void IsEmptyList(){
        Activity activity = Robolectric.setupActivity(MainActivity.class);
        assertNotNull(activity);

        ListView list = (ListView) activity.findViewById(R.id.selectListView);
        assertNotNull(list);

        list.performItemClick(list.getAdapter().getView(0, null, null)
                , 0, list.getAdapter().getItemId(0));
        assertEquals(ShadowToast.getTextOfLatestToast(), "one");

//         error // change two -> one
//        list.performItemClick(list.getAdapter().getView(0, null, null)
//                , 0, list.getAdapter().getItemId(0));
//        assertEquals(ShadowToast.getTextOfLatestToast(), "two");



    }
}


