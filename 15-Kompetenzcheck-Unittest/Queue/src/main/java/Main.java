public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(7);

        queue.print();

        System.out.println("Queue size = " + queue.size());

        queue.dequeue(2);

        System.out.println("Queue size = " + queue.size());

        queue.dequeue();

        System.out.println();

        queue.print();
    }
}