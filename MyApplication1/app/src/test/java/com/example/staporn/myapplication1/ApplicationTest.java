package com.example.staporn.myapplication1;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
//@Config(constants = BuildConfig.class)
public class ApplicationTest{

    private MainActivity mActivity;

    /*@Before
    public void setup() throws Exception{
       mActivity = Robolectric.buildActivity(MainActivity.class).create().get();

    }*/

//    @Before
//    public void setup(){
//        mActivity = new MainActivity();
//
//    }

    @Test
    public void checkActivityNotNull() throws Exception{
        //mActivity = Robolectric.buildActivity(MainActivity.class).create().get();
        mActivity = Robolectric.setupActivity(MainActivity.class);
        assertNotNull(mActivity);
    }

/*    @Test
    public void testButtonClick() throws Exception{
        Button bt1 = (Button) mActivity.findViewById(R.id.btOne);
        assertNotNull(bt1);
        bt1.performClick();
        assertEquals(bt1.getText().toString(),"one");
    }*/
}