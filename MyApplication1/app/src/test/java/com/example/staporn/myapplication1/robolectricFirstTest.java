package com.example.staporn.myapplication1;

/**
 * Created by staporn on 5/28/2015 AD.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(RobolectricTestRunner.class)

public class robolectricFirstTest {
    @Test
    public void testIt() {
        // failing test gives much better feedback
        // to show that all works correctly ;)
        assertThat(Robolectric.application, notNullValue());
    }
}
