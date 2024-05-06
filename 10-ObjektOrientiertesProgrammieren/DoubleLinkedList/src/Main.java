public class Main {
    public static void main(String[] args) {
        List li = new List();

        li.add(3);
        li.add(5);
        li.add(7);
        li.add(9);
        li.add(11);
        li.add(13);

        System.out.println(li);

        li.add(2, 15);

        System.out.println(li);

        li.remove(3);

        System.out.println(li);

        li.get(3);

        System.out.println("List size = " + li.size());

    }
}