import java.util.ArrayList;

public class Queue {
    ArrayList<Integer> queue = new ArrayList<>();


    void enqueue(int newElement){
        queue.add(newElement);
    }

    public int size(){
        return queue.size();
    }
    public int dequeue(){
        queue.removeFirst();
        System.out.println("[" + queue.getFirst() + "]" + " Deleted");
        return queue.getFirst();
    }

    public int[] dequeue(int n){
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = queue.removeFirst();
            System.out.println("[" + temp[i] + "] deleted");
        }
        return temp;
    }

    public void print(){
        for(int i: queue){
            System.out.println("[" + i + "]");
        }
    }
}
