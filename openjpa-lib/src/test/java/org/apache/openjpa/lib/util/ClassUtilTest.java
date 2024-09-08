package org.apache.openjpa.lib.util;

import org.junit.Test;
import static org.apache.openjpa.lib.util.ClassUtil.toClass;
import static org.junit.Assert.*;

public class ClassUtilTest {

    //------------Casi di test per GetClassName derivati dalla boundary value analysis-------------------------
    @Test
    public void testValidGetClassName() {
        String fullName = "org.apache.openjpa.lib.util.ClassUtil";
        String expected = "ClassUtil";
        String actual = ClassUtil.getClassName(fullName);
        assertEquals(expected, actual);
    }

    @Test
    public void testInvalidGetClassName() {
        String fullName = "*";
        String expected = "*";
        String actual = ClassUtil.getClassName(fullName);
        assertEquals(expected, actual);
    }

    @Test
    public void testValidGetClassName2() {
        String fullName = "ClassUtil";
        String expected = "ClassUtil";
        String actual = ClassUtil.getClassName(fullName);
        assertEquals(expected, actual);
    }

    @Test
    public void testNullGetClassName() {
        String fullName = null;
        String actual = ClassUtil.getClassName(fullName);
        assertEquals(null, actual);
    }

    @Test
    public void testEmptyGetClassName() {
        String fullname = "";
        String actual = ClassUtil.getClassName(fullname);
        assertEquals("", actual);
    }

    //-------------Casi di test per migliorare Statement coverage e Branch coverage----------------------------------------
    @Test
    public void newTestValidTridimGetClassName() {
        String fullName = "[[[C";
        String expected = "char[][][]";
        String actual = ClassUtil.getClassName(fullName);
        assertEquals(expected, actual);
    }

    @Test
    public void newTestValidUnidimGetClassName() {
        String fullName = "[Ljava.lang.String;";
        String expected = "String[]";
        String actual = ClassUtil.getClassName(fullName);
        assertEquals(expected, actual);
    }

    @Test
    public void newTestValidUniSmallGetClassName() {
        String fullName = "[Ljava.lang.String";
        String expected = "String[]";
        String actual = ClassUtil.getClassName(fullName);
        assertEquals(expected, actual);
    }



//-------------Casi di test per ToClass----------------------------------------


    @Test
    public void testWithInvalidClassName() {
        String str = "ClasseNonEsistente";
        boolean resolve = true;
        ClassLoader loader = getClass().getClassLoader();

        assertThrows(IllegalArgumentException.class, ()->ClassUtil.toClass(str, resolve, loader));
    }

    @Test
    public void testWithValidClassName() {
        String str = "java.lang.String";
        boolean resolve = true;
        ClassLoader loader = getClass().getClassLoader();

        Class<?> clazz = toClass(str, resolve, loader);
        assertEquals(String.class, clazz);
    }

    @Test
    public void testWithPrimitiveType() {
        String str = "int";
        boolean resolve = true;
        ClassLoader loader = getClass().getClassLoader();

        Class<?> clazz = toClass(str, resolve, loader);
        assertEquals(int.class, clazz);
    }


    @Test
    public void testWithNullString() {
        String str = null;
        boolean resolve = true;
        ClassLoader loader = getClass().getClassLoader();

        assertThrows(NullPointerException.class, ()->ClassUtil.toClass(str, resolve, loader));
    }

    @Test
    public void testWithEmptyStringAndFalseResolve() {
        String str = "";
        boolean resolve = false;
        ClassLoader loader = getClass().getClassLoader();

        assertThrows(IllegalArgumentException.class, ()->ClassUtil.toClass(str, resolve, loader));
    }

    @Test
    public void testWithLoaderNull() {
        String str = "java.lang.String";
        boolean resolve = false;
        ClassLoader loader = null;

        Class<?> clazz = toClass(str, resolve, loader);
        assertEquals(String.class, clazz);
    }

    private static class ErrorClassLoader extends ClassLoader{
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            return null;
        }
    }

    @Test
    public void testWithInvalidLoader() {
        String str = "java.lang.String";
        boolean resolve = false;
        ClassLoader loader = new ErrorClassLoader();

        assertThrows(IllegalArgumentException.class, ()->ClassUtil.toClass(str, resolve, loader));
    }
//------------------------Casi di test per migliorare Statement, Branch e Mutation Coverage---------------------------------------------------

    @Test
    public void newTest() {
        String str = "org.apache.openjpa.lib.util.ClassUtilTest[]"; // Rappresenta un array di int
        boolean resolve = true;
        ClassLoader loader = getClass().getClassLoader();

        Class<?> clazz = toClass(str, resolve, loader);
        assertEquals(new ClassUtilTest[0].getClass(), clazz);
    }


}
