package com.cimakasky.songr;

import org.junit.Test;

import static org.junit.Assert.*;

public class UpperCaseTest {

    @Test
    public void testCapitalize(){
        UpperCase testCapitalize = new UpperCase();

        assertEquals("HEY THERE", testCapitalize.toUpperCase("Hey There"));
        assertEquals("THIS IS CAPITALIZED", testCapitalize.toUpperCase("this is capitalized"));
        assertNotEquals("all lowercase", testCapitalize.toUpperCase("all lowercase"));
    }
}
