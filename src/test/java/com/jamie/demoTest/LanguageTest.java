package com.jamie.demoTest;

import com.jamie.demo.Language;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LanguageTest {

    private Language language = new Language();

    @Test  //this is done to test the get function if you want to test this with the database it would be the mokito test
    void getNameTest(){
        Language getNameTest = new Language("testName");
        assertEquals("testName",getNameTest.getName(), "this test has failed ");
    }

    @Test
    public void test_constructor(){
        assertTrue(language instanceof Language, "its not an instance of language");
    }



}
