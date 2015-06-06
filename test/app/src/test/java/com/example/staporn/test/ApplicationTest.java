package com.example.staporn.test;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */

//public class ApplicationTest extends ApplicationTestCase<Application> {
//    public ApplicationTest() {
//        super(Application.class);
//    }
//}
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertNotNull;

//import org.robolectric.annotation.*;


@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)

public class ApplicationTest{
    private MainActivity mActivity;

    @Before
    public void setup()throws Exception {
        mActivity = Robolectric.buildActivity(MainActivity.class)
                .create().get();
    }

    @Test
    public void checkNotNull()throws Exception{
        assertNotNull(mActivity);
    }


}

