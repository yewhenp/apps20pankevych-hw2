package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    private final ImmutableArrayList list = new ImmutableArrayList();

    @Test
    public void testAddLast() {
        ImmutableArrayList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList = tempList.add("3");

        assertEquals(tempList.toString(), "1,2,3,");
        assertEquals(list.toString(), "");
    }

    @Test
    public void testAddIndex() {
        ImmutableArrayList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList = tempList.add(1, "3");

        assertEquals(tempList.toString(), "1,3,2,");
        assertEquals(list.toString(), "");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexExept() {
        ImmutableArrayList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList.add(5, "3");
    }


    @Test
    public void testAddAllLast() {
        ImmutableArrayList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList = tempList.addAll(new String[]{"3", "4", "5"});

        assertEquals(tempList.toString(), "1,2,3,4,5,");
        assertEquals(list.toString(), "");
    }

    @Test
    public void testAddAllIndex() {
        ImmutableArrayList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList = tempList.addAll(1, new String[]{"3", "4", "5"});

        assertEquals(tempList.toString(), "1,3,4,5,2,");
        assertEquals(list.toString(), "");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllIndexExept() {
        ImmutableArrayList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList.addAll(5, new String[]{"3", "4", "5"});
    }

    @Test
    public void testGet() {
        ImmutableArrayList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList = tempList.addAll(new String[]{"3", "4", "5"});

        assertEquals(tempList.toString(), "1,2,3,4,5,");
        assertEquals(tempList.get(1), "2");
        assertEquals(list.toString(), "");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetExept() {
        ImmutableArrayList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList = tempList.addAll(new String[]{"3", "4", "5"});

        assertEquals(tempList.toString(), "1,2,3,4,5,");
        assertEquals(list.toString(), "");
        tempList.get(5);
    }

    @Test
    public void testRemove() {
        ImmutableArrayList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList = tempList.add("3");
        tempList = tempList.remove(1);

        assertEquals(tempList.toString(), "1,3,");
        assertEquals(list.toString(), "");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveExept() {
        ImmutableArrayList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList.remove(5);
    }

    @Test
    public void testSet() {
        ImmutableArrayList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList = tempList.add("3");
        tempList = tempList.set(1, "4");

        assertEquals(tempList.toString(), "1,4,3,");
        assertEquals(list.toString(), "");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetExept() {
        ImmutableArrayList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList.set(5, "4");
    }

    @Test
    public void testIndexOf() {
        ImmutableArrayList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList = tempList.add("3");
        tempList = tempList.set(1, "4");

        assertEquals(tempList.toString(), "1,4,3,");
        assertEquals(tempList.indexOf("4"), 1);
        assertEquals(tempList.indexOf("5"), -1);
        assertEquals(list.toString(), "");
    }

    @Test
    public void testSize() {
        ImmutableArrayList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList = tempList.add("3");
        tempList = tempList.set(1, "4");

        assertEquals(tempList.toString(), "1,4,3,");
        assertEquals(tempList.size(), 3);
        tempList = tempList.remove(1);
        assertEquals(tempList.size(), 2);
        tempList = tempList.addAll(1, new Object[] {"1", "2", "3"});
        assertEquals(tempList.size(), 5);
        assertEquals(list.toString(), "");
    }

    @Test
    public void testClear() {
        ImmutableArrayList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList = tempList.add("3");
        tempList = tempList.set(1, "4");

        assertEquals(tempList.toString(), "1,4,3,");
        assertEquals(list.toString(), "");
        tempList = tempList.clear();
        assertEquals(tempList.toString(), "");
        assertEquals(list.toString(), "");
    }

    @Test
    public void testIsEmpty() {
        ImmutableArrayList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList = tempList.add("3");
        tempList = tempList.set(1, "4");

        assertEquals(tempList.toString(), "1,4,3,");
        assertFalse(tempList.isEmpty());
        assertEquals(list.toString(), "");
        tempList = tempList.clear();
        assertEquals(tempList.toString(), "");
        assertTrue(tempList.isEmpty());
        assertEquals(list.toString(), "");
    }

    @Test
    public void testToArray() {
        ImmutableArrayList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList = tempList.add("3");
        tempList = tempList.set(1, "4");

        assertEquals(tempList.toString(), "1,4,3,");
        assertEquals(list.toString(), "");
        assertArrayEquals(tempList.toArray(), new Object[]{"1","4","3"});
    }
}
