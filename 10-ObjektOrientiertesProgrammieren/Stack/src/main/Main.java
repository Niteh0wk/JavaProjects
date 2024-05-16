package main;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(3);
        stack.push(6);
        stack.push(10);

        stack.print();

        System.out.println("Stack size = " + stack.size());

        stack.pop(2);

        System.out.println(stack.peek() + " Peek");

        System.out.println(stack.pop() + " Pop single");
    }
}