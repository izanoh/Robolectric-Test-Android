package com.example.staporn.myapplication1;


import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

@RunWith(CustomRobolectricRunner.class)
public class RobolectricTest {

    @Test
    public void NotNull() {
        Activity activity = Robolectric.setupActivity(MainActivity.class);
        assertNotNull(activity);
    }


    @Test
    public void testIt() {
        Activity activity = Robolectric.setupActivity(MainActivity.class);

        TextView results =
                (TextView) activity.findViewById(R.id.textView1);
        String resultsText = results.getText().toString();

        // failing test gives much better feedback
        // to show that all works correctly ;)
        assertThat(resultsText, equalTo("Hello World"));

    }

    @Test
    public void testButton1Click() throws Exception{
        Activity activity = Robolectric.setupActivity(MainActivity.class);
        Button bt = (Button) activity.findViewById(R.id.btOne);
        assertNotNull(bt);
        bt.performClick();
        assertEquals(bt.getText().toString(), "1");
        TextView results =
                (TextView) activity.findViewById(R.id.resultBox);
        String resultsBox = results.getText().toString();
        assertEquals(resultsBox, "1");

    }

    @Test
    public void testButton2Click() throws Exception{
        Activity activity = Robolectric.setupActivity(MainActivity.class);
        Button bt = (Button) activity.findViewById(R.id.btTwo);
        assertNotNull(bt);
        bt.performClick();
        assertEquals(bt.getText().toString(), "2");
        TextView results =
                (TextView) activity.findViewById(R.id.resultBox);
        String resultsBox = results.getText().toString();
        assertEquals(resultsBox, "2");

    }

    @Test
    public void testButton3Click() throws Exception{
        Activity activity = Robolectric.setupActivity(MainActivity.class);
        Button bt = (Button) activity.findViewById(R.id.btThree);
        assertNotNull(bt);
        bt.performClick();
        assertEquals(bt.getText().toString(), "3");
        TextView results =
                (TextView) activity.findViewById(R.id.resultBox);
        String resultsBox = results.getText().toString();
        assertEquals(resultsBox, "3");

    }

    @Test
    public void testButton4Click() throws Exception{
        Activity activity = Robolectric.setupActivity(MainActivity.class);
        Button bt = (Button) activity.findViewById(R.id.btFour);
        assertNotNull(bt);
        bt.performClick();
        assertEquals(bt.getText().toString(), "4");
        TextView results =
                (TextView) activity.findViewById(R.id.resultBox);
        String resultsBox = results.getText().toString();
        assertEquals(resultsBox, "4");

    }

}


