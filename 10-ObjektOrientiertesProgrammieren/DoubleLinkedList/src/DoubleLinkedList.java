

public class DoubleLinkedList {
    private int size;
    private Node head = null;
    private Node tail = null;

    void add(int value) {
        Node temp = new Node(value);

        if (head == null) {
            head = temp;
            tail = temp;
            head.prev = null;
            tail.next = null;
        } else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
            tail.next = null;
        }
        size++;
    }

    void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index=" + index);
        }
        if (index == 0) {
            head = new Node(value);
        } else {
            Node n = search(index - 1);
            n.next = new Node(n, n.next, value);
            n.next.next.prev = n.next;
        }
        size++;
    }

    void get(int index) {
        Node n = search(index);
        System.out.println("The value of index " + index + " = " + n.value);
    }

    void remove(int index) {
        Node n = search(index - 1);
        n.next = n.next.next;
        size--;
    }


    Node search(int index) {
        Node current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }


    @Override
    public String toString() {
        Node current = head;
        if (head == null) {
            return "List is empty";
        }
        String s = "[";
        while (current != null) {
            s += current.value + ", ";
            current = current.next;
        }
        return s + "]" + "\n The size is = " + size;
    }

    public String toStringReverse() {
        Node current = tail;
        String s = "[";
        for (int i = size; i > 0; i--) {
            s += current.value + ", ";
            current = current.prev;
        }
        return s + "]" + "\n The size is = " + size;
    }

    class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(Node prev, Node next, int value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }
}
