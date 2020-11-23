package ua.edu.ucu.collections;

import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableArrayList;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import static org.junit.Assert.*;

public class QueueTest {

    private final Queue queueArray = new Queue(new ImmutableArrayList());
    private final Queue queueLinked = new Queue(new ImmutableLinkedList());

    @Test
    public void testEnqueue() {
        queueArray.enqueue("1");
        queueArray.enqueue("2");
        queueArray.enqueue("3");
        queueArray.enqueue("4");

        queueLinked.enqueue("1");
        queueLinked.enqueue("2");
        queueLinked.enqueue("3");
        queueLinked.enqueue("4");

        assertEquals(queueArray.toString(), queueLinked.toString());
        assertEquals(queueArray.toString(), "1,2,3,4,");
    }

    @Test
    public void testPeek() {
        queueArray.enqueue("1");
        queueArray.enqueue("2");
        queueArray.enqueue("3");
        queueArray.enqueue("4");

        queueLinked.enqueue("1");
        queueLinked.enqueue("2");
        queueLinked.enqueue("3");
        queueLinked.enqueue("4");

        assertEquals(queueArray.peek(), queueLinked.peek());
        assertEquals(queueArray.peek(), "1");
    }

    @Test
    public void testDequeue() {
        queueArray.enqueue("1");
        queueArray.enqueue("2");
        queueArray.enqueue("3");
        queueArray.enqueue("4");

        queueLinked.enqueue("1");
        queueLinked.enqueue("2");
        queueLinked.enqueue("3");
        queueLinked.enqueue("4");

        assertEquals(queueArray.toString(), queueLinked.toString());
        assertEquals(queueArray.toString(), "1,2,3,4,");
        assertEquals(queueArray.dequeue(), "1");
        assertEquals(queueLinked.dequeue(), "1");

        assertEquals(queueArray.toString(), queueLinked.toString());
        assertEquals(queueArray.toString(), "2,3,4,");
        assertEquals(queueArray.dequeue(), "2");
        assertEquals(queueLinked.dequeue(), "2");

        assertEquals(queueArray.toString(), queueLinked.toString());
        assertEquals(queueArray.toString(), "3,4,");
        assertEquals(queueArray.dequeue(), "3");
        assertEquals(queueLinked.dequeue(), "3");

        assertEquals(queueArray.toString(), queueLinked.toString());
        assertEquals(queueArray.toString(), "4,");
        assertEquals(queueArray.dequeue(), "4");
        assertEquals(queueLinked.dequeue(), "4");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPeekEmptyArray() {
        queueArray.peek();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testPeekEmptyLinked() {
        queueLinked.peek();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDequeueEmptyArray() {
        queueArray.dequeue();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDequeueEmptyLinked() {
        queueLinked.dequeue();
    }
}
