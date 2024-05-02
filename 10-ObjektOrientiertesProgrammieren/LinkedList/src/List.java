public class List {
    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);

        node1.next = node2;
        node2.next = node3;

        Node head = node1;
        while (head != null){
            System.out.println(head.value);
            head = head.next;
        }
    }
}
