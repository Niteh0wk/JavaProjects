public class Main {
    public static void main(String[] args) {
        DoubleLinkedList li = new DoubleLinkedList();

        li.add(1);
        li.add(3);
        li.add(5);
        li.add(7);
        li.add(9);

        System.out.println(li);
        System.out.println(li.toStringReverse());

        li.add(3, 6);
        li.add(2, 4);

        System.out.println(li);
        System.out.println(li.toStringReverse());

        li.get(3);

        li.remove(1);

        System.out.println(li);
        System.out.println(li.toStringReverse());
    }
}