import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A queue that removes items uniformly at random.
 * @param <Item> the type of items stored in this randomized queue
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;
    private int size;

    /** Construct an empty randomized queue. */
    public RandomizedQueue() {
        // TODO: Initialize an empty array-backed randomized queue. Resize by doubling when full and halving when quarter full.
        items = (Item[]) new Object[100];
        size = 0;
    }

    /** Return whether the randomized queue is empty. */
    public boolean isEmpty() {
        // TODO: Report whether this array-backed queue contains no items.
        return size == 0;
    }

    /** Return the number of items in the randomized queue. */
    public int size() {
        // TODO: Return this array-backed queue's item count.
        return size;
    }

    /** Add an item; reject null with IllegalArgumentException. */
    public void enqueue(Item item) {
        // TODO: Add the item to the backing array, resizing as needed.
        items[size] = item;
        ++size;
        if (size == items.length) {
            Item[] resized = (Item[]) new Object[items.length * 2];
            for (int i = 0; i < items.length; ++i) {
                resized[i] = items[i];
            }
            items = resized;
        }
    }

    /** Remove and return a uniformly random item; throw NoSuchElementException if empty. */
    public Item dequeue() {
        // TODO: Pick a random index between 0 and size-1; swap the chosen item with the last item, then remove and resize as needed.
        int id = (int) (Math.random() * size);
        Item output = items[id];
        items[id] = null;
        for (int i = id + 1; i < size; ++i) {
            items[i-1] = items[i];
        }
        return output;
    }

    /** Return a uniformly random item without removing it; throw NoSuchElementException if empty. */
    public Item sample() {
        // TODO: Pick a random index between 0 and size-1 and return that array item without removing it.
        int id = (int) (Math.random() * size);
        Item output = items[id];
        return output;
    }

    /** Return an independent iterator in uniformly random order; define next() and remove() exceptions. */
    @Override
    public Iterator<Item> iterator() {
        // TODO: Return an independent iterator that traverses the array items in random order.


        return null;
    }
    private class RandomizedQueueIterator implements Iterator<Item>{
        private Item[] shuffledItems;
        private int current;
        private int pos = 0;

        RandomizedQueueIterator() {
            shuffledItems = (Item[]) new Object[size];
            int i = 0;
            while (size > 0) {
                shuffledItems[i] = dequeue();
            }
        }

        @Override
        public boolean hasNext() {
            return pos < size;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item output = shuffledItems[pos];
            ++pos;
            return output;
        }
    }

    /** Run unit tests for the randomized queue. */
    public static void main(String[] args) {
        // TODO: Add unit tests.
    }
}
