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

        li.add(5,12);

        System.out.println(li + "with add");

        li.remove(1);

        System.out.println(li + "with remove");

        li.get(3);

        System.out.println("The size is = " + li.size());
    }
}
