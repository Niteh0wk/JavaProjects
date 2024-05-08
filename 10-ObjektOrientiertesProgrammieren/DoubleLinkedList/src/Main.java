public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> li = new DoubleLinkedList<>();

        li.add(1);
        li.add(3);
        li.add(5);
        li.add(7);
        li.add(9);

        System.out.println(li);
        System.out.println(li.toStringReverse());
        li.size();

        li.add(4, 6);
        li.add(2, 4);

        System.out.println(li);
        li.get(3);
        System.out.println(li.toStringReverse());
        li.size();

        li.remove(3);

        System.out.println(li);
        System.out.println(li.toStringReverse());
        li.size();
    }
}