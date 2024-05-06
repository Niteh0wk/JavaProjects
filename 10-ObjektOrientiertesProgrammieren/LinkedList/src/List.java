public class List {

    private Node head;
    private int size;

    void add (int value){
        add(size, value);
    }

    void add(int index, int value){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("index=" + index);
        }
        if (index == 0){
            head = new Node(head, value);
        }else{
            Node n = search(index-1);
            n.next = new Node(n.next, value);
        }
        size++;
    }

    void get(int index){
        Node n = search(index);
        System.out.println("The value of index " + index + " = " + n.value);
    }

    void remove(int index){
        Node n = search(index-1);
        n.next = n.next.next;
        size--;
    }

    Node search(int index){
        Node n = head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n;
    }

    @Override
    public String toString(){
        Node n = head;
        String s = "[";
        for (int i = 0; i < size; i++) {
            s += n.value + ", ";
            n = n.next;
        }
        return s + "]";
    }
    public int size(){
        return size;
    }

    class Node {
        Node next;
        int value;

        public Node(Node next, int value) {
            this.next = next;
            this.value = value;
        }
    }
}