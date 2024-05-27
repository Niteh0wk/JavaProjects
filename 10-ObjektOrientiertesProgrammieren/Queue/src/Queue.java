import java.util.ArrayList;

public class Queue {
    DoubleLinkedList<Integer> queue = new DoubleLinkedList<>();


    void enqueue(int newElement){
        queue.add(newElement);
    }

    public int size(){
        return queue.size();
    }

    public void dequeue(){
        System.out.println("[" + queue.get(0) + "]" + " Deleted");
        queue.remove(0);
    }

    public void dequeue(int howMany){
        for (int i = 0; i < howMany; i++) {
            System.out.println(queue.get(0));
            queue.remove(0);
        }
    }

    public void print(){
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.toString());
        }
    }
}
