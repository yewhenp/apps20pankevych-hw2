package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {


    private final ImmutableLinkedList list = new ImmutableLinkedList();

    @Test
    public void testAdd() {
        ImmutableLinkedList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList = tempList.add("3");

        assertEquals(tempList.toString(), "1,2,3,");
        assertEquals(list.toString(), "");
    }

    @Test
    public void testAddIndex() {
        ImmutableLinkedList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList = tempList.add(1, "3");
        tempList = tempList.add(3, "4");

        assertEquals(tempList.toString(), "1,3,2,4,");
        assertEquals(list.toString(), "");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexExept() {
        ImmutableLinkedList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList.add(5, "3");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexBelowExept() {
        ImmutableLinkedList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList.add(5, "3");
    }


    @Test
    public void testAddAllLast() {
        ImmutableLinkedList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList = tempList.addAll(new String[]{"3", "4", "5"});

        assertEquals(tempList.toString(), "1,2,3,4,5,");
        assertEquals(list.toString(), "");
    }

    @Test
    public void testAddAllIndex() {
        ImmutableLinkedList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList = tempList.addAll(1, new String[]{"3", "4", "5"});

        assertEquals(tempList.toString(), "1,3,4,5,2,");
        assertEquals(list.toString(), "");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllIndexExept() {
        ImmutableLinkedList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList.addAll(5, new String[]{"3", "4", "5"});
    }

    @Test
    public void testGet() {
        ImmutableLinkedList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList = tempList.addAll(new String[]{"3", "4", "5"});

        assertEquals(tempList.toString(), "1,2,3,4,5,");
        assertEquals(tempList.get(1), "2");
        assertEquals(list.toString(), "");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetExept() {
        ImmutableLinkedList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList = tempList.addAll(new String[]{"3", "4", "5"});

        assertEquals(tempList.toString(), "1,2,3,4,5,");
        assertEquals(list.toString(), "");
        tempList.get(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetExeptBelow() {
        ImmutableLinkedList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList = tempList.addAll(new String[]{"3", "4", "5"});

        assertEquals(tempList.toString(), "1,2,3,4,5,");
        assertEquals(list.toString(), "");
        tempList.get(-5);
    }

    @Test
    public void testRemove() {
        ImmutableLinkedList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList = tempList.add("3");
        tempList = tempList.remove(1);

        assertEquals(tempList.toString(), "1,3,");
        assertEquals(list.toString(), "");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveExept() {
        ImmutableLinkedList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList.remove(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveExeptBelow() {
        ImmutableLinkedList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList.remove(-5);
    }

    @Test
    public void testSet() {
        ImmutableLinkedList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList = tempList.add("3");
        tempList = tempList.set(1, "4");

        assertEquals(tempList.toString(), "1,4,3,");
        assertEquals(list.toString(), "");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetExept() {
        ImmutableLinkedList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList.set(5, "4");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetExeptBelow() {
        ImmutableLinkedList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList.set(-5, "4");
    }

    @Test
    public void testIndexOf() {
        ImmutableLinkedList tempList;

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
        ImmutableLinkedList tempList;

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
        ImmutableLinkedList tempList;

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
        ImmutableLinkedList tempList;

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
        ImmutableLinkedList tempList;

        tempList = list.add("1");
        tempList = tempList.add("2");
        tempList = tempList.add("3");
        tempList = tempList.set(1, "4");

        assertEquals(tempList.toString(), "1,4,3,");
        assertEquals(list.toString(), "");
        assertArrayEquals(tempList.toArray(), new Object[]{"1","4","3"});
    }

    @Test
    public void testAddLast() {
        ImmutableLinkedList tempList;

        tempList = list.addLast("1");
        tempList = tempList.addLast("2");
        tempList = tempList.addLast("3");

        assertEquals(tempList.toString(), "1,2,3,");
        assertEquals(list.toString(), "");
    }

    @Test
    public void testAddFirst() {
        ImmutableLinkedList tempList;

        tempList = list.addFirst("1");
        tempList = tempList.addFirst("2");
        tempList = tempList.addFirst("3");

        assertEquals(tempList.toString(), "3,2,1,");
        assertEquals(list.toString(), "");
    }

    @Test
    public void testGetLast() {
        ImmutableLinkedList tempList;

        tempList = list.addLast("1");
        tempList = tempList.addLast("2");
        tempList = tempList.addLast("3");

        assertEquals(tempList.toString(), "1,2,3,");
        assertEquals(tempList.getLast(), "3");
        assertEquals(list.toString(), "");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetLastExept() {
        list.getLast();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetFirstExept() {
        list.getFirst();
    }

    @Test
    public void testGetFirst() {
        ImmutableLinkedList tempList;

        tempList = list.addLast("1");
        tempList = tempList.addLast("2");
        tempList = tempList.addLast("3");

        assertEquals(tempList.toString(), "1,2,3,");
        assertEquals(tempList.getFirst(), "1");
        assertEquals(list.toString(), "");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveLast() {
        ImmutableLinkedList tempList;

        tempList = list.addLast("1");
        tempList = tempList.addLast("2");
        tempList = tempList.addLast("3");

        assertEquals(tempList.toString(), "1,2,3,");
        tempList = tempList.removeLast();
        assertEquals(tempList.toString(), "1,2,");
        tempList = tempList.removeLast();
        assertEquals(tempList.toString(), "1,");
        tempList = tempList.removeLast();
        assertEquals(tempList.toString(), "");
        assertEquals(list.toString(), "");

        tempList.removeLast();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFirst() {
        ImmutableLinkedList tempList;

        tempList = list.addLast("1");
        tempList = tempList.addLast("2");
        tempList = tempList.addLast("3");

        assertEquals(tempList.toString(), "1,2,3,");
        tempList = tempList.removeFirst();
        assertEquals(tempList.toString(), "2,3,");
        tempList = tempList.removeFirst();
        assertEquals(tempList.toString(), "3,");
        tempList = tempList.removeFirst();
        assertEquals(tempList.toString(), "");
        assertEquals(list.toString(), "");

        tempList.removeFirst();
    }

}
