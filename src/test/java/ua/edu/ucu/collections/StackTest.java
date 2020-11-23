package ua.edu.ucu.collections;

import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableArrayList;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import static org.junit.Assert.*;

public class StackTest {

    private final Stack stackArray = new Stack(new ImmutableArrayList());
    private final Stack stackLinked = new Stack(new ImmutableLinkedList());

    @Test
    public void testPush() {
        stackArray.push("1");
        stackArray.push("2");
        stackArray.push("3");
        stackArray.push("4");

        stackLinked.push("1");
        stackLinked.push("2");
        stackLinked.push("3");
        stackLinked.push("4");

        assertEquals(stackArray.toString(), stackLinked.toString());
        assertEquals(stackArray.toString(), "4,3,2,1,");
    }

    @Test
    public void testPeek() {
        stackArray.push("1");
        stackArray.push("2");
        stackArray.push("3");
        stackArray.push("4");

        stackLinked.push("1");
        stackLinked.push("2");
        stackLinked.push("3");
        stackLinked.push("4");

        assertEquals(stackArray.peek(), stackLinked.peek());
        assertEquals(stackArray.peek(), "4");
    }

    @Test
    public void testPop() {
        stackArray.push("1");
        stackArray.push("2");
        stackArray.push("3");
        stackArray.push("4");

        stackLinked.push("1");
        stackLinked.push("2");
        stackLinked.push("3");
        stackLinked.push("4");

        assertEquals(stackArray.toString(), stackLinked.toString());
        assertEquals(stackArray.toString(), "4,3,2,1,");
        assertEquals(stackArray.pop(), "4");
        assertEquals(stackLinked.pop(), "4");

        assertEquals(stackArray.toString(), stackLinked.toString());
        assertEquals(stackArray.toString(), "3,2,1,");
        assertEquals(stackArray.pop(), "3");
        assertEquals(stackLinked.pop(), "3");

        assertEquals(stackArray.toString(), stackLinked.toString());
        assertEquals(stackArray.toString(), "2,1,");
        assertEquals(stackArray.pop(), "2");
        assertEquals(stackLinked.pop(), "2");

        assertEquals(stackArray.toString(), stackLinked.toString());
        assertEquals(stackArray.toString(), "1,");
        assertEquals(stackArray.pop(), "1");
        assertEquals(stackLinked.pop(), "1");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPeekEmptyArray() {
        stackArray.peek();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPeekEmptyLinked() {
        stackLinked.peek();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPopEmptyArray() {
        stackArray.pop();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPopEmptyLinked() {
        stackLinked.pop();
    }
    
}
