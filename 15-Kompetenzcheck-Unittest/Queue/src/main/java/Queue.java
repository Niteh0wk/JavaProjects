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
        if (howMany > queue.size()){
            for (int i = 0; i < queue.size()+1; i++) {
                System.out.println("[" + queue.get(0) + "]" + " Deleted");
                queue.remove(0);
            }
        }else {
            for (int i = 0; i < howMany; i++) {
                System.out.println("[" + queue.get(0) + "]" + " Deleted");
                queue.remove(0);
            }
        }
    }

    public void print(){
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(queue.toString());
        }
    }

}
