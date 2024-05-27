package main;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(3);
        stack.push(6);
        stack.push(9);
        stack.push(11);
        stack.push(13);
        stack.push(15);
        stack.push(17);

        stack.print();

        System.out.println("Stack size = " + stack.size());

        stack.pop(3);

        stack.print();

        System.out.println(stack.peek() + " Peek");

        System.out.println(stack.pop() + " Pop single");

        stack.print();
    }
}