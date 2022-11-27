package org.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplementsTest {

    private final StringListImplements stringListImplements = new StringListImplements();

    @Test
    public void StringListImplementsAddTestNoIndex() {
        String item = "Вася";
        String[] stringList = {item};
        assertEquals(stringList[0], stringListImplements.add(item));
    }

    @Test
    void StringListImplementsAddTestWithIndex() {
        String item = "Вася";
        String[] stringList = new String[5];
        stringList[0] = item;
        assertEquals(stringList[0], stringListImplements.add(0, item));
    }

    @Test
    void StringListImplementsSetTest() {
        String item = "One";
        String[] stringList = {"Two", "Two", "Thee", "Four"};
        stringList[0] = item;
        assertEquals(stringList[0], stringListImplements.set(0, "One"));
    }

    @Test
    void StringListImplementsRemoveItemTest() {
        stringListImplements.add("One");
        stringListImplements.remove(0);
        assertEquals(stringListImplements.size(),0);
    }

    @Test
    void StringListImplementsRemoveIndexTest() {
        stringListImplements.add("One");
        stringListImplements.add("Two");
        stringListImplements.add("One1");
        stringListImplements.add("Two1");
        stringListImplements.remove("One");
        assertEquals(stringListImplements.size(),3);
    }

    @Test
    void StringListImplementsContainsTest() {
        stringListImplements.add("One");
        stringListImplements.add("Two");
        boolean result = true;
        assertEquals(result, stringListImplements.contains("One"));
    }

    @Test
    void StringListImplementsIndexOfTest() {
        stringListImplements.add("One");
        stringListImplements.add("Two");
        assertEquals(stringListImplements.indexOf("One"), 0);
    }

    @Test
    void StringListImplementsLastIndexOfTest() {
        stringListImplements.add("One");
        stringListImplements.add("Two");
        assertEquals(stringListImplements.indexOf("One"), 0);
    }

    @Test
    void StringListImplementsGetToIndexTest() {
        stringListImplements.add("One");
        stringListImplements.add("Two");
        assertEquals(stringListImplements.get(0), "One");
    }

    @Test
    void StringListImplementsEqualsTest() {
        StringListImplements stringListImplements1 = new StringListImplements();
        assertTrue(stringListImplements.equals(stringListImplements1));
    }

    @Test
    void StringListImplementsSizeTest() {
        stringListImplements.add("One");
        stringListImplements.add("Two");
        assertEquals(stringListImplements.size(), 2);
    }

    @Test
    void StringListImplementsTsEmptyTest() {
        stringListImplements.add("One");
        stringListImplements.add("Two");
        boolean meaning = false;
        assertEquals(meaning,stringListImplements.isEmpty());
    }

    @Test
    void StringListImplementsClearTest() {
        stringListImplements.add("One");
        stringListImplements.add("Two");
        stringListImplements.clear();
        assertEquals(stringListImplements.size(), 0);
    }

    @Test
    void StringListImplementsToArrayTest() {
        stringListImplements.add("One");
        int size = stringListImplements.toArray().length;
        assertEquals(stringListImplements.size(), size);
    }
}