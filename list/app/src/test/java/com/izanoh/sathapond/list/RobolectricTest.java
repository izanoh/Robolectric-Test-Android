package com.izanoh.sathapond.list;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.robolectric.Robolectric.shadowOf;

@RunWith(CustomRobolectricRunner.class)
public class RobolectricTest {
    @Test
    public void MainCheck() throws Exception{
        //***
        //Check activity is NotNull
        Activity activity = Robolectric.setupActivity(MainActivity.class);
        assertNotNull(activity);

        //***
        //Check ListView is NotNull
        ListView listView = (ListView) activity.findViewById(R.id.selectListView);
        assertNotNull(listView);

        //****
        //Check Text
        String txtA = (String) listView.getItemAtPosition(0);
        assertEquals(txtA,"b");
        String txtB = (String) listView.getItemAtPosition(1);
        assertEquals(txtB,"a");

        //****
        //check when click list will goto next activity   by click a
        listView.performItemClick(listView.getAdapter().getView(0, null, null)
                , 0, listView.getAdapter().getItemId(0));

        Intent intent0 = shadowOf(activity).getNextStartedActivity();
        assertThat(intent0.getComponent().getClassName(),equalTo(next.class.getName()));

        //****
        //check when click list will goto next activity   by click b
        listView.performItemClick(listView.getAdapter().getView(1, null, null)
                , 1, listView.getAdapter().getItemId(1));

        Intent intent1 = shadowOf(activity).getNextStartedActivity();
        assertThat(intent1.getComponent().getClassName(),equalTo(next.class.getName()));
    }

    @Test
    public void nextCheck() throws Exception{
//        assertNotNull(Robolectric.setupActivity(next.class));
//        Activity activity = Robolectric.setupActivity(next.class);
        next next = Robolectric.buildActivity(next.class).create().get();
//        assertNotNull(activity);
        assertNotNull(next);
//        ListView nextListView = (ListView) activity.findViewById(R.id.list);
//        TextView txtFromMain = (TextView) activity.findViewById(R.id.textView);
        ListView nextListView = (ListView) next.findViewById(R.id.list);
        TextView txtFromMain = (TextView) next.findViewById(R.id.textView);

        //****
        //Check List
        assertEquals((String)nextListView.getItemAtPosition(0),"2");
        assertEquals((String) nextListView.getItemAtPosition(1), "2");

        //***
        //Click List
        nextListView.performItemClick(nextListView.getAdapter().getView(0, null, null)
                , 0, nextListView.getAdapter().getItemId(0));
//next -> act
        Intent intent0 = shadowOf(next).getNextStartedActivity();
        assertThat(intent0.getComponent().getClassName(), equalTo(endPage.class.getName()));

        //****
        //check when click list will goto next activity   by click b
        nextListView.performItemClick(nextListView.getAdapter().getView(1, null, null)
                , 1, nextListView.getAdapter().getItemId(1));
//next -> act
        Intent intent1 = shadowOf(next).getNextStartedActivity();
        assertThat(intent1.getComponent().getClassName(), equalTo(endPage.class.getName()));

    }

    @Test
    public void endpageCheck() throws Exception{
        Activity activity = Robolectric.setupActivity(endPage.class);
        assertNotNull(activity);
        Button btrenew = (Button) activity.findViewById(R.id.btRenew);

        btrenew.performClick();
        Intent intent = shadowOf(activity).getNextStartedActivity();
        assertThat(intent.getComponent().getClassName(), equalTo(MainActivity.class.getName()));
     }

	@Test
    public void passingParameterToNext() throws Exception{
        //***
        //Check text when click get namelist to bundle
        Activity activity = Robolectric.setupActivity(MainActivity.class);
        ListView mainListview = (ListView) activity.findViewById(R.id.selectListView);
        String chooseA = (String) mainListview.getItemAtPosition(0);
        mainListview.performItemClick(mainListview.getAdapter().getView(0, null, null)
                , 0, mainListview.getAdapter().getItemId(0));

        Intent intent = shadowOf(activity).getNextStartedActivity();
        String a = intent.getStringExtra("KeyA");
        assertEquals(a,"a");
        
		String ChooseB = (String) mainListview.getItemAtPosition(1);
		mainListview.performItemClick(mainListview.getAdapter().getView(1,null,null)
				, 1, mainListview.getAdapter().getItemId(1));

		intent = shadowOf(activity).getNextStartedActivity();
		String b = intent.getStringExtra("KeyA");
		assertEquals(b,"b");

    }

	 @Test
	 public void getParameterToNext() throws Exception{
		Intent intent = new Intent(Robolectric.application,next.class);
		intent.putExtra("KeyA","a");

		next next = Robolectric.buildActivity(next.class).withIntent(intent).create().get();
        TextView textView = (TextView) next.findViewById(R.id.textView); 

		Intent intent1 = next.getIntent();

		String txtFirst = textView.getText().toString();
		assertNotNull(txtFirst);
		assertEquals(txtFirst,"a");
	 }

	 @Test
	 public void passingParameterToEndpage() throws Exception{
		Intent intent = new Intent(Robolectric.application,next.class);
		intent.putExtra("KeyA","a");

		next next = Robolectric.buildActivity(next.class).withIntent(intent).create().get();
		ListView listView = (ListView) next.findViewById(R.id.list);
		
		listView.performItemClick(listView.getAdapter().getView(0, null, null)
                , 0, listView.getAdapter().getItemId(0));
		
		Intent intent1 = shadowOf(next).getNextStartedActivity();
		int x = intent1.getIntExtra("KeyB", -1);
		assertNotNull(x);
		assertEquals(x+"",listView.getItemAtPosition(0));//    look!!!!
	 }

	 @Test
	 public void getParameterToEndpage() throws Exception {
		String KeyA = "a"; int KeyB = 1;
		Intent intent = new Intent(Robolectric.application,endPage.class);
		intent.putExtra("KeyA",KeyA);
		intent.putExtra("KeyB",KeyB);

		endPage endPage = Robolectric.buildActivity(endPage.class).withIntent(intent).create().get();
		TextView textFirst = (TextView) endPage.findViewById(R.id.textFirst);
		TextView textSecond = (TextView) endPage.findViewById(R.id.textSecond);
		
		Intent intent1 = endPage.getIntent();
		String txtFirst = textFirst.getText().toString();
		String txtSecond = textSecond.getText().toString();
		assertNotNull(txtFirst);
		assertNotNull(txtSecond);
		assertEquals(txtFirst,KeyA);
		assertEquals(txtSecond,KeyB+"");
	 }
}
