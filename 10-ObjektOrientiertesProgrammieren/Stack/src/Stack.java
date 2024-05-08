import java.util.ArrayList;

public class Stack {
    ArrayList<Integer> stack = new ArrayList<>();


    void push(int newElement){
        stack.add(newElement);
    }

    public int size(){
        return stack.size();
    }
    public int pop(){
        if (stack.isEmpty()){
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        int temp = stack.getLast();
        stack.removeLast();
        return temp;
    }
    public int peek(){
        if (stack.isEmpty()){
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return stack.getLast();
    }
    public int[] pop(int n){
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = stack.removeLast();
            System.out.println("[" + temp[i] + "]");
        }
        return temp;
    }

    public void print(){
        for(int i:stack){
            System.out.println("[" + i + "]");
        }
    }
}
