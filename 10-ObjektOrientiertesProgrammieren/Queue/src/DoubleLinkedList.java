public class DoubleLinkedList<T> {
    private int size;
    private Node<T> head = null;
    private Node<T> tail = null;

    public void add(T value) {
        Node<T> temp = new Node<>(value);

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

    public void add(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index=" + index);
        }
        if (index == 0) {
            head = new Node<T>(value);
        } else {
            Node<T> n = search(index - 1);
            n.next = new Node<>(n, n.next, value);
            n.next.next.prev = n.next;
        }
        size++;
    }

    public T get(int index) {
        Node<T> n = search(index);
        return n.value;
    }

    public void remove(int index) {
        Node<T> n = search(index);
        if (index == 0){
            head = head.next;
            head.prev = null;
        }else if (index == size){
            tail = tail.prev;
            tail.next = null;
        }else{
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }

        size--;
    }

    public int size(){
        return size;
    }


    Node<T> search(int index) {
        Node<T> current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }


    @Override
    public String toString() {
        Node<T> current = head;
        if (head == null) {
            return "List is empty";
        }
        String s = "[";
        while (current != null) {
            s += current.value + ", ";
            current = current.next;
        }
        return s + "]";
    }

    public String toStringReverse() {
        Node<T> current = tail;
        String s = "[";
        for (int i = size; i > 0; i--) {
            s += current.value + ", ";
            current = current.prev;
        }
        return s + "]";
    }

    class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value) {
            this.value = value;
        }

        public Node(Node<T> prev, Node<T> next, T value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }
}
