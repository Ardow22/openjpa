package org.apache.openjpa.lib.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringUtilTest {

    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    //-----------Casi di test per il metodo Split derivati dalla Boundary Value Analysis-------------------------------
    @Test
    public void testValidSplit() {
        String str = "Questaèunafrase";
        String token = "Questa";
        int max = 0;
        String[] expected = {"", "èunafrase"};
        String[] actual = StringUtil.split(str, token, max);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test1() {
        String str = "stringa";
        String token = null;
        int max = 0;
        assertThrows(IllegalArgumentException.class, ()->StringUtil.split(str, token, max));
    }

    @Test
    public void test2() {
        String str = "stringa";
        String token = "";
        int max = 0;
        assertThrows(IllegalArgumentException.class, ()->StringUtil.split(str, token, max));
    }

    @Test
    public void test3() {
        String str = "Questaèunafrase";
        String token = "Questa";
        int max = 1;
        String[] expected = {"Questaèunafrase"};
        String[] actual = StringUtil.split(str, token, max);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test4() {
        String str = null;
        String token = "stringa";
        int max = 0;
        String[] expected = EMPTY_STRING_ARRAY;
        String[] actual = StringUtil.split(str, token, max);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test5() {
        String str = "";
        String token = "stringa";
        int max = 0;
        String[] expected = EMPTY_STRING_ARRAY;
        String[] actual = StringUtil.split(str, token, max);
        assertArrayEquals(expected, actual);
    }
//------------------Casi di test per migliorare la Statement coverage, Branch coverage, Mutation coverage e Data Flow coverage------------------------------
    @Test
    public void newTestSplitTokenLast() {
        String str = "c+I+A+O+";
        String token = "+";
        int max = Integer.MAX_VALUE;
        String[] expected = {"c", "I", "A", "O", ""};
        String[] actual = StringUtil.split(str, token, max);
        assertArrayEquals(expected, actual);
    }

//---------------Casi di test per stripEnd derivati dalla boundary value analysis---------------------------------------
    @Test
    public void test6() {
        String str = "!";
        String stripchars = "";
        String expected = "!";
        String actual = StringUtil.stripEnd(str, stripchars);
        assertEquals(expected, actual);
    }

    @Test
    public void test7() {
        String str = null;
        String stripchars = "!";
        String expected = null;
        String actual = StringUtil.stripEnd(str, stripchars);
        assertEquals(expected, actual);
    }

    @Test
    public void test8() {
        String str = "";
        String stripchars = "!";
        String expected = "";
        String actual = StringUtil.stripEnd(str, stripchars);
        assertEquals(expected, actual);
    }

    @Test
    public void test9() {
        String str = "!";
        String stripchars = null;
        String expected = "!";
        String actual = StringUtil.stripEnd(str, stripchars);
        assertEquals(expected, actual);
    }

    @Test
    public void test10() {
        String str = "!";
        String stripchars = "";
        String expected = "!";
        String actual = StringUtil.stripEnd(str, stripchars);
        assertEquals(expected, actual);
    }

    @Test
    public void test11() {
        String str = "!";
        String stripchars = "!!";
        String expected = "";
        String actual = StringUtil.stripEnd(str, stripchars);
        assertEquals(expected, actual);
    }
//----------------Casi di test per migliorare Statement Coverage, Branch Coverage e Mutation Coverage------------------
    @Test
    public void NewTest12() {
        String str = " ";
        String stripchars = null;
        String expected = "";
        String actual = StringUtil.stripEnd(str, stripchars);
        assertEquals(expected, actual);
    }
//---------------Casi di test per migliorare Data Flow Coverage-----------------------------------------
    @Test
    public void newTest13() {
        String str = "Hello++";
        String stripchars = "++";
        String actual = StringUtil.stripEnd(str, stripchars);
        assertEquals(expected, actual);
    }
}
