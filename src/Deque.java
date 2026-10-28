import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A double-ended queue that supports adding and removing items at either end.
 * @param <Item> the type of items stored in this deque
 */
public class Deque<Item> implements Iterable<Item> {

    /** A node in the doubly linked list. */
    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    private Node head;
    private Node tail;
    private int size;

    /** Construct an empty deque. */
    public Deque() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
        size = 0;
        // TODO: Initialize an empty linked list.
    }

    /** Return whether the deque is empty. */
    public boolean isEmpty() {
        // TODO: Report whether this linked list contains no items.
        return size == 0;
    }

    /** Return the number of items in the deque. */
    public int size() {
        // TODO: Return this linked list's item count.
        return size;
    }

    /** Add an item to the front; reject null items with IllegalArgumentException. */
    public void addFirst(Item item) {
        // TODO: Create a node and link it at the front; update head/tail pointers.
        if (item == null)  {
            throw new IllegalArgumentException();
        }
        if (size == 0) {
            Node newFirst = new Node();
            head.next = newFirst;
            tail.prev = newFirst;
            newFirst.item = item;
            newFirst.prev = head;
            newFirst.next = tail;
            ++size;
            return;
        }
        Node oldFirst = head.next;
        Node newFirst = new Node();
        newFirst.item = item;
        newFirst.next = oldFirst;
        newFirst.prev = head;
        ++size;
    }

    /** Add an item to the back; reject null items with IllegalArgumentException. */
    public void addLast(Item item) {
        if (item == null)  {
            throw new IllegalArgumentException();
        }
        if (size == 0) {
            Node newLast = new Node();
            head.next = newLast;
            tail.prev = newLast;
            newLast.item = item;
            newLast.prev = head;
            newLast.next = tail;
            ++size;
            return;
        }
        Node oldLast = tail.prev;
        Node newLast = new Node();
        oldLast.next = newLast;
        newLast.next = tail;
        newLast.prev = oldLast;
        ++size;
    }

    /** Remove and return the front item; throw NoSuchElementException if empty. */
    public Item removeFirst() {
        // TODO: Remove the front node and update head/tail pointers.
        if (isEmpty()) throw new NoSuchElementException();
        Node first = head.next;
        head.next = first.next;
        first.next = null;
        first.prev = null;
        Item oldItem = first.item;
        first.item = null;
        --size;
        return oldItem;
    }

    /** Remove and return the back item; throw NoSuchElementException if empty. */
    public Item removeLast() {
        // TODO: Remove the back node and update head/tail pointers.
        if (isEmpty()) throw new NoSuchElementException();
        Node last = tail.prev;
        tail.prev = last.prev;
        last.next = null;
        last.prev = null;
        Item oldItem = last.item;
        last.item = null;
        --size;
        return oldItem;
    }

    /** Return an iterator from front to back; next() and remove() follow the specified exceptions. */
    @Override
    public Iterator<Item> iterator() {
        // TODO: Return an iterator that follows next links from head to tail.
        return (new Iterator<Item>() {
            private Node pos = head.next;
            private int count = 0;

            public boolean hasNext() {
                //TODO Implement the hasNext() method
                return !this.pos.equals(tail);
            }

            public Item next() {
                //TODO Implement the next() method
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Item item = pos.item;
                pos = pos.next;
                return item;
            }
        });
    }

    private class DequeIterator implements Iterator<Item>{
        private Node current = head.next;
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            return null;
        }
    }

    /** Run unit tests for the deque. */
    public static void main(String[] args) {
        // TODO: Add unit tests.
    }
}
