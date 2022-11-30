package org.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplementsTest {

    private final IntegerListImplements stringListImplements = new IntegerListImplements();

    @Test
    public void StringListImplementsAddTestNoIndex() {
        int item = 10;
        Integer[] stringList = {item};
        assertEquals(stringList[0], stringListImplements.add(item));
    }

    @Test
    void StringListImplementsAddTestWithIndex() {
        int item = 10;
        int[] stringList = new int[5];
        stringList[0] = item;
        assertEquals(stringList[0], stringListImplements.add(0, item));
    }

    @Test
    void StringListImplementsSetTest() {
        int item = 5;
        int[] stringList = {1, 2, 3, 4};
        stringList[0] = item;
        assertEquals(stringList[0], stringListImplements.set(0, 5));
    }

    @Test
    void StringListImplementsRemoveItemTest() {
        stringListImplements.add(5);
        stringListImplements.remove(0);
        assertEquals(stringListImplements.size(),0);
    }

    @Test
    void StringListImplementsRemoveIndexTest() {
        stringListImplements.add(1);
        stringListImplements.add(2);
        stringListImplements.add(3);
        stringListImplements.add(4);
        stringListImplements.remove("1");  //должен убирать не по индексу
        assertEquals(stringListImplements.size(),3);
    }

    @Test
    void StringListImplementsContainsTest() {
        stringListImplements.add(1);
        stringListImplements.add(2);
        boolean result = true;
        assertEquals(result, stringListImplements.contains(1));
    }

    @Test
    void StringListImplementsIndexOfTest() {
        stringListImplements.add(1);
        stringListImplements.add(2);
        assertEquals(stringListImplements.indexOf(1), 0);
    }

    @Test
    void StringListImplementsLastIndexOfTest() {
        stringListImplements.add(1);
        stringListImplements.add(2);
        assertEquals(stringListImplements.indexOf(1), 0);
    }

    @Test
    void StringListImplementsGetToIndexTest() {
        stringListImplements.add(1);
        stringListImplements.add(2);
        assertEquals(stringListImplements.get(0), 1);
    }

    @Test
    void StringListImplementsEqualsTest() {
        IntegerListImplements stringListImplements1 = new IntegerListImplements();
        assertTrue(stringListImplements.equals(stringListImplements1));
    }

    @Test
    void StringListImplementsSizeTest() {
        stringListImplements.add(1);
        stringListImplements.add(2);
        assertEquals(stringListImplements.size(), 2);
    }

    @Test
    void StringListImplementsTsEmptyTest() {
        stringListImplements.add(1);
        stringListImplements.add(2);
        boolean meaning = false;
        assertEquals(meaning,stringListImplements.isEmpty());
    }

    @Test
    void StringListImplementsClearTest() {
        stringListImplements.add(1);
        stringListImplements.add(2);
        stringListImplements.clear();
        assertEquals(stringListImplements.size(), 0);
    }

    @Test
    void StringListImplementsToArrayTest() {
        stringListImplements.add(1);
        int size = stringListImplements.toArray().length;
        assertEquals(stringListImplements.size(), size);
    }
}