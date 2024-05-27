import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack();
    }

    @Test
    void testPush() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size(), "Stack size should be 3 after pushing three elements.");
    }

    @Test
    void testPop() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop(), "The popped element should be 3.");
        assertEquals(2, stack.size(), "Stack size should be 2 after popping one element.");
    }

    @Test
    void testPopFromEmptyStack() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            stack.pop();
        });
        assertEquals("Stack is empty", exception.getMessage(), "Expected IndexOutOfBoundsException with message 'Stack is empty'.");
    }

    @Test
    void testPeek() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.peek(), "The top element should be 3.");
        assertEquals(3, stack.size(), "Stack size should remain 3 after peeking.");
    }

    @Test
    void testPeekFromEmptyStack() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            stack.peek();
        });
        assertEquals("Stack is empty", exception.getMessage(), "Expected IndexOutOfBoundsException with message 'Stack is empty'.");
    }

    @Test
    void testPopMultiple() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop(2);
        assertEquals(2, stack.size(), "Stack size should be 2 after popping two elements.");
        assertEquals(2, stack.peek(), "The top element should be 2 after popping two elements.");
    }

    @Test
    void testSize() {
        assertEquals(0, stack.size(), "Initial stack size should be 0.");
        stack.push(1);
        assertEquals(1, stack.size(), "Stack size should be 1 after pushing one element.");
    }

    @Test
    void testPrint() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.print(); // Call to see if runs without exceptions
    }

    @Test
    void testMixedOperations() {
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.push(3);
        stack.push(4);
        stack.pop(2);
        assertEquals(1, stack.size(), "Stack size should be 1 after mixed operations.");
        assertEquals(1, stack.peek(), "The top element should be 1 after mixed operations.");
    }
}