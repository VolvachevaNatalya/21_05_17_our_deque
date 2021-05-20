package telran;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class OurArrayDequeTest {
    private final ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

    @Test
    public void addLast() {
        deque.addLast(3);
        deque.addLast(5);
        deque.addLast(9);
        assertEquals(3, deque.size());
        assertEquals(9, deque.getLast());
    }

    @Test
    public void addFirst() {
        deque.addLast(3);
        deque.addLast(5);
        deque.addLast(9);
        assertEquals(3, deque.size());
        assertEquals(3, deque.getFirst());
    }

    @Test
    public void removeFirst() {
        assertThrows(NoSuchElementException.class, deque::removeFirst);
        deque.addLast(3);
        deque.addLast(5);
        deque.addLast(9);
        assertEquals(3, deque.removeFirst());
        assertEquals(5, deque.removeFirst());
        assertEquals(1, deque.size());
        assertEquals(3, deque.removeFirst());
        assertEquals(0, deque.size());


    }

    @Test
    public void removeLast() {
        assertThrows(NoSuchElementException.class, deque::removeLast);
        deque.addLast(3);
        deque.addLast(5);
        deque.addLast(9);
        assertEquals(9, deque.removeLast());
        assertEquals(5, deque.removeLast());
        assertEquals(1, deque.size());
        assertEquals(3, deque.removeLast());
        assertEquals(0, deque.size());
    }

    @Test
    public void getFirst() {
        assertThrows(NoSuchElementException.class, deque::getFirst);
        deque.addLast(3);
        deque.addLast(5);
        deque.addLast(9);
        assertEquals(3, deque.getFirst());
    }

    @Test
    public void getLast() {
        assertThrows(NoSuchElementException.class, deque::getLast);
        deque.addLast(3);
        deque.addLast(5);
        deque.addLast(9);
        assertEquals(9, deque.getLast());
    }

}