import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    public Queue queue;

    @BeforeEach
    void setUp() {
        queue = new Queue();
    }

    @Test
    void testEnqueue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(3, queue.size(), "Queue size should be 3 after enqueueing three elements.");
    }

    @Test
    void testDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        assertEquals(2, queue.size(), "Queue size should be 2 after dequeueing one element.");
        queue.dequeue(2);
        assertEquals(0, queue.size(), "Queue size should be 0 after dequeueing two more elements.");
    }

    @Test
    void testDequeueMoreThanSize() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue(3);  // Deque more elements than exist
        assertEquals(0, queue.size(), "Queue size should be 0 after attempting to dequeue more elements than present.");
    }

    @Test
    void testSize() {
        assertEquals(0, queue.size(), "Initial queue size should be 0.");
        queue.enqueue(1);
        assertEquals(1, queue.size(), "Queue size should be 1 after enqueueing one element.");
    }

    @Test
    void testPrint() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.print();  // Check if it runs without exceptions
    }

    @Test
    void testMixedOperations() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue(2);
        assertEquals(1, queue.size(), "Queue size should be 1 after mixed operations.");
    }
}